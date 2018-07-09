package jp.te4a.spring.boot.myapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<LectureBean, Integer>{

}
