package jp.te4a.spring.boot.myapp.Bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "time_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeStudentBean {
	@EmbeddedId
	@Id
	private TimeStudentPK timestudentpk;
}
