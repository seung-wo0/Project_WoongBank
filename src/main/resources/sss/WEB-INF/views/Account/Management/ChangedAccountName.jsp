<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>계좌 별칭 변경</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap">
		
		<div id="AccuontName_ChangedArea">
			<form id="accuont_name_ChangedFrm">
				<c:forEach var="UserAccountInfo" items="${ UserAccountInfo }">
				<div id="Changed_BankArea" class="dFlex">
					<div id="Changed_Bank_spanArea" class="Changed_Bank_spanArea">
						<span>현재 은행</span>
					</div>
					<!-- div#Changed_Bank_spanArea.Changed_Bank_spanArea -->
					<div id="Changed_Bank_inputArea" class="Changed_Bank_inputArea">
						<input type="text" name="1" value="${ UserAccountInfo.bank }" disabled>
					</div>
					<!-- div#Changed_Bank_inputArea.Changed_Bank_inputArea -->
				</div>
				<!-- div#Changed_BankArea -->
				
				<br/>
				
				<div id="Changed_AccountNumberArea" class="dFlex">
					<div id="Changed_Account_Number_spanArea" class="Changed_Account_Number_spanArea">
						<span>별칭변경 할 계좌번호</span>
					</div>
					<!-- div#Changed_Account_Number_spanArea.Changed_Account_Number_spanArea -->
					
					<div id="Changed_Account_Number_inputArea" class="Changed_Account_Number_inputArea">
						<input type="text" id="UserAccountNumber" name="UserAccountNumber" value="${ UserAccountInfo.account_number }" readonly>
					</div>
					<!-- div#Changed_Account_Number_inputArea.Changed_Account_Number_inputArea -->
				</div>
				<!-- div#Changed_AccountNumberArea -->
				
				<br/>
				
				<div id="Changed_AccountNameArea" class="dFlex">
				
					<div id="Changed_Account_Name_spanArea" class="Changed_Account_Name_spanArea">
						<span>현재 별칭</span>
					</div>
					<!-- div#Changed_Account_Name_spanArea.Changed_Account_Name_spanArea -->
					
					<div id="Changed_Account_Name_inputArea" class="Changed_Account_Name_inputArea">
						<input type="text" id="UserAccountName" name="UserAccountName" value="${ UserAccountInfo.account_name }" readonly>
					</div>
					<!-- div#Changed_Account_Name_inputArea.Changed_Account_Name_inputArea -->
				</div>
				<!-- div#Changed_AccountNameArea -->
				
				</c:forEach>
				<br/><br/>
				<input type="text" id="Change_Account_name" name="Change_Account_name" placeholder="변경할 별칭을 적어주세요" value="">
				<button type="button" id="Change_AccountName_btn" class="Change_AccountName_btn">변경하기</button>
			</form>
			<!-- form#accuont_name_ChangedFrm -->
			
		</div>
		<!-- div#AccuontName_ChangedArea -->
	
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    