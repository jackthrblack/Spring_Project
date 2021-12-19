package com.project.kbj.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {

	private long m_number;
	private String m_id;
	private String m_pw;
	private String m_name;
	private Date m_date;
	private String m_phone;
	private String m_gender;
	
}
