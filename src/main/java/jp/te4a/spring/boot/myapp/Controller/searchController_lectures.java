package jp.te4a.spring.boot.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp.Service.LectureService;


@Controller
@RequestMapping("search_lectures")
public class searchController_lectures {
	
	@Autowired
    LectureService lectureService;
    
	@RequestMapping("search")
    public String index(Model model) {
        return "/search.html";
    }
	
	@GetMapping
    String list(Model model) {
      model.addAttribute("lectures", lectureService.findAll());
      model.addAttribute("value",1);
      return "/search";
    }
	@GetMapping("/research")
    String one(@RequestParam String name,Model model) {
      model.addAttribute("value",1);
      model.addAttribute("lectures", lectureService.findByname(name));
      System.out.println(name);
      return "/search";
    }
}
