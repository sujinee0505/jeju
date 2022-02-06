package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class DeleteUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 회원전용 페이지 이므로 세션 조회
		HttpSession session = request.getSession();
		Integer session_user_num = (Integer)session.getAttribute("session_user_num");
		
		if(session_user_num == null) { // 로그인 X
			return "redirect:/user/loginForm.do";
		}
		
		//jsp 경로 반환
		return "/WEB-INF/views/user/deleteUserForm.jsp";
	}
}