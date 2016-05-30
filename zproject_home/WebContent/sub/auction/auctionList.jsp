<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/auction/auctionList.css">
<script src="<%= application.getContextPath() %>/js/auction/auctionList1.js"></script>
		<section>
			<div id="middleBox">
				<div id="middleHeader">
					<div id="middleLeft">
						<img src="<%= application.getContextPath()%>/img/auction/list/auctionImg.png">
					</div>
					<div id="middleRight">
						<div id="middleRightHeader">
							<p>	
								<a class="path" href="#">HOME</a> > 
								<a class="path" href="#">AUCTION</a> >
								<c:if test="${check eq 0 }">
								 <a class="path" href="#">All LIST</a>
								</c:if>
								<c:if test="${check eq 2 }">
								 <a class="path" href="#">CRAFT</a>
								</c:if>
								<c:if test="${check eq 3 }">
								 <a class="path" href="#">WEAR</a>
								</c:if>
								<c:if test="${check eq 4 }">
								 <a class="path" href="#">SUNDRIES</a>
								</c:if>
							</p>	
						<hr id="line">
						</div>
						<div id="middleRightContent">
							<p>	
								<a class="pathBoard one" href="./auctionList.ac?curPage=1&check=2">수공예</a> 
								<a class="pathBoard two" href="./auctionList.ac?curPage=1&check=3">의류</a> 
								<a class="pathBoard three" href="./auctionList.ac?curPage=1&check=4">잡화</a>
							</p>
						</div>
					</div>
				</div>
					
					<div id="middleContent">		
					<table id="productTable">
						<tbody>
						<c:forEach items="${requestScope.list}" var="list">
							
							<tr>
								<td id="pImg">
									<a href="./auctionView.ac?num=${list.num}"><img src="<%=application.getContextPath()%>/img/auction/upload/${list.imgs}"></a>	
								</td>
							
										
								<td id="pInfo">
									<div>
										<a href="./auctionView.ac?num=${list.num}">
										<span id="pCategory">${list.category}</span>
										<span id="pTitle">${list.title}</span><br> 
										<span id="pPr">${list.pr}</span>
										</a>
									</div>
									<div>
										<span id="pId">작성자 : ${list.id}</span>
									</div>
								</td>
								<td id="pState">
									<div>
										<span id="pNow">시작가 : ${list.startPrice}</span><br>
										<span id="pBid">입찰자 : ${list.bidCount} 명 </span><br>				
										<c:if test="${list.state eq 0}">
											<span id="timess">경매진행중</span>
										</c:if>
										<c:if test="${list.state eq 1}">
											<span id="timess">경매종료</span>
										</c:if>
									</div>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					<c:if test="${list ne null }">
					<center>
					<nav>
					  <ul class="pagination">
					    <c:if test="${pageing['curBlock'] > 1}">
					    <li>
					      <a href="./auctionList.ac?curPage=${pageing['startPage']-1}&check=${check}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    </c:if>
					   <c:forEach begin="${pageing['startPage']}" end="${pageing['lastPage']}" step="1" var="i" >
 							<li><a href="./auctionList.ac?curPage=${i}&check=${check}"> ${i}</a></li>
						</c:forEach>
						 <c:if test="${pageing['curBlock'] < pageing['totalBlock']}">
						 <li>
					      <a href="./auctionList.ac?curPage=${pageing['lastPage']+1}&check=${check}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    </c:if>
					  </ul>
				</nav>
				</center>
				</c:if>
				<c:if test="${list eq null }">
					<center>
						<span id="resultWrite" style="font-size: 30px">진행중인 경매가 없습니다.</span>
					</center>
				
				</c:if>
				
						<c:if test="${member.id ne null}">
							<div id="writeBtn">
								<button type="button" class="btn btn-primary write">상품등록</button>
							</div>
						</center>
						</c:if>
				</div>
			</div>		
				
				
				
		</section>
	

<%@ include file="../../common/footer.jspf" %>