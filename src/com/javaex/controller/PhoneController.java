package com.javaex.controller;

import java.io.IOException;
import java.util.List;

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
		
		
		//html작업 --> jsp에게 시킨다.
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


//localhost:8088/phonebook2/pbc