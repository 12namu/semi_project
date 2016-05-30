package com.fm.auction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;
import com.fm.dto.AuctionDTO;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class AuctionList implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
		
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		AuctionDAO adao = new AuctionDAO();
		
		adao.allList();
		ArrayList<AuctionDTO> ar = null;
		Hashtable<String, Integer> hs =  null;
		int check = Integer.parseInt(request.getParameter("check"));
		
		if(check==0){
			ar = adao.getList(curPage, check);
			hs = adao.getPage(curPage,"",check);
		}else if(check==2){
			ar = adao.getList(curPage, check);
			hs = adao.getPage(curPage,"",check);
		}else if(check==3){
			ar = adao.getList(curPage, check);
			hs = adao.getPage(curPage,"",check);
		}else if(check==4){
			ar = adao.getList(curPage, check);
			hs = adao.getPage(curPage,"",check);
		}
		for (int i = 0; i < ar.size(); i++) {			
			String [] imgs = ar.get(i).getImgs().split(" ");
			ar.get(i).setImgs(imgs[0]);			
		};
		
		if(ar.size()==0){
			ar=null;
		}
		
		
		
		
		request.setAttribute("check", check);
		request.setAttribute("list", ar);
		request.setAttribute("pageing", hs);
		af.setRedirect(true);
		af.setPath("/sub/auction/auctionList.jsp");
		return af;
	}
	
}
