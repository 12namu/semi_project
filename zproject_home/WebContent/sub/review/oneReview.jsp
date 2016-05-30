<%@page import="com.fm.dao.ReviewDAO"%>
<%@page import="com.fm.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/header.jspf" %>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/review/oneReview.css">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
<%ReviewDTO rdto=(ReviewDTO)request.getAttribute("rdto");%>
function go(){
	location.href="./reviewUpdate.jsp"
}

function delet(){
	location.href="./reviewDelete.rw?num=<%=rdto.getNum()%>"
}

function likes(){
	location.href="./reviewLikes.rw?num=<%=rdto.getNum()%>&likes=<%=rdto.getLikes()%>"
}
</script>

<div id="container">
<div id="contents">

<div id="reviewMenu">
	<div id="reviewImg"><img src="<%=application.getContextPath()%>/img/review/menu.png"></div>
	<div id="reviewMenu_1"><a  id="allReview" class="all" href="<%=application.getContextPath()%>/sub/review/reviewList.rw?curPage=1">전체리뷰</a> > 상세리뷰</div>
</div>

<div id="center">
	<div id="productImg">
<%-- 		<img src="<%=application.getContextPath()%>/img/auction/upload/${rdto.imgs}" > --%>
	</div>
	
	<div id="one_review">
	<table border="1">	
		<tr>
			<td class="title">글제목</td><td colspan="7">${rdto.title }</td>
		</tr>
		<tr>
			<td class="title">글쓴이</td><td>${member.id}</td>
			<td class="title">작성일</td><td>${rdto.reg_date }</td>
			<td class="title">조회수</td><td>${rdto.counts }</td>
			<td class="title">좋아요</td><td>${rdto.likes }</td>
		</tr>
		<tr>
			<td colspan="8"  height="350px">${rdto.contents }</td>
		</tr>
	</table>
	</div>
	
	<div id="bottom_button">
	<button class="btn btn-default" onclick="go()">수정하기</button>
	<button class="btn btn-default" onclick="delet()">삭제하기</button>
	<button class="btn btn-default" onclick="likes()" id="likes">좋아요</button>
	</div>
</div>
</div>
</div>

<%@include file="../../common/footer.jspf" %>









