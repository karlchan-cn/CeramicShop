<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style type="text/css">
.container {
	margin-top: 10px;
}

a:focus {
	outline: none;
}

body h1,h2,h3 {
	color: #494949;
}

.navhead {
	border-bottom: 1px dashed #DDDDDD
}

.navhead .nav {
	margin-bottom: 5px;
}

.global-nav {
	background-color: #545652;
	color: #D5D5D5;
	height: 28px;
	min-width: 950px;
}

.navbar-static-top {
	color: #D5D5D5;
}

.navbar-static-top .navbar-inner {
	background-color: #545652;
	background-image: none;
	min-height: 25px;
}

.navbar-static-top .navbar-inner .container {
	margin: 0;
}

#topnavbarcontainer .nav>li>a {
	font-family: Helvetica, ​Arial, ​sans-serif;
	color: #D5D5D5;
	float: none;
	padding: 10px 15px;
	text-decoration: none;
	color: #D5D5D5;
	text-shadow: none;
	line-height: 30px;
	padding-top: 0;
	padding-bottom: 0;
}

.navbar-static-top .navbar-inner .container:before,.navbar-static-top .navbar-inner .container:after
	{
	content: "";
	display: table;
	line-height: 0;
}

.navbar-static-top .navbar-inner .container:after {
	clear: both;
}

.navbar-static-top .navbar-inner .container:before,.navbar-static-top .navbar-inner .container:after
	{
	content: "";
	display: table;
	line-height: 0;
}

.navbar-static-top .navbar-inner .container {
	width: auto;
}

#topnavbarcontainer .nav>li>a:active,#topnavbarcontainer .nav>li>a:hover
	{
	color: #FFFFFF;
}
</style>
<sec:authorize ifAllGranted="ROLE_USER">
	<div class="navbar navbar-static-top">
		<div class="navbar-inner">
			<div class="container" id="topnavbarcontainer">
				<ul class="nav nav-pills">
					<li><a href="/Blog/entity/create">日志</a></li>
					<li class="pull-right"><a
						href="/Blog/j_spring_security_logout">退出登录</a></li>
				</ul>
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
</sec:authorize>
<div class="container navhead">
	<ul class="nav nav-pills">
		<li><a class="brand" href="/Blog/">日记</a></li>
		<li><a href="#">活动</a></li>
		<li><a href="#">联系我们</a></li>
	</ul>
</div>
