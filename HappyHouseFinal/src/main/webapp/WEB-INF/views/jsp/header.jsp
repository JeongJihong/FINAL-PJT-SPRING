<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${request.getContextPath()}"/>

<header>
	<!-- 로그인 메뉴 -->
	<div class="container-fluid navbar-dark bg-dark">
		<nav class="navbar navbar-expand-sm justify-content-end">
			<c:if test="${id == null}">
				<div id="nav-default">
					<div class="navbar-collapse">
						<ul class="navbar-nav">
							<li class="nav-item"><a href="/mem/mvlogin" class="btn btn-sm btn-outline-light mr-2">Log in</a></li>
							<li class="nav-item"><a href="/mem/mvinsertmember" class="btn btn-sm btn-outline-light mr-2">Sign up</a></li>
							<li class="nav-item"><a href="/mem/mvfindpassword" class="btn btn-sm btn-outline-light mr-2">비밀번호 찾기</a></li>
						</ul>
					</div>
				</div>
			</c:if>
			<c:if test="${id != null}">
				<div id="nav-login">
					<div class="navbar-collapse">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="logout-btn btn btn-sm btn-outline-light mr-2" href="/mem/logout">Logout</a></li>
							<li class="nav-item"><a class="btn btn-sm btn-outline-light mr-2" href="/mem/mvuserinfo">회원정보</a></li>
							<li class="nav-item"><a class="btn btn-sm btn-outline-danger mr-2" href="/mem/delete">회원탈퇴</a></li>
						</ul>
					</div>
				</div>
			</c:if>
		</nav>
	</div>

	<!-- nav 메뉴 -->
	<div class="container-fluid" style="height:100 px;">
		<nav class="navbar navbar-expand-sm">
			<a class="nav-link text-dark" href="/"><i class="bi bi-house-fill" style="font-size:40px"></i></a>
		
			<div class="header_nav_menu navbar-collapse justify-content-end">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="btn mr-2" href="/article/list">공지 사항</a></li>
					<li class="nav-item"><button type="button" class="btn mr-2">오늘의 뉴스</button></li>
					<li class="nav-item"><button type="button" class="btn mr-2">주변 탐방</button></li>

				</ul>
				<div style="display:none;">
					<ul>
						<li class="nav-item"><button type="button" class="btn mr-2 favorarea" style="display:none;">관심 지역 설정</button></li>
						<li class="nav-item"><button type="button" class="btn mr-2 favorarea" >관심 지역 둘러보기</button></li>
					</ul>
				</div>						
						

				<div class="nav-item">
					<form method="post" action="/search/aptname">
						<div class="form-inline">
							<input type='text' name='searchtext' id='searchtext' class="form-control mr-sm-2" placeholder="아파트 이름">
	 						<input class="btn btn-outline-secondary my-2 my-sm-0" type="submit" value='Search'>
						</div>
					</form>
				</div>
			</div>
		</nav>
	</div>
	<!-- header 타이틀 -->
	<div class="jumbotron jumbotron-fluid to-post-list" style="background-image:url(/img/jumbo_img.jpg);">
		<div class="container-fluid text-center">
  			<h2><a href="/" style="color:white; text-decoration:none"><b>HAPPY HOUSE</b></a></h2>
  			<hr class="my-4">
  			<h6 class="text-white">행복한 우리 집</h6>
  		</div>
	</div>
</header>