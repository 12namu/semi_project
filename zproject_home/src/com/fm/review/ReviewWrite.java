package com.fm.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.ReviewDAO;
import com.fm.dto.ReviewDTO;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ReviewWrite implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ReviewDTO rdto=new ReviewDTO();
		ReviewDAO rdao=new ReviewDAO();
		ActionForward af=new ActionForward();
		rdto.setId(request.getParameter("id"));
		rdto.setTitle(request.getParameter("title"));
		rdto.setContents(request.getParameter("smarteditor"));
		rdto.setImgs(request.getParameter("imgs"));
		int result=rdao.write(rdto);
		af.setRedirect(true);
		if(result>0){
			request.setAttribute("message", "글작성 성공");
			af.setPath("/sub/review/resultView.jsp");
		}else{
			request.setAttribute("message", "글작성 실패");
			af.setPath("/sub/review/resultView.jsp");
		}
		return af;
	}
}
