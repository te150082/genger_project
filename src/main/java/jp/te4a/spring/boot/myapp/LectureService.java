package jp.te4a.spring.boot.myapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

    @Autowired
    LectureRepository lectureRepository;

    public LectureBean save(LectureBean lectureBean) {
        return lectureRepository.save(lectureBean);
    }

    public List<LectureBean> findAll() {
        return lectureRepository.findAll();
    }
}

