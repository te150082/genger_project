package jp.te4a.spring.boot.myapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp.Bean.LectureBean;
import jp.te4a.spring.boot.myapp.Form.LectureForm;
import jp.te4a.spring.boot.myapp.Repository.LectureRepository;

@Service
public class LectureService {
	@Autowired
	LectureRepository lectureRepository;
	
	public LectureForm create(LectureForm lectureForm) {
		LectureBean lectureBean = new LectureBean();
		BeanUtils.copyProperties(lectureForm, lectureBean);
		lectureRepository.save(lectureBean);
		return lectureForm;
	}
	public LectureForm update(LectureForm lectureForm) {
		LectureBean lectureBean = new LectureBean();
		BeanUtils.copyProperties(lectureForm, lectureBean);
		lectureRepository.save(lectureBean);
		return lectureForm;
	}
	
	public void delete(Integer id){
		LectureBean b = new LectureBean();
		b.setId(id);
		lectureRepository.delete(b);
	}
	
	public List<LectureForm> findAll(){
		List<LectureBean> beanList = lectureRepository.findAll();
		List<LectureForm> formList = new ArrayList<LectureForm>();
		for(LectureBean lectureBean:beanList){
			LectureForm lectureForm = new LectureForm();
			BeanUtils.copyProperties(lectureBean, lectureForm);
			formList.add(lectureForm);
		}
		return formList;
	}
	public LectureForm findOne(Integer id) {
		Optional<LectureBean> opt = lectureRepository.findById(id);
		LectureForm lectureForm = new LectureForm();
		opt.ifPresent(lecture ->{
			BeanUtils.copyProperties(lecture, lectureForm);
			
		});
		return lectureForm;
	}
	public List<LectureForm> findByname(String name) {
		List<LectureBean> beanList = lectureRepository.findByName(name);
		List<LectureForm> formList = new ArrayList<LectureForm>();
		for(LectureBean lectureBean:beanList){
			LectureForm lectureForm = new LectureForm();
			BeanUtils.copyProperties(lectureBean, lectureForm);
			formList.add(lectureForm);
		}
		return formList;
	}
}
