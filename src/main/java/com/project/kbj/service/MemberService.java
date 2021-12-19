package com.project.kbj.service;

import java.util.List;

import com.project.kbj.dto.MemberDTO;
import com.project.kbj.dto.PageDTO;

public interface MemberService {

	public void insert(MemberDTO m);

	public String idDp(String m_id);

	public String login(MemberDTO m);

	public List<MemberDTO> findAll();

	public void delete(long m_number);

	public PageDTO paging(int page);

	public List<MemberDTO> pagingList(int page);

	public MemberDTO mypage(long m_number);

}
