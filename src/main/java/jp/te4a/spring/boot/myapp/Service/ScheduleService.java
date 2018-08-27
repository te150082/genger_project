package jp.te4a.spring.boot.myapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp.Bean.ScheduleBean;
import jp.te4a.spring.boot.myapp.Form.ScheduleForm;
import jp.te4a.spring.boot.myapp.Repository.ScheduleRepository;

@Service
public class ScheduleService {
	
    @Autowired
    ScheduleRepository ScheduleRepository;
    
    public ScheduleForm findOne(Integer id) {
		Optional<ScheduleBean> opt = ScheduleRepository.findById(id);
		ScheduleForm scheduleForm = new ScheduleForm();
		opt.ifPresent(schedule ->{
			BeanUtils.copyProperties(schedule, scheduleForm);
		});
		return scheduleForm;
    }
	public List<ScheduleForm> findAll(){
		List<ScheduleBean> beanList = ScheduleRepository.findAll();
		List<ScheduleForm> formList = new ArrayList<ScheduleForm>();
		for(ScheduleBean ScheduleBean:beanList){
			ScheduleForm scheduleForm = new ScheduleForm();
			BeanUtils.copyProperties(ScheduleBean, scheduleForm);
			formList.add(scheduleForm);
		}
		return formList;
	}
    
}
