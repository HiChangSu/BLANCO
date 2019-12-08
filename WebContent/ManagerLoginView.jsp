<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">BLANCO</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							LogOut</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>카테고리</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#section1">상품등록</a></li>
					<li><a href="#section2">상품수정</a></li>
					<li><a href="#section3">전체구매 목록 확인</a></li>
					<li><a href="#section4">상품 Q&A답변</a></li>
				</ul>
			</div>

			<div class="col-sm-9">
				<h4>
					<small>RECENT POSTS</small>
				</h4>
				<hr>
				<h2>I Love Food</h2>
				<h5>
					<span class="glyphicon glyphicon-time"></span> Post by Jane Dane,
					Sep 27, 2015.
				</h5>
				<h5>
					<span class="label label-danger">Food</span> <span
						class="label label-primary">Ipsum</span>
				</h5>
				<br>
				<p>Food is my passion. Lorem ipsum dolor sit amet, consectetur
					adipiscing elit, sed do eiusmod tempor incididunt ut labore et
					dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
					exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum consectetur
					adipiscing elit, sed do eiusmod tempor incididunt ut labore et
					dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
					exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat.</p>
				<br>
				<br>

				<h4>
					<small>RECENT POSTS</small>
				</h4>
				<hr>
				<h2>Officially Blogging</h2>
				<h5>
					<span class="glyphicon glyphicon-time"></span> Post by John Doe,
					Sep 24, 2015.
				</h5>
				<h5>
					<span class="label label-success">Lorem</span>
				</h5>
				<br>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat
					cupidatat non proident, sunt in culpa qui officia deserunt mollit
					anim id est laborum consectetur adipiscing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
					minim veniam, quis nostrud exercitation ullamco laboris nisi ut
					aliquip ex ea commodo consequat.</p>
				<hr>

				<h4>Leave a Comment:</h4>
				<form role="form">
					<div class="form-group">
						<textarea class="form-control" rows="3" required></textarea>
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
				</form>
			</div>
		</div>
	</div>



</body>
</html>