package com.project.kbj.service;

import java.util.List;

import com.project.kbj.dto.CommentDTO;

public interface CommentService {

	public void save(CommentDTO comment);

	public List<CommentDTO> findAll(long d_number);

	public void delete(long c_number);

	public double avg(long d_number);

}
