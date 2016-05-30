/**
 * 
 */

$(function() {
    var editor_object = [];
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",
        sSkinURI: "../../SE2/SmartEditor2Skin.html", 
        htParams : {
            bUseToolbar : true,             
            bUseVerticalResizer : true,     
            bUseModeChanger : true, 
        }
    });
    
    
    
	$("#selectCategory").blur(function() {
		if($(this).val() == "0"){
			$("#categoryState").text("카테고리를 선택해주세요.");
		}else{
			$("#categoryState").text("");	
		}
	});
	
	$("#pName").blur(function() {
		if($(this).val() == ""){
			$("#pNameState").text("물품명을 입력해주세요.");
		}else{
			$("#pNameState").text("");	
		}
	});
	
	$("#pr").blur(function() {
		if($(this).val() == ""){
			$("#prState").text("홍보글을 입력해주세요.");
		}else{
			$("#prState").text("");
			
		}
	});

	$("#startPrice").blur(function() {
		if($(this).val() == ""){
			$("#startPriceState").text("시작가를 입력해주세요.");
		}else{
			$("#startPriceState").text("");
			check=true;
		}
	});
	
	
	
	$("#bidIncrease").blur(function() {
		if($(this).val() == ""){
			$("#bidIncreaseState").text("입찰증가금액을 입력해주세요.");
		}else{
			$("#bidIncreaseState").text("");
			
		}
	});
	
	$("#date").blur(function() {
		if($(this).val() == "0"){
			$("#dateState").text("경매진행일을 입력해주세요.");
		}else{
			$("#dateState").text("");
			
		}
	});
	
	
	
	$("#files").blur(function() {
				
		if($(this).val() == ""){
			$("#pImgState").text("이미지를 첨부해주세요 최대 5장.");
		}else{
			$("#pImgState").text("");
		};
	});
	
	$("#wtitle").blur(function() {
		if($(this).val() == ""){
			$("#wtitleState").text("글 제목을 입력해주세요.");
		}else{
			$("#wtitleState").text("");
		}
	});
	
	
	$("#submit1").click(function() {
		editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
	
		if($("#selectCategory").val() =="0" || $("#pName").val()=="" || $("#pr").val()=="" || $("#startPrice").val()=="" || $("#instantPrice").val()=="" || $("#bidIncrease").val()=="" || $("#date").val()=="0" || $("#files").val()=="" || $("#smarteditor").val()=="" || $("#wtitle").val()==""){
			alert("모두입력 해주세요.")
		}else{
			
			$("#frm").submit();
		}
	});
	
	$("#goReset").click(function() {
		location.reload();
	});
	
	$("#goList").click(function() {
		var url="./auctionList.ac?curPage=1&check=0";
		$(location).attr('href', url);
	});
	
	
	var i =2;
	$(".btn-info").click(function() {
		if(i < 6){
			$(".imgss").append('<input type="file"  class="form-control imgs" name="productImg'+i+'" id="files'+i+'">');
			i++;
		}else{
			$("#pImgState").text("이미지는 5장 까지 가능합니다.");
		}
	});
	
	
	$("#files").click(function() {
		alert("파일명을 한글로 올릴경우 이미지가 깨집니다.\n" +
				"업로드시 유의 해주세요.");
		
	});
	$("#files2").click(function() {
		alert("파일명을 한글로 올릴경우 이미지가 깨집니다.\n" +
				"업로드시 유의 해주세요.");
		
	});
	$("#files3").click(function() {
		alert("파일명을 한글로 올릴경우 이미지가 깨집니다.\n" +
				"업로드시 유의 해주세요.");
		
	});
	$("#files4").click(function() {
		alert("파일명을 한글로 올릴경우 이미지가 깨집니다.\n" +
				"업로드시 유의 해주세요.");
		
	});
	$("#files5").click(function() {
		alert("파일명을 한글로 올릴경우 이미지가 깨집니다.\n" +
				"업로드시 유의 해주세요.");
		
	});
	
	
	$("#startPrice").keyup(function () {
		$(this).val($(this).val().replace(/[^0-9]/gi,""));		
	});
	
	$("#bidIncrease").keyup(function () {
		$(this).val($(this).val().replace(/[^0-9]/gi,""));		
	});
	
});