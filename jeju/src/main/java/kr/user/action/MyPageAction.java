package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.user.dao.UserDAO;
import kr.user.vo.UserVO;

public class MyPageAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//회원 전용 페이지니까 세션 조회 필수
		HttpSession session = request.getSession();
		Integer session_user_num = (Integer)session.getAttribute("session_user_num");
		if(session_user_num == null) { //로그인이 되지 않은 경우
			return "redirect:/user/loginForm.do";
		}
		
		// 로그인이 된 경우
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUser(session_user_num);
		
		request.setAttribute("user", user);
		
		// jsp 경로 반환
		return "/WEB-INF/views/user/myPage.jsp";
	}

}
