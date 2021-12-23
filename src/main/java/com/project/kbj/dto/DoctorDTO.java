package com.project.kbj.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class DoctorDTO {

	private long d_number;
	private String d_id;
	private String d_pw;
	private String d_name;
	private Date d_date;
	private String d_phone;
	private String d_email;
	private String d_gender;
}

//<div class="container mb-3">
//<label class="form-label" id="label_font" style="font-size: 30px;">이메일</label> <br>
//<input type="text" id="email" onblur="e_input()" class="form-control-lg">
//<h2 id="atSign">@</h2>
//<input type="text" id="domain" class="form-control-lg">
//
//
//<select id="emailSel" class="form-select-lg mb-3" onchange="emailSelect()">
//    <option>선택하세요.</option>
//    <option value="naver.com">네이버</option>
//    <option value="daum.net">다음</option>
//    <option value="gamil.com">지메일</option>
//</select>
//<br>
//<span id="eReg"></span>
//</div>