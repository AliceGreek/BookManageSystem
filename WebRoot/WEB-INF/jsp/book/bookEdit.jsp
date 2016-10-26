<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
<head>
<base href="${pageContext.request.contextPath}/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书编辑</title>

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

	<div class="container">

		<div class="page-title">${formTitle}</div>

		<form role="form" class="book-form" action="book/bookAdd.action"
			method="post">
			<input value="${selectByPrimaryKey.id}" class="form-control" name="id"
			type="hidden">

			<div class="form-group">
				<label for="exampleInputEmail1">书名</label> <input
					value="${selectByPrimaryKey.name}" class="form-control"
					id="exampleInputEmail1" placeholder="书名" name="name">
			</div>

			<div class="form-group">
				<label for="exampleInputPassword1">作者</label> <input
					value="${selectByPrimaryKey.author}" class="form-control"
					id="exampleInputPassword1" placeholder="作者" name="author">
			</div>

			<div class="form-group">
				<label for="exampleInputFile">出版社</label> <input
					value="${selectByPrimaryKey.press}" class="form-control"
					id="exampleInputPassword1" placeholder="出版社" name="press">
			</div>

			<div class="form-group">
				<label for="exampleInputFile">价格</label> <input class="form-control"
					value="${selectByPrimaryKey.price}" id="exampleInputPassword1"
					placeholder="价格" name="price">
			</div>

			<div class="form-group">
				<label for="exampleInputFile">是否可被借阅</label> <select
					class="form-control" name="status">
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
			</div>

			<button type="submit" class="btn btn-default">确定</button>
		</form>


	</div>
	<!-------------------------end-------------------------->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resource/assets/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resource/assets/bootstrap/js/bootstrap.js"></script>
</body>
</html>