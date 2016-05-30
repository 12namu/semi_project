<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../../common/header.jspf" %>
    <link rel="stylesheet" href="<%=application.getContextPath()%>/css/myPage/myPage_mywish.css">
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
					<a href="<%=application.getContextPath() %>/sub/myPage/mywishProcess.me?curPage=1">MY WISH</a> 					
 					</li>
 					<li>
 					<a href="<%=application.getContextPath() %>/sub/myPage/myPage_myinfo.jsp"">회원정보수정</a>
 					</li>
 					
 					</ul>
 					</div>
 				</div>
 				</div>
 				

   			<div id="middle_content">
				<div id="upload_list">
				<hr style="border: solid 1.5px black;">
				
				<div class="main_section">
				<p>
				<img src="<%=application.getContextPath()%>/img/member/myPage/tit_myPage_mywish.png">
				</p>
				<br>
				<a href="#">HOME</a> > <a href="#">MY FREEMARKET</a> > <a href="#">MYWISH</a>
				<br><br>
				[상품번호]를 클릭하시면 상세페이지를 조회할 수 있습니다.
				<br><br>
							
				 <ul class="nav nav-tabs" role="tablist">
  				  <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Wish List</a></li>
  				  </ul>


  				<div class="tab-content">
    				  <div role="tabpanel" class="tab-pane active" id="home">
		    			<table class="table table-hover">
						<tr height="20%">
						<td width="13%">상품번호</td>
						<td width="24%">상품명</td>
						<td width="13%">현재입찰가</td>
						<td width="13%">현재상태</td>		
						</tr>
				
				<c:if test="${wish eq null}">
  	 			<tr>
				<td colspan="5">현재 Wish List에 담긴 상품이 없습니다.</td>
				</tr>
				</table>	
    			</c:if>
				
						
  			 <c:if test="${wish ne null}">
  				 <c:forEach var="i" items="${wish}" >					
						<tr>
						<td width="13%"><a href="<%=application.getContextPath()%>/sub/auction/auctionView.ac?num=${i.num}">${i.num}</a></td>
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
						</c:if>
    				  </div>
    				  
 				 </div><!-- tab-content-->
				</div><!--main section-->
				</div><!--upload_list-->
   			</div><!--middle_content-->
   		</div><!--middle-->
   	</div><!--container-->
    
    
    <%@ include file="../../common/footer.jspf" %>