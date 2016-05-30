package com.fm.auction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dto.AuctionDTO;

public class AuctionJJim implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
		HttpSession session=request.getSession();	
		ArrayList<AuctionDTO> wish=new ArrayList<>();
		wish = (ArrayList<AuctionDTO>)session.getAttribute("wish");
		AuctionDTO adto = new AuctionDTO();

		
		adto.setNum(Integer.parseInt(request.getParameter("num")));
		adto.setCategory(request.getParameter("category"));
		adto.setTitle(request.getParameter("title"));
		adto.setPr(request.getParameter("pr"));
		adto.setBidCount(Integer.parseInt(request.getParameter("counts")));
		adto.setId(request.getParameter("id"));
		adto.setImgs(request.getParameter("imgs"));
		adto.setStartPrice(Integer.parseInt(request.getParameter("startPrice")));
		adto.setNowPrice(Integer.parseInt(request.getParameter("nowPrice")));
		adto.setBidIncrease(Integer.parseInt(request.getParameter("bidIncrease")));
		adto.setState(Integer.parseInt(request.getParameter("state")));
		adto.setBidCount(Integer.parseInt(request.getParameter("bidCount")));
		wish.add(adto);
	
		
		session.setAttribute("wish", wish);
		
		request.setAttribute("num", adto.getNum());
		af.setRedirect(true);
		af.setPath("/sub/auction/result/jjimResult.jsp");
		return af;
	}
}
