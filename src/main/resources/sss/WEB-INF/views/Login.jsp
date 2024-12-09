<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>로그인 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap">
		<!-- header부분 inc 시작 -->
		<%@ include file="inc/Header_inc.jsp" %>
		<!-- header부분 inc 끝 -->
		<main id="main">
			<form id="LoginFrm" action="">
				<input id="LoginID" name="LoginID" type="text" placeholder="로그인 할 핸드폰번호">
				<input id="LoginPW" name="LoginPW" type="password" placeholder="패스워드">
			</form>
			<button id="LoginBtn" class="LoginBtn" type="button">로그인</button>
			<button id="JoinBtn" class="JoinBtn" type="button">회원가입</button>
		</main>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    