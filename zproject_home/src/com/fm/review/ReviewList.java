package com.fm.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.ReviewDAO;
import com.fm.dto.ReviewDTO;

public class ReviewList implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward af=new ActionForward();
		int curPage=Integer.parseInt(request.getParameter("curPage"));
		ReviewDAO rdao=new ReviewDAO();
		
		ArrayList<ReviewDTO> ar = rdao.reviewList(curPage);
		System.out.println(ar.size());
		
		request.setAttribute("list", ar);
		
		af.setPath("reviewList.jsp");
		af.setRedirect(true);
		
		return af;
	}
}
