package jp.te4a.spring.boot.myapp;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

import lombok.Data;
@Data
@NoArgsConstructor
public class LectureForm  {
	private Integer id;
	@Size(max = 60)
	private String name;
	@Size(max = 255)
	private String address;
	@Size(max = 30)
	private String phone;
	private Integer grade_id;
	private String[] subject;
}