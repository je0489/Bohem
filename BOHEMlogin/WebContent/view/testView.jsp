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
		<td class="contentsView" width="70%">
			<iframe class="contentsView" width="560" height="315" src="${requestScope.recipeinfo.recipeSrc}" frameborder="0"></iframe>
		</td>
		<td class="contentsView">
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
						    10분만에 만드는<br>이탈리아 전통 원팬파스타</h2>
						    <!-- ${requestScope.recipeinfo.recipeTitle}  -->
					    </label>
					    <hr style="max-width: 95%;">
				    </td>
			    </tr>
			    <tr>
					<td colspan="4">
			    		<h5 class="section-heading contentsView">
			    		< 재료 ><br>
			    		양송이버섯 2개/소세지 (중간크기) 3개 /<br>
			    		방울 토마토 6개/양파 1/4개 브로콜리 6조각/<br>
			    		스파게티면 75g/다진마늘 1ts/토마토소스 100g<br>
			    		 페페론치노 5~6개/드라이바질/소금,후추/물 350ml/<br>
			    		 슈레드 치즈/드라이파슬리 < 레시피 > Step1. 양송이,<br>
			    		 소세지, 방울토마토, 양파를 먹기 좋은 크기로 썬다.<br>
			    		 Step2. 팬에 스파게티면 야채, 소세지, 다진마늘,<br>
			    		 토마토소스, 페페론치노, 바질,소금,후추,물을 넣고 7~10분정도<br>
			    		  면이 익을 때까지 끓인다. Step3. 접시에 담고 치즈와 파슬리를<br>
			    		   뿌린다.
			    			<!-- ${requestScope.recipeinfo.recipeContent} -->
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
							<input class="btn btn-primary btn-xl page-scroll contentsView" type="text" name="comment" placeholder="댓글 입력하세염" style="text-align: left;">
							<hr style="max-width:95%; border-color:gray; margin: auto 2% 3%;">
							<input type="submit" class="hidden">
						</td>
						<input type="hidden" name="recipeIndex" value ="${requestScope.recipeinfo.recipeIndex}">
						<input type="hidden" name="userIndex" value ="${sessionScope.userindex}">
						<input type="hidden" name="username" value ="${sessionScope.username}">
						<!-- <td id="button">
							<input type="submit" value="등록">
						</td>-->
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
 				alert("좋아요 눌렀다");
 				$('#icon').css('color','#FD847C');
 				likingState = true;
			}
 			else {
 				alert("좋아요 취소");
 				$('#icon').css('color','black');
 				likingState = false;
 			}
		}
	</script>