package com.fm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.fm.dto.AuctionDTO;
import com.fm.dto.BuyingDTO;
import com.fm.util.DBConnectorPool;

public class MyPageDAO {
	
	//등록상품 전체 리스트 불러오기
	public int getUploadTotalList(String id,int state){
		int result=0;
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		ResultSet rs=null;
		
		String sql1="select count(num) from auction where id=?";
		String sql2="select count(num) from auction where id=? and state=?";
		
		try {
			if(state==0 || state==1){
				st=con.prepareStatement(sql2);
				st.setString(1, id);
				st.setInt(2, state);
				rs=st.executeQuery();
			}else{
				st=con.prepareStatement(sql1);
				st.setString(1, id);
				rs=st.executeQuery();
			}
			
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		
		return result;
	}
	
	//등록상품 페이징
	public Hashtable<String,Integer> getUploadPage(int curPage,String id,int state){
		Hashtable<String, Integer> hs=new Hashtable<>();
		int totalList=0;
		int perPageList=10;
		int totalPage=0;
		int totalBlock=0;
		int perBlock=5;
		int curBlock=0;
		int startPage=0;
		int lastPage=0;
		
		//1.totalList구하기
		totalList=getUploadTotalList(id, state);
		if(totalList%perPageList==0){
			totalPage=totalList/perPageList;
		}else{
			totalPage=totalList/perPageList+1;
		}
		
		//2.총 블럭수 구하기
		if(totalPage%perBlock==0){
			totalBlock=totalPage/perBlock;
		}else{
			totalBlock=totalPage/perBlock+1;
		}
		
		//3.현재 페이지의 블럭 구하기
		if(curPage%perBlock==0){
			curBlock=curPage/perBlock;
		}else{
			curBlock=curPage/perBlock+1;
		}
		
		//4.현재 블럭의 시작페이지,마지막페이지 구하기
		startPage=(curBlock-1)*perBlock+1;
		if(totalBlock==curBlock){
			lastPage=totalPage;
		}else{
			lastPage=curBlock*perBlock+1;
		}
		
		hs.put("startPage", startPage);
		hs.put("lastPage", lastPage);
		hs.put("totalBlock", totalBlock);
		hs.put("curBlock", curBlock);
		
		return hs;
	}

	//등록상품 리스트 불러오기
	public ArrayList<AuctionDTO> uploadProduct(int curPage,String id,int state){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		ResultSet rs=null;
		int lastNum=curPage*10;
		int startNum=lastNum-9;
		ArrayList<AuctionDTO> ar=new ArrayList<>(); 

		//전체조회할때
		String sql1="select * from (select rownum R, A.* from (select * from auction where id=? order by num desc)A) where R between ? and ?";

		//진행중,종료
		String sql2="select * from (select rownum R, A.* from (select * from auction where id=? and state=? order by num desc)A) where R between ? and ?";

		try {
			if(state==0 || state==1){
				st=con.prepareStatement(sql2);
				st.setString(1, id);
				st.setInt(2, state);
				st.setInt(3, startNum);
				st.setInt(4, lastNum);
				rs=st.executeQuery();
			}else{
				st=con.prepareStatement(sql1);
				st.setString(1, id);
				st.setInt(2, startNum);
				st.setInt(3, lastNum);
				rs=st.executeQuery();			
			}

			while(rs.next()){
				AuctionDTO ad=new AuctionDTO();
				ad.setNum(rs.getInt("num"));
				ad.setId(rs.getString("id"));
				ad.setTitle(rs.getString("title"));
				ad.setContents(rs.getString("contents"));
				ad.setImgs(rs.getString("imgs"));
				ad.setCategory(rs.getString("category"));
				ad.setName(rs.getString("name"));
				ad.setPr(rs.getString("pr"));
				ad.setStartPrice(rs.getInt("startPrice"));
				ad.setNowPrice(rs.getInt("nowPrice"));
				ad.setBidCount(rs.getInt("bidCount"));
				ad.setBidIncrease(rs.getInt("bidIncrease"));
				ad.setReg_date(rs.getTimestamp("reg_date"));
				ad.setDays(rs.getInt("days"));
				ad.setDayLast(rs.getTimestamp("daylast"));
				ad.setCounts(rs.getInt("counts")+1);
				ad.setState(rs.getInt("state"));
				ar.add(ad);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
	}
	
	//등록한 상품중 종료되었을 때 입찰자 가져오기
	public ArrayList<String> getBuyingMember(String id){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		ResultSet rs=null;
		ArrayList<String> end=new ArrayList<>();
		AuctionDAO adao=new AuctionDAO();
		adao.allList();
		
		String sql="select maxbuy from Auction where id=? and maxbuy is not null order by num desc";
		
		try {
			st=con.prepareStatement(sql);
			st.setString(1, id);
			rs=st.executeQuery();
			
			while(rs.next()){		
				BuyingDTO bdto=new BuyingDTO();
				end.add(rs.getString(1));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		return end;
	}
	
	//-----------------------------------------------------------------------참여상품
	//참여상품 리스트 불러오기
	public ArrayList<AuctionDTO> partProduct(int curPage,String id,int state){
		Connection con=DBConnectorPool.getCon();
		PreparedStatement st=null;
		ResultSet rs=null;
		int lastNum=curPage*10;
		int startNum=lastNum-9;
		ArrayList<AuctionDTO> ar=new ArrayList<>(); 

		//전체조회할때
		String sql1="select * from( "
					+ "select * from auction where num = any(select num from buying where id=?)) " 
					+ "where rownum between ? and ? order by num desc";
					

		//진행중,종료
		String sql2="select * from( "
					+ "select * from auction where num =any(select num from buying where id=? and state=?)) "
					+ "where rownum between ? and ? order by num desc";
							

		try {
			if(state==0 || state==1){
				st=con.prepareStatement(sql2);
				st.setString(1, id);
				st.setInt(2, state);
				st.setInt(3, startNum);
				st.setInt(4, lastNum);
				rs=st.executeQuery();
			}else{
				st=con.prepareStatement(sql1);
				st.setString(1, id);
				st.setInt(2, startNum);
				st.setInt(3, lastNum);
				rs=st.executeQuery();			
			}

			while(rs.next()){
				AuctionDTO ad=new AuctionDTO();
				ad.setNum(rs.getInt("num"));
				ad.setId(rs.getString("id"));
				ad.setTitle(rs.getString("title"));
				ad.setContents(rs.getString("contents"));
				ad.setImgs(rs.getString("imgs"));
				ad.setCategory(rs.getString("category"));
				ad.setName(rs.getString("name"));
				ad.setPr(rs.getString("pr"));
				ad.setStartPrice(rs.getInt("startPrice"));
				ad.setNowPrice(rs.getInt("nowPrice"));
				ad.setBidCount(rs.getInt("bidCount"));
				ad.setBidIncrease(rs.getInt("bidIncrease"));
				ad.setReg_date(rs.getTimestamp("reg_date"));
				ad.setDays(rs.getInt("days"));
				ad.setDayLast(rs.getTimestamp("daylast"));
				ad.setCounts(rs.getInt("counts")+1);
				ad.setState(rs.getInt("state"));
				ar.add(ad);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
	}
	
	//참여상품 페이징
		public Hashtable<String,Integer> getPartPage(int curPage,String id,int state){
			Hashtable<String, Integer> hs=new Hashtable<>();
			int totalList=0;
			int perPageList=10;
			int totalPage=0;
			int totalBlock=0;
			int perBlock=5;
			int curBlock=0;
			int startPage=0;
			int lastPage=0;
			
			//1.totalList구하기
			totalList=getUploadTotalList(id, state);
			if(totalList%perPageList==0){
				totalPage=totalList/perPageList;
			}else{
				totalPage=totalList/perPageList+1;
			}
			
			//2.총 블럭수 구하기
			if(totalPage%perBlock==0){
				totalBlock=totalPage/perBlock;
			}else{
				totalBlock=totalPage/perBlock+1;
			}
			
			//3.현재 페이지의 블럭 구하기
			if(curPage%perBlock==0){
				curBlock=curPage/perBlock;
			}else{
				curBlock=curPage/perBlock+1;
			}
			
			//4.현재 블럭의 시작페이지,마지막페이지 구하기
			startPage=(curBlock-1)*perBlock+1;
			if(totalBlock==curBlock){
				lastPage=totalPage;
			}else{
				lastPage=curBlock*perBlock+1;
			}
			
			hs.put("startPage", startPage);
			hs.put("lastPage", lastPage);
			hs.put("totalBlock", totalBlock);
			hs.put("curBlock", curBlock);
			
			return hs;
		}
		//참여상품 전체리스트수
		public int getPartTotalList(String id,int state){
			int result=0;
			Connection con=DBConnectorPool.getCon();
			PreparedStatement st=null;
			ResultSet rs=null;
			
			String sql1="select count(num) from buying where id=?";
			String sql2="select count(num) from buying where id=? and state=?";
			
			try {
				if(state==0 || state==1){
					st=con.prepareStatement(sql2);
					st.setString(1, id);
					st.setInt(2, state);
					rs=st.executeQuery();
				}else{
					st=con.prepareStatement(sql1);
					st.setString(1, id);
					rs=st.executeQuery();
				}
				
				if(rs.next()){
					result=rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnectorPool.disConnection(rs, st, con);
			}
			
			return result;
		}

}
