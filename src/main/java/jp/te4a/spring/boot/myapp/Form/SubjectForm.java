package jp.te4a.spring.boot.myapp.Form;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;
@Data
@NoArgsConstructor
public class SubjectForm  {
	private Integer id;
	@Size(max = 60)
	private String grade;
	private String subject;
	
}