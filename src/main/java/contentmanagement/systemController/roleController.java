package contentmanagement.systemController;

import contentmanagement.pojo.Role;
import contentmanagement.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class roleController {

    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping("/role/list")
    public String list(Model model){
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("roleList",roleList);
        return "role/role";
    }

    @RequestMapping("/role/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("functions") String functions,
                      Model model){
        int i = roleService.addRole(name,functions);
        if(i != 1){
            model.addAttribute("msg","添加失败");
            return "role/add";
        }else {
            model.addAttribute("msg","添加成功");
        }
        return "redirect:/role/list";
    }

    @GetMapping("/role/modify/{name}")
    public String getMessage(@PathVariable("name") String name,
                                Model model){
        Role role = roleService.queryRole(name);
        model.addAttribute("role",role);
        return "role/modify";
    }

    @RequestMapping ("/role/modify")
    public String modify(@RequestParam("name") String name,
                         @RequestParam("functions") String functions,
                         Model model){
        if(roleService.updateRole(name,functions) == 0){
            model.addAttribute("msg","修改失败");
            return "redirect:/role/modify/"+name;
        }
        return "redirect:/role/list";
    }

    @GetMapping("/role/delete/{name}")
    public String delete(@PathVariable("name") String name){
        roleService.deleteRole(name);
        return "redirect:/role/list";
    }

}
