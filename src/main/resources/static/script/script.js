$(function () {
	////////////////////////////
	//메인 페이지 관련
	////////////////////////////
	$(document).ready(function() { 
		
	});
	
	
	////////////////////////////
	//로그인 페이지 관련 ("/")
	////////////////////////////
	$(document).ready(function() { 
		
		// 로그인버튼 이벤트
		$(".LoginBtn").click(function() {
			//console.log("로그인버튼 클릭");
			$("form#LoginFrm").attr("method","post");
			$("form#LoginFrm").attr("action", "LoginProc");
			$("form#LoginFrm").submit();
		});
		
		// 회원가입버튼 이벤트
		$(".JoinBtn").click(function(){
			window.location.href="/Join";
		});
		
		// 로그아웃버튼 이벤트
		$(".LogoutBtn").click(function(){
			window.location.href="/Logout";
		});
		
	});
	
	
	////////////////////////////////
	//회원가입 페이지 관련 ("/Join")
	////////////////////////////////
	$(document).ready(function() { 
		$(".JoinUserProcBtn").click(function(){
			var blank_pattern = /[\s]/g;
			var num_pattern = /^[0-9]*$/;
			var kor_pattern = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$/;
			var msg = " 공백이 포함되어있거나\r\n입력되지 않았습니다.";
			
			var JoinUserName = $("#JoinUserName").val().trim();
			var JoinUserPhone1 = $("#JoinUserPhone1").val();
			var JoinUserPhone2 = $("#JoinUserPhone2").val();
			var JoinUserPhone3 = $("#JoinUserPhone3").val();
			var JoinUserPW = $("#JoinUserPW").val();
			var JoinUserPW2 = $("#JoinUserPW2").val();
			
//			console.log("JoinUserName : " + JoinUserName);
//			console.log("JoinUserPhone1 : " + JoinUserPhone1);
//			console.log("JoinUserPhone2 : " + JoinUserPhone2);
//			console.log("JoinUserPhone3 : " + JoinUserPhone3);
//			console.log("JoinUserPW : " + JoinUserPW);
//			console.log("JoinUserPW2 : " + JoinUserPW2);
//			console.log("kor_pattern.test(JoinUserName) : " + kor_pattern.test(JoinUserName));
			if (kor_pattern.test(JoinUserName) == false|| blank_pattern.test(JoinUserName) || JoinUserName == null || JoinUserName == "") {
				alert("이름 에" + msg);
			} else if (num_pattern.test(JoinUserPhone2) == false || blank_pattern.test(JoinUserPhone2) || JoinUserPhone2 == null || JoinUserPhone2 == "" || JoinUserPhone2.length != 4 ) {
				alert("핸드폰번호 에" + msg);		
				$("#JoinUserPhone2").focus();			
			} else if (num_pattern.test(JoinUserPhone3) == false || blank_pattern.test(JoinUserPhone3) || JoinUserPhone3 == null || JoinUserPhone3 == "" || JoinUserPhone3.length != 4 ) {
				alert("핸드폰번호 에" + msg);
				$("#JoinUserPhone3").focus();
			} else if (blank_pattern.test(JoinUserPW) || JoinUserPW == null || JoinUserPW == "" || blank_pattern.test(JoinUserPW2) || JoinUserPW2 == null || JoinUserPW2 == "") {
				alert("패스워드 에" + msg);
			} else if (JoinUserPW != JoinUserPW2) {
				alert("패스워드 불일치");
			} else {
//				confirm("모든 유효성검사 성공");
				$("#JoinUserFrm").attr("method", "post");
				$("#JoinUserFrm").attr("action", "JoinProc");
				$("#JoinUserFrm").submit();
			}
			
		});
		
	});
	
	
	/////////////////////
	/////////////////////
	

});

// Nav 메뉴클릭 관련
function QuickMenuEvent(MenuName) {
	var ClickMenu = $(MenuName).attr("id").trim();
		window.location.href = "/"+ClickMenu;
};