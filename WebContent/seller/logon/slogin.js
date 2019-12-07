$(document).ready(function(){
	//[로그아웃]버튼을 클릭하면 자동실행
	$("#sLogout").click(function(){
		$.ajax({
		   type: "POST",
		   url: "/shoppingmall/mg/managerLogout.do",
		   success: function(data){
			   window.location.href("/shoppingmall/mg/managerMain.do");
		   }
		});
	});
 });