package cn.pzhu.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJournalsecureApplicationTests {

    @Test
    public void contextLoads() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(passwordEncoder.encode("isawesome"));
        System.out.println(passwordEncoder.encode("isawesometoo"));
        System.out.println(passwordEncoder.encode("1"));
        System.out.println(passwordEncoder.encode("123456"));
    }

}
