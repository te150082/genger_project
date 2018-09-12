package jp.te4a.spring.boot.myapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.te4a.spring.boot.myapp.Bean.StudentBean;

public interface StudentRepository extends JpaRepository<StudentBean, Integer>{
	public List<StudentBean> findByName(String name);
}
