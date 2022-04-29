package contentmanagement.systemController;

import contentmanagement.pojo.News;
import contentmanagement.pojo.Role;
import contentmanagement.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class ContentController {
    @Autowired
    NewsServiceImpl newsService;

    @RequestMapping("/content/list")
    public String list(Model model){
        List<News> newsList = newsService.findAll();
        model.addAttribute("newsList",newsList);
        return "content/content";
    }

    @RequestMapping("/content/add")
    public String add(@RequestParam("title") String title,
                      @RequestParam("writer") String writer,
                      @RequestParam("content") String content,
                      Model model){
        News news = new News();
        news.setTitle(title);
        news.setWriter(writer);
        news.setContent(content);
        news.setCreateTime(new Date());
        news.setUpdateTime(new Date());
        int i = newsService.addNews(news);
        if(i != 1){
            model.addAttribute("msg","添加失败");
            return "content/add";
        }else {
            model.addAttribute("msg","添加成功");
        }
        return "redirect:/content/list";
    }

    @GetMapping("/content/delete/{name}")
    public String delete(@PathVariable("name") String name){
        newsService.deleteNews(name);
        return "redirect:/content/list";
    }

    @GetMapping("/content/modify/{name}")
    public String getMessage(@PathVariable("name") String name,
                             Model model){
        News news = newsService.findByTitle(name);
        model.addAttribute("news",news );
        return "content/modify";
    }

    @RequestMapping ("/content/modify")
    public String modify(@RequestParam("title") String title,
                         @RequestParam("writer") String writer,
                         @RequestParam("content") String content,
                         Model model){
        News news = newsService.findByTitle(title);
        news.setWriter(writer);
        news.setContent(content);
        System.out.println(news);
        if(newsService.updateNews(news) == 0){
            model.addAttribute("msg","修改失败");
            return "redirect:/content/modify/"+title;
        }
        return "redirect:/content/list";
    }

}
