package com.project.kbj.repository;

import java.sql.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.DateTimeDTO;
import com.project.kbj.dto.ReservationDTO;

@Repository
public class ReservationRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public void insert(ReservationDTO r) {
		// TODO Auto-generated method stub
		sql.insert("Reservation.insert", r);
	}

	public String check(Date r_date) { // TODO Auto-generated method stub return
		return sql.selectOne("Reservation.check", r_date);
	}

	public String check2(String r_time) { // TODO Auto-generated method stub
		return sql.selectOne("Reservation.chekc2", r_time);
	}

	public long check3(long d_number) { // TODO Auto-generated method stub return
		return sql.selectOne("Reservation.check3", d_number);
	}

	public List<ReservationDTO> rList(long m_number) {
		// TODO Auto-generated method stub
		return sql.selectList("Reservation.rList",m_number);
	}

	public void delete(long m_number) {
		sql.delete("Reservation.delete",m_number);
		
	}


}
