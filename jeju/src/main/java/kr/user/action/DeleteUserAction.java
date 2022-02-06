package kr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.user.dao.UserDAO;
import kr.user.vo.UserVO;
import kr.util.FileUtil;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Integer session_user_num = (Integer)session.getAttribute("session_user_num");
		
		if(session_user_num == null) { // 로그인 안되어 있는 경우
			return "redirect:/user/loginForm.do";
		}
		
		//전달받은 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		//전달받은 데이터 반환
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//로그인한 아이디 (세션조회)
		String session_user_id = (String)session.getAttribute("session_user_id");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO db_user = dao.checkUser(id);
		boolean check = false;
		
		//사용자가 입력한 아이디가 존재하고 로그인한 아이디와 일치하는지 체크
		if(db_user!=null && id.equals(session_user_id)) {
			//비밀번호 일치 여부 체크
			check = db_user.isCheckedPassword(passwd);
		}
		
		if(check) {
			//회원 정보 삭제
			dao.deleteUser(session_user_num);
			//프로필 삭제
			FileUtil.removeFile(request, db_user.getPhoto());
			//로그아웃
			session.invalidate();
		}
		
		request.setAttribute("check", check);
		
		// jsp 경로 반환
		return "/WEB-INF/views/user/deleteUser.jsp";
	}

}