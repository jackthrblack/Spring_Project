package com.project.kbj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.kbj.dto.CommentDTO;
import com.project.kbj.dto.DoctorDTO;
import com.project.kbj.dto.MemberDTO;
import com.project.kbj.dto.PageDTO2;
import com.project.kbj.service.CommentService;
import com.project.kbj.service.DoctorService;

@Controller
@RequestMapping("/doctor/*")
public class DoctorController {

	@Autowired
	public DoctorService ds;
	
	@Autowired
	public CommentService cs;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert_form() {
		return "doctor/insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute DoctorDTO d) {
		ds.insert(d);
		return "index";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value = "page2", required = false, defaultValue = "1") int page, Model model, @RequestParam("d_number") long d_number) {
		ds.delete(d_number);
		return "redirect:/doctor/paging2";
	}
	
	@RequestMapping(value = "paging2", method = RequestMethod.GET)
	public String paging(@RequestParam(value = "page2", required = false, defaultValue = "1") int page, Model model) {
		PageDTO2 paging = ds.paging(page);
		List<DoctorDTO> d = ds.pagingList(page);
		model.addAttribute("findAll", d);
		model.addAttribute("paging", paging);
		return "doctor/findAll";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login_form() {
		return "/doctor/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute DoctorDTO d) {
		String result = ds.login(d);
		return result;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value="review", method=RequestMethod.GET)
	public String review(Model model, @RequestParam("d_number") long d_number) {
		DoctorDTO d = ds.review(d_number);
		List<CommentDTO> commentList=cs.findAll(d_number);
		model.addAttribute("commentList", commentList);
		model.addAttribute("review", d);
		return "doctor/review";
	}
}
