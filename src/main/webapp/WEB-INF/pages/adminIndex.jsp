<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>这儿 &middot; 首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 导入通用的css ico --><%@ include file="header.jsp"%>
<style type="text/css">
*:before,*:after {
	-moz-box-sizing: border-box;
}

*:before,*:after {
	-moz-box-sizing: border-box;
}

.nav-tabs>li>a {
	border: 1px solid rgba(0, 0, 0, 0);
	border-radius: 4px 4px 0 0;
	line-height: 1.42857;
	margin-right: 2px;
}

.nav>li>a {
	display: block;
	padding: 10px 15px;
	position: relative;
}

a {
	color: #428BCA;
	text-decoration: none;
	background: none repeat scroll 0 0 rgba(0, 0, 0, 0);
}

* {
	-moz-box-sizing: border-box;
}

.nav {
	list-style: none outside none;
}

body {
	color: #333333;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 13px;
	line-height: 1.42857;
}

html {
	font-size: 62.5%;
	font-family: sans-serif;
}
</style>

<style type="text/css">
.bs-sidebar.affix {
	position: static;
}

.bs-sidenav { /**background-color: #F7F5FA;
	border-radius: 5px;**/
	font-size: 13px;
	margin-bottom: 30px;
	margin-top: 30px;
	padding-bottom: 10px;
	padding-top: 10px;
	text-shadow: 0 1px 0 #FFFFFF;
	margin-bottom: 30px;
}

.bs-sidebar .nav>li>a {
	color: #716B7A;
	display: block;
	padding: 5px 20px;
}

.bs-sidebar .nav>li>a:hover,.bs-sidebar .nav>li>a:focus {
	background-color: #E5E3E9;
	border-right: 1px solid #DBD8E0;
	text-decoration: none;
}

.bs-sidebar .nav>.active>a,.bs-sidebar .nav>.active:hover>a,.bs-sidebar .nav>.active:focus>a
	{
	background-color: rgba(0, 0, 0, 0);
	border-right: 1px solid #563D7C;
	color: #563D7C;
	font-weight: bold;
}

.bs-sidebar .nav .nav {
	display: none;
	margin-bottom: 8px;
}

.bs-sidebar .nav .nav>li>a {
	font-size: 90%;
	padding-bottom: 3px;
	padding-left: 30px;
	padding-top: 3px;
}

@media ( min-width : 992px) {
	.bs-sidebar .nav>.active>ul {
		display: block;
	}
	.bs-sidebar.affix,.bs-sidebar.affix-bottom {
		width: 213px;
	}
	.bs-sidebar.affix {
		position: fixed;
		top: 80px;
	}
	.bs-sidebar.affix-bottom {
		position: absolute;
	}
	.bs-sidebar.affix-bottom .bs-sidenav,.bs-sidebar.affix .bs-sidenav {
		margin-bottom: 0;
		margin-top: 0;
	}
}

@media ( min-width : 1200px) {
	.bs-sidebar.affix-bottom,.bs-sidebar.affix {
		width: 263px;
	}
}

.sub-menu {
	display: none
}

.sub-menu li {
	text-indent: 35px
}

.postsbox-nav li a {
	padding-left: 0;
	padding-right: 0;
}
/**
**Uplad area CSS
**/
.upload-area {
	border: 4px dashed #BBBBBB;
	height: 200px;
	margin-bottom: 0;
}

.drag-over {
	border-color: #83B4D8;
}

#upload-area.in {
	border-color: #83B4D8;
}

#upload-area.hover {
	border-color: #83B4D8;
}

#upload-area.fade {
	-webkit-transition: all 0.3s ease-out;
	-moz-transition: all 0.3s ease-out;
	-ms-transition: all 0.3s ease-out;
	-o-transition: all 0.3s ease-out;
	transition: all 0.3s ease-out;
	opacity: 1;
}

.upload-area .drag-drop-inside {
	margin: 70px auto 0;
	width: 250px;
}

.upload-area .drag-drop-inside p,.drag-drop-inside p.drag-drop-buttons {
	display: block;
}

.drag-drop-inside p.drag-drop-info {
	font-size: 20px;
}

.upload-area .drag-drop-inside p {
	text-align: center;
}

.drag-drop-inside p {
	color: #AAAAAA;
	font-size: 14px;
	margin: 5px 0;
}

.upload-area .drag-drop-inside p {
	text-align: center;
}

.drag-drop-buttons input {
	cursor: pointer;
	direction: ltr;
	font-size: 20px;
	margin: 0;
	opacity: 0;
	position: absolute;
	right: 405px;
	top: 150px;
	width: 70px;
}
/**
**uploaded items
**/
.media-item {
	border-bottom-style: solid;
	border-bottom-width: 1px;
	min-height: 36px;
	border-color: #DFDFDF;
}

.media-item .pinkynail {
	float: left;
	margin: 2px 10px 0 0;
	max-height: 32px;
	max-width: 40px;
}

.media-item div {
	padding: 0;
}

.media-item .filename,.media-item .error-msg {
	line-height: 36px;
	color: #444444;
	font-size: 13px;
}

div.error,.login #login_error {
	background: none repeat scroll 0 0 #FFFFFF;
	border-left: 4px solid #DD3D36;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.1);
}

/**
** end of uploaded items
**/
</style>
<style type="text/css">
/**
** start of form css
**/
form .form-group label strong {
	font-size: 13px;
	line-height: 1.5;
	cursor: pointer;
	color: #777777;
}

form .form-group textarea {
	resize: vertical;
}

/**
** submit div style sheet
**/
.submitdiv {
	background-color: #F9F9F9;
}
</style>

<style type="text/css">
div.dataTables_length label {
	float: left;
	text-align: left;
}

div.dataTables_length select {
	width: 75px;
}

div.dataTables_filter label {
	float: right;
}

div.dataTables_info {
	padding-top: 8px;
}

div.dataTables_paginate {
	float: right;
	margin: 0;
}

table.table {
	clear: both;
	margin-bottom: 6px !important;
	max-width: none !important;
}

table.table thead .sorting,table.table thead .sorting_asc,table.table thead .sorting_desc,table.table thead .sorting_asc_disabled,table.table thead .sorting_desc_disabled
	{
	cursor: pointer;
	*cursor: hand;
}

table.table thead .sorting {
	background: url('/Blog/assets/images/sort_both.png') no-repeat center
		right;
}

table.table thead .sorting_asc {
	background: url('/Blog/assets/images/sort_asc.png') no-repeat center
		right;
}

table.table thead .sorting_desc {
	background: url('/Blog/assets/images/sort_desc.png') no-repeat center
		right;
}

table.table thead .sorting_asc_disabled {
	background: url('/Blog/assets/images/sort_asc_disabled.png') no-repeat
		center right;
}

table.table thead .sorting_desc_disabled {
	background: url('/Blog/assets/images/sort_desc_disabled.png') no-repeat
		center right;
}

table.dataTable th:active {
	outline: none;
}

/* Scrolling */
div.dataTables_scrollHead table {
	margin-bottom: 0 !important;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

div.dataTables_scrollHead table thead tr:last-child th:first-child,div.dataTables_scrollHead table thead tr:last-child td:first-child
	{
	border-bottom-left-radius: 0 !important;
	border-bottom-right-radius: 0 !important;
}

div.dataTables_scrollBody table {
	border-top: none;
	margin-bottom: 0 !important;
}

div.dataTables_scrollBody tbody tr:first-child th,div.dataTables_scrollBody tbody tr:first-child td
	{
	border-top: none;
}

div.dataTables_scrollFoot table {
	border-top: none;
}

/*
 * TableTools styles
 */
.table tbody tr.active td,.table tbody tr.active th {
	background-color: #08C;
	color: white;
}

.table tbody tr.active:hover td,.table tbody tr.active:hover th {
	background-color: #0075b0 !important;
}

.table-striped tbody tr.active:nth-child(odd) td,.table-striped tbody tr.active:nth-child(odd) th
	{
	background-color: #017ebc;
}

table.DTTT_selectable tbody tr {
	cursor: pointer;
	*cursor: hand;
}

div.DTTT .btn {
	color: #333 !important;
	font-size: 12px;
}

div.DTTT .btn:hover {
	text-decoration: none !important;
}

ul.DTTT_dropdown.dropdown-menu a {
	color: #333 !important;
	/* needed only when demo_page.css is included */
}

ul.DTTT_dropdown.dropdown-menu li:hover a {
	background-color: #0088cc;
	color: white !important;
}

/* TableTools information display */
div.DTTT_print_info.modal {
	height: 150px;
	margin-top: -75px;
	text-align: center;
}

div.DTTT_print_info h6 {
	font-weight: normal;
	font-size: 28px;
	line-height: 28px;
	margin: 1em;
}

div.DTTT_print_info p {
	font-size: 14px;
	line-height: 20px;
}

/*
 * FixedColumns styles
 */
div.DTFC_LeftHeadWrapper table,div.DTFC_LeftFootWrapper table,table.DTFC_Cloned tr.even
	{
	background-color: white;
}

div.DTFC_LeftHeadWrapper table {
	margin-bottom: 0 !important;
	border-top-right-radius: 0 !important;
	border-bottom-left-radius: 0 !important;
	border-bottom-right-radius: 0 !important;
}

div.DTFC_LeftHeadWrapper table thead tr:last-child th:first-child,div.DTFC_LeftHeadWrapper table thead tr:last-child td:first-child
	{
	border-bottom-left-radius: 0 !important;
	border-bottom-right-radius: 0 !important;
}

div.DTFC_LeftBodyWrapper table {
	border-top: none;
	margin-bottom: 0 !important;
}

div.DTFC_LeftBodyWrapper tbody tr:first-child th,div.DTFC_LeftBodyWrapper tbody tr:first-child td
	{
	border-top: none;
}

div.DTFC_LeftFootWrapper table {
	border-top: none;
}
</style>
</head>
<body data-spy="scroll" data-target=".navbar-example">
	<!-- 导入navhead --><%@ include file="navhead.jsp"%>
	<div class="container" id="content">
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked" style="margin-top: 15px">
					<li><a href="#" class="pitem">日记</a>
						<ul class="nav nav-pills nav-stacked sub-menu">
							<li><a href="#">日记列表</a></li>
							<li><a href="#">新增日记</a></li>
							<li><a href="#">分类列表</a></li>
							<li><a href="#">标签列表</a></li>
						</ul></li>
					<li><a href="#" class="pitem">用户</a>
						<ul class="nav nav-pills nav-stacked sub-menu">
							<li><a href="#">用户列表</a></li>
							<li><a href="#">增加用户</a></li>
							<li><a href="#">我的资料</a></li>

						</ul></li>
					<li><a href="#" class="pitem">多媒体</a>
						<ul class="nav nav-pills nav-stacked sub-menu">
							<li><a href="#">媒体库</a></li>
							<li><a href="#">添加</a></li>
						</ul></li>
				</ul>

			</div>

			<div class="col-md-10" role="main">
				<div id="entities-region">
					<div class="row">
						<div class="col-md-6" role="main">
							<h2>
								文章<small><a href="#" class="btn  btn-sm">新增</a></small>
							</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<ul id="entityTab" class="nav nav-tabs">
								<li><a href="" id="allEntities" class="">全部<span>(12)</span></a></li>
								<li class="active"><a id="releasedEntities" href=""
									class="">已发布<span>(11)</span></a></li>
								<li><a id="draftEntities" href="" class="">草稿<span>(1)</span></a></li>
							</ul>
						</div>
						<div class="col-md-12">
							<table class="table table-striped" id="EntitiesTable">
								<thead>
									<tr>
										<th>#</th>
										<th>名字</th>
										<th>姓氏</th>
										<th>用户名</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Karl</td>
										<td>Chen</td>
										<td>@karl</td>
									</tr>
									<tr>
										<td>2</td>
										<td>Jacob</td>
										<td>Thornton</td>
										<td>@fat</td>
									</tr>
									<tr>
										<td>3</td>
										<td>Larry</td>
										<td>the Bird</td>
										<td>@twitter</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div id="media-region">
					<div class="row">
						<div class="col-md-6" role="main">
							<h2>
								媒体库<small><a href="#" class="btn  btn-sm">添加</a></small>
							</h2>
						</div>
					</div>
					<div class="row">
						<!-- 
						<div class="col-md-12">
							<ul id="media-tab" class="nav nav-tabs">
								<li><a href="" id="allEntities" class="">全部<span>(12)</span></a></li>
								<li class="active"><a id="releasedEntities" href=""
									class="">图像<span>(11)</span></a></li>
								<li><a id="draftEntities" href="" class="">未附加<span>(1)</span></a></li>
							</ul>
						</div> -->
						<div class="col-md-12">
							<table class="table table-striped  table-bordered"
								id="media-table">
								<thead>
									<tr>
										<th>#</th>
										<th>文件</th>
										<th>作者</th>
										<th>上传至</th>
										<th>日期</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
					</div>
					<div class="row" id="add-media-region">
						<div class="col-md-12">
							<h2>上传新媒体文件</h2>
							<br>
						</div>
						<div class="col-md-12">
							<form id="file-form" class="media-upload-form type-form validate"
								action="http://www.nightletter.me/wp-admin/media-new.php"
								method="post" enctype="multipart/form-data">
								<div class="upload-area fade well" id="upload-area">
									<div class="drag-drop-inside">
										<p class="drag-drop-info">将文件拖到这里</p>
										<p>或</p>
										<p class="drag-drop-buttons">
											<span class="btn btn-success btn-sm"> <span>选择文件</span>
												<input type="file" value="" id="plupload-browse-button"
												name="file" style="">
											</span>
										</p>
									</div>
								</div>
								<div>
									<span class="max-upload-size"><small>最大上传文件大小：2MB.</small></span>
								</div>
							</form>
						</div>
						<div class="col-md-8 upload-media-items" id="upload-medis-items">
						</div>
					</div>
					<!-- edit media region -->
					<div class="row" id="edit-media-region">
						<div class="col-md-12">
							<h2>
								编辑媒体<small><a href="#" class="btn  btn-sm">添加</a></small>
							</h2>
							<br>
						</div>
						<div class="row">
							<div class="col-md-9">

								<div class="col-md-12">
									<form class="description-form" role="form">
										<div class="form-group">
											<input type="text" class="form-control input-sm"
												autocomplete="off" id="edit-media-title" value=""
												name="edit-media-title">
										</div>
										<div class="form-group">
											<img class="edit-media-src" id="edit-media-src"
												style="width: 75%; height: 500px"
												src="http://www.nightletter.me/wp-content/uploads/2014/02/p446344.jpg" />
										</div>
										<div class="form-group">
											<label for="edit-media-state"><strong class="">说明</strong></label>
											<textarea rows="3" class="form-control" id="edit-media-state"
												name="edit-media-state"></textarea>

										</div>

										<div class="form-group">
											<label for="edit-media-replacement"><strong class="">替代文本</strong>
											</label> <input type="text" class="form-control input-sm"
												id="edit-media-replacement" placeholder=""
												name="edit-media-replacement" autocomplete="off" value="">
										</div>
										<div class="form-group">
											<label for="edit-media-description"><strong class="">图像描述</strong></label>
											<textarea rows="3" class="form-control"
												id="edit-media-description" name="edit-media-description"></textarea>

										</div>
									</form>
								</div>
							</div>
							<div class="col-md-3">
								<div class="panel panel-default ">
									<!-- Default panel contents -->
									<div class="panel-heading">
										保存 <a href="update" class="  pull-right"><span
											id="panel-fold-btn" class="glyphicon glyphicon-chevron-up"></span></a>
									</div>
									<!-- List group -->
									<ul class="list-group" id="panel-list-group">
										<li class="list-group-item"><span
											class="glyphicon glyphicon-upload"></span>上传于：2014年2月13日@
											6:36</li>
										<li class="list-group-item">文件URL：<!-- <input type="text"
											class="form-control input-sm" autocomplete="off"
											id="detail-media-url"
											value="http://www.nightletter.me/wp-content/uploads/2014/02/p584291.jpg"
											name="detail-media-url"> -->
											<p>http://www.nightletter.me/wp-content/uploads/2014/02/p584291.jpg</p>
										</li>
										<li class="list-group-item">文件名： <strong>p584291.jpg</strong>
										</li>
										<li class="list-group-item">文件类型： <strong> JPG</strong></li>
										<li class="list-group-item">文件大小： <strong>237 kB</strong></li>
										<li class="list-group-item">尺寸：<strong>600 × 553</strong></li>
										<li class="list-group-item"><a href="delete"
											class="btn btn-danger btn-sm">永久删除</a><a href="update"
											class="btn btn-success btn-sm pull-right">更新</a></li>

									</ul>
									<div class="panel-body" style="display: none"></div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end of media region -->
			</div>
			<!-- end of main content  -->
		</div>
		<div class="row" id="mediaContent"></div>
	</div>
	<!-- /container -->
</body>
<!-- 导入通用js  -->
<%@ include file="footer.jsp"%>
<script src="/Blog/assets/js/jquery.ui.widget.js">
	
</script>
<script src="/Blog/assets/js/jquery.iframe-transport.js">
	
</script>
<script src="/Blog/assets/js/jquery.fileupload.js">
	
</script>
<script src="/Blog/assets/js/modernizr-2.7.1.js">
	
</script>
<script src="/Blog/assets/js/jquery.dataTables.js">
	
</script>

<script type="text/javascript">
	$(function() {
		var win = window, controller;
		//cumstomize DND hadler from stackoverflow 
		$.fn.dndhover = function(options) {
			return this.each(function() {
				var self = $(this);
				var collection = $();

				self.on('dragenter', function(event) {
					if (collection.size() === 0) {
						self.trigger('dndHoverStart');
					}
					collection = collection.add(event.target);
				});
				self.on('drop', function(event) {
					self.trigger('dndHoverEnd');
					event.stopPropagation();
					event.preventDefault();
					return false;

				});
				self.on('dragover', function(event) {
					event.stopPropagation();
					event.preventDefault();
					return false;

				});
				self.on('dragleave', function(event) {
					/*
					 * Firefox 3.6 fires the dragleave event on the previous element
					 * before firing dragenter on the next one so we introduce a delay
					 */
					setTimeout(function() {
						collection = collection.not(event.target);
						if (collection.size() === 0) {
							self.trigger('dndHoverEnd');
						}
					}, 1);
				});
			});
		};

		controller = {
			/**
			 **file update handler
			 **/
			fileUploadHandler : function(e) {
				if (Modernizr.draganddrop) {
					//if support d and drop. HTML5 new feature.
					$("#upload-area")
							.fileupload(
									{
										dataType : 'json',
										url : 'uploadfile',
										dropZone : $('#upload-area'),
										//forceIframeTransport : true,
										acceptFileTypes : /(\.|\/)(gif|jpe?g|png)$/i,
										maxFileSize : 2000000, // 2MB
										formAcceptCharset : 'utf-8',
										submit : (function() {
											//add one upload html item
											var items = $("#upload-medis-items");
											var item_template = $($(
													"#file-upload-template")
													.text());
											return function(e, data) {
												var temp_id = 'upload-item-'
														+ ($('#upload-medis-items .media-item').length + 1);
												var item = item_template
														.clone();
												item.attr("id", temp_id);
												item
														.find(".filename span")
														.text(
																data.files[0].name);
												data.id = temp_id;
												items.append(item);
												return true;
											};
										})(),
										progress : function(e, data) {
											//update the item's pregress bar status
											var _progress = data._progress;
											var percentage = (_progress.loaded
													/ _progress.total * 100)
													.toFixed(0);
											var percentage_str = percentage
													+ "%";
											$("#" + data.id + " .progress-bar")
													.attr("aria-valuenow",
															percentage).css(
															"width",
															percentage_str)
													.text(percentage_str);
											;
										},
										always : function(e, data) {
											var item = $('#' + data.id);
											item.find(".col-md-8").css(
													"display", "none");
											if (data.result.error) {
												item.addClass("error");
												item
														.find(".error-msg")
														.css("display", "block")
														.find("span")
														.text(
																data.result.errorMsg);
											} else {
												var image = data.result.image;
												var new_id = "image_"
														+ image.id;
												item.attr("id", new_id);
												item.find(".edit-item").attr(
														"href", new_id);
												item.data("image", image);
												item.find(".col-md-1").css(
														"display", "block");
												var pinkynail = item
														.find(".pinkynail");
												pinkynail
														.attr(
																"src",
																"http://localhost:8081/Blog/assets/images/thumb_"
																		+ data.result.image.name);
											}
										}
									});
					$(document)
							.bind(
									'dragover',
									function(e) {
										var dropZone = $('#upload-area'), timeout = window.dropZoneTimeout;
										if (!timeout) {
											dropZone.addClass('in');
										} else {
											clearTimeout(timeout);
										}
										var found = false, node = e.target;
										do {
											if (node === dropZone[0]) {
												found = true;
												break;
											}
											node = node.parentNode;
										} while (node != null);
										if (found) {
											dropZone.addClass('hover');
										} else {
											dropZone.removeClass('hover');
										}
										window.dropZoneTimeout = setTimeout(
												function() {
													window.dropZoneTimeout = null;
													dropZone
															.removeClass('in hover');
												}, 100);
									});
					$(document).bind('drop dragover', function(e) {
						e.preventDefault();
					});
					//register edit media item click event
					$(document).on(
							"click",
							".edit-item",
							function(e) {
								e.preventDefault();
								var image = $("#" + $(this).attr("href")).data(
										"image");
								$("#edit-media-title").text(image.name);
								$("#edit-media-description").text(
										image.description === null ? ""
												: image.description);
								$("#edit-media-state")
										.text(
												image.state === null ? ""
														: image.state);
								$("#edit-media-replacement").text(
										image.replacement);
								$("#edit-media-src").attr(
										"src",
										"http://localhost:8081/Blog/assets/images/"
												+ image.name);
							});
					/**
					$('.upload-area').dndhover().on({
						'dndHoverStart' : function(event) {
							$('.upload-area').addClass('drag-over');
							event.stopPropagation();
							event.preventDefault();
							return false;
						},
						'dndHoverEnd' : function(event) {
							$('.upload-area').removeClass('drag-over');
							event.stopPropagation();
							event.preventDefault();
							return false;
						}
					});
					 **/
				} else {
					// Fallback to a library solution.
				}
			},
			/**
			 **
			 **/
			registerUpdataPanelHandler : function() {
				//panel save-media-button click event
				$("#panel-fold-btn").bind("click", function(e) {
					e.preventDefault();
					var _this = $(this);
					var up_icon_cls = "glyphicon glyphicon-chevron-up";
					var down_icon_cls = "glyphicon glyphicon-chevron-down";
					var panel_list_group = $("#panel-list-group");
					if (_this.hasClass(up_icon_cls)) {
						_this.removeClass(up_icon_cls).addClass(down_icon_cls);
						panel_list_group.slideUp("normal");
					} else if (_this.hasClass(down_icon_cls)) {
						_this.removeClass(down_icon_cls).addClass(up_icon_cls);
						panel_list_group.slideDown("normal");
					}
				});

				/* Bootstrap style pagination control */
				$
						.extend(
								$.fn.dataTableExt.oPagination,
								{
									"bootstrap" : {
										"fnInit" : function(oSettings, nPaging,
												fnDraw) {
											var oLang = oSettings.oLanguage.oPaginate;
											var fnClickHandler = function(e) {
												e.preventDefault();
												if (oSettings.oApi
														._fnPageChange(
																oSettings,
																e.data.action)) {
													fnDraw(oSettings);
												}
											};

											$(nPaging)

													.append(
															'<ul class="pagination pull-right" style="margin:0px">'
																	+ '<li class="prev disabled"><a href="#">«'
																	+ '</a></li>'
																	+ '<li class="next disabled"><a href="#">'
																	+ '»</a></li>'
																	+ '</ul>');
											var els = $('a', nPaging);
											$(els[0]).bind('click.DT', {
												action : "previous"
											}, fnClickHandler);
											$(els[1]).bind('click.DT', {
												action : "next"
											}, fnClickHandler);
										},

										"fnUpdate" : function(oSettings, fnDraw) {
											var iListLength = 5;
											var oPaging = oSettings.oInstance
													.fnPagingInfo();
											var an = oSettings.aanFeatures.p;
											var i, ien, j, sClass, iStart, iEnd, iHalf = Math
													.floor(iListLength / 2);

											if (oPaging.iTotalPages < iListLength) {
												iStart = 1;
												iEnd = oPaging.iTotalPages;
											} else if (oPaging.iPage <= iHalf) {
												iStart = 1;
												iEnd = iListLength;
											} else if (oPaging.iPage >= (oPaging.iTotalPages - iHalf)) {
												iStart = oPaging.iTotalPages
														- iListLength + 1;
												iEnd = oPaging.iTotalPages;
											} else {
												iStart = oPaging.iPage - iHalf
														+ 1;
												iEnd = iStart + iListLength - 1;
											}

											for (i = 0, ien = an.length; i < ien; i++) {
												// Remove the middle elements
												$('li:gt(0)', an[i]).filter(
														':not(:last)').remove();

												// Add the new list items and their event handlers
												for (j = iStart; j <= iEnd; j++) {
													sClass = (j == oPaging.iPage + 1) ? 'class="active"'
															: '';
													$(
															'<li '+sClass+'><a href="#">'
																	+ j
																	+ '</a></li>')
															.insertBefore(
																	$(
																			'li:last',
																			an[i])[0])
															.bind(
																	'click',
																	function(e) {
																		e
																				.preventDefault();
																		oSettings._iDisplayStart = (parseInt(
																				$(
																						'a',
																						this)
																						.text(),
																				10) - 1)
																				* oPaging.iLength;
																		fnDraw(oSettings);
																	});
												}

												// Add / remove disabled classes from the static elements
												if (oPaging.iPage === 0) {
													$('li:first', an[i])
															.addClass(
																	'disabled');
												} else {
													$('li:first', an[i])
															.removeClass(
																	'disabled');
												}

												if (oPaging.iPage === oPaging.iTotalPages - 1
														|| oPaging.iTotalPages === 0) {
													$('li:last', an[i])
															.addClass(
																	'disabled');
												} else {
													$('li:last', an[i])
															.removeClass(
																	'disabled');
												}
											}
										}
									}
								});

				/* API method to get paging information */
				$.fn.dataTableExt.oApi.fnPagingInfo = function(oSettings) {
					return {
						"iStart" : oSettings._iDisplayStart,
						"iEnd" : oSettings.fnDisplayEnd(),
						"iLength" : oSettings._iDisplayLength,
						"iTotal" : oSettings.fnRecordsTotal(),
						"iFilteredTotal" : oSettings.fnRecordsDisplay(),
						"iPage" : oSettings._iDisplayLength === -1 ? 0 : Math
								.ceil(oSettings._iDisplayStart
										/ oSettings._iDisplayLength),
						"iTotalPages" : oSettings._iDisplayLength === -1 ? 0
								: Math.ceil(oSettings.fnRecordsTotal()
										/ oSettings._iDisplayLength)
					};
				};
				$.extend($.fn.dataTableExt.oStdClasses, {
					"sWrapper" : "dataTables_wrapper form-inline"
				});
				//media table handler
				$("#media-table")
						.dataTable(
								{
									"bProcessing" : true,
									"bServerSide" : true,
									"bStateSave" : true,
									"sAjaxSource" : "/Blog/imagemanage/getpaginatedimages",
									"fnServerData" : function(sSource, aoData,
											fnCallback, oSettings) {
										var oSettings = $(this).dataTable()
												.fnSettings();
										oSettings.jqXHR = $.ajax({
											"dataType" : 'json',
											"type" : "POST",
											"url" : sSource,
											data : aoData,
											/**
											"data" : {
												"pageNumber" : oSettings._iDisplayStart,
												"pageSize" : oSettings._iDisplayLength
											},
											 **/
											"success" : fnCallback
										/**function(data,
												textStatus, jqXHR) {
											$("#media-table").DataTable
													.fnSettings({
														"aoData" : data.page.content
													});
										}**/
										});
									},
									"aoColumns" : [ {
										"sTitle" : "#",
										"mData" : "idx",
										"sDefaultContent" : ""
									}, {
										"sTitle" : "Name",
										"mData" : "name",
										"sDefaultContent" : ""
									}, {
										"sTitle" : "User",
										"mData" : "user",
										"sDefaultContent" : ""
									}, {
										"sTitle" : "Create Date",
										"mData" : "createDate",
										"sDefaultContent" : ""
									}, {
										"sTitle" : "Create Date",
										"mData" : "createDate",
										"sDefaultContent" : ""
									} ],
									"sDom" : "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-6'i><'col-md-6'p>>",
									"sPaginationType" : "bootstrap",
									"oLanguage" : {
										"sLengthMenu" : "_MENU_",
										"sZeroRecords" : "无任何数据",
										"sInfo" : "展示_TOTAL_条记录当中的_START_到_END_",
										"sInfoEmpty" : "展示0条记录当中的 0  到 0",
										"sInfoFiltered" : "(从_MAX_条记中过滤)",
										"sProcessing" : "加载中...",
										"sSearch" : "<div class='pull-right'>_INPUT_</div>"
									}
								});
				$("#media-table_length select").addClass(
						"form-control pull-left input-sm col-xs-1 col-md-1");
				$("#media-table_filter label").addClass("pull-right").find(
						"input").addClass("form-control input-sm");
				$("#media-table_info").addClass("infotips");
			},
			/**
			 **
			 **/
			entitiesTabHandler : function(e) {
				e.preventDefault();
				var strActive = "active";
				var strAll = "allEntities";
				var strRel = "releasedEntities";
				var strDra = "draftEntities";
				$("#entityTab li").removeClass(strActive);
				$(this).parent().addClass(strActive);
			},

			/**
			 * main menu click event handler.
			 **/
			pitemHandler : (function() {
				var lastItem = null;
				return function() {
					try {
						lastItem.css("display", "none");
					} catch (e) {

					}
					var that = $(this);
					lastItem = that.next();
					lastItem.css({
						display : "block"
					});
					return false;
				};
			})(),
			init : function() {
				$(".pitem").click(this.pitemHandler);
				$("#entityTab a").click(this.entitiesTabHandler);
				//file upload handler registeration
				this.fileUploadHandler();
				//media update panel event register
				this.registerUpdataPanelHandler();
			},
			//check form inpurt elements			
			checkform : function() {
				var that = this;
				return false;
			}
		};
		win.pageController = controller;
		//all the action begin from here.
		controller.init();
	});
</script>

<script type="x-script" id="file-upload-template">
<div class="media-item">
								<div class="col-md-1 pull-left" style="display: none">
									<img class="pinkynail" src="" />
								</div>
								<div class="col-md-4 filename pull-left">
									<span></span>
								</div>
								<div class="col-md-4 pull-left error-msg" style="display: none">
									<span></span>
								</div>
								<div class="col-md-8 pull-right">
									<div class="progress"
										style="margin-bottom: 0px; margin-top: 10px;">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="">0%</div>
									</div>
								</div>
								<div class="col-md-1 pull-right" style="display: none">
									<a class="edit-item" href="" class="pull-right" >编辑</a>
								</div>
</div>
</script>
</html>
