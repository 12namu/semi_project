<%@page import="java.lang.String"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.fm.dto.ReviewDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jspf" %>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/review/reviewList.css">
<script type="text/javascript">
function go() {
	location.href="./reviewWrite.jsp";

}
</script>


<%
ArrayList<ReviewDTO> ar=(ArrayList<ReviewDTO>)request.getAttribute("list");
Hashtable<String, Integer> hs=(Hashtable<String, Integer>)request.getAttribute("paging");
%>

<div id="container">

<div id="contents">
	<div id="reviewMenu">
		<div id="reviewImg"><img src="<%=application.getContextPath()%>/img/review/menu.png"></div>
		<div><a class="all" href="<%=application.getContextPath()%>/sub/review/reviewList.rw?curPage=1">전체리뷰</a></div>
	</div>
	
	
<div id="center">
	 <table class="table table-bordered" >
		 <c:forEach items="${requestScope.list}" var="list">
		<tr>
				<td class="product" >
					<div class="img"><%-- <img src="<%=application.getContextPath()%>/img/review/<%=ar.get(i).getImgs()%>"> --%></div>
					<a class="title_1" href="<%=application.getContextPath()%>/sub/review/oneReview.rw?num=${list.num}">
						${list.title}
					</a>
					<br>좋아요 : ${list.likes}
					<br>조회수 : ${list.counts}
				</td>
		</tr>
			</c:forEach>
	</table>
	</div>
	
	<c:if test="${sessionScope.member ne null}">
	
	<div id="bottom_button">
	<input type="button" class="btn btn-default" value="등록하기" onclick="go()">
	</div>
	</c:if>

</div><!--contents -->
</div><!-- container-->

<%@include file="../../common/footer.jspf" %>