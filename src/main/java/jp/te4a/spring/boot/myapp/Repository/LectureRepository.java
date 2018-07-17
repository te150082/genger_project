package jp.te4a.spring.boot.myapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.spring.boot.myapp.Bean.LectureBean;

public interface LectureRepository extends JpaRepository<LectureBean, Integer>{
	public List<LectureBean> findByName(String name);
}
