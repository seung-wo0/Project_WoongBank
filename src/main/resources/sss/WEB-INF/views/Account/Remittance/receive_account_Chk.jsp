<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var ReceiveAccountChkMsg = "${ReceiveAccountChkMsg}";
if (ReceiveAccountChkMsg == "이체 가능") {
	$("#ReceiveAccountChkMsg").css({
		"color": "blue",
		"bold" : "bold"
	})
	
} else {
	$("#ReceiveAccountChkMsg").css({
		"color": "red",
		"bold" : "bold"
	})
}

$("#ReceiveAccountChkMsg").text(ReceiveAccountChkMsg);
</script>

<span id="ReceiveAccountChkMsg"></span>