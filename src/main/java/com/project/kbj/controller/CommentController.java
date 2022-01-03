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

import com.project.kbj.dto.CommentDTO;
import com.project.kbj.dto.DoctorDTO;
import com.project.kbj.service.CommentService;

@Controller
@RequestMapping("/comment/*")
public class CommentController {

	@Autowired
	public CommentService cs;
		
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public @ResponseBody List<CommentDTO> insert(Model model, @ModelAttribute CommentDTO comment){
		cs.save(comment);
		List<CommentDTO> commentList = cs.findAll(comment.getD_number());
		model.addAttribute("commentList", comment);
		return commentList;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@ModelAttribute CommentDTO c, @RequestParam("c_number") long c_number) {
	cs.delete(c_number);
	return "redirect:/doctor/review?d_number="+c.getD_number();
	}
	
}
