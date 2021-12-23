package com.project.kbj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.CommentDTO;
import com.project.kbj.repository.CommentRepository;

@Service
public class CommentServiceImple implements CommentService {

	@Autowired
	private CommentRepository cr;

	@Override
	public void save(CommentDTO comment) {
		// TODO Auto-generated method stub
		cr.save(comment);
	}

	@Override
	public List<CommentDTO> findAll(long d_number) {
		// TODO Auto-generated method stub
		return cr.findAll(d_number);
	}


	
}
