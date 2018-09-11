/**
 * 
 */
package jp.te4a.spring.boot.myapp.Bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 140170
 *
 */
@Embeddable
@Data
@NoArgsConstructor
public class LectureSubjectPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer lecture_id;
	private Integer subjects_id;
}
