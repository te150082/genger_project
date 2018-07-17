package jp.te4a.spring.boot.myapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.te4a.spring.boot.myapp.Bean.ScheduleBean;

public interface ScheduleRepository extends JpaRepository<ScheduleBean, Integer>{

}
