package com.project.kbj.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.DiseaseDTO;

@Repository
public class DiseaseRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public void insert(DiseaseDTO di) {
		// TODO Auto-generated method stub
		sql.insert("Disease.insert",di);
	}

	public List<DiseaseDTO> check() {
		// TODO Auto-generated method stub
		return sql.selectList("Disease.check");
	}
}
