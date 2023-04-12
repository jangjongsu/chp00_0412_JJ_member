<%@page import="com.jscompany.test.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="dao" class="com.jscompany.test.MemberDAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pass");
		
		//MemberDAO dao = new MemberDAO();

		int dbFlag = dao.loginCheck(mid, mpw);
		
		if(dbFlag==1){
			session.setAttribute("sessionId", mid);
	%>
		<script type="text/javascript">
			alert("로그인 성공");
			history.back();
		</script>
			
	<%
		}else{
	%>
		<script type="text/javascript">
			alert("로그인 실패");
			history.back();
		</script>		
	<%	
		}
	
	%>

</body>
</html>