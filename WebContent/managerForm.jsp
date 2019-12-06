<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	 * {
        margin: 0 auto;
        padding: 0;
       }

     ul li {
            list-style: none;
           }

     a {
        text-decoration: none;
        color:black;
       }

     header {
     		 width:100%;
             height: 100px;
             border: solid 1px red;
             text-align:center;
             margin-top:200px;
        	}
     section {
     		border:solid 1px black;
     		width:70%;
     		height: 200px;
     		text-align:center;
     }
     footer {
     		border:solid 1px blue;
     		width:100%;
     		height:100px;
     		text-align:center;
     }
     #logo {
     	width:100%;
     	height:100%;
     }
     #log {
     	text-align:left;
     	border:solid 1px black;
     	width:100%;
     }
     #seller {
     	border:solid 1px black;
     	width:48%;
     	height:85%;
     	float:left;
     }
     #manager {
     	border:solid 1px black;
     	width:48%;
     	height:85%;
     	float:right;
     }
     .user {
     	border:solid 1px black;
     }
     .logwindow {
     	width:80%;
     	height:100%;
     	text-align:center;
     	margin-top:50px;
     }
</style>

</head>
	<body>
		<header>
			<div id="logo">LOGO</div>
		</header>
		<br>
		<section>
		
			<div id="log">
				로그인
			</div>
			
			<article id="seller">
					<div class="user">판매자 로그인</div>
					<div class="logwindow">
						<input type="text" size="20" maxlength="50" placeholder="아이디">
						<label><input type="checkbox" name="idbox" value="아이디저장">저장</label>
						<br>
						<input type="text" size="20" maxlength="50" placeholder="비밀번호">
						<input type="button" id="loginbutton" name="loginbutton" value="로그인">
 					</div>
 			</article>
			
			<article id="manager">
					<div class="user">관리자 로그인</div>
					<div class="logwindow">
						<input type="text" size="20" maxlength="50" placeholder="아이디">
						<label><input type="checkbox" name="idbox" value="아이디저장">저장</label>
						<br>
						<input type="text" size="20" maxlength="50" placeholder="비밀번호">
						<input type="button" id="loginbutton" name="loginbutton" value="로그인">
 					</div>
			</article>
			
		</section>
		<br>
		<footer>footer</footer>
	</body>
</html>