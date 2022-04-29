package contentmanagement.systemController;

import contentmanagement.pojo.User;
import contentmanagement.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/login/check")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            return "main";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

//        User user = userService.queryUserByName(name);
//        if(user == null){
//            model.addAttribute("msg","用户不存在");
//            return "login";
//        }
//        if(password.equals(user.getPassword())){
//            session.setAttribute("LoginUser",name);
//            model.addAttribute("msg",name);
//            return "main";
//        }
//        model.addAttribute("msg","密码错误");

    }

    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
