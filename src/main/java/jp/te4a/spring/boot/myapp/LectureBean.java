package jp.te4a.spring.boot.myapp;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "lectures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureBean  {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String phone;
	private String address;
}
