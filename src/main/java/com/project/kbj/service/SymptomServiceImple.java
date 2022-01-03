package com.project.kbj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.SymptomDTO;
import com.project.kbj.repository.SymptomRepository;

@Service
public class SymptomServiceImple implements SymptomService{
	
	@Autowired
	private SymptomRepository sr;

	@Override
	public void insert(SymptomDTO s) {
		// TODO Auto-generated method stub
		sr.insert(s);
	}

	@Override
	public List<SymptomDTO> sym(String ds_id) {
		List<SymptomDTO> s = sr.sym(ds_id);
		return s;
	}



}
