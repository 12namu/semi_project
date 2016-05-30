<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ include file="../../common/header.jspf" %>
   
   	<script src="<%=application.getContextPath() %>/js/member/joinComplete.js"></script>
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/member/joinComplete.css">
   
   	

   	<section>
		<div id="middleBox">			

			
		<div id="middle">
					<div id="middleHeader">
						<div id="middleHeader_left">
							<div id="main_font">
							회원가입<br>
							<div id="body_font">
							프리마켓에 오신 것을 환영합니다.
							</div>
							</div>
						</div>
						<div id="middleHeader_right">
							<ol class="join_txt">
							<li>
							<img src="<%=application.getContextPath() %>/img/member/join/txt_join_step01_off.gif">
							</li>
							<li>
							<img src="<%=application.getContextPath() %>/img/member/join/txt_join_step02_off.gif">
							</li>
							<li>
							<img src="<%=application.getContextPath() %>/img/member/join/txt_join_step03_off.gif">
							</li>					
							</ol>
						</div>
					</div> 
					
		<div id="middle_body">
		<hr style="border: solid 2px black;">
		<div id="complete_box">
		<div id="complete_form">
			<span id="completeMsg" class="cr6aa7cc">${requestScope.id}</span>님<br>
			프리마켓의 가족이 되신 것을 환영합니다.<br>
			이후 모든 서비스를 이용하실 수 있습니다.
			
		</div>
		</div>
		<div id="join_btn">
		<a href="../../index.jsp"><span class="btn btnM1 btnRed btnW130" id="complete">메인가기</span></a>

		</div>			
		
		</div><!-- middlebody -->
		</div><!-- middle -->
			
		<div id="middleRight">
		</div>	
	</section>	

	<%@ include file="../../common/footer.jspf" %>
					
					