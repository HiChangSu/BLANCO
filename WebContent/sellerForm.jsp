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
        	}
     section {
     		border:solid 1px black;
     		width:100%;
     		height: 700px;
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
     #detailMenu {
     	border:solid 1px black;
     	width:10%;
     	height:100%;
     	margin:0;
     	float:left;
     }
     #content {
     	border:solid 1px black;
     	width:89%;
     	height:100%;
     	float:right;
     }
</style>

</head>
	<body>
		<header>
			<div id="member">
				<input type="button" value="로그아웃">
				<input type="button" value="고객센터">
			</div>
			<div id="menu">
				<a href="#">상품관리</a>
				<a href="#">주문관리</a>
				<a href="#">고객관리</a>
				<a href="#">게시판 관리</a>
				<a href="#">상점관리</a>
			</div>
		</header>
		
		<section>
			<article id="detailMenu">
			상세메뉴
			</article>
			<aside id="content">
			내용
			</aside>
		</section>
		<footer>
			footer
		</footer>
	</body>
</html>