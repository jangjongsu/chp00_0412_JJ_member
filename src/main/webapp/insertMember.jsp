<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jscompany.test.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String mid = request.getParameter("userID");
		String mpw = request.getParameter("userPW");
		String memail = request.getParameter("userMAIL");
		
		MemberDAO dao = new MemberDAO();
		
		int dbFlag = dao.insertMember(mid, mpw, memail);
		
		if(dbFlag==1){
			%>
			<script type="text/javascript">
				alert('회원가입을 축하합니다.');
			</script>
			<%
		} else{
			%>
			<script type="text/javascript">
				alert('회원가입 실패하셨습니다. 입력사항을 다시 확인해주세요');
				history.back();
			</script>
			<%
		}

		
	
	%>
</body>
</html>