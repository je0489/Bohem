<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    
<table style="height:590px;	width: 100%;">
	<tr>
		<td class="contentsView">
		<!-- ${requestScope.recipeinfo.recipeSrc} -->
			<iframe class="contentsView" width="560" height="315" src="${requestScope.recipeinfo.recipeSrc}" frameborder="0"></iframe>
		</td>
		<td class="contentsView" width="35%">
			<table class="contentsView">
				<colgroup>
					<col width="10%"/>
					<col width="60%"/>
					<col width="25%"/>
					<col width="5%"/>
				</colgroup>
			    <tr>
				    <td colspan="4">
				    <hr style="max-width: 95%;">
				   
					    <h2 class="section-heading" style="padding:0">
					    <label class="contentsView padding">
							${requestScope.recipeinfo.recipeTitle}
						</label>
					    <hr style="max-width: 95%;">
				    </td>
			    </tr>
			    <tr>
					<td colspan="4">
			    		<h5 class="section-heading contentsView">
			    		
			    		 ${requestScope.recipeinfo.recipeContent} 
			    		</h5>
					</td>
			    </tr>
			    <tr>
			    	<td colspan="4">
			    		<label id="icon" onclick="liking()" style="font-size: xx-large; margin:0; padding-left:3%;">♥</label>
			    		<hr style="max-width:95%; border-color:gray; margin: auto 2% 3%;">
			    	</td>
			    </tr>
			    <c:choose>
				    <c:when test="${empty requestScope.newComList}">
					<tr>
				        <td colspan="4">
				            <p align="center"><b><span style="font-size:9pt;">등록된 댓글이 없습니다.</span></b></p>
				        </td>
				    </tr>
				    </c:when>
				    <c:otherwise>
				    	<div class="contentsView">
							<c:forEach items="${requestScope.newComList}" var="newcomDto" varStatus="state">
								<tr>
									<td bgcolor="">
										<span style="font-size:9pt;text-align: left;">
										${newcomDto.username}</span>
									</td>
									<td bgcolor="">
										<span style="font-size:9pt; text-align:left;">
								           ${newcomDto.comentComent}</span>
									</td>
									<td bgcolor="">
										<span style="font-size:9pt; text-align: left;">
										${newcomDto.comentDate}</span>
									</td>
									<td>
								        <form name = "requestForm" method = post action="comm?command=delete">
								        	<input type =hidden name ="comentIndex" value="${newcomDto.comentIndex}">
								        	<input type =hidden name = "recipeIndex" value="${requestScope.recipeinfo.recipeIndex}">
								        	<input type="hidden" name="userIndex" value ="${sessionScope.userindex}">
								        	<input type = button value ="삭제" onClick="submit()">
								       	</form>
									</td>
								</tr>    
						    </c:forEach>
					    </div>
					</c:otherwise>
			    </c:choose>
				<tr>
					<form method="post" action="comm?command=insert" >
						<td colspan="4" width="100%">
							<input class="page-scroll btn btn-default btn-contentsView sr-button login-button" type="text" name="comment" placeholder="댓글 입력하세염" style="text-align: left;">
							<input type="submit" class="hidden">
						</td>
						<input type="hidden" name="recipeIndex" value ="${requestScope.recipeinfo.recipeIndex}">
						<input type="hidden" name="userIndex" value ="${sessionScope.userindex}">
						<input type="hidden" name="username" value ="${sessionScope.username}">
					</form>
					
				</tr>
			</table>
		</td>
	</tr>
</table>

<script type="text/javascript">
		var likingState = false;
		$(window).resize( function(){ resizeYoutube(); });
		$(function(){resizeYoutube();});
		function resizeYoutube() { 
			$("iframe").each(function() { 
				if( /^https?:\/\/www.youtube.com\/embed\//g.test($(this).attr("src")) ){
				 	$(this).css("width","100%");
				 	$(this).css("height",Math.ceil(parseInt($(this).css("width")) * 315 / 450 ) + "px");
				} 
			}); 
		}
		function liking(){
			if(likingState == false ) {
 				$('#icon').css('color','#FD847C');
 				likingState = true;
			}
 			else {
 				$('#icon').css('color','black');
 				likingState = false;
 			}
		}
	</script>