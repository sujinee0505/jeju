package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.user.dao.UserDAO;
import kr.user.vo.UserVO;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 회원가입 입력폼에서 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 자바빈(VO) 객체 생성
		UserVO user = new UserVO();
		
		// 회원가입 입력폼에서 전송된 데이터 반환하여 자바빈 객체에 set
		user.setId(request.getParameter("id"));
		user.setName(request.getParameter("name"));
		user.setPasswd(request.getParameter("passwd"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setZipcode(request.getParameter("zipcode"));
		user.setAddress1(request.getParameter("address1"));
		user.setAddress2(request.getParameter("address2"));
		
		UserDAO dao = UserDAO.getInstance();
		dao.insertUser(user);
		
		// jsp 경로 반환
		return "/WEB-INF/views/user/registerUser.jsp";
	}
}