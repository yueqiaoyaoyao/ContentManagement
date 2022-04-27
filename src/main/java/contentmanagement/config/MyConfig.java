package contentmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController(("/main")).setViewName("main");
        registry.addViewController("/side").setViewName("side");
        registry.addViewController("/role").setViewName("role/role");
        registry.addViewController("/role/addRole").setViewName("role/add");
        registry.addViewController("/user").setViewName("user/user");
        registry.addViewController("/user/addUser").setViewName("user/add");
        registry.addViewController("/content").setViewName("content/content");
    }
}
