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
		
		
		//파라미터의 actuin값을 읽어온다.
		String action = request.getParameter("action");	//항상 문자열로 온다.
		System.out.println(action);
				
		if ("list".equals(action)) {
			//리스트업무
			System.out.println("[리스트]");
			//리스트 만들기
			PhoneDao phoneDao = new PhoneDao();	//메모리에 Dao올린다.
			List<PersonVo> personList = phoneDao.getPersonList();
			
			System.out.println("controller-------------------------");
			System.out.println(personList);
			
			
			//데이터를 넣어줌. --> request에 어트리뷰트(Attribute)에 데이터를 넣어준다.
			request.setAttribute("pList", personList); 	// pList는 이름 지어준거.
			
			/*	형변환 설명때문에 해본거.
			request.setAttribute("age", 30);
			request.setAttribute("name", "최원호");
			*/
			
			
			//html작업 --> jsp에게 시킨다. --> forword(포워드) : 내부 직원끼리 일을 넘김.
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");	//포워드로 할 수 있는 애들 달라는 뜻.
																//WEB-INF 에 넣어주면 jsp파일을 보호할 수 있다.--> 사용자가 주소를 알아낸다 한들 접근 불가능하다.
			rd.forward(request, response);
			//위 두개가 한 세트.
			
		} else if ("wform".equals(action)) {
			System.out.println("[글쓰기폼]");
			
			//wireteForm.jsp --> 포워드해줌. --> 데이터 줄게 없음. 어트리뷰트 안해도 됨.
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");//WEB-INF 에 넣어주면 jsp파일을 보호할 수 있다.--> 사용자가 주소를 알아낸다 한들 접근 불가능하다.
			rd.forward(request, response);
			
		}else if ("insert".equals(action)) {
			System.out.println("[저장]");
			
			//Dao --> 저장
			//파라미터를 꺼낸다(name, hp, company)
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			
			//vo로 묶어준다
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo);
			
			//Dao에 personInsert(vo)-->해줌.
			PhoneDao phoneDao = new PhoneDao();
			int count = phoneDao.personInsert(personVo);
			
			System.out.println(count);
			
			
			//리다이렉트 시킨다.	--> 리스트로 다시 보냄.
			response.sendRedirect("/phonebook2/pbc?action=list");	//--> model2에서는 주소체계가 조금 바뀜.
									// 위 주소로 이동함. 그냥 pbc아님.
		}else if("delete".equals(action)) {
			System.out.println("[삭제]");
			
			
			PhoneDao phoneDao = new PhoneDao();
			int personId = Integer.parseInt(request.getParameter("id"));
			
			int count = phoneDao.personDelete(personId);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		} else if("uform".equals(action)) {
			System.out.println("수정폼");
			
			
			PhoneDao phoneDao = new PhoneDao();
			
			int personId = Integer.parseInt(request.getParameter("id"));
			
			PersonVo personVo = phoneDao.getPerson(personId);
			
					    
		} else if ("update".equals(action)) {
			
		}
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


//localhost:8088/phonebook2/pbc