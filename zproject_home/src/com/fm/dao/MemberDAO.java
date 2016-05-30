package com.fm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fm.dto.MemberDTO;
import com.fm.util.DBConnectorPool;

public class MemberDAO {
	
	//회원가입
	public MemberDTO InsertMember(MemberDTO m){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		String sql="insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			st=con.prepareStatement(sql);
			st.setString(1, m.getId());
			st.setString(2, m.getPw());
			st.setString(3, m.getName());
			st.setString(4, m.getGender());
			st.setString(5, m.getBirth1());
			st.setString(6, m.getBirth2());
			st.setString(7, m.getBirth3());
			st.setString(8, m.getMail1());
			st.setString(9, m.getMail2());
			st.setString(10, m.getPhone1());
			st.setString(11, m.getPhone2());
			st.setString(12, m.getPhone3());
			st.setString(13, m.getCkmessage());
			int result=st.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m=null;
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return m;
	}
	
	//아이디 중복확인
	public String IdCheck(String id){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		ResultSet rs=null;
		String result=null;	
		String sql="select * from member where id=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, id);
			rs=st.executeQuery();
			if(rs.next()){
				result="exist";
			}else{
				result="useable";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
			return result;
	}

	
	//로그인하기
	public MemberDTO Login(MemberDTO m){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select * from member where id=? and pw=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, m.getId());
			st.setString(2, m.getPw());
			rs=st.executeQuery();
			if(rs.next()){
				m.setName(rs.getString(3));
				m.setGender(rs.getString(4));
				m.setBirth1(rs.getString(5));
				m.setBirth2(rs.getString(6));
				m.setBirth3(rs.getString(7));
				m.setMail1(rs.getString(8));
				m.setMail2(rs.getString(9));
				m.setPhone1(rs.getString(10));
				m.setPhone2(rs.getString(11));
				m.setPhone3(rs.getString(12));
				m.setCkmessage(rs.getString(13));
			}else{
				m=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		
		return m;
	}
	
	//회원정보수정
	public MemberDTO alterInfo(MemberDTO m){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		String sql="update member set pw=?, name=?, gender=?, birth1=?, birth2=?, birth3=?, mail1=?, mail2=?, phone1=?, phone2=?, phone3=?, ckmessage=? where id=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, m.getPw());
			st.setString(2, m.getName());
			st.setString(3, m.getGender());
			st.setString(4, m.getBirth1());
			st.setString(5, m.getBirth2());
			st.setString(6, m.getBirth3());
			st.setString(7, m.getMail1());
			st.setString(8, m.getMail2());
			st.setString(9, m.getPhone1());
			st.setString(10, m.getPhone2());
			st.setString(11, m.getPhone3());
			st.setString(12, m.getCkmessage());
			st.setString(13, m.getId());
			int result=st.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m=null;
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return m;
	}
	
	//회원탈퇴하기
	public int DelteMember(String id){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		String sql="delete from member where id=?";
		int result=0;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, id);
			result=st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return result;
	}
	
}
