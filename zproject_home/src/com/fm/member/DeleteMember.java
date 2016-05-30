package com.fm.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.MemberDAO;

public class DeleteMember implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		String id=request.getParameter("id");
		MemberDAO mDao=new MemberDAO();
		int result=mDao.DelteMember(id);
		
		if(result>0){
			request.setAttribute("message", "회원탈퇴 되었습니다. 그동안 프리마켓을 이용해주셔서 감사합니다");
			af.setPath("/sub/member/loginResult.jsp");
			af.setRedirect(true);
			HttpSession session=request.getSession();
			session.invalidate();
			
		}else{
			request.setAttribute("message", "회원탈퇴 실패");
			af.setPath("/sub/myPage/myPage_result.jsp");
			af.setRedirect(true);
		}
		return af;
	}

}
