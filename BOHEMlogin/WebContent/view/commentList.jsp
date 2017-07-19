<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<SCRIPT language = javascript>
function sendUpdate(){
	document.requestForm.command.value ="update";
	document.requestForm.submit();//전송해라- action에서 지정한 곳으로 이동.
}

function sendDelete(){
	document.requestForm.command.value ="delete";
	document.requestForm.submit();
}

</SCRIPT>

</head>
<body> 
-->
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<colgroup>
		<col width="7%" />
		<col width="73%"/>
		<col width="10%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
        <td bgcolor="pink">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">번호</span></b></font></p>
        </td>
        <td bgcolor="pink">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">내용</span></b></font></p>
        </td>
        <td bgcolor="pink">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">사용자</span></b></font></p>
        </td>
        <td bgcolor="pink">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">날짜</span></b></font></p>
        </td>
        <td bgcolor="pink">
        </td>
        
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.comlist}">
	<tr>
        <td colspan="4">
            <p align="center"><b><span style="font-size:9pt;">등록된 댓글이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.comlist}" var="comDto" varStatus="state">
		    <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${state.count}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					 ${comDto.comentComent}</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		           ${comDto.userIndex}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${comDto.comentDate}</span></p>
		        </td>
		        <td>
		        
		        <form name = "requestForm" method = post action="comm?command=delete">
		        	<input type =hidden name ="userIndex" value="${comDto.userIndex}">
		        	<input type =hidden name ="comentIndex" value="${comDto.comentIndex}">
		        	<input type =hidden name ="command" value = "">
		        	<input type = button value ="삭제" onClick="submit()">
		       	</form>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<!-- 
</body>
</html>  -->