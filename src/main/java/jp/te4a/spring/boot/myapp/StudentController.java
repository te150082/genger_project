package jp.te4a.spring.boot.myapp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService StudentService;
	
	@ModelAttribute
	StudentForm setUpForm() {
		return new StudentForm();
	}
	@GetMapping
	String list(Model model) {
		model.addAttribute("Students", StudentService.findAll());
		return "Students/list";
	}
	@PostMapping(path="create")
	String create(@Validated StudentForm form, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return list(model);
		}
		StudentService.create(form);
		return "redirect:/Students";
	}
	@PostMapping(path = "edit", params = "form")
	String editForm(@RequestParam Integer id, StudentForm form){
		StudentForm StudentForm = StudentService.findOne(id);
		BeanUtils.copyProperties(StudentForm,  form);
		return "Students/edit";
	}
	
	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, @Validated StudentForm form, BindingResult result) {
		if(result.hasErrors()) {
			return editForm(id,form);
		}
		StudentService.update(form);
		return "redirect:/Students";
	}
	
	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id){
		StudentService.delete(id);
		return "redirect:/Students";
	}
	
	@PostMapping(path = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/Students";
	}


}
