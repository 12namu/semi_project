package com.fm.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.BuyingDAO;
import com.fm.dto.BuyingDTO;

public class AuctionBidStart implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
		
		
		
		
		BuyingDTO bdto = new BuyingDTO();
		bdto.setNum(Integer.parseInt(request.getParameter("writeNum")));
		bdto.setPrice(Integer.parseInt(request.getParameter("bidPrice")));
		bdto.setId(request.getParameter("ids"));
		BuyingDAO bdao = new BuyingDAO();
		int num = bdao.setBid(bdto);
	
		request.setAttribute("num", num);
		request.setAttribute("message", "해당 경매에 입찰을 하셨습니다.");
		af.setRedirect(true);
		af.setPath("/sub/auction/result/auctionViewResult.jsp");
		
		return af;
	}
	
}
