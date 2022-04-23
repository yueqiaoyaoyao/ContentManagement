package contentmanagement.systemController;

import contentmanagement.pojo.User;
import contentmanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/register/check")
    public String register(@RequestParam("name") String name,
                           @RequestParam("password") String password,
                           Model model){
        User user = userService.queryUserByName(name);
        if(user != null){
            model.addAttribute("msg","用户已存在");
            return "login";
        }
        if(name == "" || name == null || password == ""){
            model.addAttribute("msg","用户名或者密码为空");
            return "login";
        }
        int i = userService.addUser(name,password);
        if(i == 1){
            model.addAttribute("msg","用户注册成功");
        }else {
            model.addAttribute("msg","用户注册失败");
        }
        return "login";
    }
}
