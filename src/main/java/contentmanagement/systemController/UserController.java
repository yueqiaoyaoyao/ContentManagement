package contentmanagement.systemController;

import contentmanagement.pojo.Right;
import contentmanagement.pojo.Role;
import contentmanagement.pojo.User;
import contentmanagement.service.RightServiceImpl;
import contentmanagement.service.RoleServiceImpl;
import contentmanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    RightServiceImpl rightService;

    @RequestMapping("/user/list")
    public String list(Model model){
        List<Right> rightList = rightService.getAllRight();
        model.addAttribute("rightList",rightList);
        return "user/user";
    }

    @RequestMapping("/user/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("password") String password,
                      Model model){
        int i = userService.addUser(name,password);
        if(i != 1){
            model.addAttribute("msg","添加失败");
            return "user/add";
        }else {
            model.addAttribute("msg","添加成功");
        }
        return "redirect:/user/list";
    }

    @GetMapping("/user/modify")
    public String get(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("roleList",roleList);
        return "user/modify";
    }

    @PostMapping("user/modify/save")
    public String save(String username,
                       String rolename){
        if (rightService.addRight(username,rolename) == 0){
            rightService.updateRight(username,rolename);
        }
        return "redirect:/user/list";
    }


    @GetMapping("/user/delete/{name}")
    public String delete(@PathVariable("name") String name){
        rightService.deleteRight(name);
        return "redirect:/user/list";
    }

}
