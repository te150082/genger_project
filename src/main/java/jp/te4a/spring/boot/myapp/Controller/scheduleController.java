package jp.te4a.spring.boot.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp.Service.ScheduleService;
import jp.te4a.spring.boot.myapp.Service.StudentService;


@Controller
@RequestMapping("schedule")
public class scheduleController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ScheduleService scheduleService;
	
	@PostMapping
    String list(@RequestParam Integer id,Model model) {
      model.addAttribute("students", studentService.findOne(id));
      model.addAttribute("schedule", scheduleService.findAll());
      System.out.println(model);
      return "schedule.html";
    }
	
	
}
