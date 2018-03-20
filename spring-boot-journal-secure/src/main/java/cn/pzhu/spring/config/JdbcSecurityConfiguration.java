package cn.pzhu.spring.config;

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

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailService) {
        this.userDetailsService = userDetailService;
    }

    @Bean
    public UserDetailsService userDetailService(JdbcTemplate jdbcTemplate) {
        RowMapper<User> userRowMapper = (ResultSet rs, int i) ->
            new User(
                    rs.getString("ACCOUNT_NAME"),
                    rs.getString("PASSWORD"),
                    rs.getBoolean("ENABLED"),
                    rs.getBoolean("ENABLED"),
                    rs.getBoolean("ENABLED"),
                    rs.getBoolean("ENABLED"),
                    AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
        return username ->
            jdbcTemplate.queryForObject("SELECT * from ACCOUNT where ACCOUNT_NAME = ?",
                    userRowMapper, username);
    }

    @Override
    public void init(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService);
    }
}
