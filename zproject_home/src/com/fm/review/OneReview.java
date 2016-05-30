package com.fm.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.ReviewDAO;
import com.fm.dto.ReviewDTO;

public class OneReview implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		ReviewDAO rdao=new ReviewDAO();
		ReviewDTO rdto=new ReviewDTO();
		int num=Integer.parseInt(request.getParameter("num"));
		rdto=rdao.oneReview(num);
		HttpSession session=request.getSession();
		session.setAttribute("rdto", rdto);
		af.setRedirect(true);
		if(rdto!=null){
			request.setAttribute("rdto", rdto);
			af.setPath("/sub/review/oneReview.jsp");
		}else{
			request.setAttribute("message", "글이 존재하지 않습니다.");
			af.setPath("/sub/review/resultView.jsp");
		}
		return af;
	}

}
