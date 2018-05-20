package cn.pzhu.spring.config;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.enumerate.RoleEnum;
import cn.pzhu.spring.repository.AccountEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.ResultSet;

@Configuration
@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private final AccountEntityRepository accountEntityRepository;

    @Autowired
    public JdbcSecurityConfiguration(AccountEntityRepository accountEntityRepository) {
        this.accountEntityRepository = accountEntityRepository;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailService) {
        this.userDetailsService = userDetailService;
    }

    @Bean
    public UserDetailsService userDetailService(JdbcTemplate jdbcTemplate) {
        RowMapper<User> teacherRowMapper = (ResultSet rs, int i) ->
                new User(
                        rs.getString("ACCOUNT_NAME"),
                        rs.getString("PASSWORD"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
        RowMapper<User> studentRowMapper = (ResultSet rs, int i) ->
                new User(
                        rs.getString("ACCOUNT_NAME"),
                        rs.getString("PASSWORD"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        AuthorityUtils.createAuthorityList("ROLE_USER"));
        return username -> {
            AccountEntity existAccountEntity = accountEntityRepository.findAccountEntitiesByAccountName(username);
            if (existAccountEntity == null) {
                throw new IllegalArgumentException("用户名或密码错误");
            }
            if (RoleEnum.STUDENT == existAccountEntity.getUserRole()) {
                return jdbcTemplate.queryForObject("SELECT * from ACCOUNT where ACCOUNT_NAME = ?",
                        studentRowMapper, username);
            }
            return jdbcTemplate.queryForObject("SELECT * from ACCOUNT where ACCOUNT_NAME = ?",
                    teacherRowMapper, username);
        };
    }

    @Override
    public void init(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService);
    }
}
