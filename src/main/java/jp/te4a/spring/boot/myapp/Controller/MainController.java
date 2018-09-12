package jp.te4a.spring.boot.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.te4a.spring.boot.myapp.Service.StudentService;

@Controller
public class MainController {
	@Autowired
	StudentService studentService;
	@RequestMapping("/")
	String index(Model model) {
		return "menu";
	}
}
