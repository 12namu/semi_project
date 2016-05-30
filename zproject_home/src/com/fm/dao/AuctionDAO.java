
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





public class AuctionDAO {
	
	public ArrayList<AuctionDTO> getSearch(int curPage, String search){
		Connection con = DBConnectorPool.getCon();
		int start = (curPage-1) * perPage+1;
		int last =curPage * perPage;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
 		String sql="select * from (select rownum R, A.* from"
				   + "(select * from auction where AUCTION.title like ? or AUCTION.category like ? or AUCTION.id like ? order by reg_date desc) A)"
				   +" where R between ? and ?";
	
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, "%"+search+"%");
			st.setString(2, "%"+search+"%");
			st.setString(3, "%"+search+"%");
			st.setInt(4, start);
			st.setInt(5, last);
			rs = st.executeQuery();
			
			while(rs.next()){
				AuctionDTO adto = new AuctionDTO();
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts"));
				adto.setState(rs.getInt("state"));
				ar.add(adto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
	
	
	}
	
	
	
	
	public void allList(){
		Connection con = DBConnectorPool.getCon();
		

		String sql= "select * from auction where state=0 and dayLast < sysdate";
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				AuctionDTO adto = new AuctionDTO();
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts"));
				adto.setState(rs.getInt("state"));
				ar.add(adto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		for (int i = 0; i < ar.size(); i++) {
			this.stateUpdate(ar.get(i).getNum());
		}
		
	}
	
	private void stateUpdate(int num){
		Connection con = DBConnectorPool.getCon();
		String sql= "update auction set state=? where num=?";
		PreparedStatement st = null;
		int result = 0;
		ResultSet rs = null;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
		try {
			st= con.prepareStatement(sql);
			st.setInt(1, 1);
			st.setInt(2, num);
			result = st.executeUpdate();
			
		sql = "select * from auction where state =1";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		while(rs.next()){
			AuctionDTO adto = new AuctionDTO();
			adto.setNum(rs.getInt("num"));
			ar.add(adto);
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(st, con);
		}
		
		for(int i = 0; i < ar.size(); i++){
			this.getMaxBuy(ar.get(i).getNum());
		}
		
		
	}
	
	
	private void getMaxBuy(int num){
		Connection con = DBConnectorPool.getCon();
		String sql ="select * from buying where num = ? order by times desc";
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			rs = st.executeQuery();
			
			if(rs.next()){
				BuyingDTO bdto = new BuyingDTO();
				bdto.setId(rs.getString("id"));
				
				sql = "update auction set maxBuy=? where num=?";
				st = con.prepareStatement(sql);
				st.setString(1, bdto.getId());
				st.setInt(2, num);
				st.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public ArrayList<AuctionDTO> indexList(){
		Connection con =  DBConnectorPool.getCon();
		String sql = "select * from (select rownum R, A.* from"
				+ " (select * from auction where category='수공예' and state=0 order by reg_date desc) A)"
				+ "	where R between 1 and 4";
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				AuctionDTO adto = new AuctionDTO();
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts"));
				adto.setState(rs.getInt("state"));
				ar.add(adto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
		
	}
	public ArrayList<AuctionDTO> indexList2(){
		Connection con =  DBConnectorPool.getCon();
		String sql = "select * from (select rownum R, A.* from"
				+ " (select * from auction where category='의류' and state=0 order by reg_date desc) A)"
				+ "	where R between 1 and 4";
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				AuctionDTO adto = new AuctionDTO();
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts"));
				adto.setState(rs.getInt("state"));
				ar.add(adto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
		
	}
	public ArrayList<AuctionDTO> indexList3(){
		Connection con =  DBConnectorPool.getCon();
		String sql = "select * from (select rownum R, A.* from"
				+ " (select * from auction where category='잡화' and state=0 order by reg_date desc) A)"
				+ "	where R between 1 and 4";
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				AuctionDTO adto = new AuctionDTO();
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts"));
				adto.setState(rs.getInt("state"));
				ar.add(adto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
		
	}
	private int getSundriesCount(){
		Connection con = DBConnectorPool.getCon();
		String sql="select count(num) from auction where state=0 and category='잡화'";
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int result =0;
		try {
			st = con.prepareStatement(sql);
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
	
	private int getWearCount(){
		Connection con = DBConnectorPool.getCon();
		String sql="select count(num) from auction where state=0 and category='의류'";
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int result =0;
		try {
			st = con.prepareStatement(sql);
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
	
	
	private int getCraftCount(){
		Connection con = DBConnectorPool.getCon();
		String sql="select count(num) from auction where state=0 and category='수공예'";
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int result =0;
		try {
			st = con.prepareStatement(sql);
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
	
	
	private int getCount(){
		Connection con = DBConnectorPool.getCon();
		String sql="select count(num) from auction where state=0";
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int result =0;
		try {
			st = con.prepareStatement(sql);
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
	
	private int getSearchCount(String search){
		Connection con = DBConnectorPool.getCon();
		String sql="select count(num) from auction where AUCTION.title like ? or AUCTION.category like ? or AUCTION.id like ?";
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int result =0;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, "%"+search+"%");
			st.setString(2, "%"+search+"%");
			st.setString(3, "%"+search+"%");
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
	
	
	public Hashtable<String, Integer> getPage(int curPage, String search, int check){
		
		Hashtable<String, Integer> hs =  new Hashtable<>();
		
		int totalList=0; //전체게시물수
		int perPageList=10; //페이지 당 게시물 수
		int totalPage=0; // 총 페이지 수
		int totalBlock=0; //총 블럭 수
		int perBlock =5; // 한 블럭당 들어 갈 페이지 수
		int curBlock=0; //현재 페이지가 속해있는 블럭
		int startPage=0; //블록의 시작페이지 넘버
		int lastPage=0; //블록의 끝페이지 넘버
		
		//1. 토탈페이지 구하기
		if(check==0){			
			totalList =  this.getCount();
		}else if(check==1){
			totalList = this.getSearchCount(search);
		}else if(check==2){
			totalList = this.getCraftCount();
		}else if(check==3){
			totalList = this.getWearCount();
		}else if(check==4){
			totalList = this.getSundriesCount();
		}
		
		
		if(totalList%perPageList==0){
			totalPage =  totalList /  perPageList;
		}else{
			totalPage =  totalList /  perPageList +1;
		}
		
		//2. curPage를 이용해서 curBlock 구하기(현재페이지가 속해있는 블록 찾기)
		if(curPage%perBlock==0){
			curBlock =  curPage / perBlock;
		}else{
			curBlock =  curPage / perBlock+1;
		}
		
		
		//4. 총블럭 구하기(총페이지 수, 총 블럭 이용)
		if(totalPage%perBlock==0){
			totalBlock =  totalPage / perBlock;
		}else{
			totalBlock =  totalPage / perBlock+1;
		}
		
		//3. curBlock 이용 스타트,라스트 페이지 구하기
		startPage = (curBlock-1)* perBlock+1;
		
		if(totalBlock==curBlock){ //총블럭수와 현재 블럭수가 같으면
			lastPage  = totalPage; //블록의 끝페이지넘버에 총페이지수를 넣어주
		}else{ //아니면
			lastPage  = curBlock * perBlock; //블록의 끝페이지넘버에 현재페이지 * 뿌려줄만큼
		}
		
		hs.put("startPage", startPage);
		hs.put("lastPage", lastPage);
		hs.put("curBlock", curBlock);
		hs.put("totalBlock", totalBlock);
		
		return hs;
		
	}

	public int auctionDelete(int num){
		Connection con = DBConnectorPool.getCon();
		String sql="delete auction where num=?";
		PreparedStatement st = null;
		int result = 0;
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(st, con);
		}
	
		return result;
	}
	
	public int auctionUpdate(AuctionDTO adto){
		Connection con = DBConnectorPool.getCon();
		String sql= "update auction set title=?, contents=?, imgs=?, category=?, name=?, pr=?, startprice=?,"
				+ " bidIncrease=?, days=?, dayLast=? where num=?";
		PreparedStatement st = null;
		int result = 0;
		
		try {
			st= con.prepareStatement(sql);
			st.setString(1, adto.getTitle());
			st.setString(2, adto.getContents());
			st.setString(3, adto.getImgs());
			st.setString(4, adto.getCategory());
			st.setString(5, adto.getName());
			st.setString(6, adto.getPr());
			st.setInt(7, adto.getStartPrice());
			st.setInt(8, adto.getBidIncrease());
			st.setInt(9, adto.getDays());
			st.setTimestamp(10, adto.getDayLast());
			st.setInt(11, adto.getNum());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(st, con);
		}
		return result;
	}
	
	public AuctionDTO getContent(AuctionDTO adto){
		Connection con = DBConnectorPool.getCon();
		String sql="select * from auction where num=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, adto.getNum());
			rs = st.executeQuery();
			
			if(rs.next()){
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts")+1);
				adto.setState(rs.getInt("state"));
				sql="update auction set counts=? where num=?";
				st = con.prepareStatement(sql);
				st.setInt(1, adto.getCounts());
				st.setInt(2, adto.getNum());
				result = st.executeUpdate();
			}else{
				adto = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		return adto;
	}

	private int perPage=10;

	public ArrayList<AuctionDTO> getList(int curPage, int check){
		Connection con = DBConnectorPool.getCon();
		
		int start = (curPage-1) * perPage+1;
		int last =curPage * perPage;
		String sql="";
		
		if(check==0){
				sql= "select * from (select rownum R, A.* from"
				+ " (select * from auction where state=0 order by num desc) A)"
				+ "	where R between ? and ?";
		}else if(check==2){
			sql= "select * from (select rownum R, A.* from"
					+ " (select * from auction where state=0 and category='수공예' order by num desc) A)"
					+ "	where R between ? and ?";
		}else if(check==3){
			sql= "select * from (select rownum R, A.* from"
					+ " (select * from auction where state=0 and category='의류' order by num desc) A)"
					+ "	where R between ? and ?";
		}else if(check==4){
			sql= "select * from (select rownum R, A.* from"
					+ " (select * from auction where state=0 and category='잡화' order by num desc) A)"
					+ "	where R between ? and ?";
		}
		
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AuctionDTO> ar = new ArrayList<>();
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, start);
			st.setInt(2, last);
			rs = st.executeQuery();
			
			while(rs.next()){
				AuctionDTO adto = new AuctionDTO();
				adto.setNum(rs.getInt("num"));
				adto.setId(rs.getString("id"));
				adto.setTitle(rs.getString("title"));
				adto.setContents(rs.getString("contents"));
				adto.setImgs(rs.getString("imgs"));
				adto.setCategory(rs.getString("category"));
				adto.setName(rs.getString("name"));
				adto.setPr(rs.getString("pr"));
				adto.setStartPrice(rs.getInt("startPrice"));
				adto.setNowPrice(rs.getInt("nowPrice"));
				adto.setBidCount(rs.getInt("bidCount"));
				adto.setBidIncrease(rs.getInt("bidIncrease"));
				adto.setReg_date(rs.getTimestamp("reg_date"));
				adto.setDays(rs.getInt("days"));
				adto.setDayLast(rs.getTimestamp("daylast"));
				adto.setCounts(rs.getInt("counts"));
				adto.setState(rs.getInt("state"));
				ar.add(adto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(rs, st, con);
		}
		return ar;
	}
	
	
	
	public int setWrite(AuctionDTO adto){
		Connection con = DBConnectorPool.getCon();
		String sql="insert into auction values(auction_seq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, sysdate, ?, ?, 0, 0, null)";
		PreparedStatement st = null;
		int result =0;
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, adto.getId());
			st.setString(2, adto.getTitle());
			st.setString(3, adto.getContents());
			st.setString(4, adto.getImgs());
			st.setString(5, adto.getCategory());
			st.setString(6, adto.getName());
			st.setString(7, adto.getPr());
			st.setInt(8, adto.getStartPrice());
			st.setInt(9, adto.getStartPrice());
			st.setInt(10, adto.getBidIncrease());
			st.setInt(11, adto.getDays());
			st.setTimestamp(12, adto.getDayLast());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectorPool.disConnection(st, con);
		}
		return result;
	}
}
