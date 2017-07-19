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
         opener.document.applyForm.ID.value="${param.id}";
         self.close();
      }
     
</script>
</head>
<body>
	<div align="center">
   
   ${requestScope.result} <p>
   <form name = "checkForm" method="post" action="confrimIDCheck">
            
            <input type="text" name="id" value="${param.id}">
            <input type="submit" value="ID 중복확인">
            <input type="button" value="사용하기" onclick="setID()">
         </form> 
   </div>
</body>
</html>