package com.fm.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.MemberDAO;
import com.fm.dto.AuctionDTO;
import com.fm.dto.MemberDTO;

import sun.rmi.transport.proxy.RMIDirectSocketFactory;

public class Login implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		MemberDTO mDto=new MemberDTO();
		MemberDAO mdDao=new MemberDAO();
		mDto.setId(request.getParameter("id"));
		mDto.setPw(request.getParameter("pw"));
		mDto=mdDao.Login(mDto);
		ArrayList<AuctionDTO> wish=new ArrayList<>();
		if(mDto != null){
			HttpSession session=request.getSession();
			session.setAttribute("member", mDto);
			session.setAttribute("wish", wish);
			
			af.setRedirect(true);
			request.setAttribute("message", "로그인 성공");
			af.setPath("/sub/member/loginResult.jsp");
		}else{
			request.setAttribute("message", "로그인 실패");
			af.setRedirect(true);
			af.setPath("/sub/member/loginResult.jsp");
		}		
		return af;
	}

}
