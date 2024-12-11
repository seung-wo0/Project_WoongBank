<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	if(confirm("계좌를 생성 하시겠습니까?")) {
		window.location.href="/AccountCreateProc";
		alert("계좌 생성이 완료 되었습니다.");
		opener.location.reload();
		window.close();
		
	} else {
		alert("계좌 생성을 취소 하였습니다.");
		opener.location.reload();
		window.close();
	}
</script>