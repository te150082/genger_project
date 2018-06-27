package jp.te4a.spring.boot.myapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<StudentBean, Integer>{

}
