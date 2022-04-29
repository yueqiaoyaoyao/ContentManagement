package contentmanagement.config;

import contentmanagement.pojo.Right;
import contentmanagement.pojo.Role;
import contentmanagement.pojo.User;
import contentmanagement.service.RightServiceImpl;
import contentmanagement.service.RoleServiceImpl;
import contentmanagement.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.shiro.authz.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    RightServiceImpl rightService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Right right = rightService.queryRight(user.getName());
        if (right == null)
            return null;
        Role role = roleService.queryRole(right.getRoleName());

        Collection<String> list = new ArrayList<>();
        String[] ss = role.getFunctions().split(",");
        for (String func:ss) {
            int i = Integer.parseInt(func);
            String r = "role" + i;
            list.add(r);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(list);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;


        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
