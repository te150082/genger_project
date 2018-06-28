package jp.te4a.spring.boot.myapp;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class LectureForm  {
	String name;
	String phone;
	String address;
	String[] check;
}