$(function () {
	//////////////////////
	// 메인 페이지 관련 //
	//////////////////////
	$(document).ready(function() { 
		
	});
	
	
	//////////////////////////////
	// 로그인 페이지 관련 ("/") //
	//////////////////////////////
	$(document).ready(function() { 
		
		// 로그인버튼 이벤트
		$(".LoginBtn").click(function() {
			//console.log("로그인버튼 클릭");
			$("form#LoginFrm").attr("method","post");
			$("form#LoginFrm").attr("action", "LoginProc");
			$("form#LoginFrm").submit();
		});
		
		// id창에서 'Enter' 키 누를시 
		$("#LoginID").focus(function(){
			addEventListener("keydown", function(e) {
				if(e.key == "Enter") {
					$("#LoginPW").focus();
				}
			});
		});
		
		// pw창에서 'Enter' 키 누를시 
		$("#LoginPW").focus(function(){
			addEventListener("keydown", function(e) {
				if(e.key == "Enter") {
					$(".LoginBtn").click();
				}
			});
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
	
	
	////////////////////////////////////
	// 회원가입 페이지 관련 ("/Join") //
	////////////////////////////////////
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
	
	
	//////////////////////////////////////////
	// 계좌관리 페이지 관련(Management.jsp) //
	//////////////////////////////////////////
	$(document).ready(function() { 
		
		//계좌생성버튼 이벤트
		$(".UserAccount_add").click(function() {
			var w = 500;   
			var h = 200;  
			var url = "/AccountCreate";
			var WindowTitleName = "계좌생성여부체크";
			NewWindows_open(w, h, url, WindowTitleName);
		});
		
		//계좌별칭 변경을 위한이벤트 
		$("tr.userAccountListCol").click(function(){
			var clickAccount_Number = $(this).find("td:eq(1)").attr("id");
//			console.log(clickAccount_Number);
			var w = 500;
			var h = 200;
			var url = "/ChangedAccountName?Account_Number="+clickAccount_Number;
			var WindowTitleName = "계좌별칭 변경";
			NewWindows_open(w, h, url, WindowTitleName);
		});
		
		//계좌별칭 변경처리 버튼
		$(".Change_AccountName_btn").click(function(){
			var changeName = $("#Change_Account_name").val();
//			console.log("변경할 별칭 : " + changeName);
			if (changeName == "" || changeName == null) {
				alert("별칭을 적어주세요");
			} else {
				$("#accuont_name_ChangedFrm").attr("method", "post");
				$("#accuont_name_ChangedFrm").attr("action", "ChangedAccountNameProc");
				$(this).attr("type", "submit");
			}
		});
		
	});

});

// Nav 메뉴클릭 관련
function QuickMenuEvent(MenuName) {
	var ClickMenu = $(MenuName).attr("id").trim();
		window.location.href = "/"+ClickMenu;
};

//팝업 호출
function NewWindows_open(w, h, url, WindowTitleName) {
	// 받아오는 'w' 는 팝업창의 너비
	// 받아오는 'h' 는 팝업창의 높이
	
	LeftPosition=(screen.width-w)/2;
	TopPosition=(screen.height-h)/2;
	
	window.open(url, WindowTitleName, "width="+w+",height="+h+",top="+TopPosition+",left="+LeftPosition+", scrollbars=no");
}