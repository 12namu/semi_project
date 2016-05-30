package com.fm.auction;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;
import com.fm.dto.AuctionDTO;

public class AuctionSearchList implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
	
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		String search = request.getParameter("search");
		
		AuctionDAO adao = new AuctionDAO();
		int check = 1;
		Hashtable<String, Integer> hs = adao.getPage(curPage, search, check);
		ArrayList<AuctionDTO> ar = adao.getSearch(curPage, search);
		int counts = ar.size(); 
		
		if(ar.size() == 0){
			ar = null;
			counts = 0;
		}
		
			request.setAttribute("list", ar);
			request.setAttribute("word", search);
			request.setAttribute("size", counts);
			request.setAttribute("pageing", hs);
		
		String rootPath = request.getServletContext().getContextPath();
		
		
		af.setRedirect(true);
		af.setPath("/sub/auction/search.jsp");	
		return af;
	}
}
