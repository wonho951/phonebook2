<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호수정</h1>
	<p>수정화면 입니다. 아래 항목을 수정하고 "수정"버튼을 클릭하세욤</p>
	<form action ="/phonebook2/pbc" method="get">
       이름(name): <input type="text" name="name" value="${pVo.name }"> <br>
       핸드폰(hp): <input type="text" name="hp" value="${pVo.hp }"> <br>
       회사(company): <input type="text" name="company" value="${pVo.company }"> <br>
       <input type = "hidden" name = "id" value = "${pVo.name }"><br>
       <input type = "hidden" name = "action" value = "update">	
       
       <button type="submit">수정</button>
   </form>

</body>
</html>