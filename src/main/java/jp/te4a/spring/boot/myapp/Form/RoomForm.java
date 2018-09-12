package jp.te4a.spring.boot.myapp.Form;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomForm {
	private Integer id;
	private Integer name;
	private Integer capacity;
}
