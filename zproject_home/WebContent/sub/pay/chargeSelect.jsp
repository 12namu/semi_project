<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/header.jspf" %>
<head>
<style type="text/css">
#chargeBox{
width: 80%;
margin: 0 auto;
}
#charge{
width: 100%;
border: 1px solid black;
text-align: center;
}
.point{
font-size: 20px;
width: 24%;
}
.cash{
font-size: 20px;
}
#payMenu{
width: 80%;
margin: 0 auto;
margin-bottom: 3%;
}
#cong{
	width: 70%;
    margin: auto;
}
</style>
<script type="text/javascript">
function showCharge() {
	var cong1=$("#10p").val();
	var cong2=$("#50p").val();
	var cong3=$("#100p").val();
	var cong4=$("#500p").val();
	if($("#10p").click){
		
	}
	window.open("popup.jsp","회원정보 확인", "width=500,height=300");
}
</script>
</head>
<body>
<div id="payMenu">
	<div id="payImg"><img src="<%=application.getContextPath()%>/img/pay/charge.png"></div>
</div>
<div id="chargeBox">
	<table id="charge" border="1">
		<tr>
			<td class="point"><div id="cong"><img src="<%=application.getContextPath()%>/img/pay/cong.jpg"></div>10p<br>1100원</td>
			<td class="point"><div id="cong2"><img src="<%=application.getContextPath()%>/img/pay/cong2.jpg"></div>50p<br>5500원</td>
			<td class="point"><div id="cong3"><img src="<%=application.getContextPath()%>/img/pay/cong3.jpg"></div>100p<br>11000원</td>
			<td class="point"><div id="cong4"><img src="<%=application.getContextPath()%>/img/pay/cong3.jpg"></div>500p<br>55000원</td>
		</tr>
		<tr>
			<td><button id="10p" onclick="showCharge()" value="10">충전하기</button></td>
			<td><button id="50p" onclick="showCharge()" value="50">충전하기</button></td>
			<td><button id="100p" onclick="showCharge()" value="100">충전하기</button></td>
			<td><button id="500p" onclick="showCharge()" value="500">충전하기</button></td>
		</tr>
	</table>
</div>
</body>
<%@include file="../../common/footer.jspf" %>