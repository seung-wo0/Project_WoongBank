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
			<input type="text" value="${ AccountAdress }" readonly>
			<input type="text" placeholder="비밀번호부분 키패드" maxlength="4" min="4">
		</main>
		<!-- main#main -->

	</div>
	<!-- div#wrap -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
<!-- <script> -->
<!-- 	if(confirm("계좌를 생성 하시겠습니까?")) { -->
<!-- 		window.location.href="/AccountCreateProc"; -->
<!-- 		alert("계좌 생성이 완료 되었습니다."); -->
<!-- 		opener.location.reload(); -->
<!-- 		window.close(); -->
		
<!-- 	} else { -->
<!-- 		alert("계좌 생성을 취소 하였습니다."); -->
<!-- 		opener.location.reload(); -->
<!-- 		window.close(); -->
<!-- 	} -->
<!-- </script> -->
</body>
</html>    
