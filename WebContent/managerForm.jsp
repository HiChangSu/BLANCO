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
             height: 150px;
             border: solid 1px red;
             text-align:center;
             margin-top:200px;
        	}
     section {
     		border:solid 1px black;
     		width:100%;
     		height: 400px;
     		position: relative;
     		margin:0;
     }
     footer {
     		border:solid 1px blue;
     		width:100%;
     		height:100px;
     		text-align:center;
     }
     
     #member {
     	text-align:right;
     	height:85%;
     	margin:0;
     }
     
     #menu {
     	border:solid 1px black;
     	text-align:center;
     	margin:0;
     }
     #menu a {
     	width:100px;
     	margin:20px;
     	padding:20px;
     }
     #guest {
     	border:solid 1px black;
     	width:48%;
     	height:100%;
     	margin:0;
     	float:left;
     	text-align:center;
     }
     #seller {
     	border:solid 1px black;
     	width:48%;
     	height:100%;
     	float:right;
     	text-align:center;
     }
     body {
     	width:70%;
     }
     .member {
     	width:100%;
     	height:100%;
     }
     #welcome {
     	padding-top:70px;
     }
</style>

</head>
	<body>
		<header>
		<p id="welcome">BLANCO에 오신 것을 환영합니다.</p>
		</header>
		
		<section>
			<article id="guest">
			<input type="button" class="member" value="개인 구매회원 가입하기">
			</article>
			<aside id="seller">
			<input type="button" class="member" value="판매자 회원 가입하기">
			</aside>
		</section>
	</body>
</html>