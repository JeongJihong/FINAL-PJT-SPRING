<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="root" value="${pageContext.request.contextPath}"/>    
<!-- 로그인 안했을 경우 index page로 이동 -->
<c:if test="${id == null}">
	<script>
	alert("로그인이 필요한 페이지입니다.\n로그인 페이지로 이동합니다.");
	location.href = "mvlogin";
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
  function writeArticle() {
	if(document.getElementById("subject").value == "") {
		alert("제목을 입력해주세요");
		return;
	} else if(document.getElementById("content").value == "") {
		alert("내용을 입력해주세요");
		return;
	} else {
	  	document.getElementById("writeform").action = "/article/register";
	  	document.getElementById("writeform").submit();
	}
  }
  </script>
</head>
<body>

<!-- header -->
<%@ include file="header.jsp"%>
	
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<c:if test="${artdto eq null}">
			<h2>공지사항 작성</h2>
		</c:if>
		<c:if test="${artdto ne null}">
			<h2>공지사항 수정</h2>
		</c:if>
		
		<form id="writeform" method="post" action="">
		<input type="hidden" name="act" id="act" value="write">
			<div class="form-group" align="left">
				<c:if test="${artdto.articleno == 0}">
					<label for="subject">제목:</label>
					<input type="text" class="form-control" id="subject" name="subject">
				</c:if>
				<c:if test="${artdto.articleno != 0}">
					<label for="subject">제목:</label>
					<input type="text" class="form-control" id="subject" name="subject" value="${artdto.subject}">
				</c:if>
			</div>
			<div class="form-group" align="left">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="15" id="content" name="content">${artdto.content}</textarea>
			</div>
			<c:if test="${artdto eq null}">
				<button type="button" class="btn btn-primary" onclick="javascript:writeArticle();">글작성</button>
			</c:if>
			<c:if test="${artdto ne null}">
				<button type="button" class="btn btn-primary" onclick="javascript:writeArticle();">글수정</button>
			</c:if>
			
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>


<!-- footer -->
<%@ include file="footer.jsp"%>
</body>
</html>
</c:if>