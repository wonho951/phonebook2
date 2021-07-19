<!-- WEB-INF -> 사용자가 접근하지 못하게끔 보호해주는 영역이기 때문에 이 폴더 안에 jsp파일 만들어준다. 
				사용자는 무조건 컨트롤러를 통해서만 접근 가능. -->


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
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>



	<c:forEach items = "${pList }" var = "personList">
		<table border = "1">
			<tr>
				<td>이름</td>
				<td>${personList.name }</td>
			</tr>
		
			<tr>
				<td>핸드폰</td>
				<td>${personList.hp }</td>
			</tr>
		
			<tr>
				<td>회사</td>
				<td>${personList.company }</td>
			</tr>	
			<tr>
				<td><a href = "/phonebook2/pbc?action=uform&id=${personList.personId }">수정</a></td>
				<td><a href = "/phonebook2/pbc?action=delete&id=${personList.personId }">삭제</a></td>
			</tr>
		</table>
	</c:forEach>

	
	<a href="/phonebook2/pbc?action=wform">추가번호 등록</a>
</body>
</html>