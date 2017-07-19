<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> BOHEM APPLY</title>
	<style type="text/css">
			a { 
				text-decoration: none; 
				color : black;
			}
			section { padding-top : 5%; }
			input[type="text"] ,input[type="password"] { height : 20px; }
			input[type="SUBMIT"] ,input[type="RESET"] { height : 50px; }
			#none { height : 20px; }
	</style>
	<script language=javascript>		
		function openConfirmID(input) {
			var id = input.ID.value;
			var idCheck = false;
			if ( id == "" ) {
				alert("아이디를 입력해주세용");
				return;
			}
			url = "confirmIDView.jsp?id=" + id;
			window.open(url,"confirm","width=330,height=140");
		}
		
		function passchk(){   // 비밀번호 재확인
			   var pw=document.applyForm.PW.value;
			   var pw_check=document.applyForm.PW_CHECK.value;
			   if(pw_check.length==0 || pw_check==null){
				   document.applyForm.PWCK.value="비밀번호를 입력하세요.";
			   }
			   else if(pw!=pw_check){
				   document.applyForm.PWCK.value="비밀번호가 다릅니다.";
			   }else{
				   document.applyForm.PWCK.value="비밀번호가 동일합니다.";
			   }
			  return;
		}
		
		function checkEmptySpace() {
			var input = document.applyForm;
			if (input.ID.value=="") {
					alert("아이디를 입력하세요");
				return false;
			} else if(input.PW.value=="") {
					alert("비밀번호를 입력하세요.");
				return false;
			} else if (input.NAME.value=="") {
					alert("이름을 입력하세요.");
				return false;
			} else if (input.TEL2.value==""||input.TEL3.value=="") {
					alert("핸드폰 번호를 입력하세요.");
				return false;
			} else if (input.EMAIL_ID.value==""||input.EMAIL_ADDRESS.value=="") {
					alert("이메일을 입력하세요.");
				return false;
			}
		}
	</script>
</head>
<body>
	<div align=center>
		<section>
			<form name = "applyForm" method="post" action="apply" onSubmit="return checkEmptySpace()">
				<table>
					<caption><a href="index.html"><h1>BOHEM</h1></a>
					<hr color="#5d5d5d"></caption>
					<TR id="none"/>
					<TR>
						<th>ID</th>
						<td><input type="text" name="ID" size="10">&nbsp;
						<input type="button" name="ID_CHECK" value="ID CHECK" onClick="openConfirmID(this.form)">
						</td>
					</TR>
					<TR>
						<Th><label for=PW>PASSWORD</label></Th>
						<TD><INPUT TYPE=PASSWORD NAME="PW" SIZE="20"></TD>
					</TR>
					<TR>	
						<Th><label for=PW_CHECK>PASSWORD CONFIRM</label></Th>
						<TD><INPUT TYPE=PASSWORD NAME=PW_CHECK SIZE="20" onblur="passchk()">&nbsp;
						<INPUT TYPE=TEXT style= "border-width:0px; font-size:8pt" size="20" name="PWCK" value="비밀번호를 입력하세요" readonly="readonly"/></TD>
					</TR>
					<TR>	
						<Th><label for=NAME>NAME</label></Th>
						<TD><INPUT TYPE=TEXT NAME="NAME" SIZE=10 ></TD>
					</TR>
					<TR>	
						<Th><label for=PHONENO>MOBILE NUMBER</label></Th>
						<TD><SELECT SIZE=1 NAME="TEL1">
						<option SELECTED> 010</option>
						<option> 011</option>
						<option> 017</option>
						<option> 018</option>
						<option> 019</option>
						</SELECT> - <INPUT TYPE=TEXT  NAME="TEL2" SIZE="4" Maxlength=4> - <INPUT TYPE=TEXT NAME="TEL3" SIZE="4" Maxlength=4></TD>
					</TR>
					<TR>
						<Th><label for=EMAIL>E-MAIL</label></Th>
						<TD><INPUT TYPE=TEXT NAME="EMAIL_ID" SIZE=15> @ <INPUT TYPE=TEXT NAME="EMAIL_ADDRESS" SIZE=15></TD>
					</TR>
					<TR  id="none"/>
					<TR >
						<TD COLSPAN=2 ALIGN=CENTER>
						<INPUT TYPE=SUBMIT VALUE=확인>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<INPUT TYPE=RESET VALUE=취소 onClick="location.href='HomeProcessing.jsp'"></TD>
					</TR>
				</table>
			</form>
		</section>
	</div>
</body>
</html>