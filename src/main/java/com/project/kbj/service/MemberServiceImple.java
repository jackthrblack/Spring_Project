package com.project.kbj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kbj.dto.MemberDTO;
import com.project.kbj.dto.PageDTO;
import com.project.kbj.repository.MemberRepository;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired
	public MemberRepository mr;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public void insert(MemberDTO m) {
		mr.insert(m);
		
	}
	@Override
	public String idDp(String m_id) {
		String result = mr.idDp(m_id);
		if(result==null)
			return "ok";
		else
			return "no";
	}
	@Override
	public String login(MemberDTO m) {
		MemberDTO loginMember = mr.login(m);
		if(loginMember!=null) {
			session.setAttribute("loginId", m.getM_id());			
			session.setAttribute("loginNumber", loginMember.getM_number());
			return "index";
		}else {
			return "/member/login";
		}
	}
	@Override
	public List<MemberDTO> findAll() {
		List<MemberDTO> m = mr.findAll();
		return m;
	}
	@Override
	public void delete(long m_number) {
		mr.delete(m_number);
		
	}
	
	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 20;
	
	@Override
	public PageDTO paging(int page) {
		int memberCount = mr.memberCount();
		int maxPage = (int)(Math.ceil((double)memberCount/PAGE_LIMIT));
		int startPage =(((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1)*BLOCK_LIMIT+1;
		int endPage = startPage + BLOCK_LIMIT-1;
		if(endPage>maxPage)
			endPage = maxPage;
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		return paging;
	}
	@Override
	public List<MemberDTO> pagingList(int page) {
		int pagingStart = (page-1)*PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		List<MemberDTO> pagingList = mr.pagingList1(pagingParam);
		
		return pagingList;
	}
	@Override
	public MemberDTO mypage(long m_number) {
		MemberDTO m = mr.mypage(m_number);
		return m;
	}

}
