//package contentmanagement.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class MySecurity extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/role/**").hasRole("role1")
//                .antMatchers("/user/**").hasRole("role2")
//                .antMatchers("/content/**").hasRole("role3");
//        http.formLogin();
//        http.rememberMe().rememberMeParameter("remember");
//        http.cors().disable();
//        http.logout();
//    }
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("test")
//                .password(new BCryptPasswordEncoder().encode("1234567"))
//                .roles("role1","role2","role3");
//    }
//}