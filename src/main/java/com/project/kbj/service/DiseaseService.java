package com.project.kbj.service;

import java.util.List;

import com.project.kbj.dto.DiseaseDTO;

public interface DiseaseService {

	public void insert(DiseaseDTO di);

	public List<DiseaseDTO> check();

}
