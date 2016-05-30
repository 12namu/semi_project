/**
 * 
 */

$(function() {

	$("#all_check").click(function(){
		if($("input:checkbox[id='all_check']").is(":checked")){
			$('input:checkbox[name="ckbox"]').each(function() {	
				this.checked = true; //checked 처리			
			});
		}else{
			$('input:checkbox[name="ckbox"]').each(function() {	
				this.checked = false; //checked 처리			
			});
		}
	});	 
	
	
	
	
	$("#agreeCheck").click(function(){
		if( $("input:checkbox[id='agreeUse']").is(":checked")==true &&  $("input:checkbox[id='agreePrivate']").is(":checked")==true){
			location.href="../../sub/member/joinPage.jsp";	
		}else{
			alert("모든약관에 동의하셔야 회원가입이 가능합니다");
		}
	});
});