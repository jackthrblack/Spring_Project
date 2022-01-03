package com.project.kbj.service;


import java.sql.Date;
import java.util.List;

import com.project.kbj.dto.DateTimeDTO;
import com.project.kbj.dto.ReservationDTO;

public interface ReservationService {

	public void insert(ReservationDTO r);
	  public String check(Date r_date);
	  public String check2(String r_time);
	  public long check3(long d_number);
	public List<ReservationDTO> rList(long m_number);
	public void delete(long r_number);
	 


//	public ReservationDTO time(ReservationDTO r);

}
