package contentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class ContentManagementApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedis(){
        stringRedisTemplate.opsForValue().set("19301136", "zhou");
        String res = stringRedisTemplate.opsForValue().get("19301136");
        System.out.println(res);
    }

}
