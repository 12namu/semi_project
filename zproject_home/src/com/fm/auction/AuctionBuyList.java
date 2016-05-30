package com.fm.auction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.BuyingDAO;
import com.fm.dto.BuyingDTO;

public class AuctionBuyList implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
		
		int num = Integer.parseInt(request.getParameter("num"));
		BuyingDAO bdao = new BuyingDAO();
		ArrayList<BuyingDTO>ar = bdao.getbuyList(num);
			
			
		
		
		
			JSONArray ar2 = new JSONArray();
			BuyingDTO bdto = new BuyingDTO(); 	
			
			for (int i = 0; i < ar.size(); i++) {
				JSONObject obj = new JSONObject();  
				obj.put("id", String.valueOf(ar.get(i).getId()));
				obj.put("price", String.valueOf(ar.get(i).getPrice()));
				obj.put("times", String.valueOf(ar.get(i).getTimes()));
				ar2.add(obj);
			}
			
			 
			System.out.println(ar2);
			request.setAttribute("json", ar2.toJSONString());
		
		af.setRedirect(true);
		af.setPath("/sub/auction/result/jsonResult.jsp");
		return af;
	}

}
