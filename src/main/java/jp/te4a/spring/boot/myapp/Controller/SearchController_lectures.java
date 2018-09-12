package jp.te4a.spring.boot.myapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp.Form.LectureSubjectForm;
import jp.te4a.spring.boot.myapp.Form.SubjectForm;
import jp.te4a.spring.boot.myapp.Service.LectureService;
import jp.te4a.spring.boot.myapp.Service.LectureSubjectService;
import jp.te4a.spring.boot.myapp.Service.SubjectService;


@Controller
@RequestMapping("search_lectures")
public class SearchController_lectures {
	
	@Autowired LectureService lectureService;
	@Autowired LectureSubjectService lecturesubjectService;
	@Autowired SubjectService subjectService;
    
	@RequestMapping("search")
    public String index(Model model) {
        return "/search.html";
    }
	
	@GetMapping
    String list(Model model) {
      model.addAttribute("lectures", lectureService.findAll());
		System.out.println("DEBUG:"+model);
		
		List<LectureSubjectForm> lecturesSubjectsList = lecturesubjectService.findAll();
		for(LectureSubjectForm i:lecturesSubjectsList) {
			System.out.println("lid:" + i.getLecture_id());
			System.out.println("sid:" + i.getSubjects_id());
		}
		List<SubjectForm> subjectList = subjectService.findAll();
		// 講師のIDごとに科目IDを取り出し、科目IDを使って、DB（lecturesテーブル）から科目名を取得する
		//model.addAttribute("subject", subjectService.findAll());
		
		
		model.addAttribute("value",1);
		return "/search";
    }
	@GetMapping("/research")
    String one(@RequestParam String name,Model model) {
      model.addAttribute("value",1);
      model.addAttribute("lectures", lectureService.findByname(name));
      return "/search";
    }
}
