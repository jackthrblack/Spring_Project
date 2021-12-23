package com.project.kbj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.DoctorDTO;
import com.project.kbj.dto.MemberDTO;
import com.project.kbj.dto.PageDTO;
import com.project.kbj.dto.PageDTO2;
import com.project.kbj.repository.DoctorRepository;

@Service
public class DoctorServiceImple implements DoctorService{

	@Autowired
	public DoctorRepository dr;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public void insert(DoctorDTO d) {
		dr.insert(d);
	}

	@Override
	public void delete(long d_number) {
		// TODO Auto-generated method stub
		dr.delete(d_number);
	}

	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 20;
	
	@Override
	public PageDTO2 paging(int page) {
		int doctorCount = dr.doctorCount();
		int maxPage = (int)(Math.ceil((double)doctorCount/PAGE_LIMIT));
		int startPage =(((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1)*BLOCK_LIMIT+1;
		int endPage = startPage + BLOCK_LIMIT-1;
		if(endPage>maxPage)
			endPage = maxPage;
		PageDTO2 paging = new PageDTO2();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		return paging;
	}

	@Override
	public List<DoctorDTO> pagingList(int page) {
		int pagingStart = (page-1)*PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		List<DoctorDTO> pagingList = dr.pagingList1(pagingParam);
		
		return pagingList;
	}

	@Override
	public String login(DoctorDTO d) {
		DoctorDTO DloginMember = dr.login(d);
		if(DloginMember!=null) {
			session.setAttribute("DloginId", d.getD_id());			
			session.setAttribute("DloginNumber", DloginMember.getD_number());
			session.setAttribute("DloginPw", d.getD_pw());
			return "index";
		}else {
			return "/doctor/login";
		}
	}

	@Override
	public DoctorDTO review(long d_number) {
		DoctorDTO d = dr.review(d_number);
		return d;
	}

}
