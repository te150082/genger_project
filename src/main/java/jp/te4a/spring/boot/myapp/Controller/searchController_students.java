package jp.te4a.spring.boot.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp.Service.StudentService;

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
      model.addAttribute("value",0);
      return "/search";
    }
	@GetMapping("/research")
    String one(@RequestParam String name,Model model) {
      model.addAttribute("value",0);
      model.addAttribute("students", studentService.findByname(name));
      System.out.println(name);
      return "/search";
    }
}
