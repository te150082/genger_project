package jp.te4a.spring.boot.myapp;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LectureController {
    @Autowired
    LectureService lectureService;
    @RequestMapping("lecturers/create")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "lecturers/add-lec";
    }
    @RequestMapping(value="lecturers/add-lec", method=RequestMethod.POST)
     public ModelAndView postForm(@RequestParam("name") String name, 
    @RequestParam("phone") String phone,@RequestParam("address") String address) {
         ModelAndView mv = new ModelAndView("lecturers/add-lec");
         lectureService.save(new LectureBean(name, phone, address));
         // TODO:DEBUG
         //List<LectureBean> a = new List();
         // mv.addObject("lectures", a);
         mv.addObject("lecturers", lectureService.findAll());
         return mv;
    }
    @RequestMapping(value="lecturers/confirm-lec", method=RequestMethod.POST)
    public ModelAndView postForm2(@RequestParam("name") String name, 
    	    @RequestParam("phone") String phone,@RequestParam("address") String address, @RequestParam("subject") String[] subject, LectureForm form) {
    	    
    	         form.setName(name);
    	         form.setPhone(phone);
    	         form.setAddress(address);
    	         form.setSubject(subject);
        
    	         ModelAndView mv = new ModelAndView("lecturers/confirm-lec");
    	         lectureService.save(new LectureBean(name, phone, address));
    	         // TODO:DEBUG
    	         //List<LectureBean> a = new List();
    	         // mv.addObject("lectures", a);
    	         mv.addObject("lecturers", lectureService.findAll());
    	         return mv;
    	    }
    
}