//package contentmanagement.config;
//
//import contentmanagement.pojo.Right;
//import contentmanagement.pojo.Role;
//import contentmanagement.service.RightServiceImpl;
//import contentmanagement.service.RoleServiceImpl;
//import contentmanagement.service.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    RightServiceImpl rightService;
//    @Autowired
//    RoleServiceImpl roleService;
//    @Autowired
//    UserServiceImpl userService;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        System.out.println(name);
//        contentmanagement.pojo.User user = userService.queryUserByName(name);
//        Right right = rightService.queryRight(name);
//        Role role = roleService.queryRole(right.getRoleName());
//        if (user != null){
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//            String s = role.getFunctions();
//            String[] ss = s.split(",");
//            for (String func:ss){
//                int i = Integer.parseInt(func);
//                String r = "role" + i;
//                authorities.add(new SimpleGrantedAuthority(r));
//            }
//            User user1 = new User(user.getName(),passwordEncoder.encode(user.getPassword()),authorities);
//            System.out.println(user1.getAuthorities());
//            return user1;
//        }
//        return null;
//    }
//}
