package jp.te4a.spring.boot.myapp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.te4a.spring.boot.myapp.Form.LectureForm;
import jp.te4a.spring.boot.myapp.Service.LectureService;

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
        return "lectures/add";
    }
    
    @PostMapping
    String adds(Model model) {
    	return "lectures/add";
    }
    
    @PostMapping(path="edit")
    String edit(Model model) {
    	return "lectures/edit";
    }
    
    @PostMapping(path="create")
    String create (LectureForm form,Model model){
    	
    	String[] param = form.getSubject();
    	String[] param2 = {"", "", "", "", "", ""};
    	
    	for(int i = 0; param != null && i < param.length; i++) {
    	    if(param[i].equals("0")) param2[0] = "0";
    	    else if(param[i].equals("1"))param2[1] = "1";
    	    else if(param[i].equals("2"))param2[2] = "2";
    	    else if(param[i].equals("3"))param2[3] = "3";
    	    else if(param[i].equals("4"))param2[4] = "4";
    	    else if(param[i].equals("5"))param2[5] = "5";
    	}
        form.setSubject(param2); 
    	lectureService.create(form);
    	return "lectures/confirm";
        //return "redirect:/lectures";
    }
}