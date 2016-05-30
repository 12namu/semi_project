<%@page import="com.fm.dto.AuctionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../common/header.jspf" %>
<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/auction/auctionView.css">
<script src="<%= application.getContextPath() %>/js/auction/auctionView.js"></script>	
	<section>
		<div id="middleBox">
		<form action="./auctionJJim.ac" method="post">
			<div id="middleHeader">
				<div id="middleHeaderTop">
					<span id="auctionCategory">[${view.category}]</span>
						<input type="hidden" name="category" value="${view.category}">
					<span id="auctionTitle">${view.title}</span><br>
						<input type="hidden" name="title" value="${view.title}">
				</div>
				<div id="middleHeaderContent">
					<span id="auctionPr">${view.pr}</span><br>
						<input type="hidden" name="pr" value="${view.pr}">
					<span id="auctionCounts">조회수 : ${view.counts} </span><br>		
						<input type="hidden" name="counts" value="${view.counts}">
					<span id="auctionWriter">글쓴이 : ${view.id } </span>
						<input type="hidden" name="id" value="${view.id}">
				</div>
			</div>
			
			<div id="middleContent">
				<div id="middleImgs">
					<table class="contentImgs">
						<tbody>
						<tr>
						<td>
							<div id="mainImg">
								<img src="<%=application.getContextPath()%>/img/auction/upload/${imgs['0']}" id="auctionHeaderImg">
								<input type="hidden" name="imgs" value="${view.imgs}">
							</div>
						</td>
						</tr>
						</tbody>
					</table>
					
					<table class="contentImgs2">
						
						<tr>
						<c:forEach items="${imgs}" var="im" varStatus="i" >
							<c:if test="${i.index ne 0 }">	
							<td>
								<div class="subImg">
								<img src="<%=application.getContextPath()%>/img/auction/upload/${im}" class="auctionSubImg" id="imged${i.index}">
								
							</div>
							</td>
							</c:if>
															
						 </c:forEach>
						</tr>
					</table>							
				
					
					</div>
				
				<div id="middleWriteContent">
					<table class="auctionInfo">
						<tr>
							<input type="hidden" id="num" value="${view.num}" name="num"> 
							<input type="hidden" name="state" value="${view.state}">
							<td class="infoTitle">시작가</td>
							<td class="infoContents">${view.startPrice }원</td>
							<input type="hidden" name="startPrice" value="${view.startPrice}">
						</tr>
						<tr>
							<td class="infoTitle"><span class="nowPrice">현재가</span></td>
							<td class="infoContents"><span class="nowPrice">${view.nowPrice}원</span></td>
							<input type="hidden" name="nowPrice" value="${view.nowPrice}">
						</tr>
						<tr>
							<td class="infoTitle">입찰증가금액</td>
							<td class="infoContents">${view.bidIncrease}원</td>
							<input type="hidden" name="bidIncrease" value="${view.bidIncrease}">
						</tr>
						<tr>
							<td class="infoTitle">남은시간</td>
							
							<td class="infoContents timesss">
								<input type="hidden" id="endTime" value="${lastDay}"> 
							</td>
						</tr>
						<tr>
							<td class="infoTitle">입찰자</td>
							<td class="infoContents">${view.bidCount}명
							<input type="hidden" name="bidCount" value="${view.bidCount}">
							<input id="bidderBtn" type="image" src="<%= application.getContextPath() %>/img/auction/view/btnAuction.gif" data-toggle="modal" data-target="#myModal" onclick="return false">
							
							</td>
						</tr>
			
					</table>
				</div>
				<div id="middleWriteContent2">
				<c:if test="${view.state eq 0 && member.id ne null}">
					<table class="auctionInfo2" >
						<tbody>
							<tr>
								<td>
									<div id="btnBid">
										<input type="image" src="<%= application.getContextPath() %>/img/auction/view/btnBid.jpg" id="bidBtn" class="btns" data-toggle="modal" data-target="#myModal2" onclick="return false">		
									</div>
								</td>
								<td>
									<div id="btnJjim">
									<input type="image" src="<%= application.getContextPath() %>/img/auction/view/btnJjim.gif" id="jjimBtn" class="btns">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</c:if>
				</div>
			</div>
			</form>
			<div id="middleContent2">
				<table id="detailContents">
					<tbody>
						<tr>
							<td>
								<div id="detailHeader">
									<img src="<%= application.getContextPath() %>/img/auction/view/detailHead.jpg" >
								</div>
							</td>
	
						</tr>
						<tr>
							<td>
								<div id="detailContent">
									${view.contents}
								</div>
							</td>
						</tr>
						<tr>
							<td>
							<c:if test="${view.id eq member.id}">
							<center>
								<div id="writeBtn">
									<button type="button" id="update1" class="btn btn-primary write">수정하기</button>
									<button type="button" id="del1" class="btn btn-primary write">삭제하기</button>
								</div>
							</center>
							</c:if>
							</td>
							</tr>
						<tr>	
							<td>
								<div id="btnListGo">
									<a href="<%=application.getContextPath() %>/sub/auction/auctionList.ac?curPage=1&check=0"><img src="<%= application.getContextPath() %>/img/auction/view/btn_list.gif" ></a>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			
			
			</div>
		
		</div>

		<!--입찰내역 Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel"><img src="<%= application.getContextPath() %>/img/auction/view/bidders.jpg" ></h4>
		      </div>
		      <div class="modal-body">
		        <table class="table table-hover">
				</table>
		      </div>
		      
		    </div>
		  </div>
		</div>
		<!-- end  -->
		
		<!--입찰하기 Modal -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">
					입찰하기
				</h4>
		      </div>
		      <div class="modal-body">
		      	<div id="bidInfo">
		        	<table class="auctionInfoBid">
						<tr>
							<td><span id="bidInfoCategory">[${view.category}]</span>
								${view.title}
							</td>
						</tr>
						<tr>
							<td>시작가 </td><td>${view.startPrice} 원</td>
							<input type="hidden" value="${view.startPrice}" id="bidInfostartPrice">
						</tr>
						<tr>
							<td>입찰증가금액 </td><td>${view.bidIncrease} 원</td>
							<input type="hidden" value="${view.bidIncrease}" id="bidInfoIncrease">
						</tr>
						<tr>
							<td><span class="bidInfoNowPrice">현재가</span></td>
							<td><span class="bidInfoNowPrice">${view.nowPrice} 원</span></td>
							<input type="hidden" value="${view.nowPrice}" id="bidInfoNowPrices">
						</tr>
						<tr>
							<td>입찰자 </td><td>${view.bidCount} 명</td>
						</tr>					
						<tr>
							<td>타이머 </td><td><span class="timesss"></span></td>
						</tr>
					</table>
				</div>	
		      </div>
		      <div class="modal-footer">
              	<form action="./auctionBidStart.ac" method="post" id="frmBid" onsubmit="false" >
        			<div id="bidStart">
              			<table class="bidPrice">
              				
        					<tr>
        						<input type="hidden" id="writeNum" value="${view.num}" name="writeNum">
        						<input type="hidden" id="ids" value="${member.id}" name="ids">
        						<td id="bidPricess">입찰금액</td>
        						<td><input type="text" name="bidPrice" id="bidPrice" class="form-control"> 원</td>
        					</tr>
      		  			</table>
        			</div>
					<input type="image" id="bidStartBtn" src="<%= application.getContextPath() %>/img/auction/view/detailBt04.gif">        					        			
      		  	</form>
      		  </div>
		    </div>
		  </div>
		</div>
		<!-- end  -->
	</section>
<%@ include file="../../common/footer.jspf" %>
    