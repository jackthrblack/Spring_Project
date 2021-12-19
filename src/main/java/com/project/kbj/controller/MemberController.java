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
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.kbj.dto.PageDTO;
import com.project.kbj.dto.MemberDTO;
import com.project.kbj.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	public MemberService ms;
	
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public String insert_form() {
		return "member/insert";
	}
	
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute MemberDTO m) {
		ms.insert(m);
		return "index";
	}
	
	@RequestMapping(value = "idDp", method = RequestMethod.POST)
	public @ResponseBody String idDp(@RequestParam("m_id") String m_id) {
		String result = ms.idDp(m_id);
		return result;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login_form() {
		return "/member/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO m) {
		String result = ms.login(m);
		return result;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, @RequestParam("m_number") long m_number) {
		ms.delete(m_number);
		return "redirect:/member/paging";
	}
	
	@RequestMapping(value = "paging", method = RequestMethod.GET)
	public String paging(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
		PageDTO paging = ms.paging(page);
		List<MemberDTO> m = ms.pagingList(page);
		model.addAttribute("findAll", m);
		model.addAttribute("paging", paging);
		return "member/findAll";
	}
	
	@RequestMapping(value="mypage", method=RequestMethod.GET)
	public String mypage(Model model, @RequestParam("m_number") long m_number) {
		MemberDTO m = ms.mypage(m_number);
		model.addAttribute("mypage", m);
		return "member/mypage";
	}
}
