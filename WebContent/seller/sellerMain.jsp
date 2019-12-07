<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/BLANCO/js/jquery-3.4.1.min.js"></script>
<script src="/BLANCO/sellerMain.js"></script>
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
				<c:if test="${empty sessionScope.id}">
  					<ul>
       					<li>
       						<label for="id">아이디
       							<input id="id" name="id" type="email" size="20" maxlength="50" placeholder="example@kings.com">
       						</label>
           					<label for="passwd">비밀번호
           						<input id="passwd" name="passwd" type="password" size="20" placeholder="6~16자 숫자/문자" maxlength="16">
           					</label>           					          
           					<button id="login">로그인</button>
           					<button id="create">회원가입</button>
           					<button id="inquiry">고객센터</button>
           				</li>
    				</ul>
				</c:if>
				<c:if test="${!empty sessionScope.id}">
  					<ul>
       					<li>
       						<label for="">
       							관리자 페이지에 오신것을 환영합니다.
       						</label>
           					<button id="logout">로그아웃</button>
           				</li>
    				</ul>
				</c:if>
			</div>
			<div id="menu">
				<c:if test="${!empty sessionScope.id}">
  					<div id="mList">
     					<ul>
					    	<li>상품관련 작업
					    	<li><button id="registProduct">상품등록</button>
					    	<li><button id="updateProduct">상품수정/삭제</button>
					    </ul>
					     <ul>
					        <li>구매된 상품관련 작업
					        <li><button id="orderedProduct">전체구매목록 확인</button>
					     </ul>
     					<ul>
        					<li>상품 QnA 작업
        					<li><button id="qna">상품 QnA답변</button>
     					</ul>
  					</div>
				</c:if>     
<!-- 				<a href="#">상품관리</a> -->
<!-- 				<a href="#">주문관리</a> -->
<!-- 				<a href="#">게시판 관리</a> -->
<!-- 				<a href="#">상점관리</a> -->
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