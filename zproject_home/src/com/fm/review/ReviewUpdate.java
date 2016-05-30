package com.fm.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.ReviewDAO;
import com.fm.dto.ReviewDTO;

public class ReviewUpdate implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		ReviewDAO rdao=new ReviewDAO();
		ReviewDTO rdto=new ReviewDTO();
		rdto.setTitle(request.getParameter("title"));
		
		rdto.setContents(request.getParameter("smarteditor"));
		
		rdto.setNum(Integer.parseInt(request.getParameter("num")));
		int result=rdao.reviewUpdate(rdto);
		
		if(result>0){
			af.setRedirect(true);
			request.setAttribute("message2", "수정완료되었습니다.");
			af.setPath("/sub/review/resultView2.jsp");
		}
		return af;
	}

}
