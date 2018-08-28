package jp.te4a.spring.boot.myapp.Form;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentForm {
	private Integer id;
	@Size(max = 60)
	private String name;
	@Size(max = 255)
	private String address;
	@Size(max = 30)
	private String phone;
	private Integer grade_id;
}
