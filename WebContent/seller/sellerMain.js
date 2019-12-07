var status = true;

$(document).ready(function(){
	$("#login").click(function(){
		var query = {
				id: $("#id").val(),
				passwd:$("#passwd").val()
		}
		
		$.ajax({
			type:"POST",
			url:"/BLANCO/mg/sellerLoginPro.do",
			data:query,
			success:function(data){
				$(location).attr('href', "/BLANCO/sellerMain.jsp");
			}
		});
	});
	
	$("#logout").click(function(){
		$.ajax({
			type:"POST",
			url:"/BLANCO/mg/sellerLogout",
			
		});
	});
	
	$("#registProduct").click(function(){//[상품등록]버튼 클릭
		window.location.href("/BLANCO/mg/itemRegisterForm.do");
	});
	
	$("#updateProduct").click(function(){//[상품수정/삭제]버튼 클릭
		window.location.href("/BLANCO/mg/ITEMList.do");  // book_kind=all
	});
	
	$("#orderedProduct").click(function(){//[전체구매목록 확인]버튼 클릭
		window.location.href("/BLANCO/mg/orderList.do");
	});
	
	$("#qna").click(function(){//[상품 QnA답변]버튼 클릭
		window.location.href("/BLANCO/mg/qnaList.do");
	});
});