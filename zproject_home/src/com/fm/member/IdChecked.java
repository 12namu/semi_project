package com.fm.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.MemberDAO;

public class IdChecked implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		String id=request.getParameter("id");
		MemberDAO mdDao=new MemberDAO();
		String result=mdDao.IdCheck(id);
		request.setAttribute("check", result);
		af.setPath("./idCheck.jsp");
		af.setRedirect(true);
		return af;
	}

	

}
