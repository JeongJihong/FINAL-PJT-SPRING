<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<title>LOG IN</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function login() {
			if (document.getElementById("id").value == "") {
				alert("아이디를 입력하세요.");

			} else if (document.getElementById("password").value == "") {
				alert("비밀번호를 입력하세요.");

			} else {
				document.getElementById("loginform").action = "/mem/login";
				document.getElementById("loginform").submit();
			}
		}
	</script>
	<style>
		#loginform {
			margin: 0 auto;
			padding: 20px;
			width: 400px;
			text-align: center;
		}
		
		#loginform label {
			width: 100px;
		}
		
		#loginform input {
			width: 240px;
		}
	</style>

</head>
<body>
	<!-- header -->
	<%@ include file="header.jsp"%>

	<!-- main contents -->
	<section id="main-contents" class="container-fluid">
		<!-- content -->
		<div class="row mb-2">
			<!-- AD -->
			<article class="col-sm-4">
				<img src="/img/sideAD.jpg" class="img-thumbnail" alt="ad">
			</article>

			<!-- 로그인 -->
			<article class="col-sm-8">

				<form id="loginform" class="border rounded container-fluid" method="post" action="">
					<h4>Login</h4>
					<div class="form-group">
						<label for="usr">ID </label>
						<input type="text" name="id" id="id" />
					</div>
		          	<div class="form-group">
		          		<label for="pwd">Password </label>
		          		<input type="text" name="password" id="password" />
		          	</div>
		          	<c:if test="${msg != null}">
						<div class="text-danger">${msg}</div>
					</c:if>
		          	<div class="form-group">
		          		<button class="btn btn-primary" onclick="javascript:login();">로그인 </button>
						<a class="btn btn-secondary" href="/">메인으로</a>
		          	</div>
				</form>

			</article>


		</div>
	</section>

	<!-- footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>