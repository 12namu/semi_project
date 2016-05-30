package com.fm.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.ReviewDAO;

public class ReviewDelete implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		ReviewDAO rdao=new ReviewDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		int result=rdao.reviewDelete(num);
		af.setRedirect(true);
		if(result>0){
			request.setAttribute("message", "삭제 완료되었습니다.");
			af.setPath("/sub/review/resultView.jsp");
		}else{
			request.setAttribute("message", "삭제 실패하였습니다");
			af.setPath("/sub/review/resutlView.jsp");
		}
		return af;
	}
}
