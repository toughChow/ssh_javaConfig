package com.qingshixun.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.model.Student;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveStudent(Student stu) {
		getCurrentSession().save(stu);
	}

	/**
	 * 分页获得
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Transactional
	public List<Student> getStudentList(int pageNo, int pageSize) {
		Session session = getCurrentSession();
		Query<Student> query = session.createQuery("From Student");
		query.setFirstResult(pageNo);
		query.setMaxResults(pageSize);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student.getId());
		}
		return list;
	}
	@Transactional
	public List<Student> getAllStudent() {
		Session session = getCurrentSession();
		Query<Student> query = session.createQuery("From Student");
		List<Student> list = query.list();
		return list;
	}

	@Transactional
	public long getTotalRows(int pageSize) {
		Session session = getCurrentSession();
		long result = (long) session.createQuery("select count(*) from Student").uniqueResult();
//		System.out.println("result :" + result);
		long record = result % pageSize;
//		System.out.println("records :" + record);
		if (record == 0) {
			return result/pageSize;
		} else {
			return result/pageSize + 1;
		}
	}
}
