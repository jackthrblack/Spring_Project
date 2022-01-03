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
		System.out.println("cr:"+comment);
		cr.save(comment);
	}

	@Override
	public List<CommentDTO> findAll(long d_number) {
		// TODO Auto-generated method stub
		System.out.println("cr2:"+d_number);
		return cr.findAll(d_number);
	}

	@Override
	public void delete(long c_number) {
		cr.delete(c_number);
		
	}


	@Override
	public double avg(long d_number) {
		double avg = cr.avg(d_number);
		if(avg != 0) {
			return avg;
		} else {
			return 0;
		}

	}

}
