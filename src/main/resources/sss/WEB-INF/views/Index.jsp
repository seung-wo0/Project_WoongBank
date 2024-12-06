<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	String UserSession = (String) session.getAttribute("LoginUserSession");
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
		세션 1: ${ LoginUserSession }
		<br>
		세션 2: <%= UserSession %>
		<br>
		<a href="/Logout">로그아웃</a>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    