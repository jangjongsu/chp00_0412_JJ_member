
<%@page import="com.jscompany.test.MemberDAO"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="com.jscompany.test.MemberDTO"></jsp:useBean>
<jsp:useBean id="dao" class="com.jscompany.test.MemberDAO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//String mid = request.getParameter("userID");
		//String mpw = request.getParameter("userPW");
		//String memail = request.getParameter("userMAIL");
		
		
		//MemberDTO dto= new MemberDTO();
		
		//dto.setId(mid);
		//dto.setPass(mpw);
		//dto.setEmail(memail);
		//MemberDAO dao = new MemberDAO();
		
		int dbFlag = dao.insertMember(dto);
		
		if(dbFlag==1){
			%>
			<script type="text/javascript">
				alert('회원가입을 축하합니다.');
				history.back();
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