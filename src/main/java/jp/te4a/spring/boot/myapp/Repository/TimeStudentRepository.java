package jp.te4a.spring.boot.myapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.spring.boot.myapp.Bean.TimeStudentBean;
import jp.te4a.spring.boot.myapp.Bean.TimeStudentPK;

public interface TimeStudentRepository extends JpaRepository<TimeStudentBean, TimeStudentPK>{
}
