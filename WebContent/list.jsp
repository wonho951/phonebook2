<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.PersonVo" %>    
    
<%
	//request 안에 데이터 사용 --> pList
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("pList");	//그냥 꺼내올수 없어서 형변환을 해줌.
	
	
	System.out.println("jsp-------------------------");
	System.out.println(personList);
	
	/*	형변환 설명때문에 하신거.
	int age = (int)request.getAttribute("age");	//int형이기 때문에 int로 형변환 해줌
	String name = (String)request.getAttribute("name");	//String형이기 때문에 String으로 형변환 해줌.
		
	System.out.println(age + ", " + name);
	*/
	
	
	
	
%>    








<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<table border = "1">
		<tr>
			<td>이름</td>
			<td>이효리</td>
		</tr>
	
		<tr>
			<td>핸드폰</td>
			<td>010-2222-2222</td>
		</tr>
	
		<tr>
			<td>회사</td>
			<td>02-9999-9999</td>
		</tr>	
	</table>
	<br>
	
	<table border = "1">
		<tr>
			<td>이름</td>
			<td>정우성</td>
		</tr>
	
		<tr>
			<td>핸드폰</td>
			<td>010-3333-3333</td>
		</tr>
	
		<tr>
			<td>회사</td>
			<td>02-8888-8888</td>
		</tr>	
	</table>


</body>
</html>