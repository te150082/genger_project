package jp.te4a.spring.boot.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("search_students")
public class searchController_students {
	
	@Autowired
	StudentService studentService;
    
	@RequestMapping("search")
    public String index(Model model) {
        return "/search.html";
    }
    
	@GetMapping
    String list(Model model) {
      model.addAttribute("students", studentService.findAll());
      return "/search";
    }
}
