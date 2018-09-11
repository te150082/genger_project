package jp.te4a.spring.boot.myapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.spring.boot.myapp.Bean.SubjectBean;

public interface SubjectRepository extends JpaRepository<SubjectBean, Integer>{
	// SELECT * FROM subjects where name = ??;
	public List<SubjectBean> findBySubject(String subject);
}
