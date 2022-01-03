package com.project.kbj.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.SymptomDTO;

@Repository
public class SymptomRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public void insert(SymptomDTO s) {
		// TODO Auto-generated method stub
		sql.insert("Symptom.insert",s);
	}

	public List<SymptomDTO> sym(String ds_id) {
		// TODO Auto-generated method stub
		return sql.selectList("Symptom.sym",ds_id);
	}
}
