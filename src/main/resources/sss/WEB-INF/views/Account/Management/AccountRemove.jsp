<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>계좌 삭제</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap">
		<main id="main">
			
			<select name="SelectAccount" id="SelectAccount" form="SelectAccountFrm">
				<option value="0">삭제 할 계좌를 선택하세요.</option>
			<c:forEach var="UserAccountList" items="${ UserAccountList }">
				<option value="${ UserAccountList.account_number }">${ UserAccountList.account_number } - (${ UserAccountList.account_name })</option>
			</c:forEach>
			</select>
			<form method="post" id="SelectAccountFrm"></form>
			<button type="button" id="SelectAccountRemove_Btn" class="SelectAccountRemove_Btn" form="SelectAccountFrm">해당계좌 삭제하기</button>
		</main>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    