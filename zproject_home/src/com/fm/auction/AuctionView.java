package com.fm.auction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;
import com.fm.dto.AuctionDTO;


public class AuctionView implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=  new ActionForward();
		
		AuctionDTO adto = new AuctionDTO();
		adto.setNum(Integer.parseInt(request.getParameter("num")));
		String check = request.getParameter("check");
		AuctionDAO adao =  new AuctionDAO();
		adto =adao.getContent(adto);
		String result = "";
		af.setRedirect(true);
		 
		ArrayList<String> ar =  new ArrayList<>();
		StringTokenizer st = new StringTokenizer(adto.getImgs()," ");
		
		int i=0;
		while(st.hasMoreElements()){
			ar.add(st.nextToken()); 
			i++;
		} 
	
		long lastDay =  adto.getDayLast().getTime();
	
		if(check == null){
		
			if(adto !=null){
				
				request.setAttribute("lastDay", lastDay);
				request.setAttribute("imgs", ar);
				request.setAttribute("view", adto);
				af.setPath("/sub/auction/auctionView.jsp"); 
			}else{
				request.setAttribute("message", "보기실패");
				af.setPath("/sub/auction/auctionResult.jsp");
			}
		}else{
			if(adto !=null){
				request.setAttribute("lastDay", lastDay);
				request.setAttribute("imgs", ar);
				request.setAttribute("view", adto);
				af.setPath("/sub/auction/auctionUpdate.jsp"); 
			}else{
				request.setAttribute("message", "보기실패");
				af.setPath("/sub/auction/auctionResult.jsp");
			}
		}
		return af;
	}

}
