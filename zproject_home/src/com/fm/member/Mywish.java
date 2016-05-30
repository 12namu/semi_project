package com.fm.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dto.AuctionDTO;

public class Mywish implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		//세션에서 가져오기
		HttpSession session=request.getSession();

			ArrayList<AuctionDTO> wish=(ArrayList<AuctionDTO>)session.getAttribute("wish");
/*			if(wish.size()==0){
				wish=null;
			}*/
			session.setAttribute("wish", wish);
			af.setPath("myPage_mywish.jsp");
			af.setRedirect(true);
			
		return af;
	}
	
}
