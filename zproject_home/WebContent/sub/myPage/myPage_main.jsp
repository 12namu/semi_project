<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="../../common/header.jspf" %>
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/myPage/myPage_main.css">
   
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
 				</div>
 				
   			
   			<div id="middle_content">
		   			<div class="contents">
		   			<hr>
		   			<h3>&nbsp;등록상품목록 &nbsp;<a href="uploadProcess.me?curPage=1" class="more">more></a></h3>
		   			<table class="table table1">
		   			<tr> 			
		   			<td width="85px">상품명</td><td width="250px">상품정보</td><td width="85px">결과</td>  			
		   			</tr>
		   			
		   			<c:if test="${upload_list eq null}">
		   			<tr>
	    			<td colspan="5">현재 등록상품이 없습니다.</td>
					</tr>
					</table>	   			
		   			</c:if>
		   			
		   			<c:if test="${upload_list ne null}" >
		   			<c:forEach var="i" items="${upload_list}" begin="0" end="0" step="1">
		   			<tr>
		   			<td width="85px">${i.name}</td>
		   			<td width="250px"><div id="imgbox_1">
		   								<a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${i.num}">
		   								<img src="<%=application.getContextPath()%>/img/auction/upload/${i.imgs}" class="img1">
		   								</a></div></td>
		   			<td width="85px"class="txtbox">
		   										<c:if test="${i.state eq 0}">
												<span id="timess">경매진행중</span>
												</c:if>
												<c:if test="${i.state eq 1}">
													<span id="timess">경매종료</span>
												</c:if>
					</td> 
		   			</tr>
		  			</c:forEach> 
		   			</table>
		   			</c:if>
		   			</div><!--contents1-->
   			
   			
   			
   				<div class="contents">
   				<hr>
   				<h3>&nbsp;참여상품목록 &nbsp;<a href="partProcess.me?curPage=1" class="more">more></a></h3>
	    		<table class="table">
				<tr>
				<td width="85px">상품명</td><td width="250px">상품정보</td><td width="85px">결과</td>      			
				</tr>
				
				<c:if test="${part_list eq null}">
				<tr>
	    		<td colspan="5">현재 참여상품이 없습니다.</td>
				</tr>
				</table>
				</c:if>
				
				<c:if test="${part_list ne null}" >
				   <c:forEach var="j" items="${part_list}" begin="0" end="0" step="1">
   					<tr>
   					<td width="85px">${j.name}</td><td width="250px">
   											<div id="imgbox_1"><a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${j.num}">
   											<img src="<%=application.getContextPath()%>/img/auction/upload/${j.imgs}" class="img1">
   											</a></div></td>
   											
   					<td width="85px" class="txtbox">
   											<c:if test="${j.state eq 0}">
											<span id="timess">경매진행중</span>
											</c:if>
											<c:if test="${j.state eq 1}">
											<span id="timess">경매종료</span>
											</c:if>
					</td> 
   					</tr>
   				</c:forEach>
   				</table>
   				</c:if>
				</div>

   			
   			<div class="contents">
   			<hr>
   			<h3>&nbsp;MY WISH &nbsp;<a href="mywishProcess.me?curPage=1" class="more">more></a></h3>
   			<table class="table">
			<tr>
			<td width="85px">상품명</td><td width="250px">상품정보</td><td width="85px">현재상태</td> 
   			</tr>
   			
   			<c:if test="${wish eq null}">
				<tr>
	    		<td colspan="5">현재 Wish List에 담긴 상품이 없습니다.</td>
				</tr>
				</table>
			</c:if>
				
			<c:if test="${wish ne null}" >
				   <c:forEach var="j" items="${wish}" begin="0" end="0" step="1">
   					<tr>
   					<td width="85px">${j.name}</td><td width="250px">
   											<div id="imgbox_1"><a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${j.num}">
   											<img src="<%=application.getContextPath()%>/img/auction/upload/${j.imgs}" class="img1">
   											</a></div></td>
   											
   					<td width="85px" class="txtbox">
   											<c:if test="${j.state eq 0}">
											<span id="timess">경매진행중</span>
											</c:if>
											<c:if test="${j.state eq 1}">
											<span id="timess">경매종료</span>
											</c:if>
					</td> 
   					</tr>
   				</c:forEach>
   				</table>
   				</c:if>	
   			</div>
   			</div><!--middle contents-->
   			
   		<!-- 	<div id="middle_content">
	   			<div class="contents contents_back">
	   			<hr>
	   			<h3>&nbsp;MY COIN &nbsp;<a href="#" class="more">충전하기></a></h3>
	   			<table class="table">
	   			</table>
	   			</div>
   			</div> -->
   		</div><!--middle-->
   	</div><!--container-->

   <%@ include file="../../common/footer.jspf" %>