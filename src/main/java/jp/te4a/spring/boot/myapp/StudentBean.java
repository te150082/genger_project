package jp.te4a.spring.boot.myapp;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String address;
	private String phone;
//	@ManyToOne
//	private Integer grade_id;

}
