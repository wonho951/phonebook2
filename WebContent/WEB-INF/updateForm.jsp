<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>


<% 

	PhoneDao phoneDao = new PhoneDao();

	String id =request.getParameter("id");
	int personId = Integer.parseInt(id);
	
	
	PersonVo personVo = phoneDao.getPerson(personId);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호수정</h1>
	<p>수정화면 입니다. 아래 항목을 수정하고 "수정"버튼을 클릭하세욤</p>
	<form action ="./update.jsp" method="get">
       이름(name): <input type="text" name="name" value="<%= personVo.getName() %>"> <br>
       핸드폰(hp): <input type="text" name="hp" value="<%= personVo.getHp() %>"> <br>
       회사(company): <input type="text" name="company" value="<%= personVo.getCompany() %>"> <br>
       <input type = "text" name = "id" value = "">	
       
       <button type="submit">수정</button>
   </form>

		
	


</body>
</html>