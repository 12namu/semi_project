package com.fm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.fm.dto.ReviewDTO;
import com.fm.util.DBConnectorPool;

public class ReviewDAO {
	private final int PER_PAGE=8;
	
	//리뷰쓰기
	public int write(ReviewDTO rdto){
		Connection con=DBConnectorPool.getCon();
		String sql="insert into review values(review_seq.nextVal,?,?,?,?,0,0,sysdate)";
		int result=0;
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, rdto.getId());
			st.setString(2, rdto.getTitle());
			st.setString(3, rdto.getContents());
			st.setString(4, rdto.getImgs());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return result;
	}
	
	//리뷰 수정
	public int reviewUpdate(ReviewDTO rdto){
		Connection con=DBConnectorPool.getCon();
		String sql="update review set title=?, contents=? where num=?";
		int result = 0;
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, rdto.getTitle());
			st.setString(2, rdto.getContents());
			st.setInt(3, rdto.getNum());
			result=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return result;
	}
	
	//리뷰 삭제
	public int reviewDelete(int num){
		Connection con=DBConnectorPool.getCon();
		String sql="delete review where num=?";
		PreparedStatement st=null;
		int result=0;
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, num);
			result=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return result;
	}
	
	//리뷰 전체보기
	public ArrayList<ReviewDTO> reviewList(int curPage){
		Connection con=DBConnectorPool.getCon();
		int starNum = (curPage-1)*PER_PAGE+1;
		int lastNum = curPage*PER_PAGE;
		String sql="select * from (select rownum R, A.* from"
				   + " (select * from REVIEW order by num desc) A)"
				   + " where R between ? and ?";
		PreparedStatement st=null;
		ResultSet rs=null;
		ArrayList<ReviewDTO> ar=new ArrayList<>();
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, starNum);
			st.setInt(2, lastNum);
			rs=st.executeQuery();
			while(rs.next()){
				ReviewDTO rv=new ReviewDTO();
				rv.setNum(rs.getInt("num"));
				rv.setId(rs.getString("id"));
				rv.setTitle(rs.getString("title"));
				rv.setContents(rs.getString("contents"));
				rv.setImgs(rs.getString("imgs"));
				rv.setCounts(rs.getInt("counts"));
				rv.setLikes(rs.getInt("likes"));
				rv.setReg_date(rs.getDate("reg_date"));
				ar.add(rv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
	}
	
	//리뷰 하나 보기
	public ReviewDTO oneReview(int num){
		Connection con= DBConnectorPool.getCon();
		String sql="select * from review where num=?";
		PreparedStatement st=null;
		ResultSet rs=null;
		int result = 0;
		ReviewDTO rdto=new ReviewDTO();
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, num);
			rs=st.executeQuery();
			if(rs.next()){
				rdto.setNum(rs.getInt("num"));
				rdto.setId(rs.getString("id"));
				rdto.setTitle(rs.getString("title"));
				rdto.setContents(rs.getString("contents"));
				rdto.setImgs(rs.getString("imgs"));
				rdto.setCounts(rs.getInt("counts")+1);
				rdto.setLikes(rs.getInt("likes"));
				rdto.setReg_date(rs.getDate("reg_date"));
				sql="update review set counts=? where num=?";
				st=con.prepareStatement(sql);
				st.setInt(1, rdto.getCounts());
				st.setInt(2, rdto.getNum());
				result = st.executeUpdate();
			}else{
				rdto=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		return rdto;
	}
	//좋아요 증가
	public ReviewDTO likesPlus(int num, int likes){
		Connection con= DBConnectorPool.getCon();
		String sql="update review set likes=? where num=?";
		PreparedStatement st=null;
		int result=0;
		ReviewDTO rdto=new ReviewDTO();
		rdto.setLikes(likes);
		rdto.setNum(num);
		System.out.println(rdto.getNum());
		System.out.println(rdto.getLikes());
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, rdto.getLikes()+1);
			st.setInt(2, rdto.getNum());
			result=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(st, con);
		}
		return rdto;
	}
	//전체 글 갯수
	public int getCount(){
		Connection con=DBConnectorPool.getCon();
		String sql="select count(num) from review";
		PreparedStatement st=null;
		ResultSet rs=null;
		int result=0;
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		return result;
	}
	
	//페이징 처리
	public Hashtable<String, Integer> getPage(int curPage){
		int totalPage=0;//전체 페이지 구하기
		int total=getCount();//전체 글 갯수
		
		//전체 페이지수
		if(total%PER_PAGE==0){
			totalPage=total/PER_PAGE;
		}else{
			totalPage=total/PER_PAGE+1;
		}
		
		//perBlock 구하기
		int perBlock=5;//블럭당 페이지수
		int curBlock=0;//curPage가 속해있는 블럭
		if(curPage%perBlock==0){
			curBlock=curPage/perBlock;
		}else{
			curBlock=curPage/perBlock+1;
		}
		
		//블럭의 시작번호,끝번호 구하기
		int startNum=(curBlock-1)*perBlock+1;
		int lastNum=curBlock*perBlock;
		
		//총 블럭 수 구하기
		int totalBlock=0;
		if(totalPage%perBlock==0){
			totalBlock=totalPage/perBlock;
		}else{
			totalBlock=totalPage/perBlock+1;
		}
		
		//lastNum 조정하기
		if(curBlock==totalBlock){
			lastNum=totalPage;
		}
		Hashtable<String, Integer> hs=new Hashtable<>();
		hs.put("startNum", startNum);
		hs.put("lastNum", lastNum);
		hs.put("curBlock", curBlock);
		hs.put("totalBlock", totalBlock);
		return hs;
	}
}
