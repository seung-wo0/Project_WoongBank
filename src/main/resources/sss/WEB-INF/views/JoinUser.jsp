<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>회원가입 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap" class="JoinUserWrap">
		<header id="header">
			<!-- header부분 inc 시작 -->
			<%@ include file="inc/Header_inc.jsp" %>
			<!-- header부분 inc 끝 -->
			
		</header>
		
		<main id="main">
			<form action="" id="JoinUserFrm">
				<fieldset id="JoinUserFrmfd">
					<legend>WoongBank 회원가입 양식</legend>
					
					<label for="JoinUserName">
						<span class="JoinUserTitle">이름</span>
						<input type="text" id="JoinUserName" name="JoinUserName">
					</label>
					<br/>
					<label for="JoinUserID">
						<span class="JoinUserTitle">핸드폰번호</span>
<!-- 						<select id="JoinUserPhone1"> -->
<!-- 							<option value="010">010</option> -->
<!-- 						</select> -->
						<input type="text" id="JoinUserPhone1" name="JoinUserPhone1" class="JoinUserPhone" min="3" maxlength="3" value="010" readonly>
						<span> - </span>
						<input type="text" id="JoinUserPhone2" name="JoinUserPhone2" class="JoinUserPhone" min="4" maxlength="4">
						<span> - </span>
						<input type="text" id="JoinUserPhone3" name="JoinUserPhone3" class="JoinUserPhone" min="4" maxlength="4">
					</label>
					<br/>
					<label for="JoinUserPW">
						<span class="JoinUserTitle">패스워드</span>
						<input type="password" id="JoinUserPW" name="JoinUserPW">
					</label>
					<br/>
					<label for="JoinUserPW2">
						<span class="JoinUserTitle">패스워드 재확인</span>
						<input type="password" id="JoinUserPW2" name="JoinUserPW2">
					</label>
					
					<div id="JoinBtnArea">
						<button type="button" id="JoinUserProcBtn" class="JoinUserProcBtn">가입하기</button>
						<button type="reset">다시쓰기</button>
					</div>
					<!-- div#JoinBtnArea -->
					
				</fieldset>
			</form>
			
			
		</main>
		
		
	</div>
	<!-- div#JoinUserWrap.JoinUserWrap -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    