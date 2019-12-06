<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     		 width:70%;
             height: 150px;
             border: solid 1px red;
             position: relative;
        	}
     section {
     		border:solid 1px black;
     		width:100%;
     		height: 700px;
     		margin:0;
     }
     footer {
     		border:solid 1px blue;
     		width:70%;
     		height:100px;
     		text-align:center;
     }
     
     #logo {
     		text-align:center;
     		width:100%;
     		height:30%;
     }
     
     #middlebox {
     	border:solid 1px orange;
     	width:70%;
     	height:30px;
     }
     
     #logUI {
     	float:left;
     }
      
     #searchBar {
     	float:right;
     }
     #previous {
     	width:10%;
     	height:100%;
     	margin:0;
     	float:left;
     }
     #next {
     	height:100%;
     	float:right;
     }
     
     #box50 {
    	 height: 50%;
     }
     
     #itemlist {
     	border:solid 1px black;
     	text-align:center;
     	width:70%;
     	height:100%;
     }
</style>

</head>
	<body>
		<header>
			<div id="logo">
				BLANCO
			</div>
		</header>
		
		<nav id="middlebox">
			<nav id="logUI">
				<c:if test="${empty login}"> 
					<jsp:include page="guest/logon/gLoginForm.jsp"/>
				</c:if>
				<c:if test="${login == 1 }">
					<jsp:include page="seller/sloginForm.jsp"/>
				</c:if> 
			</nav>
			
			<nav id="searchBar">
				<label for="search">검색 : </label><input type="text" id="search" size="30" maxlength="60">
			</nav>
		</nav>
		
		<section>
			<article id="previous">
				<div id="box50"></div>
				<input type="button" value="이전">
			</article>
			<aside id="next">
				<div id="box50"></div>
				<input type="button" value="다음">
			</aside>
			<article id="itemlist">
				
			</article>
			
		</section>
		
			<footer>footer</footer>
	</body>
</html>