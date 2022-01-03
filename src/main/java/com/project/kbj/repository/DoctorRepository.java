package com.project.kbj.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.DoctorDTO;

@Repository
public class DoctorRepository {
	
	@Autowired
	private SqlSessionTemplate sql;

	public void insert(DoctorDTO d) {
		// TODO Auto-generated method stub
		sql.insert("Doctor.insert", d);
	}

	public void delete(long d_number) {
		sql.delete("Doctor.delete", d_number);
		
	}

	public int doctorCount() {
		// TODO Auto-generated method stub
		return sql.selectOne("Doctor.count");
	}

	public List<DoctorDTO> pagingList1(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("Doctor.pagingList1", pagingParam);
	}

	public DoctorDTO login(DoctorDTO d) {
		// TODO Auto-generated method stub
		return sql.selectOne("Doctor.login", d);
	}

	public DoctorDTO review(long d_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Doctor.review",d_number);
	}

	public List<DoctorDTO> doctor() {
		// TODO Auto-generated method stub
		return sql.selectList("Doctor.doctor");
	}

	/*
	 * public long d_num(String r_doctor) { return sql.selectOne("Doctor.d_num",
	 * r_doctor); }
	 */


}
