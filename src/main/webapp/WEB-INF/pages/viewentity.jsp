<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title><c:choose>
		<c:when test="${requestScope.entity == 'all'}">
			所有文章</c:when>
		<c:otherwise>${requestScope.entity.title}</c:otherwise>
	</c:choose></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 导入通用的css ico --><%@ include file="header.jsp"%>
<style type="text/css">
#allcontainer .listTitle {
	background-color: #F2FBF2;
	color: #666666;
	font: 14px/1.8 Arial, Helvetica, sans-serif;
	margin-bottom: 1px;
	margin-left: 4px;
}

.listTime {
	color: #666666;
	font: 12px/150% Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
	<%@ include file="navhead.jsp"%>
	<c:choose>
		<c:when test="${requestScope.entity == 'all'}">
			<div class="container pagecontainer span6"
				id="${requestScope.entity}container">
				<div class="row listItent">
					<div class=" listTitle">
						<a href="#">Google搜索技巧</a> <a>展示全文</a>
					</div>
					<div class=" listTime">2013-11-16 16:31:50</div>
					<div class=" listContent">1.搜索特性按顺序词组,使用双引号. 例如:"Karl
						Lagerfeld"] 2.与或关系搜索词 AND,OR 紧急需要大写 google.com OR bing.com
						google.com AND bing.com 3.搜索相关联内容 例如:related:twitter.com 4.包括不包括
						要搜索红烧,不包括肉 输入:红烧 -肉 搜索包括肉的红烧: 输入:红烧 +肉 5.使用操作符,参考下表 算......</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container pagecontainer span6">
				<div class="row">
					<h3 id="title-preview" class="entity-view-title">${requestScope.entity.title}</h3>
					<div class="entity-view-createtime">
						<span>${requestScope.entity.createdate}</span>
					</div>
				</div>
				<div class="row entity-view-content" id="content-preview">
					<p class="note span6">${requestScope.entity.content}</p>
				</div>
				<div class="row note_upper_footer">
					<span class="pl gtleft">&nbsp;1人浏览</span> <span class="gtleft">&gt;
						<a href="#" class="a_edit_tag">添加标签</a>&nbsp; &nbsp;
					</span> <span class="gtleft">&gt; <a
						href="http://localhost:8081/Blog/entity/edit/${requestScope.entity.id}">修改</a>&nbsp;
						&nbsp;
					</span> <span class="gtleft"> &gt; <a rel="confirm_direct"
						title="删除这篇日记吗?" class="j a_post_link"
						href="http://localhost:8081/Blog/entity/remove/${requestScope.entity.id}">删除</a>
					</span>
				</div>
			</div>

		</c:otherwise>

	</c:choose>

</body>

<!-- 导入通用js  -->
<%@ include file="footer.jsp"%>
<script type="text/javascript">
	$(function() {

		var win = window, controller;

		controller = {

			init : function() {

			}
		};
		if ($('#allcontainer').length > 0) {
			controller.viewtype = 'all';
		}
		win.pageController = controller;
		controller.init();

	});
</script>
</html>
