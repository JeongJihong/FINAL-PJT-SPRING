<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.dto.HouseDeal, com.ssafy.dto.EnvCheckDTO, 
    							 com.ssafy.dto.HospitalDTO " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="${request.getContextPath()}"/>

<!DOCTYPE html>
<html>
<head>
	<title>Happy House | Search</title>
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
	<%@ include file="header.jsp"%>
	
	<!-- googlemap -->
	<%@ include file="googlemap.jsp"%>
	
	<!-- search -->
	<section class="container-fluid">
		<c:if test="${envcheck != null}">
			<!-- 환경점검 데이터 -->
			<div class="row mb-2">
				<p class="mb-0">
				  	<button class="btn btn-primary ml-2 mb-1" type="button" data-toggle="collapse" data-target="#envcollapse" aria-expanded="false" aria-controls="envcollapse">
					환경 점검 내역
					</button>
				</p>
				<div class="collapse container-fluid" id="envcollapse">
					<div class="row">
						<c:if test="${fn:length(envcheck) == 0}">
							<div class="card col-sm-3 p-0 m-2">
								<div class="card-header">환경 점검 : 결과 없음</div>
								<div class="card-body">
									<blockquote class="blockquote mb-0">
										<h6>해당하는 검색 결과가 없습니다</h6>
									</blockquote>
								</div>
							</div>
						</c:if>
					
						<c:forEach items="${envcheck}" var="env">
							<c:if test="${env.getHasProblem() != 'Y'}">
						        <div class="card col-sm-3 p-0 m-2 bg-light">
						        	<div class="card-header">환경 점검 : ${env.getCoType()}</div>
				    				<div class="card-body">
				    					<blockquote class="blockquote mb-0">
				    						<h5>${env.getCoName()}</h5>
				    						<h6>주소 : ${env.getCoAddr()}</h6>
				    						<h6>내용 : ${env.getCheckDetail()}</h6>
				    						<h6>날짜 : ${env.getCheckDate()}</h6>
				    						<h6>결과 : 문제 없음</h6>
				    					</blockquote>
				    				</div>
			    				</div>
							</c:if>
							<c:if test="${env.getHasProblem() == 'Y'}">
						        <div class="card col-sm-3 p-0 m-2 bg-danger">
						        	<div class="card-header text-white">환경 점검 : ${env.getCoType()}</div>
				    				<div class="card-body">
				    					<blockquote class="blockquote mb-0">
				    						<h5 class="text-white">${env.getCoName()}</h5>
				    						<h6 class="text-white">주소 : ${env.getCoAddr()}</h6>
				    						<h6 class="text-white">내용 : ${env.getCheckDetail()}</h6>
				    						<h6 class="text-white">날짜 : ${env.getCheckDate()}</h6>
				    						<h6 class="text-white">결과 : 문제 발생</h6>
				    					</blockquote>
				    				</div>
			    				</div>
							</c:if>			
						</c:forEach>
					</div>
				</div>
			</div>
			
			<!-- 병원 데이터 -->
			<div class="row mb-2">
				<p class="mb-0">
				  	<button class="btn btn-primary ml-2 mb-1" type="button" data-toggle="collapse" data-target="#hospitalcollapse" aria-expanded="false" aria-controls="hospitalcollapse">
					국민 안심병원 정보
					</button>
				</p>
				<div class="collapse container-fluid" id="hospitalcollapse">
					<div class="row">
						<c:if test="${fn:length(hospitaldata) == 0}">
							<div class="card col-sm-3 p-0 m-2 bg-success">
								<div class="card-header text-white">국민 안심병원 : 결과 없음</div>
								<div class="card-body">
									<blockquote class="blockquote mb-0">
										<h6 class="text-white">해당하는 검색 결과가 없습니다</h6>
									</blockquote>
								</div>
							</div>
						</c:if>
					
						<c:forEach items="${hospitaldata}" var="hospital">
					        <div class="card col-sm-3 p-0 m-2 bg-success">
					        	<div class="card-header text-white">${hospital.getHname()}</div>
			    				<div class="card-body">
			    					<blockquote class="blockquote mb-0">
			    						<h6 class="text-white">주소 : ${hospital.getHaddr()}</h6>
			    						<h6 class="text-white">tel : ${hospital.getHtel()}</h6>
			    						<c:if test="${hospital.getHtype() == 'A'}">
			    							<h6 class="text-white">진료 : 외래진료</h6>
			    						</c:if>
			    						<c:if test="${hospital.getHtype() == 'B'}">
			    							<h6 class="text-white">진료 : 입원</h6>
			    						</c:if>
			    					</blockquote>
			    				</div>
		    				</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:if>
		<div class="row">
			<c:if test="${fn:length(housedeal) == 0}">
				<div class="card col-sm-2 p-0 m-2">
					<div class="card-header">결과 없음</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<h6>해당하는 검색 결과가 없습니다</h6>
						</blockquote>
					</div>
				</div>
			</c:if>
			<c:forEach items="${housedeal}" var="deal">
    			<div class="card col-sm-2 p-0 m-2">
    				<div class="card-header">${deal.getAptName()}</div>
    				<div class="card-body">
    					<blockquote class="blockquote mb-0">
    						<h6>동 : ${deal.getDong()}</h6>
    						<h6>가격 : ${deal.getDealAmount()}</h6>
    						<h6>날짜 : ${deal.getDealYear()}년 ${deal.getDealMonth()}월 ${deal.getDealDay()}일</h6>
    					</blockquote>
    				</div>
    			</div>
			</c:forEach>
		</div>
	</section>
	
	<!-- footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>