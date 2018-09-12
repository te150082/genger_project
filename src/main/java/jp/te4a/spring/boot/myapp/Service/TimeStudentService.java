package jp.te4a.spring.boot.myapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp.Bean.TimeStudentBean;
import jp.te4a.spring.boot.myapp.Bean.TimeStudentPK;
import jp.te4a.spring.boot.myapp.Repository.TimeStudentRepository;

@Service
public class TimeStudentService {
	@Autowired
	TimeStudentRepository timestudentRepository;
	
	public List<TimeStudentBean> findAll(){
		List<TimeStudentBean> beanList = timestudentRepository.findAll();
		return beanList;
	}
	public Optional<TimeStudentBean> findOne(TimeStudentPK id){
		Optional<TimeStudentBean> beanList = timestudentRepository.findById(id);
		return beanList;
	}
	 public void delete(Integer id) {		 
		  TimeStudentBean studenttime = new TimeStudentBean();
		  TimeStudentPK timeStudentPK = new TimeStudentPK();
		  List<TimeStudentBean> list_stu = this.findAll();
		  for(TimeStudentBean studentTimeBean:list_stu) {
			  if( studentTimeBean.getTimestudentpk().getStudentId() == id) {
				  Integer time_id = studentTimeBean.getTimestudentpk().getTimeId();
				  timeStudentPK.setStudentId(id);
				  timeStudentPK.setTimeId(time_id);
				  studenttime.setTimestudentpk(timeStudentPK);
				  timestudentRepository.delete(studenttime);
		  		}
		  }
	  }

}
