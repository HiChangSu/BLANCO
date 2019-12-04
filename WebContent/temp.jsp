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
       }

     header {
     		 width:100%;
             height: 150px;
             border: solid 1px red;
             position: relative;
        	}
     section {
     		border:solid 1px black;
     		width:100%;
     		height: 700px;
     		text-align:center;
     }
     footer {
     		border:solid 1px blue;
     		width:100%;
     		height:100px;
     		text-align:center;
     }
     
     #visual {
     		width:100%;
     		border : solid 1px green;
     }
     #logo {
     		text-align:center;
     }
     #menu {
     		border:solid 1px purple;
     		margin-top:75px;
     		width:100%;
     		height:30px;
     		text-align:center;
     }
     #login {
     		text-align:right;
     }
</style>

</head>
	<body>
		<header>
			<div id="logo">BLANCO</div>
			<div id="login">
				<label for="id">로그인 : </label>
				<input id="id" name="id" type="text" size="20"
				maxlength="50" placeholder="abcd1234">
				<label for="passwd"></label>
				<input id="passwd" name="passwd" type="password"
				size="20" maxlength="20" placeholder="비밀번호 입력하시오">
				<button id="login">로그인</button>
				<button id="register">회원가입</button>
			</div>
				<nav id="menu">
				menuber
				</nav>
		</header>
		<div id="visual">
			<section>
				<article id="art1">article</article>
			</section>
			<footer>footer</footer>
		</div>
	</body>
</html>