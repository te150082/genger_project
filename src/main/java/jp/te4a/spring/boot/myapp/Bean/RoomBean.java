package jp.te4a.spring.boot.myapp.Bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBean {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer name;
	private Integer capacity;
	@OneToMany(mappedBy="room")
	private List<ScheduleBean> scehdulebean;
	
}
