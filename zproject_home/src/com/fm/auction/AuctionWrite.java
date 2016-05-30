package com.fm.auction;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.AuctionDAO;
import com.fm.dto.AuctionDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AuctionWrite implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af = new ActionForward();
		
		String upload= request.getServletContext().getRealPath("img/auction/upload");
		
		int result=0;
		String message="";
		MultipartRequest multi = null;
		String resultNames = "";
		int max=1024*1024*10;									
		AuctionDTO adto = new AuctionDTO();
		AuctionDAO adao = new AuctionDAO();
		try {
			 multi = new MultipartRequest(request, upload, max, "UTF-8",  new DefaultFileRenamePolicy());
			 adto.setCategory(multi.getParameter("category"));
			 adto.setName(multi.getParameter("productName"));
			 adto.setPr(multi.getParameter("pr"));
			 adto.setStartPrice(Integer.parseInt(multi.getParameter("startPrice")));
			 adto.setBidIncrease(Integer.parseInt(multi.getParameter("bidIncrease")));
			 adto.setDays(Integer.parseInt(multi.getParameter("date")));
			 adto.setTitle(multi.getParameter("wtitle"));
			 adto.setContents(multi.getParameter("smarteditor"));
			 adto.setId(multi.getParameter("writer"));
			 //날짜 처리
			 Calendar ca = Calendar.getInstance();
			 ca.add(Calendar.DATE, Integer.parseInt(multi.getParameter("date")));
			 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
			 
			 String lastDay = sd.format(ca.getTime());
			 Timestamp t =  Timestamp.valueOf(lastDay);
			 
			 adto.setDayLast(t);
			 //날짜end
			 //이미지 처리
			 Enumeration files = multi.getFileNames();
			 int i =0;
			 while(files.hasMoreElements()){
				 String fileNames = (String)files.nextElement();
				 resultNames = resultNames + multi.getFilesystemName(fileNames)+" ";
				 i++;
			 }
			 adto.setImgs(resultNames);
			 //이미지 처리 end
			 result = adao.setWrite(adto);	 
			 
			 if(result >0){
				 message="글 쓰기 성공";
				 request.setAttribute("message", message);
			 }else{
				 message="글 쓰기 실패";
				 request.setAttribute("message", message);
			 }
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		af.setRedirect(true);
		af.setPath("/sub/auction/result/auctionResult.jsp");
		
		return af;
	}

}
