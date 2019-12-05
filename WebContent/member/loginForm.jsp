<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	atricle {
		display : inline-block;
	}
	
	span {
		width : 300px;
		height : 50px;
		margin : 30px;
		padding: 20px;
	}
	
	#loginContainer {
		list-style : none;
		text-align : right;
	}
	h3 {
		text-align : center;
	}
	#menubar {
		text-align : center;
	}
	
	header {
	}
	
	section {
		margin : 30px;
		padding : 30px;
		text-align : center;
	}
	footer {
		text-align : center;
	}
</style>

<header>
	<div id="logview">
	<h3>BLANCO</h3>
		<ul id="loginContainer">
			<li><label for="id">로그인 : </label>
				<input id="id" name="id" type="text" size="10"
				maxlength="50" placeholder="abcd1234">
				<label for="passwd"></label>
				<input id="passwd" name="passwd" type="password"
				size="10" maxlength="20" placeholder="비밀번호 입력하시오">
				<button id="login">로그인</button>
				<button id="register">회원가입</button>
			</li>
		</ul>
		
		<ul id="menubar">
			<a href="#"><span>세면도구</span></a>
			<a href="#"><span>욕실도구</span></a>
			<a href="#"><span>휴지/물티슈/생리대</span></a>
			<a href="#"><span>청소/세탁</span></a>
			<a href="#"><span>수납</span></a>
		</ul>
	</div>
</header>

<section>
	<article>
		<img src="../images/긔여운주황벗서.jpg" width="200" height="200" alt="엄슴">
		<img src="../images/루디브리엄2D.jpg" width="200" height="200" alt="엄슴">
		<img src="../images/커닝시티 2D맵.jpg" width="200" height="200" alt="엄슴">
		<img src="../images/catchar.png" width="200" height="200" alt="엄슴">
	</article>
</section>
<footer>
	footer
</footer>