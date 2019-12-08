<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/site.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BLANCO</title>
</head>
	<body>
		<div class="jumbotron text-center">
	  		<h1>BLANCO</h1>
		 	<input type="text" size="15" maxlength="50" placeholder="아이디">
			<input type="text" size="15" maxlength="50" placeholder="비밀번호">
			<button type="button" class="btn btn-primary">로그인</button>
			<button type="button" class="btn btn-primary">회원가입</button>
		</div>
  
		<div class="container">
			<ul class="nav nav-pills">
			    <li class="active"><a href="#">Home</a></li>
			    <li><a href="#">세면도구</a></li>
			    <li><a href="#">휴지/물티슈/생리대</a></li>
			    <li><a href="#">욕실도구</a></li>
			    <li><a href="#">주방/세제</a></li>
	 		 </ul>
		
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="/BLANCO/images/image1.jpg" alt="Los Angeles" width="460" height="345">
        <div class="carousel-caption">
          <h3>이제는 주방용품도 고급스럽게</h3>
          <p>made in korea</p>
        </div>
      </div>

      <div class="item">
        <img src="/BLANCO/images/image2.jpg" alt="Chicago" width="460" height="345">
        <div class="carousel-caption">
          <h3>편하게 눌러 사용하는 치약</h3>
          <p>made in korea</p>
        </div>
      </div>
    
      <div class="item">
        <img src="/BLANCO/images/image3.jpg" alt="New York" width="460" height="345">
        <div class="carousel-caption">
          <h3>향기 가득한 빨래</h3>
          <p>made in korea</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

	</body>
</html>