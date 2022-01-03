package com.project.kbj.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationDTO {
	private long r_number;
	private long m_number;
	private long d_number;
	private long ds_number;
	private long s_number;
	private long da_number;
	private long ti_number;
	private String r_name;
	private String r_doctor;
	private String r_dsName;
	private String r_symptom;
	private Date r_date;
	private String r_time;
}
