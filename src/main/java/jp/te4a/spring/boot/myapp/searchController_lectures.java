package jp.te4a.spring.boot.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
      return "/search";
    }
}
