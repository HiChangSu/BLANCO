var status = true;

$(document).ready(function(){
	$("#sLogin").click(function(){
		var query = {
				id: $("#sid").val(),
				passwd:$("#spw").val()
		}
		
		$.ajax({
			type:"POST",
			url:"/BLANCO/mg/sellerLoginPro.do",
			data:query,
			success:function(data){
				$(location).attr('href', "/BLANCO/seller/sellerMain.jsp");
			}
		});
	});
	
	
});