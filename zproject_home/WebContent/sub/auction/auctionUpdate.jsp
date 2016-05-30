<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../common/header.jspf" %>
<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/auction/auctionWrite.css">
<script type="text/javascript" src="<%= application.getContextPath() %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="<%= application.getContextPath() %>/js/auction/auctionUpdate.js"></script>

	<section>
		<div id="middleBox">
			<div id="middleHeader">
				<div id="middleLeft">
					<p>	
						<a class="path" href="#">HOME</a> > 
						<a class="path" href="#">AUCTION</a> > 
						<a class="path" href="#">상품등록</a> >
						<a class="path" href="#">글 수정</a> 
					</p>
					<hr id="line">
				</div>
				<div id="middleRight">	
						<img src="<%= application.getContextPath()%>/img/auction/write/titleImg.gif">
				</div>					
			</div>
		
			
			<div id="middleContent">
				<form action="./auctionUpdate.ac" method="post" id="frm" enctype="multipart/form-data">
					<table class="pTable">
						<tbody>
							<tr>
								<input type="hidden" name="num" value="${view.num}">
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 카테고리
								</td>
								<td class="pContent">
									<select class="form-control" id="selectCategory" name="category">
									<c:if test="${view.category eq '수공예'}">
									  <option value="0">----</option>
									  <option value="수공예" selected="selected">수공예</option>
									  <option value="의류">의류</option>
									  <option value="잡화">잡화</option>
									 </c:if>
									<c:if test="${view.category eq '의류'}">
									  <option value="0">----</option>
									  <option value="수공예">수공예</option>
									  <option value="의류" selected="selected">의류</option>
									  <option value="잡화">일반상품</option>
									 </c:if>
									 <c:if test="${view.category eq '잡화'}"> 
								 	 <option value="0">----</option>
									  <option value="수공예">수공예</option>
									  <option value="의류">의류</option>
									  <option value="잡화" selected="selected">잡화</option>
								 	 </c:if>
									
									</select>
								</td>
								<td class="pSubContent">
									<div id="categoryState">
									</div>
								</td>
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 물품명
								</td>
								<td class="pContent">
									<input type="text" class="form-control data" name="productName" id="pName" value="${view.name }">
								</td>
								<td class="pSubContent">
									<div id="pNameState">
									</div>
								</td>	
							
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 홍보문구
								</td>
								<td class="pContent">
									<input type="text" class="form-control data" name="pr" id="pr" value="${view.pr }">
								</td>
								<td class="pSubContent">
									<div id="prState">
									</div>
								</td>
							</tr>
							
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 시작가
								</td>
								<td class="pContent">
									<input type="text" class="form-control data" name="startPrice" id="startPrice" value="${view.startPrice }">
								</td>
								<td class="pSubContent">
									<div id="startPriceState">
										
									</div>
								</td>
							</tr>
						
							<c:if test="${view.bidCount eq 0 }">
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 최소입찰증가
								</td>
								<td class="pContent">
									<input type="text" class="form-control data" name="bidIncrease" id="bidIncrease" value="${view.bidIncrease }">
								</td>
								<td class="pSubContent">
									<div id="bidIncreaseState">
									</div>
								</td>
							</tr>
							</c:if>
							
							<c:if test="${view.bidCount > 0 }">
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 최소입찰증가
								</td>
								<td class="pContent">
									<input type="text" class="form-control data" name="bidIncrease" id="bidIncrease" value="${view.bidIncrease }" readonly="readonly">
								</td>
								<td class="pSubContent">
									<div id="bidIncreaseState">
										입찰이 시작되면 입찰증가 금액을 수정 할 수 없습니다.
									</div>
								</td>
							</tr>
							</c:if>	
							
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 경매진행일
								</td>
								<td class="pContent">
									<select class="form-control data" name="date" id="date"  >
									  <option value="0">----</option>
									  <c:if test="${view.days eq '1'}">
									  	<option value="1" selected="selected">1일</option>
									  	<option value="2" >2일</option>
									  	<option value="3" >3일</option>
									  	<option value="4" >4일</option>
									  </c:if>
									  <c:if test="${view.days eq '2'}">
									  	<option value="1" >1일</option>
									  	<option value="2" selected="selected">2일</option>
									  	<option value="3" >3일</option>
									  	<option value="4" >4일</option>
									  </c:if>
									  <c:if test="${view.days eq '3'}">
									  	<option value="1" >1일</option>
									  	<option value="2" >2일</option>
									  	<option value="3" selected="selected">3일</option>
									  	<option value="4" >4일</option>
									  </c:if>
									  <c:if test="${view.days eq '4'}">
									  	<option value="1" >1일</option>
									  	<option value="2" >2일</option>
									  	<option value="3" >3일</option>
									  	<option value="4" selected="selected">4일</option>
									  </c:if>
									</select>
								</td>
								<td class="pSubContent">
									<div id="dateState">
									</div>
								</td>
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 상품이미지
								</td>
								<td class="pContent imgss">
									<input type="file"  class="form-control imgs" name="productImg1" id="files">
									<button type="button" class="btn btn-info">이미지 추가</button>
								</td>
								<td class="pSubContent">
									<div id="pImgState">
										글 수정 시 이미지를 다시 업로드 해주세요.
										
									</div>
								</td>
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 글 제목
								</td>
								<td class="pContent">
									<input type="text"  class="form-control" name="wtitle" id="wtitle" value="${view.title }">
								</td>
								<td class="pSubContent">
									<div id="wtitleState">
									</div>
								</td>
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								작성자
								</td>
								<td class="pContent">
									<input type="text"  readonly="readonly" class="form-control" name="writer" id="writer" value="${view.id }">
								</td>
								<td class="pSubContent">
									<div id="writer">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div id="writeImg">
						<img src="<%=application.getContextPath() %>/img/auction/write/productInfo.png">
					</div>
					<div id="write">
						<textarea name="smarteditor" class="data" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px;">
							${view.contents }
						</textarea>
					</div>
					<center>
					<div id="writeBtn">
						<button type="button" id="update1" class="btn btn-primary write">수정하기</button>
						<button type="button" id="goReset" class="btn btn-primary write">다시쓰기</button>
						<button type="button" id="goList" class="btn btn-primary write">목록으로</button>
					</div>
					</center>
				</form>			
			</div>
		</div>
	</section>
<%@ include file="../../common/footer.jspf" %>