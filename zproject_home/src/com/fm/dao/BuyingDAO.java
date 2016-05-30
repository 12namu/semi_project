package com.fm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fm.dto.BuyingDTO;
import com.fm.util.DBConnectorPool;

public class BuyingDAO {
	
	public ArrayList<BuyingDTO> getbuyList(int num){
		Connection con = DBConnectorPool.getCon();
		String sql = "select * from buying where num=?";
		PreparedStatement st = null;
		ResultSet rs =null;
		ArrayList<BuyingDTO> ar = new ArrayList<>(); 
		
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, num);
			rs=st.executeQuery();
			
			while(rs.next()){
				BuyingDTO bdto = new BuyingDTO();
				bdto.setNum(rs.getInt("num"));
				bdto.setPrice(rs.getInt("price"));
				bdto.setTimes(rs.getTimestamp("times"));
				bdto.setId(rs.getString("id"));
				ar.add(bdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(st, con);
		}
		return ar;
	}
		
		
		
		
	
	
	
	private int getBidList(int num){
		Connection con = DBConnectorPool.getCon();
		String sql = "select count(rownum) from buying where num=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		int result =0;
		try {
			st= con.prepareStatement(sql);
			st.setInt(1, num);
			System.out.println("2번"+num);
			rs = st.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		
		return result;
		
	}
	public int setBid(BuyingDTO bdto){
		Connection con = DBConnectorPool.getCon();
		String sql = "insert into buying values(?, ?, sysdate, ?)";
		PreparedStatement st = null;
		
		int num = bdto.getNum();
		
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, bdto.getNum());
			st.setInt(2, bdto.getPrice());
			st.setString(3, bdto.getId());
			int result = st.executeUpdate();
			sql="update auction set bidcount=?, nowPrice=? where num=?";
			st=con.prepareStatement(sql);
			result =this.getBidList(num);
			st.setInt(1, result);
			st.setInt(2, bdto.getPrice());
			st.setInt(3, bdto.getNum());
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(st, con);
		}
		return num;
	}
	
	
}
