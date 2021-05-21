<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="root" value="${pageContext.request.contextPath}"/>    
<!-- 로그인 안했을 경우 index page로 이동 -->
<c:if test="${id == null}">
	<script>
	alert("로그인이 필요한 페이지입니다.\n로그인 페이지로 이동합니다.");
	location.href = "/mem/mvlogin";
	</script>
</c:if>

<!-- 로그인 했을 경우 아래 출력 -->
<c:if test="${id != null}">


<!DOCTYPE html>
<html lang="ko">
<head>
  <title>공지사항 글 작성</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
		function movewrite() {
			location.href="/article/mvwrite";
		}
		
		function searchArticle() {
			if(document.getElementById("word").value == "") {
				alert("모든 목록 조회!!");
			}
			document.getElementById("searchform").action = "/article/search";
			document.getElementById("searchform").submit();
		}
		
		function pageMove(pg) { 
			document.getElementById("pg").value=pg;
			document.getElementById("pageform").action = "/mem/list";
			document.getElementById("pageform").submit();
		}
	</script>
</head>
<body>

<!-- header -->
	<%@ include file="header.jsp"%>
	
	
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="act" id="act" value="list">
		<input type="hidden" name="pg" id="pg" value="">
	</form>
	
	
<div class="container" align="center">

	  <div class="col-lg-8" align="center">
	  <h2>공지 사항</h2>
	  
	  <table class="table table-borderless">
	  	<tr>
	  		<c:if test="${id eq 'admin'}">
	  			<td align="right"><button type="button" class="btn btn-link" onclick="javascript:movewrite();">글쓰기</button></td>
			</c:if>
	  	</tr>
	  </table>
	  
	  
	  <form id="searchform" method="get" class="form-inline" action="">
	  <input type="hidden" name="act" id="act" value="list">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key">
			    <option value="id" selected="selected">아이디</option>
			    <option value="articleno">글번호</option>
			    <option value="subject">제목</option>
			    <option value="content">내용</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="word">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchArticle();">검색</button>
			  <input class="btn btn-primary my-2 my-sm-0" type="submit" value='전체 목록'>
			</td>
	  	</tr>
	  </table>
	  </form>
	  
	  <!-- 작성한 글이 없을경우 출력 -->
	  <c:if test="${list == null }">
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>작성된 글이 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	  </c:if>
	  
	  <!-- 작성한 글이 있을경우 목록출력 -->
	  <c:if test="${list != null }">
	  <table class="table table-active">
				<c:forEach var="list" items="${list}">
				<tr>
					<th>번호</th>
					<td>${list.articleno}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${list.subject}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${list.regtime}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${list.content}</td>
				</tr>
				
				<c:if test="${id eq 'admin' }">
				<tr>
					<td colspan='2' align='center' class='tfoot tspacial'> 
					<a class="btn btn-sm btn-warning mr-2" href="/article/modify?articleno=${list.articleno}">수정</a>
					<a class="btn btn-sm btn-danger mr-2" href="/article/delete?articleno=${list.articleno}">삭제</a>
					</td>
				</tr>
				</c:if>
				
				</c:forEach>

			</table>
			<table align="center">
	  			<tr>
	  				<td>${navigation.navigator}</td>
	  			</tr>
	  		</table>
	  </c:if>
	  
	  	

	  </div>
	</div>


<!-- footer -->
<%@ include file="footer.jsp"%>
</body>
</html>
</c:if>