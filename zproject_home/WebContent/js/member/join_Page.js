/**
 * 
 */


$(function() {
	var patt_id=/^[a-z0-9_-]{8,15}$/;
	var patt_pw=/^[a-z0-9_-]{8,16}$/;
	var check=false;
	var check2=false;
	var check3=false;
	
	$("#id").blur(function(){
		if($(this).val() == ""){
			$("#checkMsgID").html("아이디를 입력해주세요");
		}else if(patt_id.test($(this).val())!=true){
			$("#checkMsgID").html("공백없는 8~16자의 영문/숫자를 조합하여 입력해야합니다.");		
		}else{
			$("#checkMsgID").html("");
		}
	});
	
	$("#id_C").click(function(){
		var id=$("#id").val();
		$.post("idCheckProcess.me",
			{
				id:id
			},
		function(data){
			data=data.trim();
			if(data=='useable'){
				$("#checkMsgID").html("사용가능한 아이디");
				check=true;
			}else{
				$("#checkMsgID").html("사용불가능한 아이디")
			}
		});
	});
	
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
			check2=true;
		}
	});
	
	$("#name").blur(function(){
		if($(this).val().length>15){
			$("#checkMsgName").html("한글 15자, 영문 15자까지 가능합니다.");
		}else if($(this).val().length==0){
			$("#checkMsgName").html("이름을 입력해주세요.");
		
		}else{
			$("#checkMsgName").html("");
			check3=true;
		}
	});
	
		
	$("#phone3").blur(function(){
		if($(this).val().length>3){
			if($("#phone2").val().length>3){
				$("#checkMsgPhone").html("");	
			}}
	});	
	
	
	$("#complete").click(function(){
		if(check==true && check2==true && check3==true){
			$("#myinfo").submit();
		}else{
			alert("모든 조건에 맞게 입력해주세요");
		}
	});



});