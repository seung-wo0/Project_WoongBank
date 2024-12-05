$(function () {
	
	//메인 페이지 관련
	$(document).ready(function() { 
		
	});

	//로그인 페이지 관련
	$(document).ready(function() { 
		
		$(".LoginBtn").click(function() {
			console.log("로그인버튼 클릭");
			$("form#LoginFrm").attr("method","post");
			$("form#LoginFrm").attr("action", "LoginProc");
			$("form#LoginFrm").submit();
		});
		
	});


});