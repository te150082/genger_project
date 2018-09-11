package jp.te4a.spring.boot.myapp.Form;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;
@Data
@NoArgsConstructor
public class LectureSubjectForm  {
	private Integer lecture_id;
	@Size(max = 11)
	private Integer subjects_id;
}