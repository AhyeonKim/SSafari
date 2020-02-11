package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.AuthRequest;
import com.ssafy.edu.vue.dto.Member;

@Repository
public class MemberDaoImpl {
	
	String ns = "ssafy.member.";
	@Autowired
	private SqlSession sqlSession;

	
	public List<Member> getMemberList() {
		return sqlSession.selectList(ns+"getMemberList");
	}

	public Member getMember(int memberid) {
		return sqlSession.selectOne(ns+"getMember", memberid);
	}

	public void addMember(Member member) {
		sqlSession.insert(ns+"addMember", member);
	}

	public void updateMember(Member member) {
		sqlSession.update(ns+"updateMember", member);
	}

	public void deleteMember(int memberid) {
		sqlSession.delete(ns+"deleteMember", memberid);
	}

	public Member checkLogin(Member member) {
		return sqlSession.selectOne(ns+"checkLogin", member);
	}

	public int checkEmail(String email) {
		return sqlSession.selectOne(ns+"checkEmail", email);
	}

	public int checkUsername(String username) {
		return sqlSession.selectOne(ns+"checkUsername", username);
	}

	public int checkUsers() {
		return sqlSession.selectOne(ns+"checkUsers");
	}

	public void updateMemberAuth(Member member) {
		sqlSession.update(ns+"updateMemberAuth", member);
	}

	public int checkDelflag(String email) {
		return sqlSession.selectOne(ns+"checkDelflag",email);
	}

	public void authRequest(AuthRequest ar) {
		sqlSession.insert(ns+"authRequest",ar);
	}

	public void updatePassword(Member member) {
		sqlSession.update(ns+"updatePassword",member);
	}

	public void deleteAuthRequest(int memberid) {
		sqlSession.delete(ns+"deleteAuthRequest",memberid);
	}

	public List<AuthRequest> getAuthRequestList() {
		return sqlSession.selectList(ns+"getAuthRequestList");
	}

	public AuthRequest getAuthRequest(int memberid) {
		return sqlSession.selectOne(ns+"getAuthRequest",memberid);
	}

	public void updateLocationUnit(AuthRequest ar) {
		sqlSession.update(ns+"updateLocationUnit",ar);
	}

}
