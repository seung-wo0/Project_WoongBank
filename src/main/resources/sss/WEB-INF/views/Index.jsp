<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	String UserSession = (String) session.getAttribute("UserSession");
	String UserNameSession = (String) session.getAttribute("UserNameSession");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>메인 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
<%
	if (UserSession == null || UserSession == "") {
%>
<script>
	alert("로그인은 필수 입니다.");
	window.location.href = "/";
</script>
<% } %>
	<div id="wrap">
		<!-- header부분 inc 시작 -->
		<%@ include file="inc/Header_inc.jsp" %>
		<!-- header부분 inc 끝 -->
		
		세션 1: ${ UserNameSession }
		<br>
		세션 2: <%= UserSession %>
		<br>
		<button id="LogoutBtn" class="LogoutBtn" type="button">로그아웃</button>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    