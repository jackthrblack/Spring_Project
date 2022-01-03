package com.project.kbj.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.DateTimeDTO;
import com.project.kbj.dto.ReservationDTO;
import com.project.kbj.repository.ReservationRepository;

@Service
public class ReservationServiceImple implements ReservationService {

	@Autowired
	private ReservationRepository rr;

	@Override
	public void insert(ReservationDTO r) {
		// TODO Auto-generated method stub
		rr.insert(r);
	}

	@Override
	public String check(Date r_date) {
		System.out.println("s1:" + r_date);
		String result = rr.check(r_date);
		System.out.println("s2:" + result);
		if (result == null){
			return "ok";
		} else
			return "no";
	}

	@Override
	public String check2(String r_time) {
		System.out.println("st1:" + r_time);
		String result = rr.check2(r_time);
		System.out.println("st2:" + result);
		if (result == null) {
			return "ok";
		} else
			return "no";
	}

	@Override
	public long check3(long d_number) {
		long result = rr.check3(d_number);
		return result;
	}

	@Override
	public List<ReservationDTO> rList(long m_number) {
		List<ReservationDTO> r = rr.rList(m_number);
		return r;
	}

	@Override
	public void delete(long r_number) {
		// TODO Auto-generated method stub
		rr.delete(r_number);
	}


}
