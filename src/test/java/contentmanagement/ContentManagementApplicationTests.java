package contentmanagement;

import contentmanagement.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class ContentManagementApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedis(){
        stringRedisTemplate.opsForValue().set("19301136", "zhou");
        String res = stringRedisTemplate.opsForValue().get("19301136");
        System.out.println(res);
    }

    @Test
    void testMySql() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test
    void testMybatis(){
        System.out.println(userService.addUser("test0","123456"));
    }

}
