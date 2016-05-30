/**
 * 
 */


/**
 * 
 */


$(function() {
	var patt_pw=/^[a-z0-9_-]{8,16}$/;
	var check=false;
	var check2=false;

	
	
	$("#pw1").blur(function(){
		if($(this).val()==""){
			$("#checkMsgPW").html("비밀번호를 입력해주세요");
		}else if(patt_pw.test($(this).val())!=true){
			$("#checkMsgPW").html("공백없는 8~16자의 영문/숫자를 조합하여 입력해야합니다.");	
		}else{
			$("#checkMsgPW").html("");
		}	
	});
	
	$("#pw2").blur(function(){
		if($(this).val() != $("#pw1").val()){
			$("#checkMsgPW2").html("비밀번호를 동일하게 입력해주세요");
		}else{
			$("#checkMsgPW2").html("");
			check=true;
		}
	});
	
	$("#name").blur(function(){
		if($(this).val().length>15){
			$("#checkMsgName").html("한글 15자, 영문 15자까지 가능합니다.");
		}else if($(this).val().length==0){
			$("#checkMsgName").html("이름을 입력해주세요.");
		
		}else{
			$("#checkMsgName").html("");
			check2=true;
		}
	});
	
		
	$("#phone3").blur(function(){
		if($(this).val().length>3){
			if($("#phone2").val().length>3){
				$("#checkMsgPhone").html("");	
			}}
	});	
	
	
	$("#alterinfo").click(function(){
		if(check==true && check2==true){
			alert(check);
			alert(check2);
			$("#myinfo").submit();
		}else{
			alert("모든 조건에 맞게 입력해주세요");
		}
	});
	
	
	$("#delete").click(function(){
		if(confirm("정말 탈퇴하시겠습니까?") == true){    //확인
		    var url="./deleteProcess.me?id="+$("#id").val();
		    $(location).attr('href',url);
		}else{   //취소
		    return;
		}
	});
});