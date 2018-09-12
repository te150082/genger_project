package jp.te4a.spring.boot.myapp.Bean;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "lectures_subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureSubjectBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private LectureSubjectPK lectureSubjectPK;
}