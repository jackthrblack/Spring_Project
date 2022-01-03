package com.project.kbj.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.DateTimeDTO;

@Repository
public class DateTimeRepository {

	@Autowired
	private SqlSessionTemplate sql;

	/*
	 * public DateTimeDTO check(DateTimeDTO dt) { // TODO Auto-generated method stub
	 * return sql.selectOne("DT.check",dt); }
	 * 
	 * public void insert(DateTimeDTO dt) { // TODO Auto-generated method stub
	 * sql.insert("DT.insert"); }
	 */
	

}