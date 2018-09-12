package jp.te4a.spring.boot.myapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp.Bean.LectureBean;
import jp.te4a.spring.boot.myapp.Bean.SubjectBean;
import jp.te4a.spring.boot.myapp.Form.LectureForm;
import jp.te4a.spring.boot.myapp.Form.SubjectForm;
import jp.te4a.spring.boot.myapp.Repository.LectureRepository;
import jp.te4a.spring.boot.myapp.Repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	SubjectRepository subjectRepository;
	
	public SubjectForm create(SubjectForm subjectForm) {
		SubjectBean subjectBean = new SubjectBean();
		BeanUtils.copyProperties(subjectForm, subjectBean);
		subjectRepository.save(subjectBean);
		return subjectForm;
	}
	public SubjectForm update(SubjectForm subjectForm) {
		SubjectBean subjectBean = new SubjectBean();
		BeanUtils.copyProperties(subjectForm, subjectBean);
		subjectRepository.save(subjectBean);
		return subjectForm;
	}
	
	public void delete(Integer id){
		SubjectBean b = new SubjectBean();
		b.setId(id);
		subjectRepository.delete(b);
	}
	
	public List<SubjectForm> findAll(){
		List<SubjectBean> beanList = subjectRepository.findAll();
		List<SubjectForm> formList = new ArrayList<SubjectForm>();
		for(SubjectBean subjectBean:beanList){
			SubjectForm subjectForm = new SubjectForm();
			BeanUtils.copyProperties(subjectBean, subjectForm);
			formList.add(subjectForm);
		}
		return formList;
	}
	public SubjectForm findOne(Integer id) {
		Optional<SubjectBean> opt = subjectRepository.findById(id);
		SubjectForm subjectForm = new SubjectForm();
		opt.ifPresent(lecture ->{
			BeanUtils.copyProperties(lecture, subjectForm);
			
		});
		return subjectForm;
	}
	public List<SubjectForm> findBysubject(String subject) {
		List<SubjectBean> beanList = subjectRepository.findBySubject(subject);
		List<SubjectForm> formList = new ArrayList<SubjectForm>();
		for(SubjectBean subjectBean:beanList){
			SubjectForm subjectForm = new SubjectForm();
			BeanUtils.copyProperties(subjectBean, subjectForm);
			formList.add(subjectForm);
		}
		return formList;
	}
}
