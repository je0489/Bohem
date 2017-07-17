<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<title>apply</title>
	<meta charset="UTF-8">
	<style type="text/css">
		a { text-decoration: none; }
	</style>
	<script LANGUAGE = "JavaScript">
			function openConfirmID(inputID) {   //아이디를 입력했는지 검사
				var ID = inputID.ID.value;
				var IDCheck = false;
				if ( ID == "" ) {
					alert("아이디를 입력해주세용");
					return ;
				}
				url = "confirmID.jsp?ID=" + ID;
				window.open(url, "confirm","width=330,height=140");
			}
			
			function passchk(){   // 비밀번호 재확인
				   var pw=document.ApplyForm.PW.value;
				   var pw_check=document.ApplyForm.PW_CHECK.value;
				   if(pw_check.length==0 || pw_check==null){
					   document.ApplyForm.PWCK.value="비밀번호를 입력하세요.";
				   }
				   else if(pw!=pw_check){
					   document.ApplyForm.PWCK.value="비밀번호가 다릅니다.";
				   }else{
					   document.ApplyForm.PWCK.value="비밀번호가 동일합니다.";
				   }
				  return;
			}
			
			function checkIt() {
				var input = document.ApplyForm;
				if (!input.ID.value) {
					alert("아이디를 입력하세요");
					return false;
				}
				else if(!input.PW.value) {
					alert("비밀번호를 입력하세요.");
					return false;
				}
				else if (!input.NAME.value) {
					alert("이름을 입력하세요.");
					return false;
				}
				else if (!input.TEL2.value||!input.TEL3.value) {
					alert("핸드폰 번호를 입력하세요.");
					return false;
				}
				else if (!input.EMAIL_ID.value||!input.EMAIL_ADDRESS.value) {
					alert("이메일을 입력하세요.");
					return false;
				}
				else if (!input.ANSWER.value) {
					alert("비밀번호 힌트에 대한 답을 입력하세요.");
					return false;
				}
			}
	</script>
</head>
<body>	
	<!-- Apply -->
		<div align=center><p>
			<FORM name="ApplyForm" action="apply" method=post onSubmit="return checkIt()">
				<TABLE WIDTH=500 HEIGHT=300 BORDER=0 CELLPADDING=5 ALIGN=CENTER>
				<caption><a href="index.html"><h1>BOHEM</h1></a>
				<hr color="#5d5d5d"> </caption>
					<TR style="height:20px;"/>
					<TR> 
						<Th><label for=ID>ID</label></Th>
						<TD><INPUT TYPE=TEXT NAME=ID SIZE="10" style="height:30px;">&nbsp;
						<INPUT TYPE=BUTTON NAME=ID_CHECK VALUE="ID CHECK" onClick="openConfirmID(this.form)"></TD>
					</TR>
					<TR>
						<Th><label for=PW>PASSWORD</label></Th>
						<TD><INPUT TYPE=PASSWORD NAME=PW SIZE="20" style="height:30px;"></TD>
					</TR>
					<TR>	
						<Th><label for=PW_CHECK>PASSWORD CONFIRM</label></Th>
						<TD><INPUT TYPE=PASSWORD NAME=PW_CHECK SIZE="20" onblur="passchk()" style="height:30px;">&nbsp;
						<INPUT TYPE=TEXT style= "border-width:0px; font-size:8pt" size="20" name="PWCK" value="비밀번호를 입력하세요" readonly="readonly"/></TD>
					</TR>
					<TR>	
						<Th><label for=NAME>NAME</label></Th>
						<TD><INPUT TYPE=TEXT NAME=NAME SIZE=10 style="height:30px;"></TD>
					</TR>
					<TR>	
						<Th><label for=PHONENO>MOBILE NUMBER</label></Th>
						<TD><SELECT SIZE=1 NAME=TEL1>
						<option SELECTED> 010</option>
						<option> 011</option>
						<option> 017</option>
						<option> 018</option>
						<option> 019</option>
						</SELECT> - <INPUT TYPE=TEXT NAME=TEL2 SIZE="4" Maxlength=4> - <INPUT TYPE=TEXT NAME=TEL3 SIZE="4" Maxlength=4></TD>
					</TR>
					<TR>
						<Th><label for=EMAIL>E-MAIL</label></Th>
						<TD><INPUT TYPE=TEXT NAME=EMAIL_ID SIZE=15 style="height:30px;"> @ <INPUT TYPE=TEXT NAME=EMAIL_ADDRESS SIZE=15 style="height:30px;"></TD>
					</TR>
					<TR style="height:20px;"/>
					<TR >
						<TD COLSPAN=2 ALIGN=CENTER>
						<INPUT TYPE=SUBMIT VALUE=확인 style="height:50px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<INPUT TYPE=RESET VALUE=취소 style="height:50px;" onClick="location.href='HomeProcessing.jsp'"></TD>
					</TR>
			</TABLE>
		</form>
	</div>
</body>
</html>
