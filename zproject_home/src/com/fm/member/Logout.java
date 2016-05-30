package com.fm.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;

public class Logout implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		HttpSession session=request.getSession();
		session.invalidate();	
		af.setRedirect(true);
		request.setAttribute("message", "로그아웃 되었습니다");
		af.setPath("/sub/member/loginResult.jsp");
		return af;
	}

	
}
