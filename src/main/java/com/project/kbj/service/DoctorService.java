package com.project.kbj.service;

import java.util.List;

import com.project.kbj.dto.DoctorDTO;
import com.project.kbj.dto.PageDTO;
import com.project.kbj.dto.PageDTO2;

public interface DoctorService {

	public void insert(DoctorDTO d);

	public void delete(long d_number);

	public PageDTO2 paging(int page);

	public List<DoctorDTO> pagingList(int page);

	public String login(DoctorDTO d);

	public DoctorDTO review(long d_number);

	public List<DoctorDTO> doctor();


	/* public long d_num(String r_doctor); */



}
