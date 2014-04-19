<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>登陆 &middot;Blog</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 导入通用的css ico --><%@ include file="header.jsp"%>

<style type="text/css">
.form-horizontal .form-group {
	margin-bottom: 10px;
}

.form-horizontal .form-group .col-sm-5 img {
	height: 40px;
}

.form-horizontal .form-group .changeimage {
	font-size: 12px;
	display: inline;
	position: relative;
	top: 10px;
}

.form-horizontal .text-error {
	color: #FE2617;
	line-height: 19.2px;
	font-size: 12px;
}

.form-horizontal #changeimagebtn {
	
}

.form-horizontal .mutedlabel {
	font-size: 12px;
	color: #666666;
	line-height: 19.2px;
	font-size-adjust: none;
}

a:hover {
	background: none repeat scroll 0 0 #3377AA;
	color: #FFFFFF;
	text-decoration: none;
}
</style>
</head>
<body>
	<!-- 导入navhead --><%@ include file="navhead.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form class="form-signin form-horizontal"
					action="/Blog/j_spring_security_check" id="signinform"
					method="POST">
					<div class="form-group">
						<h1 class="col-sm-3 control-label">登录后台</h1>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-5">
							<label class="text-error" for="errormsg">
								${requestScope.SPRING_SECURITY_LAST_EXCEPTION} </label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="j_username">用户名</label>
						<div class="col-sm-5">
							<input type="text" name="j_username" id="j_username"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="j_password">密码</label>
						<div class="col-sm-5">
							<input type="password" id="j_password" name="j_password"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<img src="/Blog/user/securitycode" id="securitycodeimg">
							<p class="text-muted changeimage">
								看不清？<a href="" id="changeimagebtn">换一个</a>
							</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label text-muted mutedlabel"
							for="securitycode">验证码</label>
						<div class="col-sm-3">
							<input type="text" id="securitycode" name="securitycode"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox text-muted mutedlabel">
								<label> <input type="checkbox">记住我
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">登陆</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

<!-- 导入通用js  -->
<%@ include file="footer.jsp"%>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/additional-methods.js"></script>
<script type="text/javascript">
	$(function() {
		var win = window, controller;
		controller = {
			j_username : $('#j_username'),
			j_password : $('#j_password'),
			securitycode : $('#securitycode'),
			init : function() {
				//$('#signinform').submit(this.checkform());
				$('#changeimagebtn').click(function() {
					var securitycodeimg = $('#securitycodeimg');
					securitycodeimg.attr({
						src : "/Blog/user/securitycode?" + new Date().getTime()
					});
					return false;
				});
				$('#signinform').validate({
					rules : {
						j_username : {
							required : true
						},
						j_password : {
							required : true
						},
						securitycode : {
							required : true
						}
					},
					messages : {
						j_username : {
							required : "请输入用户名"
						},
						j_password : {
							required : "请输入密码"
						},
						securitycode : {
							required : "请输入验证码 "
						}
					},
					errorElement : "span",
					errorClass : "help-inline text-error"
				/**
				showErrors : function(errorMap, errorList) {
					var errorCount = errorList.length, error, messageLabel;
					//"<span class='help-inline'>Inline help text</span>";
					while (errorCount--) {
						error = errorList[errorCount];
						messageLabel = $(error.element)
								.siblings(
										"[class='help-inline']");
						if (messageLabel.length == 0) {
							$(error.element)
									.parent()
									.append(
											"<span class='help-inline error'>"
													+ error.message
													+ "</span>");
						} else {
							messageLabel
									.text(error.message);
						}
					}
				}**/
				});
			}
		};
		win.pageController = controller;
		controller.init();

	});
</script>

</html>
