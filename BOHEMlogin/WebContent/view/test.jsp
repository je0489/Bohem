<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<table>
	<tr>
	<td>recipeindex</td><td>recipetitle</td>
	</tr>
	<c:choose>
	<c:when test = "${empty requestScope.recipelist}">
	<tr>
		<td colspan="2">
		<p align="center"><b><span style="font-size:9pt;">등록된 레시피가 없습니다.</span></b></p>
		</td>
	</tr>
	</c:when>
	<c:otherwise>
	<c:forEach items = "${requestScope.recipelist}" var ="Recipe" >
		<td><p align="center"><span style="font-size:9pt;">
		 ${Recipe.recipeIndex}</span></p>
		</td>
		<td><p align="center"><span style="font-size:9pt;">
		 ${Recipe.recipeTitle}</span></p>
		</td>
	</c:forEach>
	</c:otherwise>
	</c:choose>
</table>
</body>
</html>