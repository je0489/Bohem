<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> BOHEM이 짱이거든요? </title>
	<style type="text/css">
		F1 {font-size:50pt; font-family:Arial Black;}
		F2 {font-size:11pt; letter-spacing:10pt;}
		table{
			width : 250px;
			height : 100px;
			border : solid gray 0px;
		}
	</style>
</head>
<body style="padding-top : 5%;">
	<div align = center >
		<c:choose>
			<c:when test="${empty sessionScope.id}">
				<form action=login METHOD="post">
					<table>
						<caption><h1>BOHEM</h1></caption>
						<tr>
							<td COLSPAN="3" ALIGN=CENTER></td>
						</tr>
						<tr>
							<th Align=right><F2>ID:</F2></th>
							<td><input type="text" name=ID></td>
							<td ROWSPAN="2">
							<input type=SUBMIT value=LOGIN style="height:100px;"><br>
							</tr>
						<tr>
							<th align=right><F2>PW:</F2></th>
							<td><input type=PASSWORD name=PW></td>
						</tr>
					</table>
				</form>
				<form action=applyView.jsp>
					<table BORDER=0 CELLPADDING=2 ALIGN=CENTER>
						<tr>
							<td><input type=SUBMIT value=회원가입 style="width:140px; height:25px;"></td>
							<td><input type=button value=ID/PW찾기 style="width:140px; height:25px;"></td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<H1>${sessionScope.id} 님 환영합니다~~!</H1>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>