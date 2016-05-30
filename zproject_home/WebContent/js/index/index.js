/**
 * 
 */

$(function() {
		
		$.ajax({url:"./sub/auction/auctionIndexList.ac", type:"POST", 
			success: function(result) {
				
				$("#middleTop").html(result);

			} 
	    });
		
});
