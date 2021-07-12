<!-- WEB-INF -> 사용자가 접근하지 못하게끔 보호해주는 영역이기 때문에 이 폴더 안에 jsp파일 만들어준다.  -->


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


	<%for (int i = 0; i < personList.size(); i++) { %>
	<table border = "1">
		<tr>
			<td>이름</td>
			<td><%= personList.get(i).getName() %></td>
		</tr>
	
		<tr>
			<td>핸드폰</td>
			<td><%= personList.get(i).getHp() %></td>
		</tr>
	
		<tr>
			<td>회사</td>
			<td><%= personList.get(i).getCompany() %></td>
		</tr>	
	</table>
	<br>
	<% } %>
</body>
</html>