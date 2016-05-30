package com.fm.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;
import com.fm.dao.MemberDAO;
import com.fm.dao.MyPageDAO;
import com.fm.dto.AuctionDTO;
import com.fm.dto.MemberDTO;


public class MainList implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		ActionForward af=new ActionForward();
		MemberDTO mDto=((MemberDTO)session.getAttribute("member"));
		MyPageDAO mDao=new MyPageDAO();
		AuctionDAO aDao=new AuctionDAO();
		aDao.allList();
		String id=mDto.getId();
		int curPage=Integer.parseInt(request.getParameter("curPage"));
		
		//1.등록삼품 리스트 불러올 때
		ArrayList<AuctionDTO> ar=mDao.uploadProduct(curPage, id, 3);
		if(ar.size()==0){
			ar=null;
		}else{
			for (int i = 0; i < ar.size(); i++) {			
			String [] imgs = ar.get(i).getImgs().split(" ");
			ar.get(i).setImgs(imgs[0]);			
			}
		}
		
		
		//2.참여상품 리스트 불러올 때
		ArrayList<AuctionDTO> ar2=mDao.partProduct(curPage, id, 3);
		if(ar2.size()==0){
			ar2=null;
		}else{	
			for (int i = 0; i < ar2.size(); i++) {			
			String [] imgs = ar2.get(i).getImgs().split(" ");
			ar2.get(i).setImgs(imgs[0]);			
			}
		}
		
		ArrayList<AuctionDTO> wish=(ArrayList<AuctionDTO>)session.getAttribute("wish");
		if(wish.size()==0){
			wish=null;
		}
		
		
		
		request.setAttribute("upload_list", ar);
		request.setAttribute("part_list", ar2);
		request.setAttribute("wish",wish);
		
		af.setPath("/sub/myPage/myPage_main.jsp");
		af.setRedirect(true); 

		return af;
	}

}
