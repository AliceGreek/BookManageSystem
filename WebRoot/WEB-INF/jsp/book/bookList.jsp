<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书列表</title>

<!-- Bootstrap -->
<link
	href="resource/assets/bootstrap/css/mybootstrap.min.css"
	rel="stylesheet">
<link href="resource/css/common.css" rel="stylesheet">
<link href="resource/css/book-management.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-------------------------content-------------------------->
	<div class="big-title-bg">

		<div class="container">
			<img src="" alt="">
			<div class="big-title">
				<div class="big-title-ch">图书管理系统</div>
				<div class="big-title-en">- BOOKS MANAGEMENT SYSTEM -</div>
			</div>

			<!--搜索框组a-->
			<form action="book/bookQuery.action" method="post">
				<div class="input-group search-group">
					<input type="text" class="form-control" name="bookName"
						value="${searchContent}"> <span class="input-group-btn">
						<button class="btn btn-default" type="submit">搜索</button>
					</span>
				</div>
			</form>
			<a href="book/goAdd.action" class="btn-add"> <span
				class="glyphicon glyphicon-plus"></span>
				<div>新增</div>
			</a>
			<!-- /input-group -->
			
		</div>
		
	</div>

	<div class="container">
		<ul class="book-list">
			<c:forEach items="${bookList}" var="book">
				<li class="row">
					<div class="col-sm-8">
						<div class="book-name">
							${book.name}<span class="book-status status-ok">&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${book.status == 1}">[<span
										class="glyphicon glyphicon-ok"></span>可借阅]</c:if> <c:if
									test="${book.status == 0}">
									<span class="book-status">[不可借阅]</span>
								</c:if>
							</span>
						</div>
						<div class="book-author">${book.name}</div>
						<div class="book-press">${book.author}</div>
						<div class="book-price">￥${book.price}</div>
					</div>
					<div class="col-sm-4 book-btns">
						<a href="book/bookEdit-${book.id}.action">
							<button class="btn btn-default">
								<span class="glyphicon glyphicon-edit"></span>修改
							</button>
						</a> <a href="book/bookDelete-${book.id}.action">
							<button class="btn btn-danger">
								<span class="glyphicon glyphicon-trash"></span> 删除
							</button>
						</a>
					</div>
				</li>
			</c:forEach>
		</ul>

	</div>

	<!-------------------------end-------------------------->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resource/assets/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resource/assets/bootstrap/js/bootstrap.js"></script>
</body>
</html>