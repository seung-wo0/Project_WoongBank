<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>계좌생성 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap">
		
		<main id="main">
			<input type="text" id="CreateAccountNumber" name="CreateAccountNumber" value="${ AccountAdress }" form="CreateAccountFrm" readonly>
			<br/>
			<input type="password" id="CreateAccountPassword" name="CreateAccountPassword" placeholder="비밀번호부분 키패드" maxlength="4" min="4" form="CreateAccountFrm">
			<form action="" id="CreateAccountFrm"></form>
			<button type="button" id="CreateAccountBtn" class="CreateAccountBtn">계좌생성하기</button>
		</main>
		<!-- main#main -->

	</div>
	<!-- div#wrap -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    
