<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../../common/header.jspf" %>
	<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/auction/search.css">
		<section>
			<div id="middleBox">
				<div id="searchFilter">	
					<center>
						<p>
						<span id="searchWord">${word}</span>
						<span><img src="<%=application.getContextPath() %>/img/auction/search/btn_search.png" id="searchBtn"></span>
						<span id="searchResult">
							검색결과 <strong>${size}</strong> 상품 
						</span>
						</p>
					</center>
				</div>
				<div id="middleContent">		
				<c:if test="${list ne null}">
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
					</c:if>	
						<c:if test="${list eq null}">
							<center id="nosearch">
							<span id="noword">검색결과가 없습니다.</span>
							</center>
						</c:if>
					
					<center>
					
					<c:if test="${list ne null}">
					<nav>
					  <ul class="pagination">
					    <c:if test="${pageing['curBlock'] > 1}">
					    <li>
					      <a href="./auctionSearchList.ac?curPage=${pageing['startPage']-1}&search=${word}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    </c:if>
					   <c:forEach begin="${pageing['startPage']}" end="${pageing['lastPage']}" step="1" var="i" >
 							<li><a href="./auctionSearchList.ac?curPage=${i}&search=${word}"> ${i}</a></li>
						</c:forEach>
						 <c:if test="${pageing['curBlock'] < pageing['totalBlock']}">
						 <li>
					      <a href="./auctionSearchList.ac?curPage=${pageing['lastPage']+1}&search=${word}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    </c:if>
					  </ul>
					</nav>
					</c:if>
			</div>		
			
			</div>		
		</section>
		
		
	
	
	
	<%@ include file="../../common/footer.jspf" %>