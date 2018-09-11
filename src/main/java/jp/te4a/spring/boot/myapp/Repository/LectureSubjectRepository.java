package jp.te4a.spring.boot.myapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.te4a.spring.boot.myapp.Bean.LectureBean;
import jp.te4a.spring.boot.myapp.Bean.LectureSubjectBean;
import jp.te4a.spring.boot.myapp.Bean.LectureSubjectPK;
import lombok.Data;


public interface LectureSubjectRepository extends JpaRepository<LectureSubjectBean, LectureSubjectPK>{

	@Query("select u from LectureSubjectBean u ")
	public List<LectureSubjectBean> alllecture();
}
