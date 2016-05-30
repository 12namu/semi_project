<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="./js/index/slider/modernizr.custom.63321.js"></script>
<script src="./js/index/slider/jquery.catslider.js"></script>
<script src="js/index/slider/slider.js"></script>

	
				<div id="mi-slider" class="mi-slider">
					<ul>
					<c:forEach items="${craft}" var="craft">
						<a href="./sub/auction/auctionView.ac?num=${craft.num}">
						<li>
						<div id="indexContent">
							<table class="inContent">
								<tbody>
									<tr>
										<td colspan="2" id="inimgs">
											<div id="inimgsed">
												<img src="<%=application.getContextPath()%>/img/auction/upload/${craft.imgs}">
											</div>
										</td>
									</tr>
									<tr>
										
										<td colspan="2">${craft.title}</td>
										
									</tr>
									<tr>
 										<td colspan="2">${craft.pr}</td> 
									</tr>
									<tr>
 										<td>시작가</td><td>${craft.startPrice}원</td>
									</tr>
									<tr>
										<td>입찰자</td><td>${craft.bidCount}명</td>
									</tr>
								</tbody>
							</table>
						</div>
						</li>
						</a>
						</c:forEach>
					</ul>
					<ul>
						<c:forEach items="${wear}" var="wear">
						<a href="./sub/auction/auctionView.ac?num=${wear.num}">
						<li>
						<div id="indexContent">
							<table class="inContent">
								<tbody>
									<tr>
										<td colspan="2" id="inimgs">
											<div id="inimgsed">
												<img src="<%=application.getContextPath()%>/img/auction/upload/${wear.imgs}">
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="2">${wear.title}</td>
									</tr>
									<tr>
										<td colspan="2">${wear.pr}</td>
									</tr>
									<tr>
										<td>시작가</td><td>${wear.startPrice}원</td>
									</tr>
									<tr>
										<td>입찰자</td><td>${wear.bidCount}명</td>
									</tr>
								</tbody>
							</table>
						</div>
						</a>
						</li>
						</c:forEach>
					</ul>
					<ul>
					<c:forEach items="${sundries}" var="sundries">
						<a href="./sub/auction/auctionView.ac?num=${sundries.num}">
						<li>
						<div id="indexContent">
							<table class="inContent">
								<tbody>
									<tr>
										<td colspan="2" id="inimgs">
											<div id="inimgsed">
												<img src="<%=application.getContextPath()%>/img/auction/upload/${sundries.imgs}">
											</div>
										</td>
									</tr>
									<tr>
										
										<td colspan="2">${sundries.title}</td>
										
									</tr>
									<tr>
										<td colspan="2">${sundries.pr}</td>
									</tr>
									<tr>
										<td>시작가</td><td>${sundries.startPrice}원</a></td>
									</tr>
									<tr>
										<td>입찰자</td><td>${sundries.bidCount}명</td>
									</tr>
								</tbody>
							</table>
						</div>
						</li>
						</a>
						</c:forEach>
					</ul>					
					<nav>
						<a href="#">수공예</a>
						<a href="#">의류</a>
						<a href="#">잡화</a>
					</nav>
			</div>				