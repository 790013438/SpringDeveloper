package cn.pzhu.spring;

import cn.pzhu.spring.domain.TaskEntity;
import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.service.TaskService;
import cn.pzhu.spring.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDb() {
        {
            UserEntity userEntity = new UserEntity("testUser@mail.com", "testUser", "123456");
            userService.createUser(userEntity);
        }
        {
            UserEntity userEntity = new UserEntity("testAdmin@mail.com", "testAdmin", "123456");
            userService.createAdmin(userEntity);
        }

        TaskEntity taskEntity = new TaskEntity("03/01/2018", "00:11", "11:00", "You need to work today");
        UserEntity userEntity = userService.findOne("testUser@mail.com");
        taskService.addTask(taskEntity, userEntity);
    }

    @Test
    public void testUser() {
        UserEntity userEntity = userService.findOne("testUser@mail.com");
        Assert.assertNotNull(userEntity);
        UserEntity adminUserEntity = userService.findOne("testAdmin@mail.com");
        Assert.assertEquals(adminUserEntity.getEmail(), "testAdmin@mail.com");
    }

    @Test
    public void testTask() {
        UserEntity userEntity = userService.findOne("testUser@mail.com");
        List<TaskEntity> taskEntityList = taskService.findUserTask(userEntity);
        Assert.assertNotNull(taskEntityList);
    }

    @Test
    public void contextLoads() {
    }

}
