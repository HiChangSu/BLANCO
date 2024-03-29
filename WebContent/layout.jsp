<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="shortcut icon" href="#">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/shoppingmall/css/style.css" />
<div id="header">
	<div id="logo" class="box">
		<img class="noborder" id="logo" width="50" height="50px"
			src="/BLANCO/images/apple.png" />
	</div>

	<div id="auth" class="box">
		<c:if test="${type == 0}">
			<jsp:include page="/mngr/logon/mLoginForm.jsp" />
		</c:if>
		<c:if test="${type == 1}">
			<jsp:include page="/guest/logon/gLoginForm.jsp" />
		</c:if>
	</div>
</div>
<div id="content" class="box2">
	<c:choose>
		<c:when test="${cont != null }">
			<jsp:include page="${cont}" />
		</c:when>
		<c:otherwise>
			<jsp:include page="home.jsp" />
		</c:otherwise>
	</c:choose>
</div>