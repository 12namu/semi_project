<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/header.jspf" %>

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/review/reviewWrite.css">
<script type="text/javascript" src="<%= application.getContextPath()%>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="<%= application.getContextPath()%>/js/review/reviewWriter.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%= application.getContextPath() %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>


	<div id="reviewMenu">
		<div id="reviewImg"><img src="<%=application.getContextPath()%>/img/review/menu.png"></div>
		<div id="reviewInfo">
			<a class="all" href="<%=application.getContextPath()%>/sub/review/reviewList.rw?curPage=1">전체리뷰</a> > 리뷰작성
		</div>
	</div>
	
	<form action="./reviewWrite.rw" method="post" id="frm">
	<div id="writeDiv">
		<table>
			<tr>
				<td>제  목 </td>
				<td >
					<input type="text" name="title" id="title">
				</td>
			</tr>
			<tr>
			  	<td>내  용 </td>
			  	<td>
			  		<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px"></textarea>
			  	</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" class="sub" value="글쓰기" id="savebutton">
					<input type="reset" class="sub" value="다시쓰기" id="rese">
				</td>
			</tr>
		</table>
	</div>
	</form>


<%@include file="../../common/footer.jspf" %>