package jp.te4a.spring.boot.myapp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    @Autowired
    LectureRepository lectureRepository;
	public  LectureForm create(LectureForm lectureForm) {
		LectureBean lectureBean = new LectureBean();
		BeanUtils.copyProperties(lectureForm, lectureBean);
		lectureRepository.save(lectureBean);
		return lectureForm;
	}
}
