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
        	}
     section {
     		border:solid 1px black;
     		width:70%;
     		height: 600px;
     		text-align:center;
     }
     footer {
     		border:solid 1px blue;
     		width:100%;
     		height:150px;
     		text-align:center;
     }
     #logo {
     	width:100%;
     	height:100%;
     }
     #log {
     	text-align:left;
     	border:solid 1px black;
     }
</style>

</head>
	<body>
		<header>
			<div id="logo">LOGO</div>
		</header>
		<br>
		<section>
			<div id="log">로그인</div>
		</section>
		<br>
		<footer>footer</footer>
	</body>
</html>