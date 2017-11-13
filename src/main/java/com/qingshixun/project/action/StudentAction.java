package com.qingshixun.project.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qingshixun.project.dao.StudentDao;
import com.qingshixun.project.model.Student;

@Component
public class StudentAction {

	private int pageNo = 1;

	private List<Student> list;
	long records ;

	@Autowired
	private StudentDao studentDao;

	public String getStudentList() {
		list = studentDao.getStudentList((pageNo-1)*5, 5);
		
		records = studentDao.getTotalRows(5);
		return "success";
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}
	
	// 2
	
	List<Student> data;
	
	public String getAllStudent(){
		list = studentDao.getAllStudent();
		return "success";
	}

	public String getStudentJson(){
		System.out.println(6666);
//		data = studentDao.getStudentList((pageNo-1)*5, 5);
		data = studentDao.getAllStudent();
		return "success";
	}
	
	public List<Student> getData() {
		return data;
	}

	public void setData(List<Student> data) {
		this.data = data;
	}
}
