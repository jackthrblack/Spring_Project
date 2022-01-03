package com.project.kbj.service;

import java.util.List;

import com.project.kbj.dto.SymptomDTO;

public interface SymptomService {

	public void insert(SymptomDTO s);

	public List<SymptomDTO> sym(String ds_id);


}
