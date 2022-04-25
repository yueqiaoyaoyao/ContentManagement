package contentmanagement;

import contentmanagement.pojo.News;
import contentmanagement.service.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class ContentManagementApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private NewsServiceImpl newsService;

    @Autowired
    private RightServiceImpl rightService;

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
//        System.out.println(userService.addUser("test0","123456"));
//        System.out.println(roleService.addRole("12","2,3"));
        System.out.println(rightService.addRight("test1","3"));
    }


    @Test
    void testMongoDB(){
//        System.out.println(newsService.findByTitleLike("ws"));
    }

    @Test
    void testUser(){
        //test add
//        System.out.println(userService.addUser("ts1","123456"));
        //test find
//        System.out.println(userService.queryUserByName("ts1"));
//        System.out.println(userService.findAll());
        //test modify
//        System.out.println(userService.modifyUser("ts1","123"));
        //test delete
//        System.out.println(userService.deleteUser("ts1"));
    }

    @Test
    void testRole(){
        //test add
//        System.out.println(roleService.addRole("admin","1,2,3,4"));
        //test find
//        System.out.println(roleService.queryRole("admin"));
//        System.out.println(roleService.getAllRole());
        //test modify
//        System.out.println(roleService.updateRole("admin","1,2,3"));
        //test delete
//        System.out.println(roleService.deleteRole("admin"));
    }

    @Test
    void testRight(){
        //test add
//        System.out.println(rightService.addRight("test0","3"));
        //test find
//        System.out.println(rightService.queryRight("test0"));
//        System.out.println(rightService.getAllRight());
        //test modify
//        System.out.println(rightService.updateRight("test0","3"));
        //test delete
//        System.out.println(rightService.deleteRight("test0"));
    }

    @Test
    void testNews(){
        //test add
//        News news = new News();
//        news.setTitle("标题1");
//        news.setContent("内容1");
//        news.setWriter("作者1");
//        news.setCreateTime(new Date());
//        news.setUpdateTime(new Date());
//        newsService.addNews(news);
        //test find
//        System.out.println(newsService.findAll());
//        System.out.println(newsService.findByTitle("标题1"));
        //delete
//        System.out.println(newsService.deleteNews("标题1"));
        //modify
        News news = newsService.findByTitle("标题1").get(0);
        news.setContent("内容2");
        System.out.println(newsService.updateNews(news));

    }

}
