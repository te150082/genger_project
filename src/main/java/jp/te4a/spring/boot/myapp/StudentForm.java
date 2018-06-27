package jp.te4a.spring.boot.myapp;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentForm {
	private Integer id;
	@Size(max = 63)
	private String name;
	@Size(max = 255)
	private String address;
	@Size(max = 31)
	private String phone;
	private Integer grade_id;

}
