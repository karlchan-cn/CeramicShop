<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>这儿 &middot; 注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 导入通用的css ico --><%@ include file="header.jsp"%>
<style type="text/css">
body {
	padding-top: 20px;
	/**background-color: #f5f5f5; **/
}

h1 {
	font-family: "Arial,Helvetica,sans-serif";
	font-size: 25px;
	line-height: normal;
	font-weight: 700;
	color: #494949;
}

.navhead {
	border-bottom: 1px dashed #DDDDDD
}

.navhead .nav {
	margin-bottom: 5px;
}

#container {
	font-family: "Arial,Helvetica,sans-serif";
}

#name-help {
	font-size: 12px;
	margin-top: 5px;
}

#form-welcome {
	margin: 15px 0 15px 30px;
}
</style>
</head>
<body>
	<div class="container navhead">
		<ul class="nav nav-pills">
			<li class="active"><a href="/Blog/">日记</a></li>
			<li><a href="#">活动</a></li>
			<li><a href="#">联系我们</a></li>
		</ul>
	</div>
	<div class="container" id="container">
		<div class='row'>
			<h1 class="span12 offset1" id="form-welcome">欢迎加入这儿</h1>
			<form class="form-horizontal" action="adduser" method="POST">
				<div class="control-group">
					<label class="control-label" for="email"> 邮箱 </label>
					<div class="controls">
						<input type="text" id="email" name="email">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password"> 密码 </label>
					<div class="controls">
						<input type="password" id="password" name="password">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name"> 名号 </label>
					<div class="controls">
						<input type="text" id="name" name="name"><span
							id="name-help" class="help-block">第一印象很重要，起个响亮的名号吧</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="location"> 常居地 </label>
					<div class="controls">
						<input type="text" id="location" name="location">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="code"> 验证码 </label>
					<div class="controls error">
						<input type="text" class="input-mini" id="code" name="code">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<label class="checkbox" id="check-protocol"> <input
							type="checkbox">我已经认真阅读并同意这儿的《使用协议》
						</label>
						<button type="submit" class="btn" disabled="disabled">注册</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /container -->
</body>

<!-- 导入通用js  -->
<%@ include file="footer.jsp"%>
<script type="text/javascript">
	/**
	template
	$(function() {
		var win = window, controller;
		controller = {
			init : function() {

			}
		};
		win.pageController = controller;
	});
	 **/
	
	$(function() {
		var win = window, controller;
		controller = {
			init : function() {
				var check_protocol = $('#check-protocol');
				check_protocol.bind("click", function() {
					alert("check");
				});
			}
		};
		win.pageController = controller;
		controller.init();
	});
</script>
</html>
