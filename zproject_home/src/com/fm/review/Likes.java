package com.fm.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.ReviewDAO;
import com.fm.dto.ReviewDTO;

public class Likes implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		ReviewDAO rdao=new ReviewDAO();
		ReviewDTO rdto=new ReviewDTO();
		int num=Integer.parseInt(request.getParameter("num"));
		int likes=Integer.parseInt(request.getParameter("likes"));
		rdto=rdao.likesPlus(num,likes);
		af.setRedirect(true);
		if(rdto!=null){
			af.setPath("/sub/review/resultView2.jsp");
			request.setAttribute("message2", "좋아요 하셨습니다.");
		}else{
			af.setPath("/sub/review/resultView2.jsp");
			request.setAttribute("message2", "좋아할 수 없습니다.");
		}
		return af;
	}
	
}
