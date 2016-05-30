/**
 * 
 */
$(function() {
	
	
		
		   var day = $("#endTime").val();
		   var daysRound;
		   setInterval(function () {
			   var nowTime =  new Date();
			   var lastDay =  new Date(parseInt(day));
			  
			   // 원하는 날짜, 시간 정확하게 초단위까지 기입.
			   days = (lastDay - nowTime) / 1000 / 60 / 60 / 24; //gap day 
			   daysRound = Math.floor(days); 
			   hours = (lastDay - nowTime) / 1000 / 60 / 60 - (24 * daysRound); 
			   hoursRound = Math.floor(hours); 
			   minutes = (lastDay - nowTime) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound); 
			   minutesRound = Math.floor(minutes); 
			   seconds = (lastDay - nowTime) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound); 
			   secondsRound = Math.round(seconds); 

			   $(".timesss").text(daysRound+"일 "+ hoursRound + "시 "+ minutesRound +"분 " + secondsRound+ "초"); 
		
			   
			   
			   
		}, 1000);
	 
	
	$("#jjimBtn").click(function() {
		alert("해당물품을 찜하셨습니다.");
	});	
	
	$("#bidBtn").click(function() {		
		if(daysRound < 0){
			alert("경매가 종료 되었습니다.");
			location.reload();
		}
	});
	

	
	$("#update1").click(function() {
	
		var url="./auctionView.ac?num="+$("#num").val()+"&check=1";
		
		$(location).attr('href', url);
	});
	
	
	$("#del1").click(function() {
		var url="./auctionDelete.ac?num="+$("#num").val();
		$(location).attr('href', url);
	});
	
	$("#bidPrice").keyup(function () {
		var regExp = /^[0-9]+$/;
		if(regExp.test($(this).val())){
			
		}else{
			alert("숫자만 입력해주세요.");
			$(this).val("");
		}
		
		
	});

	$("#bidStartBtn").click(function() {
		var ck1=false;
		var ck2=false;
		var ck3=false;
		var ck4=false;
		var ck5=false;
		var resultck=false;
		var nowPrice = parseInt($("#bidInfoNowPrices").val());
		var increase = parseInt($("#bidInfoIncrease").val());
		var startPrice = parseInt($("#bidInfostartPrice").val());
		var price = parseInt($("#bidPrice").val());
		var total = startPrice + increase;
		
		
		
		if(price < startPrice){
			alert("시작가 보다 금액이 낮습니다.");
			$("#bidPrice").val("");
		}else{
			ck1=true;
		}
		
	
		if(price < nowPrice){
			alert("현재가보다 금액이 낮습니다.")
			$("#bidPrice").val("");
		}else{
			ck2=true;
		}
	
		if(! (price % increase)==0){
			alert("입찰금액은 입찰시작금액 + 입착증가금액의 배수인 금액으로 입찰해주셔야 합니다.");
			$("#bidPrice").val("");
		}else{
			ck3=true;
		}
		
		if(price == nowPrice){
			alert("현재가와 동일합니다.")
			$("#bidPrice").val("");
		}else{
			ck4=true;
		}
		
		if(price == startPrice){
			alert("현재가는 시작가와 같을 수 없습니다.");
			$("#bidPrice").val("");
		}else{
			ck5=true;
		}
		
		
		
		if(ck1 && ck2 && ck3 && ck4 && ck5){
			resultck=true;
		}
		
		
		
		return resultck;
		
	});
	
	
	
	$("#bidderBtn").click(function() {
		var num = $("#num").val();
			$.ajax({url:"./auctionBuyList.ac", type:"POST", 
				data:{
					num: num,	
				}, 
				success: function(result) {
					alert(result);
					var tr1 =  "<tr class='active'><td>입찰자</td><td>입찰가격</td><td>입찰시간</td></tr>";
					var tr ="";
					var d = JSON.parse(result); 
					
					$(d).each(function() {		
						
						tr = tr + "<tr><td>";
						tr = tr +  this.id + "</td>";
						tr = tr + "<td>" + this.price + "</td>";
						tr = tr + "<td>" + this.times + "</td></tr>";
					});
					
					$(".table-hover").html(tr1+tr);
				} 
		    });	
	});
	
	
	
	
});






