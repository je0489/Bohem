<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERROR</title>
</head>
<body>
	<script>
		var Msg = '에러다 error : ' + '${requestScope.errorMsg}';
		alert(Msg);
		
		top.location.href='${requestScope.redirectPath}';
	</script>
</body>
</html>