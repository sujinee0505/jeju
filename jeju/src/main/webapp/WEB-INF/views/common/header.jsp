<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header 시작 -->
<h1 class="align-center"><a href="${pageContext.request.contextPath}/main/main.do"><img src="${pageContext.request.contextPath}/images/logo.jpg" width="300px"></a></h1>
<div class="align-left">
	<a href="#">추천코스</a> 
	<a href="#">추천장소</a>
	<a href="#">문의사항</a>
</div>
<div class="align-right">
	<c:if test="${!empty session_user_num && !empty session_user_photo}"> <!-- user_num,user_photo가 있는경우 (로그인이 되어있고 사진이 있는경우) -->
		<img src="${pageContext.request.contextPath}/upload/${session_user_photo}" width="25" height="25" class="my-photo">
	</c:if>
	<c:if test="${!empty session_user_num && empty session_user_photo}"> <!-- 사진은 없지만, 로그인 된 경우 -->
		<img src="${pageContext.request.contextPath}/images/face.png" width="25" height="25" class="my-photo">
	</c:if>
	<c:if test="${!empty session_user_num}"> <!--  로그인 된 경우 -->
		[<span><b>${session_user_id}</b></span>]
		<a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a>
	</c:if>
	<c:if test="${empty session_user_num}"> <!--  로그인 안되어 있는 경우 -->
		<a href="${pageContext.request.contextPath}/user/registerUserForm.do">회원가입</a>
		<a href="${pageContext.request.contextPath}/user/loginForm.do">로그인</a>
	</c:if>
	<c:if test="${!empty session_user_num && session_user_auth == 2}"> <!--  일반 회원으로 로그인 한 경우 -->
		<a href="${pageContext.request.contextPath}/user/myPage.do">마이페이지</a>
	</c:if>
	<c:if test="${!empty session_user_num && session_user_auth ==3}"> <!--  관리자로 로그인 한 경우 -->
		<a href="${pageContext.request.contextPath}/user/userList.do">회원관리</a>
	</c:if>
</div>
<hr noshade="noshade">
<!-- header 끝 -->