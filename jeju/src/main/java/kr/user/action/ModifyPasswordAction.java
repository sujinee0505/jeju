package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.user.dao.UserDAO;
import kr.user.vo.UserVO;

public class ModifyPasswordAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		Integer session_user_num = (Integer)session.getAttribute("session_user_num");
		
		if(session_user_num == null) { // 회원이 아닌 경우
			return "redirect:/user/loginForm.do";
		}
		
		// 로그인 된 경우 아래 내용 수행
		
		// 비밀번호 수정 페이지에서 전달 받은 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		//전송된 데이터 반환
		String id = request.getParameter("id");
		String origin_passwd = request.getParameter("origin_passwd"); // 현재 비밀번호
		String passwd = request.getParameter("passwd"); // 새 비밀번호
		
		//현재 로그인 한 아이디 (세션조회)
		String session_user_id = (String)session.getAttribute("session_user_id");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.checkUser(id);
		
		boolean check = false;

		//사용자가 입력한 아이디가 존재하고 로그인한 아이디와 일치하는지 체크
		if(user!=null && id.equals(session_user_id)) {
			//비밀번호 일치 여부 체크
			check = user.isCheckedPassword(origin_passwd);
		}
		
		if(check) { // 인증 성공
			// 비밀번호 변경
			dao.updatePassword(passwd, session_user_num);
		}
		
		request.setAttribute("check", check);
		
		// jsp 파일 경로 반환
		return "/WEB-INF/views/user/modifyPassword.jsp";
	}
}