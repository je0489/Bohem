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
    <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/creative.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
	<title> BOHEM이 짱이거든요? </title>
	<!-- 
		F1 {font-size:50pt; font-family:Arial Black;}
		F2 {font-size:11pt; letter-spacing:10pt;}
		table{
			width : 250px;
			height : 100px;
			border : solid gray 0px;
		}
		 -->
</head>
<body>
	<div align=center>
		<section class="bg-primary">
			<c:choose>
				<c:when test="${empty sessionScope.id}">
						<h2 class="section-heading">LOGIN</h2>
					     <hr class="light">
					<form action=login METHOD="post">
						<table>
							<tr>
								<td COLSPAN="3" ALIGN=CENTER></td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="text" name=ID class="btn btn-default btn-xl sr-button" style="text-align:left" placeholder="id"></td>
							</tr>
							<tr>
								<td cols="2"><input type=PASSWORD name=PW class="btn btn-default btn-xl sr-button" style="text-align:left" placeholder="password"></td>
							</tr>
						</table>
					</form>
					<form action=applyView.jsp>
						<table BORDER=0 CELLPADDING=2 ALIGN=CENTER>
							<tr>
								<td><input type=SUBMIT value=회원가입 style="width:140px; height:25px;"></td>
								<td><input type=SUBMIT value=LOGIN style="width:140px; height:25px;"></td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:otherwise>
					<H1>${sessionScope.id} 님 환영합니다~~!</H1>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
</body>
</html>