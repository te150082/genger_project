package jp.te4a.spring.boot.myapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp.Bean.LectureSubjectBean;
import jp.te4a.spring.boot.myapp.Bean.LectureSubjectPK;
import jp.te4a.spring.boot.myapp.Form.LectureSubjectForm;
import jp.te4a.spring.boot.myapp.Repository.LectureSubjectRepository;

@Service
public class LectureSubjectService {
	@Autowired
	LectureSubjectRepository lecturesubjectRepository;
	
	public LectureSubjectForm create(LectureSubjectForm lecturesubjectForm) {
		LectureSubjectBean lecturesubjectBean = new LectureSubjectBean();
		BeanUtils.copyProperties(lecturesubjectForm, lecturesubjectBean);
		lecturesubjectRepository.save(lecturesubjectBean);
		return lecturesubjectForm;
	}
	public LectureSubjectForm update(LectureSubjectForm lecturesubjectForm) {
		LectureSubjectBean lecturesubjectBean = new LectureSubjectBean();
		BeanUtils.copyProperties(lecturesubjectForm, lecturesubjectBean);
		lecturesubjectRepository.save(lecturesubjectBean);
		return lecturesubjectForm;
	}
	
//	public void delete(Integer id){
//		LectureSubjectBean b = new LectureSubjectBean();
//		
//		LectureSubjectPK lpk = new LectureSubjectPK();
//		
//		// idはlecture_idのこと？subject_idのこと？
//		lpk.setLecture_id(id);
//
//		b.setLectureSubjectPK(lpk);
//		lecturesubjectRepository.delete(b);
//	}
	
	public List<LectureSubjectForm> findAll(){
		List<LectureSubjectBean> beanList = lecturesubjectRepository.alllecture();
		for(int i=0;i < beanList.size();i++) {
			System.out.println(beanList.get(i));
		}
		System.out.println("DEBUG00:"+beanList);
		
		List<LectureSubjectForm> formList = new ArrayList<LectureSubjectForm>();
		for(LectureSubjectBean lecturesubjectBean:beanList){
			LectureSubjectForm lecturesubjectForm = new LectureSubjectForm();
			BeanUtils.copyProperties(lecturesubjectBean, lecturesubjectForm);
			formList.add(lecturesubjectForm);
		}
		System.out.println("DEBUG00:" + formList);
		return formList;
	}
	/*public LectureSubjectForm findOne(LectureSubjectBean id) {
		
		// １．LectureSubjectBeanの変数作成(new)
		// ２．１の変数の講師IDか科目IDのどちらかにidをセット
		// ３．findByIdに１をセットする
		
		LectureSubjectBean b = new LectureSubjectBean();

		b.setLecture_id(id);
		
	    Optional<LectureSubjectBean> opt = lecturesubjectRepository.findById(b);
		LectureSubjectForm lecturesubjectForm = new LectureSubjectForm();
		opt.ifPresent(lecture ->{
			BeanUtils.copyProperties(lecture, lecturesubjectForm);
			
		});
		return lecturesubjectForm;
	}*/
}
