package com.fm.member;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.MyPageDAO;
import com.fm.dto.AuctionDTO;
import com.fm.dto.MemberDTO;

public class Part implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO mDto=new MemberDTO();
		MyPageDAO mDao=new MyPageDAO();
		ActionForward af=new ActionForward();
		int curPage=Integer.parseInt(request.getParameter("curPage"));
		HttpSession session=request.getSession();
		mDto=((MemberDTO)session.getAttribute("member"));
		String id=mDto.getId();
		
		//1.등록상품 전체리스트
		ArrayList<AuctionDTO> ar1=mDao.partProduct(curPage, id, 3);
		if(ar1.size()==0){
			ar1=null;
		}
		Hashtable<String, Integer> hs1=mDao.getPartPage(curPage, id, 3);
		
		//1-1 등록상품 진행중리스트
		ArrayList<AuctionDTO> ar2=mDao.partProduct(curPage, id, 0);
		if(ar2.size()==0){
			ar2=null;
		}
		Hashtable<String, Integer> hs2=mDao.getPartPage(curPage, id, 0);
		
		//1-2등록상품 종료된 리스트
		ArrayList<AuctionDTO> ar3=mDao.partProduct(curPage, id, 1);
		if(ar3.size()==0){
			ar3=null;
		}
		Hashtable<String, Integer> hs3=mDao.getPartPage(curPage, id, 1);
		
		request.setAttribute("list1", ar1);
		request.setAttribute("hs1", hs1);
		request.setAttribute("list2", ar2);
		request.setAttribute("hs2", hs2);
		request.setAttribute("list3", ar3);
		request.setAttribute("hs3", hs3);


		af.setPath("myPage_part.jsp");
		af.setRedirect(true);
		return af;

	}

}
