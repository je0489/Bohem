<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bohemBootstrap.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="${pageContext.request.contextPath}/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

	<!-- jQuery 1.7.2+ or Zepto.js 1.0+ -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<!-- Magnific Popup core JS file -->
	<script src="${pageContext.request.contextPath}/vendor/magnific-popup/jquery.magnific-popup.js"></script>
   
    <!-- Theme CSS -->
    <link href="${pageContext.request.contextPath}/css/creative.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<title>ID 중복 확인</title>
<script LANGUAGE = javascript>
	function setID() {
         opener.document.applyForm.ID.value="${param.id}";
         self.close();
	}
</script>
</head>
<body>
	<div align="center">
		<section style="padding: 5%;">
		   <h4 class="section-heading">${requestScope.result}</h4>
		   <form name = "checkForm" method="post" action="${pageContext.request.contextPath}/confrimIDCheck">
			   	<table class="idCheck-form">
			   		<caption><h3 class=" section-heading">ID CHECK</h3>
					<hr></caption>
			   		<tr>
			   			<td colspan="2">
			   				<input type="text" name="id" value="${param.id}" class="apply-form btn btn-default btn-apply-form sr-button">
			   			</td>
			   		</tr>
			   		<tr align=center>
			   			<td id="padding">
			   				<input type="submit" value="중복 확인" class="page-scroll btn btn-default btn-idcheck sr-button">
			   			</td>
			   			<td id="padding">
			   				<input type="button" value="사용하기" onclick="setID()" class="page-scroll btn btn-default btn-idcheck sr-button">
			   			</td>
			   	</table>
			</form>
		</section>
   </div>
</body>
</html>