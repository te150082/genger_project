package jp.te4a.spring.boot.myapp.Bean;


import java.sql.Date;
import java.sql.Time;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "time_schedule")
@ToString(exclude="room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleBean  {
	
//	@EmbeddedId
	@Id
	@Column(name="id")
	private Integer timeId;
//	private Integer id;
	private Date date;
	private Time time;
	@ManyToOne(fetch = FetchType.EAGER)
	private RoomBean room;
	@Column(name="subject_id")
	private Integer subjectid;
}
