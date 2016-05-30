package com.fm.auction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;
import com.fm.dto.AuctionDTO;

public class AuctionIndexList implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
		AuctionDAO adao = new AuctionDAO();
		adao.allList();
		ArrayList<AuctionDTO> ar1 = adao.indexList();
		ArrayList<AuctionDTO> ar2 = adao.indexList2();
		ArrayList<AuctionDTO> ar3 = adao.indexList3();
		
		for (int i = 0; i < ar1.size(); i++) {			
			String [] imgs = ar1.get(i).getImgs().split(" ");
			ar1.get(i).setImgs(imgs[0]);			
		};
		for (int i = 0; i < ar2.size(); i++) {			
			String [] imgs = ar2.get(i).getImgs().split(" ");
			ar2.get(i).setImgs(imgs[0]);			
		};
		for (int i = 0; i < ar3.size(); i++) {			
			String [] imgs = ar3.get(i).getImgs().split(" ");
			ar3.get(i).setImgs(imgs[0]);			
		};
		
		request.setAttribute("craft", ar1);
		request.setAttribute("wear", ar2);
		request.setAttribute("sundries", ar3);
		
		
		af.setRedirect(true);
		af.setPath("/sub/index/indexResult.jsp");
		
		return af;
	}

}
