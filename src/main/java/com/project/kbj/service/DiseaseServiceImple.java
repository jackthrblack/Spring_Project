package com.project.kbj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.DiseaseDTO;
import com.project.kbj.repository.DiseaseRepository;

@Service
public class DiseaseServiceImple implements DiseaseService {

	@Autowired
	private DiseaseRepository dr;

	
	@Override
	public void insert(DiseaseDTO di) {
		// TODO Auto-generated method stub
		dr.insert(di);
	}

	@Override
	public List<DiseaseDTO> check() {
		List<DiseaseDTO> di=dr.check();
		return di;
	}

}
