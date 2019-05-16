<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp'/>
		<div id="content">
			<div id="user">

				<form id="update-form" name="updateForm" method="post" action="${pageContext.servletContext.contextPath }/user/update">
					<label class="block-label" for="no">No</label>
					<input id="no" name="no" type="text" value="${vo.no }" readonly>
					
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${vo.name }">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="${vo.email }">
					<input type="button" value="id 중복체크">
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>

					<input type="submit" value="수정하기">
					
				</form>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navigation.jsp'>
			<c:param name="menu" value="user"></c:param>
		</c:import>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
</html>