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
    
	<title> BOHEM이 짱이거든요? </title>
<script>
	function openApplyView() {
		url = "${pageContext.request.contextPath}/view/applyView.html";
		var h = (screen.availHeight/2)-350;
		var w = (screen.availWidth/2)-350;
		var setting = "width=700,height=622,resizeable=yes,left="+ w + ",top=" + h;
		window.open(url,"BOHEM APPLY",setting);
	}
	
	function doLogout() {
		location.href="${pageContext.request.contextPath}/comm?command=logout";
	}
	
	function checkEmptySpace() {
		var input = document.loginForm;
		if (input.ID.value=="") {
				alert("아이디를 입력하세요");
			return false;
		} else if(input.PW.value=="") {
				alert("비밀번호를 입력하세요.");
			return false;
		}
	}

</script>
</head>
<body style="background: #FD847C;">
	<div align=center>
		<section class="bg-primary">
			<c:choose>
				<c:when test="${empty sessionScope.userid}">
					<h2 class="section-heading">LOGIN</h2>
					 <hr class="light">
					<form name = "loginForm" action="${pageContext.request.contextPath}/comm?command=logincheck" METHOD="post" onSubmit="return checkEmptySpace()">
						<table align="center" class="login-form" >
							<tr>
								<td COLSPAN="3" ALIGN=CENTER></td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="text" name=ID class="btn btn-default btn-xl sr-button login" placeholder="id" ></td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="password" name=PW class="btn btn-default btn-xl sr-button login login-button" placeholder="password"></td>
							</tr>
							<tr>
								<td>
									<input type="submit" class="page-scroll btn btn-default btn-xl sr-button login-button" value="login">
								</td>
								<td>
									<!-- <a class="simple-ajax-popup-align-top" href="applyView.html">  -->
										<input type="button" onclick="openApplyView()" value="apply" class="page-scroll btn btn-default btn-xl sr-button apply-button">
									<!--</a>  -->
								</td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:otherwise>
					<h2 class=" section-heading">${sessionScope.username} 님 맛있는 식사하세요 !</h2>
					<hr class="light">
					<h5> ' 나홀로레시피 ' 에서는 엄선된 레시피를 통해 <br>
					    집에서 만들 수 있는 특별한 식사를 안내합니다.</h5><p>
					<input type=button onclick="doLogout()" class="page-scroll btn btn-default btn-xl sr-button" value="logout">
				</c:otherwise>
			</c:choose>
		</section>
	</div>
</body>
</html>