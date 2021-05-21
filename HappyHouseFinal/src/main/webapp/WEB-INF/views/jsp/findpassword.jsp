<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<title>Happy House | 비밀번호 찾기</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style>
		#head {
			width: 450px;
		}
		
		form {
			margin: 0 auto;
			padding: 20px;
			width: 400px;
			text-align: center;
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

			<!-- 비밀번호 찾기 -->
			<article class="col-sm-8">
				<!-- 비밀번호 찾기 창-->
				<h3 class="text-secondary">${mem.id}</h3>
				<div id="head" class="border rounded">
					<form method="post" action="/mem/findpassword" class="container-container-fluid">
					<table class="table">
						<thead>
							<tr>
								<td class="caption" colspan='2'>비밀번호 찾기</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class='tbasic'>아 이 디</td>
								<td class='tbasic'><input type='text' name='id' id='id' value=""></td>
							</tr>
							<tr>
								<td class='tbasic'>이 &nbsp;름</td>
								<td class='tbasic'><input type='text' name='name' id='name'
									value=""></td>
							</tr>
							<tr>
								<td class='tbasic'>이메일</td>
								<td class='tbasic'><input type='text' name='email' id='email' value="">
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan='2' align='center' class='tfoot tspacial'>
									<input class="btn btn-outline-primary" type="submit" value='검색'>
									<a href="/" class="btn btn-outline-secondary">취소</a></td>
							</tr>
						</tfoot>
					</table>
					<c:if test="${msg != null}">
						<span class="text-danger">${msg}</span>
					</c:if>
					</form>
				</div>
			</article>

			
		</div>
	</section>

	<!-- footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>