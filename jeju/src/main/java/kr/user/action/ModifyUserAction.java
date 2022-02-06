package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.user.dao.UserDAO;
import kr.user.vo.UserVO;

public class ModifyUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Integer session_user_num = (Integer)session.getAttribute("session_user_num");
		
		if(session_user_num == null) { // 로그인 X
			return "redirect:/user/loginForm.do";
		}
		
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = new UserVO();
		
		user.setUser_num(session_user_num);
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setZipcode(request.getParameter("zipcode"));
		user.setAddress1(request.getParameter("address1"));
		user.setAddress2(request.getParameter("address2"));
		
		dao.updateUser(user);
		
		// jsp 파일 경로 반환
		return "/WEB-INF/views/user/modifyUser.jsp";
	}
}