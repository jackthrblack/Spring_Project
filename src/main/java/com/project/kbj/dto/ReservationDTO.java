package com.project.kbj.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationDTO {
	private long r_number;
	private String r_name;
	private String r_id;
	private String r_symptom;
	private String r_dName;
	private Date r_date;
}
