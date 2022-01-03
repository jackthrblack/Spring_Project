package com.project.kbj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.kbj.dto.SymptomDTO;
import com.project.kbj.service.SymptomService;

@Controller
@RequestMapping("/symptom/*")
public class SymptomController {
	
	@Autowired
	public SymptomService sp;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert_form() {
		return "symptom/insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute SymptomDTO s) {
	
		sp.insert(s);
		return "disease/insert";
	}
	
	@RequestMapping(value="sym", method=RequestMethod.POST)
	public @ResponseBody List<SymptomDTO> sym(Model model, @RequestParam("ds_id") String ds_id) {
		List<SymptomDTO> s = sp.sym(ds_id);
		System.out.println(s);
		model.addAttribute("s", s);
		return s;
	}
}
