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
			
			var JoinUserFrm = $("#JoinUserFrm");
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
				JoinUserFrm.attr("method", "post");
				JoinUserFrm.attr("action", "JoinProc");
				JoinUserFrm.submit();
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
		//새로운계좌생성 하기위한버튼 이벤트
		$("#CreateAccountBtn").click(function(){
			var CreateAccountFrm = $("#CreateAccountFrm");
			var CreateAccountPassword = $("#CreateAccountPassword").val();
			
			if(CreateAccountPassword.length == 4) {
				CreateAccountFrm.attr("method", "post")
				CreateAccountFrm.attr("action", "/AccountCreateProc")
				CreateAccountFrm.submit();
			} else {
				alert("계좌 비밀번호를 입력해주세요");
				$("#CreateAccountPassword").focus();
			}
		});
		
		//계좌삭제버튼 이벤트
		$(".UserAccount_del").click(function(){
			var w = 500;   
			var h = 200;  
			var url = "/AccountRemove";
			var WindowTitleName = "계좌삭제";
			NewWindows_open(w, h, url, WindowTitleName);
		});
		
		//계좌 선택후 삭제버튼 이벤트
		$(".SelectAccountRemove_Btn").click(function() {
			var selectAccount = $("#SelectAccount").val();
			var SelectAccountFrm = $("#SelectAccountFrm");
			if (selectAccount != 0) {
//				console.log("selectAccount : " + selectAccount);
				SelectAccountFrm.attr("action", "/SelectAccountRemoveProc");
				SelectAccountFrm.submit();
			}
		});
		
		//계좌별칭 변경을 위한이벤트 
		$("tr.userAccountListCol").click(function(){
			var clickAccount_Number = $(this).find("td:eq(1)").attr("id");
//			console.log(clickAccount_Number);
			var w = 500;
			var h = 220;
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
	
	//////////////////////////////////////////
	//  입·출금 페이지 관련(Depo_With.jsp)  //
	//////////////////////////////////////////
	$(document).ready(function() { 
		// 입출금 계좌선택 이벤트
		$("#DW_SelectAccount").change(function(){
			
			var SelectAccountBalanceUrl = "/Account_Balance?account_number=";
			var select = $("#DW_SelectAccount").val();
			
			if (select != 0) {
				SelectAccountBalanceUrl += select;
				Depo_With_Ajax(SelectAccountBalanceUrl);
			} else {
				$("#Now_account_balance").val("0");
			}
			console.log("변경됨 : " + select);
			console.log("SelectUrl : " + SelectAccountBalanceUrl);

		});
		
		//거래할금액 입력칸 이벤트
		$("#input_balance").change(function(){
			var input_balance = Number($("#input_balance").val());
			var Now_account_balance = Number($("#Now_account_balance").val());
			var Depo_With_CheckID = $("input[name=Depo_WithBox]:checked").attr("id");
			let checkNum = /^[0-9]+$/;
			if (! checkNum.test($("#input_balance").val())) {
				alert("숫자만 입력이 가능합니다.");
				$("#input_balance").focus();
				$("#maybe_AccountBalance").val("");
			} else if (input_balance > 0 || Now_account_balance != "" || Now_account_balance != null ) {
				if (Depo_With_CheckID === "Depo") {
					$("#maybe_AccountBalance").val(Now_account_balance + input_balance);
				} else {
					$("#maybe_AccountBalance").val(Now_account_balance - input_balance);
				}
				
			}
		}),$(".Depo_WithBox").change(function(){
			var input_balance = Number($("#input_balance").val());
			var Now_account_balance = Number($("#Now_account_balance").val());
			var Depo_With_CheckID = $("input[name=Depo_WithBox]:checked").attr("id");
//			console.log(Depo_With_CheckID === "Depo");
			 if (input_balance > 0 || Now_account_balance != "" || Now_account_balance != null ) {
				if (Depo_With_CheckID === "Depo") {
					$("#maybe_AccountBalance").val(Now_account_balance + input_balance);
				} else {
					$("#maybe_AccountBalance").val(Now_account_balance - input_balance);
				}
				
			}
		});
		
		//입출금 거래버튼 이벤트
		$("#Depo_WithBtn").click(function(){
			var DW_SelectAccount = $("#DW_SelectAccount").val();
			var Depo_With_Checked = $("input[name=Depo_WithBox]:checked");
			var Depo_With_CheckID = Depo_With_Checked.attr("id");
			var input_balance = $("#input_balance").val();
			let checkNum = /^[0-9]+$/;
			if (DW_SelectAccount == 0) {
				alert("입·출금 할 계좌를 선택하여 주세요!");
				$("#DW_SelectAccount").focus;
			} else if(Depo_With_Checked.val() != "on"){
				alert("입금 또는 출금 을 선택 하여 주세요 !");
			} else if(input_balance == "" || input_balance == null || input_balance == "0" || !checkNum.test(input_balance)) {
				alert("거래금액을 정확하게 입력해 주세요.");
				$("#input_balance").focus();
			} else {
					var DW_SelectAccountFrm = $("#DW_SelectAccountFrm");
					DW_SelectAccountFrm.attr("method", "post");
					$("#Depo_WithChk").val(Depo_With_CheckID);
					DW_SelectAccountFrm.attr("action", "Depo_WithProc");
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

//Depo_With.jsp 페이지내 현재잔액 ajax데이터
function Depo_With_Ajax(SelectAccountBalanceUrl) {
	let loading = false;
	
	if(!loading) {
		loading = true;
		$.ajax({
			type:"get",
			url: SelectAccountBalanceUrl,
			data: {
				
			},
			dataType: "html",
			async: true,
			success: function (data) {
				$("#Now_account_balance").val(data);
//				console.log("비동기 통신 성공");
				loading = false;
			},
			error: function() {
//                console.log("비동기 통신 실패");
				loading = false;
			}
		});
	}
	
}
