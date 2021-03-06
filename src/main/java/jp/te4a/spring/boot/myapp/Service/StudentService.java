package jp.te4a.spring.boot.myapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp.Bean.StudentBean;
import jp.te4a.spring.boot.myapp.Form.StudentForm;
import jp.te4a.spring.boot.myapp.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public StudentForm create(StudentForm studentForm) {
		StudentBean studentBean = new StudentBean();
		BeanUtils.copyProperties(studentForm, studentBean);
		studentRepository.save(studentBean);
		return studentForm;
	}
	public StudentForm update(StudentForm studentForm) {
		StudentBean studentBean = new StudentBean();
		BeanUtils.copyProperties(studentForm, studentBean);
		studentRepository.save(studentBean);
		return studentForm;
	}

	public void delete(@RequestParam Integer id) {		 
		  StudentBean studentBean = new StudentBean();
		  studentBean.setId(id);
		  studentRepository.delete(studentBean);
	}
	public List<StudentForm> findAll(){
		List<StudentBean> beanList = studentRepository.findAll();
		List<StudentForm> formList = new ArrayList<StudentForm>();
		for(StudentBean studentBean:beanList){
			StudentForm studentForm = new StudentForm();
			BeanUtils.copyProperties(studentBean, studentForm);
			formList.add(studentForm);
		}
		return formList;
	}
	public StudentForm findOne(Integer id) {
		Optional<StudentBean> opt = studentRepository.findById(id);
		StudentForm studentForm = new StudentForm();
		opt.ifPresent(student ->{
			BeanUtils.copyProperties(student, studentForm);
			
		});
		return studentForm;
	}
	public List<StudentForm> findByname(String name) {
		List<StudentBean> beanList = studentRepository.findByName(name);
		List<StudentForm> formList = new ArrayList<StudentForm>();
		for(StudentBean studentBean:beanList){
			StudentForm studentForm = new StudentForm();
			BeanUtils.copyProperties(studentBean, studentForm);
			formList.add(studentForm);
		}
		return formList;
	}
}
