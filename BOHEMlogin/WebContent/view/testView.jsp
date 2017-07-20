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
		<!--<col width="7%" />-->
		<col width="70%"/>
		<col width="10%"/>
		<col width="20%"/>
	</colgroup>
	<!-- <tr>
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
    -->
    <iframe width="560" height="315" src= "${requestScope.recipeinfo.recipeSrc}" frameborder="0"  style="float:left"></iframe>
    
    <c:choose>
    <c:when test="${empty requestScope.newComList}">
	<tr>
        <td colspan="3">
            <p align="center"><b><span style="font-size:9pt;">등록된 댓글이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.newComList}" var="newcomDto" varStatus="state">
		    <tr>
		        <!-- <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${state.count}</span></p>
		        </td> -->
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		           ${newcomDto.comentComent}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					 ${newcomDto.username}</span></p>
		        </td>
		        
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${newcomDto.comentDate}</span></p>
		        </td>
		  		<td>
		        <form name = "requestForm" method = post action="comm?command=delete">
		        	<input type =hidden name ="comentIndex" value="${newcomDto.comentIndex}">
		        	<input type =hidden name = "recipeIndex" value="${requestScope.recipeinfo.recipeIndex}">
		        	<input type = button value ="삭제" onClick="submit()">
		       	</form>
		        </td>
		    </tr>
		    
    </c:forEach>
	</c:otherwise>
    </c:choose>
    <tr>
		    <form method="post" action="comm?command=insert" >
		    <td colspan="2" width="100%">
		    <input type="text" name="comment" placeholder="댓글 입력하세염"></td>
		    <input type="hidden" name="recipeIndex" value ="${requestScope.recipeinfo.recipeIndex}">
		    <input type="hidden" name="userIndex" value ="${sessionScope.userindex}">
		    <input type="hidden" name="username" value ="${sessionScope.username}">
			<!-- <input type = button value ="등록" onClick="submit()">-->
			<td id="button"><input type="submit" value="등록"></td>
		    
		    </form>
		    </tr>
</table>
${requestScope.recipeinfo.recipeIndex}
${sessionScope.userindex}
${sessionScope.username}
<!-- 
</body>
</html>  -->