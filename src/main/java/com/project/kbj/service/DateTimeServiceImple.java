package com.project.kbj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.DateTimeDTO;
import com.project.kbj.repository.DateTimeRepository;

@Service
public class DateTimeServiceImple implements DateTimeService {

	@Autowired
	private DateTimeRepository dtr;

	/*
	 * @Override public String check(DateTimeDTO dt) { DateTimeDTO dtt =
	 * dtr.check(dt);
	 * 
	 * if(dtt==null) { return "ok"; }else return "no"; }
	 * 
	 * @Override public void insert(DateTimeDTO dt) { // TODO Auto-generated method
	 * stub dtr.insert(dt); }
	 */
	

}
