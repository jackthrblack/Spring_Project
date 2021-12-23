package com.project.kbj.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentDTO {
	private long c_number;
	private long d_number;
	private String m_id;
	private String c_id;
	private String c_contents;
	private int c_star;
	private Timestamp c_date;
}
