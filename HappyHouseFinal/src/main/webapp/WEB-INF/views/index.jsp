<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Happy House | 메인화면</title>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="jsp/header.jsp"%>
	
	<!-- googlemap -->
	<%@ include file="jsp/googlemap.jsp"%>
	
	<!-- main contents -->
	<section id="main-contents" class="container-fluid">
		<!-- content -->
		<div class="row mb-2">
			<!-- AD -->
			<article class="col-sm-4">
				<img src="/img/sideAD.jpg" class="img-thumbnail" alt="ad">
			</article>
			
			<!-- 추천 메뉴 -->
			<article class="col-sm-4">
				<h4>지혜롭게 내집 마련하기</h4>
				<hr class="my-2">
				<ul class="nav flex-column">
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-wallet2 mr-2"></i>가용자금 확인 및 대출 계획</a></li>
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-house-door-fill mr-2"></i>집 증류 및 지역 선택</a></li>
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-graph-up mr-2"></i>정보 수집 & 시세 파악</a></li>
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-zoom-in mr-2"></i>부동산 방문 & 집 구경</a></li>
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-pen mr-2"></i>계약 및 잔금 치르기</a></li>
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-file-earmark-text mr-2"></i>소유권 이전 등기</a></li>
					<li class="nav-item"><a class="nav-link text-muted d-inline" href="#"><i class="bi bi-gear-fill mr-2"></i>인테리어 공사</a></li>
				</ul>
				<hr class="my-2">
			</article>
			
			<!-- 뉴스 -->
			<article class="col-sm-4">
				<h4>오늘의 뉴스</h4>
				<hr class="my-2">
				<h6>서울 아파트. 매매·전세 다른 양상...상승...아시아경제</h6>
				<ul class="nav flex-column">
					<li class="nav-item"><a class="nav-link text-primary d-inline" href="#"><i class="bi bi-dot mr-1 text-muted"></i>서울 입주 2년차 아파트 전셋값 1억400만원 올라<span class="text-muted ml-1">한겨레</span></a></li>
					<li class="nav-item"><a class="nav-link text-primary d-inline" href="#"><i class="bi bi-dot mr-1 text-muted"></i>12·16發 거래한파…매수자가 사라졌다<span class="text-muted ml-1">아시아경제</span></a></li>
					<li class="nav-item"><a class="nav-link text-primary d-inline" href="#"><i class="bi bi-dot mr-1 text-muted"></i>재건축 대안 뜨는 수직증축 리모델링...추진 속...<span class="text-muted ml-1">동아일보</span></a></li>
					<li class="nav-item"><a class="nav-link text-primary d-inline" href="#"><i class="bi bi-dot mr-1 text-muted"></i>고가기준 9억,서울 아파트 중간값 됐다<span class="text-muted ml-1">동아일보</span></a></li>
				</ul>
			</article>
		</div>
	</section>
	
	<!-- footer -->
	<%@ include file="jsp/footer.jsp"%>
</body>
</html>