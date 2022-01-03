package com.project.kbj.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.kbj.dto.DateTimeDTO;
import com.project.kbj.dto.DiseaseDTO;
import com.project.kbj.dto.DoctorDTO;
import com.project.kbj.dto.MemberDTO;
import com.project.kbj.dto.ReservationDTO;
import com.project.kbj.service.DateTimeService;
import com.project.kbj.service.DiseaseService;
import com.project.kbj.service.DoctorService;
import com.project.kbj.service.DoctorServiceImple;
import com.project.kbj.service.MemberService;
import com.project.kbj.service.ReservationService;

@Controller
@RequestMapping("/reservation/*")
public class ReservationController {

	@Autowired
	private ReservationService rs;

	@Autowired
	private MemberService ms;

	@Autowired
	private DiseaseService ds;

	@Autowired
	private DoctorService doc;

	@Autowired
	private DateTimeService dts;

	// 질병 및 증상, 예약자이름, 의사이름
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert_form(Model model, @RequestParam("m_number") long m_number) {

		List<DoctorDTO> d = doc.doctor();
		System.out.println("1" + d);
		model.addAttribute("dname", d);

		List<DiseaseDTO> di = ds.check();
		model.addAttribute("di", di);

		MemberDTO m = ms.re_name(m_number);
		model.addAttribute("rname", m);
		return "reservation/insert";
	}

	// 의사이름, 값을 가지고다닐 랜덤번호, 정보등록
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(Model model,@ModelAttribute ReservationDTO r) { 
		rs.insert(r);
		model.addAttribute("r", r);
		return "index";
	}

	@RequestMapping(value = "check", method = RequestMethod.POST)
	public @ResponseBody String check(@RequestParam("d_number") long d_number, @RequestParam("r_date") Date r_date,@RequestParam("r_time") String r_time) {

		System.out.println("rc1:" + r_date);
		System.out.println("rt1:" + r_time);
		String rdate = rs.check(r_date);
		String rtime = rs.check2(r_time);
		long dnum = rs.check3(d_number);
		System.out.println("rc2:" + rdate);
		System.out.println("rt2:" + rtime);

		if ((dnum == 1 || dnum == 2) && rdate == "no" && rtime == "no") {
			return "no";
		} else if ((dnum == 1 || dnum == 2) && rdate == "no" || rtime == "ok") {
			return "ok";
		} else if ((dnum == 1 || dnum == 2) && rdate == "ok" && rtime == "ok") {
			return "ok";
		} else if ((dnum==0||dnum==0)&&rdate=="ok"&&rtime=="ok") {
			return "ok";
		}
		else {
			return "ok";
		}
	}

	/*
	 * @RequestMapping(value="check", method=RequestMethod.POST)
	 * public @ResponseBody String check(@ModelAttribute DateTimeDTO dt) {
	 * System.out.println("cdt"+dt); String dtt = dts.check(dt);
	 * System.out.println("cdt2"+dt); dts.insert(dt); System.out.println("cdt3"+dt);
	 * return dtt; }
	 */
	
	  @RequestMapping(value="rList", method=RequestMethod.GET) 
	  public String rList(Model model, @RequestParam("m_number") long m_number) {
		
		  List<ReservationDTO> r = rs.rList(m_number);
		  model.addAttribute("rList", r);
		  return "reservation/rList";
	  }
	  
	  @RequestMapping(value="delete", method=RequestMethod.GET)
	  public String delete(@RequestParam("r_number") long r_number) {
		  rs.delete(r_number);
		  return "index";
	  }
	 
}
