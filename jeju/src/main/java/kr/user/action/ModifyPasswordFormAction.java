package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class ModifyPasswordFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Integer session_user_num = (Integer)session.getAttribute("session_user_num");
		
		if(session_user_num == null) { // 로그인 X
			return "redirect:/user/loginForm.do";
		}
		
		// jsp 파일 경로 반환
		return "/WEB-INF/views/user/modifyPasswordForm.jsp";
	}
}