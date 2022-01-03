package com.project.kbj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.kbj.dto.DiseaseDTO;
import com.project.kbj.dto.MemberDTO;
import com.project.kbj.service.DiseaseService;
import com.project.kbj.service.MemberService;

@Controller
@RequestMapping("/disease/*")
public class DiseaseController {

	@Autowired
	private DiseaseService ds;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert_form() {
		return "disease/insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute DiseaseDTO di) {
		ds.insert(di);
		return "disease/insert";
	}
	
//	@RequestMapping(value="check", method=RequestMethod.)
}
