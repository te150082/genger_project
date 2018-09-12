package jp.te4a.spring.boot.myapp.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectBean {
	@Id
	@GeneratedValue
	private Integer id;
	private String grade;
	private String subject;
}
