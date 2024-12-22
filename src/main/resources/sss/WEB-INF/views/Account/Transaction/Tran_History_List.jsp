<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<table>
	<tr id="transactionListTitle">
		<td class="transaction">거래타입</td>
		<td class="amount">거래금액</td>
		<td class="amount_balance">거래 후 잔액</td>
		<td class="deposit_name">입금자명</td>
		<td class="withdrawal_name">출금자명</td>
		<td class="receive_name">송금 계좌주 명</td>
		<td class="receive_account">송금 계좌번호</td>
		<td class="transaction_TM">거래일자</td>
	<tr>
<c:forEach var="AccountTransactionList" items="${ AccountTransactionList }">
	<tr class="TransactionListCol">
		<td class="transaction">${ AccountTransactionList.transaction }</td>
		<td class="amount">${ AccountTransactionList.amount }</td>
		<td class="amount_balance">${ AccountTransactionList.amount_balance }</td>
		<td class="deposit_name">${ AccountTransactionList.deposit_name }</td>
		<td class="withdrawal_name">${ AccountTransactionList.withdrawal_name }</td>
		<td class="receive_name">${ AccountTransactionList.receive_name }</td>
		<td class="receive_account">${ AccountTransactionList.receive_account }</td>
		<td class="transaction_TM">
			<fmt:formatDate value="${ AccountTransactionList.transaction_TM }" pattern="yyyy-MM-dd hh:mm:ss"/>
		</td>
	</tr>
</c:forEach>
</table>