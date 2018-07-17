package jp.te4a.spring.boot.myapp.Controller;

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

import jp.te4a.spring.boot.myapp.Form.StudentForm;
import jp.te4a.spring.boot.myapp.Service.StudentService;

@Controller
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@ModelAttribute
	StudentForm setUpForm() {
		return new StudentForm();
	}
	@GetMapping
	String add(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "students/add_stu";
	}
	@PostMapping(path="create")
	String create(StudentForm form,Model model) {
//		if(result.hasErrors()) {
//			return list(model);
//		}
		studentService.create(form);
		return "redirect:/students";
	}
	@PostMapping(path = "edit", params = "form")
	String editForm(@RequestParam Integer id, StudentForm form){
		StudentForm studentForm = studentService.findOne(id);
		BeanUtils.copyProperties(studentForm,  form);
		return "students/edit";
	}
	
	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, @Validated StudentForm form, BindingResult result) {
		if(result.hasErrors()) {
			return editForm(id,form);
		}
		studentService.update(form);
		return "redirect:/students";
	}
	
	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id){
		studentService.delete(id);
		return "redirect:/students";
	}
	
	@PostMapping(path = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/students";
	}


}
