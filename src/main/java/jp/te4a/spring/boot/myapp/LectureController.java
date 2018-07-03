package jp.te4a.spring.boot.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lectures")
public class LectureController {
    
	@Autowired
    LectureService lectureService;
    
	@ModelAttribute
	LectureForm setUpForm() {
		return new LectureForm();
	}
	
    @GetMapping
    String add(Model model) {
        return "lectures/add-lec";
    }
    
    @PostMapping(path="create")
    String create (LectureForm form,Model model){
    	lectureService.create(form);
		return "redirect:/lectures";
    }
    
    
}