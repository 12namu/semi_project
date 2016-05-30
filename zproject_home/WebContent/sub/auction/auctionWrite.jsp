<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../../common/header.jspf" %>

<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/auction/auctionWrite.css">
<script type="text/javascript" src="<%= application.getContextPath() %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="<%= application.getContextPath() %>/js/auction/auctionWrite.js"></script>

	<section>
		<div id="middleBox">
			<div id="middleHeader">
				<div id="middleLeft">
					<p>	
						<a class="path" href="#">HOME</a> > 
						<a class="path" href="#">AUCTION</a> > 
						<a class="path" href="#">상품등록</a> 
					</p>
					<hr id="line">
				</div>
				<div id="middleRight">	
						<img src="<%= application.getContextPath()%>/img/auction/write/titleImg.gif">
				</div>					
			</div>
		
			
			<div id="middleContent">
				<form action="./auctionWrite.ac" method="post" id="frm" enctype="multipart/form-data">
					<table class="pTable">
						<tbody>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 카테고리
								</td>
								<td class="pContent">
									<select class="form-control" id="selectCategory" name="category">
									  <option value="0">----</option>
									  <option value="수공예">수공예</option>
									  <option value="의류">의류</option>
									  <option value="잡화">잡화</option>
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
									<input type="text" class="form-control data" name="productName" id="pName">
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
									<input type="text" class="form-control data" name="pr" id="pr">
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
									<input type="text" class="form-control data" name="startPrice" id="startPrice">
								</td>
								<td class="pSubContent">
									<div id="startPriceState">
										
									</div>
								</td>
							</tr>
							
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 입찰증가금액(단위)
								</td>
								<td class="pContent">
									<input type="text" class="form-control data" name="bidIncrease" id="bidIncrease">
								</td>
								<td class="pSubContent">
									<div id="bidIncreaseState">
									</div>
								</td>
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 경매진행일
								</td>
								<td class="pContent">
									<select class="form-control data" name="date" id="date">
									  <option value="0">----</option>
									  <option value="1">1일</option>
									  <option value="2">2일</option>
									  <option value="3">3일</option>
									  <option value="4">4일</option>
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
									<input type="file"  class="form-control imgs" name="productImg1" id="files" style="ime-mode:inactive">
									<button type="button" class="btn btn-info">이미지 추가</button>
								</td>
								<td class="pSubContent">
									<div id="pImgState">
									</div>
								</td>
							</tr>
							<tr>
								<td class="pTitle">
								<img src="<%=application.getContextPath() %>/img/auction/write/search.gif">
								 글 제목
								</td>
								<td class="pContent">
									<input type="text"  class="form-control" name="wtitle" id="wtitle">
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
									<input type="text"  readonly="readonly" class="form-control" name="writer" id="writer" value="${member.id}">
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
						<textarea name="smarteditor" class="data" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px;"></textarea>
					</div>
					<center>
					<div id="writeBtn">
						<button type="button" id="submit1" class="btn btn-primary write">등록</button>
						<button type="button" id="goReset" class="btn btn-primary write">다시쓰기</button>
						<button type="button" id="goList" class="btn btn-primary write">목록으로</button>
					</div>
					</center>
				</form>			
			</div>
		</div>
	</section>
<%@ include file="../../common/footer.jspf" %>