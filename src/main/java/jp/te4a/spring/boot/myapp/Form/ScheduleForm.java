package jp.te4a.spring.boot.myapp.Form;

import java.sql.Date;
import java.sql.Time;

import jp.te4a.spring.boot.myapp.Bean.RoomBean;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleForm {
	private Integer Id;
	private Date date;
	private Time time;
	private RoomBean room;
	private Integer subject_id;
}
