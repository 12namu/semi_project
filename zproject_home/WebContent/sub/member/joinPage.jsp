h<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   	<%@ include file="../../common/header.jspf" %>
   	<script src="<%=application.getContextPath() %>/js/member/join_Page.js"></script>
   	
<link href="<%=application.getContextPath() %>/css/member/joinPage.css" rel="stylesheet">


	<section>
		<div id="middleBox">			
				<div id="middleLeft">	
				</div>
			
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
							<img src="<%=application.getContextPath() %>/img/member/join/txt_join_step02_on.gif">
							</li>
							<li>
							<img src="<%=application.getContextPath() %>/img/member/join/txt_join_step03_off.gif">
							</li>					
							</ol>
						</div>
					</div> 
					
		<div id="middle_body">
		<hr style="border: solid 2px black;">
				<div id="join_form">	
					<form name="myinfoForm" method="post" action="joinProcess.me" id="myinfo">
					<h3>
					<img src="<%=application.getContextPath() %>/img/member/join/stit_info.gif">
					</h3>
						<legend>개인정보입력</legend>
					
						<div id="join_table">
						<table>
						<tr>
							<th>
							<label for="memId">회원아이디</label>
							</th>
							<td>
							<input type="text" name="id" id="id" title="아이디 입력" class="txtInp" style="width:150px; maxlength="16">
							<button type="button" class="btn btn-danger btn-sm" id="id_C">중복확인</button>
							<span id="checkMsgID" class="cr6aa7cc">공백없는 3~15자의 영문/숫자를 조합하여 입력해야 합니다.</span>
							</td>
						</tr>
						
						<tr>
							<th>
							<label for="memPw">비밀번호</label>
							</th>
							<td>
							<input type="password" name="pw1" id="pw1" title="비밀번호 입력" class="txtInp" style="width:150px;" maxlength="16">
							<span id="checkMsgPW" class="cr6aa7cc">공백없는 8~16자의 영문/숫자를 조합하여 입력해야합니다.</span>
						</tr>
						
						<tr>
							<th>
							<label for="memPw2">비밀번호 확인</label>
							</th>
							<td>
							<input type="password" name="pw2" id="pw2" title="비밀번호 입력" class="txtInp" style="width:150px;ime-mode:disabled;" maxlength="16">
							<span id="checkMsgPW2" class="cr6aa7cc">비밀번호 확인을 위해 다시 한번 입력해주세요.</span>
							</td>
						</tr>
						
						<tr>
							<th>
							<label for="memName">성명</label>
							</th>
							<td>
							<input type="text" name="name" id="name" title="이름 입력" class="txtInp">
							<span id="checkMsgName" class="cr6aa7cc">한글 15자, 영문 30자까지 가능합니다.</span>
						</tr>
						
						<tr>
							<th>성별</th>
							<td>
							<input type="radio" name="gender" value="M" id="gender">
							<label for="memMale">남</label>
							<input type="radio" name="gender" value="F" id="gender">
							<label for="memMale">여</label>
							<span id="checkMsgGender" class="cr6aa7cc">성별을 입력해주세요</span>
							</td>
						</tr>
						
						<tr>
						<th>
						<label for="memBirth">생년월일</label>
						</th>
						<td>
						<select name="birth1" class="select" id="birth1" style="width:60px;">
											<option value="1951">1951</option>			
											<option value="1952">1952</option>									
											<option value="1953">1953</option>								
											<option value="1954">1954</option>									
											<option value="1955">1955</option>										
											<option value="1956">1956</option>										
											<option value="1957">1957</option>										
											<option value="1958">1958</option>										
											<option value="1959">1959</option>										
											<option value="1960">1960</option>										
											<option value="1961">1961</option>										
											<option value="1962">1962</option>										
											<option value="1963">1963</option>										
											<option value="1964">1964</option>										
											<option value="1965">1965</option>										
											<option value="1966">1966</option>										
											<option value="1967">1967</option>										
											<option value="1968">1968</option>										
											<option value="1969">1969</option>										
											<option value="1970">1970</option>										
											<option value="1971">1971</option>										
											<option value="1972">1972</option>										
											<option value="1973">1973</option>										
											<option value="1974">1974</option>										
											<option value="1975">1975</option>										
											<option value="1976">1976</option>										
											<option value="1977">1977</option>										
											<option value="1978">1978</option>										
											<option value="1979">1979</option>										
											<option value="1980">1980</option>										
											<option value="1981">1981</option>										
											<option value="1982">1982</option>										
											<option value="1983">1983</option>										
											<option value="1984">1984</option>										
											<option value="1985">1985</option>										
											<option value="1986">1986</option>										
											<option value="1987">1987</option>										
											<option value="1988">1988</option>										
											<option value="1989">1989</option>										
											<option value="1990">1990</option>										
											<option value="1991">1991</option>										
											<option value="1992">1992</option>										
											<option value="1993">1993</option>										
											<option value="1994">1994</option>										
											<option value="1995">1995</option>										
											<option value="1996">1996</option>										
											<option value="1997">1997</option>										
											<option value="1998">1998</option>										
											<option value="1999">1999</option>										
											<option value="2000">2000</option>										
											<option value="2001">2001</option>										
											<option value="2002">2002</option>
										</select>년 
						
						<select name="birth2" class="select"id="birth2" style="width:60px;">
										
											<option value="01">01</option>										
											<option value="02">02</option>										
											<option value="03">03</option>										
											<option value="04">04</option>										
											<option value="05">05</option>										
											<option value="06">06</option>										
											<option value="07">07</option>										
											<option value="08">08</option>										
											<option value="09">09</option>										
											<option value="10">10</option>										
											<option value="11">11</option>										
											<option value="12">12</option>										
										</select>월
										
								<select name="birth3" class="select" style="width:60px;" id="birth3">						
											<option value="01">01</option>										
											<option value="02">02</option>										
											<option value="03">03</option>										
											<option value="04">04</option>										
											<option value="05">05</option>										
											<option value="06">06</option>										
											<option value="07">07</option>										
											<option value="08">08</option>										
											<option value="09">09</option>										
											<option value="10">10</option>										
											<option value="11">11</option>										
											<option value="12">12</option>										
											<option value="13">13</option>										
											<option value="14">14</option>										
											<option value="15">15</option>										
											<option value="16">16</option>										
											<option value="17">17</option>										
											<option value="18">18</option>										
											<option value="19">19</option>										
											<option value="20">20</option>										
											<option value="21">21</option>										
											<option value="22">22</option>										
											<option value="23">23</option>										
											<option value="24">24</option>										
											<option value="25">25</option>										
											<option value="26">26</option>										
											<option value="27">27</option>										
											<option value="28">28</option>										
											<option value="29">29</option>										
											<option value="30">30</option>										
											<option value="31">31</option>										
										</select>일	
										</td>								
						</tr>
						
						<tr>
						<td colspan="2">
							<strong>본인인증을 위해 정확한 이메일 주소, 휴대폰 번호를 입력해주세요.</strong><br>
							<span>(입력된 이메일 주소, 휴대폰 번호는 아이디 찾기, 비밀번호 재발급시 이용됩니다.)</span>	
						</td>
						</tr>
						
						<tr>
						<th>
							<label for="memMail">이메일</label>
						</th>
						
						<td>
						<input type="text" name="mail1" id="mail1" maxlength="32" class="txtInp">
						@
						<select name="mail2" class="select offInput" id="mail2">
											<option value="" selected="selected">선택해 주세요</option>
											<option value="@hanmail.net">hanmail.net</option>
											<option value="@naver.com">naver.com</option>
											<option value="@hotmail.com">hotmail.com</option>
											<option value="@yahoo.co.kr">yahoo.co.kr</option>
											<option value="@hanmir.com">hanmir.com</option>
											<option value="@paran.com">paran.com</option>
											<option value="@lycos.co.kr">lycos.co.kr</option>
											<option value="@nate.com">nate.com</option>
											<option value="@dreamwiz.com">dreamwiz.com</option>
											<option value="@korea.com">korea.com</option>
											<option value="@empal.com">empal.com</option>
											<option value="@netian.com">netian.com</option>
											<option value="@freechal.com">freechal.com</option>
											<option value="@msn.com">msn.com</option>
											<option value="@gmail.com">gmail.com</option>
											<option value="etc">직접입력</option>
										</select>
						</td>
						</tr>
						
						<tr>
							<th>
							<label for="memPhone">휴대폰</label>
							</th>
						
						<td>
						<select name="phone1" id="phone1" class="select focusOn" style="width:60px;">
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="019">019</option>
											</select>-
						<input type="text" name="phone2" id="phone2"  class="txtInp" style="width:65px;" maxlength="4">-					
						<input type="text" name="phone3" id="phone3"  class="txtInp" style="width:65px;" maxlength="4">
						<span id="checkMsgPhone" class="cr6aa7cc">전화번호를 정확히 입력해주세요</span>
					</td>
					</tr>
					<tr>
							<th>
							<label for="memMessage">결제확인메세지</label>
							</th>
						
						<td>
							<input type="password" name="ckmessage" id="ckmessage"  class="txtInp" style="width:150px;ime-mode:disabled;" maxlength="16">
						<span id="checkMsgPhone" class="cr6aa7cc">결제시 입력하신 문구로 결제가 진행 됩니다.</span>
					</td>
					</tr>
					</table>
					</div>
					</div><!--  joinform -->
					
					<div id="join_btn">
					<span class="btn btnM1 btnRed btnW130" id="complete">입력완료</span>
					<a href="<%=application.getContextPath() %>/index.jsp" class="btn btnM1 btnGry2 btnW130">뒤로</a>
					</div>
			
					</form>
				</div><!-- middlebody -->
		</div><!-- middle -->
			
	</section>	

	<%@ include file="../../common/footer.jspf" %>

