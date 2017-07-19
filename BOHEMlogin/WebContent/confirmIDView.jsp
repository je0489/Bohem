<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 중복 확인</title>
<style type="text/css">
	F1 {font-size:11pt; color : red; font-family:sans-serif; font-style:italic,bolder;}
	F2 {font-size:11pt; font-family:sans-serif;}
</style>
<script LANGUAGE = javascript>
		function setID() {
			opener.document.applyForm.ID.value="${requestScope.id}";
		}
</script>
</head>
<body>
	<div align="center">
		<c:choose>
			<c:when test ="${requestScope.result eq 'false'}">
				<b>
					<F1>&nbsp;${requestScope.id}</F1>
					<F2>&nbsp;는 이미 사용중인 아이디입니다.</F2>
				</b>
				<form name = "checkForm" method="post" action="confrimIDCheck">
					<b>
						<F2>다른 아이디를 입력하세요.</F2>
					</b>
					<br><br>
					<input type="text" name=id>
					<input type="submit" value="ID 중복확인">
				</form>
			</c:when>
			<c:otherwise>
				<b>
					<F2>입력하신&nbsp;</F2>
					<F1>${requestScope.id}</F1>
					<F2>&nbsp;는 <br> 사용하실 수 있는 ID입니다.</F2>
				</b>
				<br><br>
				<input type=button value=닫기 onClick="setID()">
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>