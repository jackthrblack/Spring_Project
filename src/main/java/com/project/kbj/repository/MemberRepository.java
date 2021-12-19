package com.project.kbj.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kbj.dto.MemberDTO;

@Repository
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void insert(MemberDTO m) {
		sql.insert("Member.insert", m);
		
	}

	public String idDp(String m_id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Member.idDp", m_id);
	}

	public MemberDTO login(MemberDTO m) {
		// TODO Auto-generated method stub
		return sql.selectOne("Member.login", m);
	}

	public List<MemberDTO> findAll() {
		// TODO Auto-generated method stub
		return sql.selectList("Member.findAll");
	}

	public void delete(long m_number) {
		sql.delete("Member.delete", m_number);
	}

	public int memberCount() {
		// TODO Auto-generated method stub
		return sql.selectOne("Member.count");
	}

	public List<MemberDTO> pagingList1(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("Member.pagingList1", pagingParam);
	}

	public MemberDTO mypage(long m_number) {
		return sql.selectOne("Member.mypage", m_number);
		
	}

}
