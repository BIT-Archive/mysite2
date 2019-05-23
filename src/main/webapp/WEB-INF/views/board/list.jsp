<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp'/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>				
					<c:forEach items="${list }" var="post" varStatus="status">
					<tr>
						<td>${post.no }</td>
						<td style="text-align:left; padding-left:${20*post.depth}px">
							
							<c:if test="${post.depth ne 0 }">
							<img src="${pageContext.servletContext.contextPath }/assets/images/reply.png"/>						
							</c:if>
							<a href="${pageContext.servletContext.contextPath }/board/view?no=${post.no }"> ${post.title }</a>
						</td>
						<td>${post.name }</td>
						<td>${post.hit }</td>
						<td>${post.reg_date }</td>
						<c:if test="${authUser.no eq post.user_no }">
							<td><a href="/board/delete?no=${post.no }" class="del">삭제</a></td>
						</c:if>
					</tr>
					</c:forEach>
				</table>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>					
				<!-- pager 추가 -->
				
				<c:if test="${authUser ne null }">
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath }/board/write" id="new-book">글쓰기</a>
				</div>
				</c:if>				
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navigation.jsp'>
			<c:param name="menu" value="board"></c:param>
		</c:import>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
<script>
console.log("${list}");
</script>
</html>