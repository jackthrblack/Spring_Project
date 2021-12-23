package com.project.kbj.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.CommentDTO;

@Repository
public class CommentRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public void save(CommentDTO comment) {
		// TODO Auto-generated method stub
		sql.insert("Comment.insert", comment);
	}

	public List<CommentDTO> findAll(long d_number) {
		// TODO Auto-generated method stub
		return sql.selectList("Comment.findAll", d_number);
	}


}
