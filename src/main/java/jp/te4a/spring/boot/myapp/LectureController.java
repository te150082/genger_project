package jp.te4a.spring.boot.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LectureController {
    @Autowired
    LectureService lectureService;
    @RequestMapping("lectures")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "lectures/add-lec";
    }
    @RequestMapping(value="lectures/add-lec", method=RequestMethod.POST)
     public ModelAndView postForm(@RequestParam("name") String name, 
    @RequestParam("phone") String phone,@RequestParam("address") String address) {
         ModelAndView mv = new ModelAndView("lectures/add-lec");
         lectureService.save(new LectureBean(name, phone, address));
         // TODO:DEBUG
         //List<LectureBean> a = new List();
         // mv.addObject("lectures", a);
         mv.addObject("lectures", lectureService.findAll());
         return mv;
    }
    @RequestMapping(value="lectures/confirm-lec", method=RequestMethod.POST)
    public ModelAndView postForm2(@RequestParam("name") String name, 
    	    @RequestParam("phone") String phone,@RequestParam("address") String address, LectureForm form) {
    	         form.setName(name);
    	         form.setPhone(phone);
    	         form.setAddress(address);
    	         ModelAndView mv = new ModelAndView("lectures/confirm-lec");
    	         lectureService.save(new LectureBean(name, phone, address));
    	         // TODO:DEBUG
    	         //List<LectureBean> a = new List();
    	         // mv.addObject("lectures", a);
    	         mv.addObject("lectures", lectureService.findAll());
    	         return mv;
    	    }
    
}