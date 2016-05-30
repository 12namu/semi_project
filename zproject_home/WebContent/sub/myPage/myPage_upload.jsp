<%@page import="com.fm.dto.BuyingDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../common/header.jspf" %>
         <link rel="stylesheet" href="<%=application.getContextPath()%>/css/myPage/myPage_upload.css">

 <div id="container">
 <div id="middle">
	<div id="middle_menu">
	<div id="menu_top">
		<h2>
 		 <a href="<%=application.getContextPath() %>/sub/myPage/mainProcess.me?curPage=1"><img src="<%=application.getContextPath()%>/img/member/myPage/tit101.png"></a>
 		</h2>
	</div>
		<div id="menu_bottom">
					<div id="quick_menu">
 					<ul class="menu_list">
 					<li>
 					<a href="<%=application.getContextPath() %>/sub/myPage/uploadProcess.me?curPage=1">등록상품목록</a>
 					</li>
 					<li>
 					<a href="<%=application.getContextPath() %>/sub/myPage/partProcess.me?curPage=1">참여상품목록</a>
 					</li>
 					<li>
					<a href="<%=application.getContextPath() %>/sub/myPage/mywishProcess.me">MY WISH</a> 					
 					</li>
 					<li>
 					<a href="<%=application.getContextPath() %>/sub/myPage/myPage_myinfo.jsp"">회원정보수정</a>
 					</li>
 					
 					</ul>
 					</div>
 		</div>
 	</div><!--middle_menu-->
 	
 	<div id="middle_content">
 		<div id="upload_list">
		<hr style="border: solid 1.5px black;">		
		<div class="main_section">
		<p>
		<img src="<%=application.getContextPath()%>/img/member/myPage/tit_myPage_upload.png">
		</p>
		<br>
		<a href="#">HOME</a> > <a href="#">MY FREEMARKET</a> > <a href="#">등록상품조회</a>
		<br><br>
		[상품번호]를 클릭하시면 등록 내역을 조회하실 수 있습니다.
		<br><br>
		
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#all" aria-controls="home" role="tab" data-toggle="tab">전체보기</a></li>
    <li role="presentation"><a href="#ing" aria-controls="profile" role="tab" data-toggle="tab">진행중</a></li>
    <li role="presentation"><a href="#end" aria-controls="messages" role="tab" data-toggle="tab">종료</a></li>
  </ul>


  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="all">
    <table class="table table-hover">
						<tr height="20%">
						<td width="13%">상품번호</td>
						<td width="13%">등록일자</td>
						<td width="24%">등록상품</td>
						<td width="13%">현재입찰가</td>
						<td width="13%">현재상태</td>	
	
						</tr>
	
	<c:if test="${list1 eq null}">
  	 	<tr>
		<td colspan="5">현재 등록상품이 없습니다.</td>
		</tr>
		</table>	
    </c:if>	
    
    <c:if test="${list1 ne null}">
  	 <c:forEach var="i" items="${list1}" >					
						<tr>
						<td width="13%"><a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${i.num}">${i.num}</a></td>
						<td width="13%">${i.reg_date }</td>
						<td width="37%">${i.title }</td>
						<td width="13%">${i.nowPrice }</td>
						<td width="13%"><c:if test="${i.state eq 0}">
										<span id="timess">경매진행중</span>
										</c:if>
										<c:if test="${i.state eq 1}">
											<span id="timess">경매종료</span>
										</c:if>
						</td>	
						</tr>
						</c:forEach>
						</table>	
		<div class="table">		 
    		<c:if test="${hs1['curBlock'] >1}">
    		<a href="./uploadProcess.me?curPage=${hs1['startPage']-1}">[이전]</a>
    		</c:if>
    				
    		<c:forEach var="t" begin="${hs1['startPage']}" end="${hs1['lastPage']}" step="1">
			<a href="./uploadProcess.me?curPage=${t}">${t}</a>
			</c:forEach> 
    				 
    				  
    		<c:if test="${hs1['curBlock']< hs1['totalBlock']}">
    		<a href="./uploadProcess.me?curPage=${hs1['lastPage']+1}">[다음]</a>
    		</c:if>  
		</div>					
    </c:if>
    
    
    </div>
    <div role="tabpanel" class="tab-pane" id="ing">
	    <table class="table table-hover">
		    <tr height="20%">
			<td width="13%">상품번호</td>
			<td width="13%">등록일자</td>
			<td width="37%">등록상품</td>
			<td width="13%">현재입찰가</td>
			<td width="13%">현재상태</td>
			</tr>		
	    
    	<c:if test="${list2 eq null}">
    		<tr>
			<td colspan="5">진행중인 등록상품이 없습니다.</td>
			</tr>
			</table>
    	</c:if>
    	
    	<c:if test="${list2 ne null}" >
			<c:forEach var="i" items="${list2}" >					
			<tr>
				<td width="13%"><a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${i.num}">${i.num}</a></td>
				<td width="13%">${i.reg_date}</td>
				<td width="37%">${i.title }</td>
				<td width="13%">${i.nowPrice }</td>
				<td width="13%"><c:if test="${i.state eq 0}">
											<span id="timess">경매진행중</span>
											</c:if>
											<c:if test="${i.state eq 1}">
											<span id="timess">경매종료</span>
											</c:if>
				</td>
			</tr>
			</c:forEach>
			</table>    	
    		
    		<div class="table">			 
		    	<c:if test="${hs2['curBlock'] >1}">
		    	<a href="./uploadProcess.me?curPage=${hs2['startPage']-1}">[이전]</a>
		    	</c:if>
		    				
		    	<c:forEach var="t" begin="${hs2['startPage']}" end="${hs2['lastPage']}" step="1">
				<a href="./uploadProcess.me?curPage=${t}">${t}</a>
				</c:forEach> 
		    				 
		    				  
		    	<c:if test="${hs2['curBlock']< hs2['totalBlock']}">
		    	<a href="./uploadProcess.me?curPage=${hs2['lastPage']+1}">[다음]</a>
		    	</c:if>  
			</div>	 	
    	</c:if>  
    </div>
   
   
    <div role="tabpanel" class="tab-pane" id="end">
    	<table class="table table-hover">
						<tr height="20%">
						<td width="13%">상품번호</td>
						<td width="13%">등록일자</td>
						<td width="24%">등록상품</td>
						<td width="13%">최종입찰가</td>
						<td width="13%">현재상태</td>	
						<td width="13%">최종입찰자</td>		
						</tr>
		
		<c:if test="${list3 eq null}">
			<tr>
			<td colspan="6">종료된 등록상품이 없습니다.</td>
			</tr>
			</table>
		</c:if>				
    	
    	<c:if test="${list3 ne null}" > 
    		<c:forEach var="i" items="${list3}">
			<% ArrayList<String> buyingM =((ArrayList<String>)request.getAttribute("end"));
							int j = 0;
			%>					
			<tr>
			<td width="13%"><a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${i.num}">${i.num}</a></td>
			<td width="13%">${i.reg_date }</td>
			<td width="24%">${i.title }</td><td width="13%">${i.nowPrice }</td>
			<td width="13%">
							<c:if test="${i.state eq 0}">
							<span id="timess">경매진행중</span>
							</c:if>
							<c:if test="${i.state eq 1}">
							<span id="timess">경매종료</span>
							</c:if>
							</td>
			<td width="13%">
							<%= buyingM.get(j) %>
							<% j++; %>
			</td>
			</tr>
			</c:forEach>
			</table>
			
			<div class="table">			 
		    		<c:if test="${hs3['curBlock'] >1}">
		    		<a href="./uploadProcess.me?curPage=${hs3['startPage']-1}">[이전]</a>
		    		</c:if>
		    				
		    		<c:forEach var="t" begin="${hs3['startPage']}" end="${hs3['lastPage']}" step="1">
					<a href="./uploadProcess.me?curPage=${t}">${t}</a>
					</c:forEach> 
		    				 
		    				  
		    		<c:if test="${hs3['curBlock']< hs3['totalBlock']}">
		    		<a href="./uploadProcess.me?curPage=${hs3['lastPage']+1}">[다음]</a>
		    		</c:if>  
			</div>	
    	</c:if>
    </div>

		</div><!--tab panes-->
		</div><!--main section-->
		</div><!--upload_list-->
   		</div><!--middle_content-->
   	</div><!--middle-->
   	</div><!--container-->

 <%@ include file="../../common/footer.jspf" %>
