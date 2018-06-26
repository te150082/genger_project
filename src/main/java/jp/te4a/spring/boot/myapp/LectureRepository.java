package jp.te4a.spring.boot.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

@Repository
public class LectureRepository {

    private final ConcurrentMap<String, LectureBean> lectureMap = new ConcurrentHashMap<>();
    public LectureBean save(LectureBean lectureBean) {
        return lectureMap.put(lectureBean.getName(), lectureBean);
    }

    public void delete(String lectureName) {
        lectureMap.remove(lectureName);
    }

    public List<LectureBean> findAll() {
        return new ArrayList<>(lectureMap.values());
    }
}
