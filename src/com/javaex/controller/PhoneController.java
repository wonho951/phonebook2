package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")	//	<-- 요청을 할수 있는 주소가 있어야함.
public class PhoneController extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컨트롤러");	//작업코드 만들기 전에 뭐라도 하나 찍어서 테스트
		
		//리스트 만들기
		PhoneDao phoneDao = new PhoneDao();	//메모리에 Dao올린다.
		List<PersonVo> personList = phoneDao.getPersonList();
		
		System.out.println(personList);
		
		
		//데이터를 넣어줌. --> request에 어트리뷰트(Attribute)에 데이터를 넣어준다.
		request.setAttribute("pList", personList); 	// pList는 이름 지어준거.
		
		
		//html작업 --> jsp에게 시킨다. --> forword(포워드) : 내부 직원끼리 일을 넘김.
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");	//포워드로 할 수 있는 애들 달라는 뜻.
		rd.forward(request, response);
		//위 두개가 한 세트.
		
		
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


//localhost:8088/phonebook2/pbc