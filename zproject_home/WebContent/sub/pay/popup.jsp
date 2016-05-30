<%@page import="com.fm.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	text-align: center;
}
#check{
	width: 400px;
	margin: 0 auto;
	margin-top: 2%;
}
#check input{
	width: 400px;
    height: 40px;	
	font-size: 20px;
}
</style>
<script type="text/javascript">
function go() {
	<%MemberDTO mdto=new MemberDTO();%>
	var m=<%=mdto.getCkmessage()%>
	var c=$("#message").val();
	if(m==c){
		alert("결제되었습니다.");
		opener.location.href="../../index.jsp";
		self.close();
	}else{
		alert("메시지가 일치하지 않습니다.");
	}
}
</script>
</head>
<body>
<div>
	<h2>회원가입할때 입력한 메시지를 입력하세요.</h2>
	<div id="check">
		<input type="text" name="check" id="message">
	</div>
	<br>
	<button onclick="go()">결제하기</button>
</div>
</body>
</html>