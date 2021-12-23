package com.project.kbj.service;

import java.util.List;

import com.project.kbj.dto.CommentDTO;

public interface CommentService {

	void save(CommentDTO comment);

	List<CommentDTO> findAll(long d_number);



}
