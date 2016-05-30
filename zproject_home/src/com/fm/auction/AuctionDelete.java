package com.fm.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;

public class AuctionDelete implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af= new ActionForward();
		int num = Integer.parseInt(request.getParameter("num"));
		AuctionDAO adao =  new AuctionDAO();
		num = adao.auctionDelete(num);
		
		af.setRedirect(true);
		if(num >0){
			request.setAttribute("message", "글 삭제 성공!");
			af.setPath("/sub/auction/result/auctionResult.jsp");
		}else{
			request.setAttribute("message", "글 삭제 실패!");
			af.setPath("/sub/auction/result/auctionResult.jsp");
		}
		
		return af;
	}

}
