package jp.te4a.spring.boot.myapp.Bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Embeddable
public class TimeStudentPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private Integer timeId;
	
}
