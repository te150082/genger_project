package jp.te4a.spring.boot.myapp.Service;

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
		System.out.println(scheduleForm);
		return scheduleForm;
    }
}
