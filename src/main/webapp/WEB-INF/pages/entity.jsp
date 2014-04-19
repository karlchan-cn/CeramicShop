<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>新加日记 &middot; 这儿</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 导入通用的css ico --><%@ include file="header.jsp"%>
<style type="text/css">
.btn:focus {
	outline: none;
}

a:hover {
	text-decoration: none;
}

h2 {
	font-size: 14px;
	line-height: 10px;
}

h3 {
	font-family: "Arial,Helvetica,sans-serif";
	font-size: 25px;
	line-height: normal;
	font-weight: 700;
	color: #494949;
	line-height: normal;
}

.infotips {
	color: #666666;
}

#edit-container {
	font-family: arial, ​​helvetica, ​​sans-serif;
}

.container input[type="text"] {
	
}

#name-help {
	font-size: 12px;
	margin-top: 5px;
}

#form-welcome {
	margin: 15px 0 15px 30px;
}

.entity-form select,textarea,input[type="text"],input[type="password"],input[type="datetime"],input[type="datetime-local"],input[type="date"],input[type="month"],input[type="time"],input[type="week"],input[type="number"],input[type="email"],input[type="url"],input[type="search"],input[type="tel"],input[type="color"],.uneditable-input
	{ /**
	border-radius: 0px
	**/
	
}

.entity-form textarea { /**width: 530px; **/
	resize: vertical;
	height: 400px;
}

.entity-form .btn-group {
	float: right;
}

.entity-form .radio-inline,.checkbox-inline span {
	font: 12px/1.62 Helvetica, Arial, sans-serif;
}

#title,#content {
	border: 1px solid #CCCCCC;
	line-height: 1.62;
	margin-top: 5px;
	padding: 3px;
	/**width: 582px; **/
}

.float-label {
	width: 545px;
	margin-bottom: 10px;
}

.float-label p {
	display: inline;
}

.btm-btn {
	margin-top: 30px
}

#cancel-btn {
	float: right;
}

.radio-inline {
	margin-right: 11px;
}

.dialogbd {
	font-size: 12px;
}

.modal {
	border-radius: 0;
}

.modal-header {
	line-height: 10px;
	height: 20px;
}

.modal-header button {
	line-height: 10px;
	font-size: 18px;
	font-family: "Comic Sans MS";
}

input[type="file"] {
	height: 25px;
	filter: alpha(opacity =       
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                         
		                                                                     
		                                                                     
		                                                                     
		                                                                     
		                                                                     
		                                                                     
		                                                                     
		                                                                     
		                                                                     
		                 0);
	opacity: 0;
}
</style>
<style type="text/css">
.modal { /**width: 648px; **/
	
}

#uploadfiletable {
	display: none;
}

.fileinput-button input {
	cursor: pointer;
	direction: ltr;
	font-size: 23px;
	margin: 0;
	opacity: 0;
	position: absolute;
	right: 0;
	top: 0;
}

.fileinput-button {
	position: relative;
}

.fileupload-buttonbar {
	margin-bottom: 10px;
}

.table th,tr {
	font-size: 12px;
	font-weight: 400;
	font-style: normal;
	color: gray;
}

.table .uploadlistname {
	text-indent: 10px;
	width: 70%;
}

.table .uploadlistsize {
	text-indent: 5px;
	width: 15%;
}

.table .uploadlistdel {
	width: 15%;
}

.table a {
	padding: 0 0 0 5px;
}

.table td {
	padding: 0;
}

.table .fileloading {
	background: url("/Blog/assets/images/loading.gif") no-repeat left;
	color: #999999;
	font-size: 12px;
	padding: 0 0 0 18px;
}

.table .totalfooter {
	color: #777777;
}

.table .uploadError {
	color: red
}

.table .totalfooter .total-num {
	text-indent: 15px;
}

.table .totalfooter .total-size {
	text-indent: 5px;
}

.table .image-error {
	color: red;
	margin-left: 10px;
}

#uploaderror {
	display: none;
}

/** 选项 blogoptiondiv **/
.blogoptiondiv {
	margin-top: 10px;
	font-size: 12px;
}

.blogoptiondiv p {
	display: inline;
}

.blogoptiondiv label,input,input[type="radio"],input[type="checkbox"],button,select,textarea
	{
	font-size: 12px;
	margin-right: 4px;
}

.blogoptiondiv input[type="checkbox"] {
	margin-top: 0;
}

#error-tips {
	display: block;
	position: absolute;
	background: url("/Blog/assets/images/tips_arrow.gif") no-repeat scroll 0
		0 transparent;
	background-position: left -52px;
	padding-left: 10px;
	color: #FF0000;
}

#preview-container .row {
	margin-left: 30px;
	margin-right: 30px;
}

#content-preview .note {
	border: none;
	background-color: white;
}
/**
image area
**/
#images-thumb {
	margin-top: 20px;
	border-bottom: 1px dashed #CCCCCC;
	padding-bottom: 10px;
}

.image-item {
	background-color: #F3F3F3;
	border: 1px solid #CCCCCC;
	padding: 10px 6px;
	margin-right: 5px;
	/**width: 530px; **/
	margin-left: 0;
	margin-top: 10px;
	position: relative;
}

.image-item textarea {
	resize: none;
	height: 90px;
}

.image-item label,.video-item label {
	color: #666666;
	font-size: 12px;
}

.image-item .image-thumb {
	margin-left: 0px;
	height: 90px;
}

.image-item .image-thumb img { /**height: 90px; **/
	width: 120px;
}

.imagedescription {
	text-align: center;
	font: 12px/150% Arial, Helvetica, sans-serif;
}

a.delete-image,a.delete-video {
	color: #999999;
	display: block;
	height: 16px;
	line-height: 16px;
	position: absolute;
	right: 5px;
	text-align: center;
	vertical-align: middle;
	width: 16px;
	font-family: arial, ​​helvetica, ​​sans-serif;
}

a.delete-image:hover,a.delete-video:hover {
	text-decoration: none;
	background-color: transparent;
	color: #333333;
}

#title-preview {
	color: #006600;
	font: 14px/150% Arial, Helvetica, sans-serif;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<%@ include file="navhead.jsp"%>
	<div class="container" id="edit-container">
		<div class='row'>
			<div class="col-md-7">
				<h3 id="">
					新加日记<small class="text-muted autosave-tip" id="autosave-tip"
						style="display: none; font-size: 12px">现在载入的是自动保存内容，时间:<span>2013-11-04
							10:41:05</span>
					</small>
				</h3>
			</div>

		</div>
		<div class='row'>
			<div class="col-md-5">
				<form class="entity-form" action="addentity" method="POST">
					<fieldset>
						<div class="form-group">
							<label for="title">题目：</label> <input type="text" name="title"
								id="title" class="editable input-xxlarge form-control"
								placeholder="" value="${requestScope.entity.title}"
								placeholder="Enter Title" />
						</div>
						<div class="form-group">
							<span class="help-inline"></span>
						</div>
						<div class="form-group">
							<label for="content">正文：
								<div class="row" style="margin-top: 5px">
									<div class="col-md-12">
										<button class="btn btn-default btn-xs pull-right"
											data-target="#myModal" role="button" data-toggle="modal"
											aria-hidden="false">图片</button>
										<button type="button" id="link-btn"
											class="btn btn-default btn-xs pull-right">连接</button>
									</div>
								</div>

							</label>
							<textarea name="content" class="editable form-control"
								id="content" tabindex="2">${requestScope.entity.content}</textarea>
						</div>
						<!-- 
						<label class="float-label" id="float-label">
							<p>正文：</p>  <ul class="list-inline">
								<li><a class="btn btn-default btn-sm" href="#myModal"
									role="button" data-toggle="modal" aria-hidden="false">图片</a></li>
								<li><a id="link-btn" class="btn btn-default btn-sm"
									style="" href="#">连接</a></li>
							</ul>
							</label>
							-->
						<!-- <span class="btn-group"><a class="btn btn-small"
							href="#myModal" role="button" data-toggle="modal"
							aria-hidden="false">图片</a><a id="link-btn" class="btn btn-small"
							style="" href="#">连接</a></span>
							 -->
						<span id="content-info" class="help-block"></span>
						<div id="images-thumb" class="form-group" style="display: none"></div>

						<div class="blogoptiondiv row">
							<label class="radio-inline control-label">设置可见：</label> <label
								class="radio-inline"> <input type="radio" value="P"
								name="readprivate" id="entity_privateP" tabindex="3" /><span>所有人看见</span>
							</label> <label class="radio-inline"> <input type="radio"
								value="S" name="readprivate" id="entity_privateS" tabindex="4" /><span>仅朋友可见</span>
							</label> <label class="radio-inline"> <input type="radio"
								value="X" name="readprivate" id="entity_privateX" tabindex="5" /><span>仅自己可见</span>
							</label>
						</div>
						<div class="blogoptiondiv row">
							<label class='checkbox-inline'>设置权限：</label> <label
								class='checkbox-inline'><input type="checkbox"
								id="cannot_reply" value=""><span>不允许回应 </span></label>
						</div>
						<label class="float-label"> <a type="button"
							class="btn btn-default btn-sm btm-btn" id="preview-btn">预览</a> <a
							type="button" class="btn btn-sm btn-success btm-btn submit-btn">发表</a>
							<a id='cancel-btn' type="button"
							class="btn btn-default btn-sm btm-btn">取消</a>
						</label> <input type="hidden" id="entityid"
							value="${requestScope.entity.id}" />
					</fieldset>
				</form>
			</div>
		</div>

	</div>
	<!-- Modal -->
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close dismissupload"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h2 id="myModalLabel">添加文件</h2>
				</div>
				<div class="modal-body">
					<div class="fileupload-buttonbar">
						<span class="btn btn-success btn-small fileinput-button"><i
							class="icon-plus icon-white"></i><span>选择图片</span><input
							id='fileupload' type="file" name="file" data-url="saveimagefile"
							multiple="true"></span>
					</div>
					<div class="dialogbd">
						<p class="infotips">图片不超过5M，一次最多20张</p>
						<div class="filelists">
							<table id='uploadfiletable' class="table table-hover">
								<thead>
									<tr>
										<th class="uploadlistname">图片</th>
										<th class="uploadlisttime">大小</th>
										<th class="uploadlistdel">删除?</th>
									</tr>
								</thead>
								<tr class="totalfooter" id="totalfooter">
									<td class="total-num" id="total-num">共<span
										class="total-num-image" id="total-num-image">0</span>张<span
										id="uploaderror">已经到达上传数量上限。</span>
									</td>
									<td class="total-size" colspan="2">总计:<span
										class='total-size-image' id='total-size-image'>0</span> <span
										class='total-size-type' id='total-size-type'>KB</span>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-small dismissupload" data-dismiss="modal"
						aria-hidden="true">关闭</button>
					<button class="btn btn-small btn-success" id="saveupload">
						保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<div class="container" id="preview-container" style="display: none">
		<div class="row">
			<h3 id="title-preview"></h3>
		</div>
		<div class="row" id="content-preview">
			<pre class="note span6"></pre>
		</div>
		<label class="float-label span6"> <a
			class="btn btn-small btm-btn" id="reedit-btn">继续编辑</a> <a
			class="btn btn-small btn-success btm-btn submit-btn"></a>
		</label>
	</div>
	<div class="error" id="error-tips"
		style="top: 260.183px; left: 1071.5px; display: none;">给日记加个标题吧</div>
</body>
<!-- 导入通用js  -->
<%@ include file="footer.jsp"%>
<script src="/Blog/assets/js/jquery.ui.widget.js">
	
</script>
<script src="/Blog/assets/js/jquery.iframe-transport.js">
	
</script>
<script src="/Blog/assets/js/jquery.fileupload.js">
	
</script>
<script type="x-script" id="x-script">
	${requestScope.entityjson}
</script>
<script type="text/javascript">
	$(function() {
		window.pageController = {
			blogentity : {
				id : 0,
				title : '',
				content : '',
				readprivate : 'P',
				commentable : true,
				images : [],
				isTemp : true
			},
			blogimage : {
				id : 0,
				tempid : 0,
				size : 0,
				position : '',
				name : '',
				showName : ''
			},
			uploadtable : $('#uploadfiletable'),
			/**
			 **	delete image.
			 **/
			delImage : function(imageId, imageName, handler) {
				$.post("/Blog/imagemanage/delimage", {
					"imageId" : imageId,
					"imageName" : imageName
				}, handler, "json");
			},
			/**
			 **title text input change handler
			 **/
			titleChange : function() {
				var controller = window.pageController;
				var titleCtl = $(this);
				controller.title = titleCtl.value();
				$("#error-tips").css({
					"display" : "none"
				});
			},
			//window onload handler
			saveTempEntity : function() {

			},
			/**
			 **page initial method
			 **/
			pageUnloadHandler : function() {
				var url = window.location;
				return false;
			},
			/**
			 **page initial method
			 **/
			updateBlogEntity : function() {
				var currentEntity = pageController.getCurrentEntityValue();
				$
						.post(
								"/Blog/entity/updateEntity",
								{
									entity : $.toJSON(currentEntity)
								},
								function(data) {
									$("#autosave-tip span")
											.text(
													new Date(data.createdate)
															.format('{yyyy}-{MM}-{dd} {24hr}:{mm}:{ss}'))
											.parent().css("display", "inline");
								}, "json");
				//auto save 10minutes/time
				window.setTimeout(arguments.callee, 600000);

			},
			/**
			 **editable input blur event handler
			 **/
			editCtlBlurHandler : function() {
				$("#error-tips").css({
					display : "none"
				});
			},
			/**
			 **editable input blur event handler
			 **/
			editableFieldChangeHandler : function() {
				var currentCtl = $(this);
				var ctlId = currentCtl.attr("id");
				var currentEntity = window.pageController.currentEntity;
				if (ctlId == "title") {
					currentEntity.title = currentCtl.val();
				} else {
					currentEntity.content = currentCtl.val();
				}

			},
			/**
			 **记录当前行数.
			 **/
			markCurrentIndex : function() {
				var that = $(this);
				var el = that[0];
				var index = 0;
				if (el.selectionStart) {
					index = el.selectionStart;
				} else if (document.selection) {
					el.focus();

					var r = document.selection.createRange();
					if (r == null) {
						index = 0;
					}
					var re = el.createTextRange(), rc = re.duplicate();
					re.moveToBookmark(r.getBookmark());
					rc.setEndPoint('EndToStart', re);
					index = rc.text.length;
				}
				that.data("index", index);
			},
			/**
			 **add image list div UI.
			 **/
			addImageItem : function(currentFile) {
				var curImgCount = $(".image-item").size() + 1;
				var imageBlock = $("<div class='image-item row' id='image"+currentFile.id+"'> <a title='删除该图片' href='#' class='delete-image'>X</a><div class='col-md-3'>"
						+ "<label class='image-name'>&lt;图片"
						+ curImgCount
						+ "&gt;</label><div class='image-thumb'>"
						+ "<img alt='图片"+ curImgCount +"' src='http://" + location.host + "/Blog/assets/images/"+"thumb"+currentFile.name+"'></div>"
						+ "</div><div class='image-desc col-md-9'><label for='p1_title' class='field'>图片描述(30字以内)</label>"
						+ "<textarea maxlength='30' name='p1_title' id='image-desc-'"
						+ currentFile.id
						+ " style='height: 90px;width:100%'></textarea></div></div>");
				currentFile.currentUploadName = "图片" + curImgCount;
				imageBlock.data("image", currentFile);
				$("#images-thumb").append(imageBlock);
				return "<图片"+ curImgCount + ">";
			},
			/**
			 **publish note.
			 **/
			publishEntity : function() {
				var submitBtns = $('.submit-btn');
				var disabledStr = "disabled";
				if (submitBtns.hasClass(disabledStr)) {
					return;
				}
				submitBtns.addClass(disabledStr);
				var controller = window.pageController;
				if (controller.validateEntityInputs() == false) {
					return;
				}
				var currentEntity = controller.getCurrentEntityValue();
				var imagesList = controller.getImagesList();
				$
						.post(
								"/Blog/entity/publishEntity",
								{
									'entity' : $.toJSON(currentEntity),
									'imagesList' : $.toJSON(imagesList)
								},
								function(data) {
									window.onbeforeunload = null;
									window.location.href = "http://localhost:8081/Blog/entity/view/"
											+ currentEntity.id;
								}, "json");
				return false;
			},
			/**
			 **get entity's current values.
			 **/
			getCurrentEntityValue : function() {
				var controller = window.pageController;
				var currentEntity = controller.currentEntity;
				currentEntity.title = $("#title").val();
				currentEntity.content = $("#content").val();
				if ($("#cannot_reply").attr("checked") == "checked") {
					currentEntity.commentable = false;
				} else {
					currentEntity.commentable = true;
				}
				$("[name='readprivate']").each(function(index, currentParam) {
					var current = $(currentParam);
					if (current.attr("checked") == "checked") {
						currentEntity.readprivate = current.val();
						return false;
					}
				});
				var retVal = Object.clone(currentEntity);
				delete retVal.images;
				delete retVal.user;
				return retVal;
			},
			/**
			 **validate entity title and content all filled.
			 **/
			validateEntityInputs : function() {
				var entityTitle = $("#title");
				var entityContent = $("#content");
				var blogutils = $.blogutils;
				var docElement = $('html,body');
				var errorTips = $('#error-tips');
				var editTipsFun = function(msg) {
					errorTips.css({
						display : "block"
					});
					window.setTimeout(function() {
						errorTips.css({
							display : "none"
						});
					}, 5000);
				}
				var entityTitleVal = entityTitle.val();
				if ($.blogutils.isEmptyString(entityTitleVal)) {
					errorTips.text("给日记加个标题吧");
					var elePosition = entityTitle.offset();
					errorTips.css({
						left : elePosition.left + entityTitle.width() + 16,
						top : elePosition.top + 5
					});
					docElement.animate({
						scrollTop : elePosition.top - 30
					}, 300);
					editTipsFun();
					return false;
				}
				var entityContentVal = entityContent.val();
				if (blogutils.isEmptyString(entityContentVal)) {
					errorTips.text("给日记添加内容吧");
					var elePosition = entityContent.offset();
					errorTips.css({
						left : elePosition.left + entityTitle.width() + 16,
						top : elePosition.top + 5
					});
					editTipsFun();
					docElement.animate({
						scrollTop : elePosition.top - 30
					}, 300);
					return false;
				}
				return true;
			},
			/**
			 **get uploaded images list in this page.
			 **/
			getImagesList : function() {
				var imagesList = [];
				$(".image-item").each(function(index, curObjectParam) {
					var curObject = $(curObjectParam);
					var curImage = curObject.data("image");
					curImage.description = curObject.find("textarea").val();
					var cloneImage = Object.clone(curImage);
					delete cloneImage.entity;
					imagesList.push(cloneImage);
				});
				return imagesList;
			},
			/**
			 **scroll page to specified location.
			 **/
			scrollPagePosition : function(scrollTop) {
				$('html,body').animate({
					"scrollTop" : scrollTop
				}, 300);
			},
			init : function() {
				var that = this;
				window.setTimeout(that.updateBlogEntity, 10000);
				//$("#link-btn").click(that.updateBlogEntity);
				//cache the current content position
				$("#content").bind("focus", that.markCurrentIndex);
				//bind title change handler
				//$("#title").bind("change", this.editableFieldChangeHandler);
				//$("#content").bind("change", this.editableFieldChangeHandler);
				//bind window unload prompt message
				window.onbeforeunload = function(e) {
					return 'data you have entered may not be saved.';
				};
				$('.submit-btn').bind("click", this.publishEntity);
				//bind editable input blur event handler
				$(".editable").bind("blur", this.editCtlBlurHandler);
				//上传表格删除按钮控制
				var delBtns = $('#uploadfiletable a');
				delBtns.on('mouseover', function() {
					$(this).find('i').addClass('icon-white');
				});
				delBtns.on('mouseout', function() {
					$(this).find('i').removeClass('icon-white');
				});
				delBtns.bind('click', function() {
					console.log(this + 'clicked');
				});
				$('.delitem').on('click', function() {
					var delRow = $(this).parent().parent();
					var rowid = delRow.attr('id');
					var count = -1;
					var size = 0;
					var uploadedCount = 0;
					if ((rowid + '').indexOf('temp') === -1) {
						that.delImage(rowid, delRow.attr('name'));
						size = -delRow.data("image").size;
						uploadedCount = -1;

					}
					that.refreshUpdatedImgInfo(count, uploadedCount, size);
					delRow.detach();

				});
				//注册上传窗体hide事件
				var uploadModel = $('#myModal');
				uploadModel.on('hide.bs.modal', function() {

				});
				uploadModel.on('show.bs.modal', function() {
					//表格数据删除
					$('#uploadfiletable tr').remove('.uploaditem');
					$('#total-num-image').text(0);
					$('#total-size-image').text('0');
					$('#total-size-type').text('KB');
					$('#uploadfiletable').hide();
					//初始化缓存
					$.get("/Blog/entity/inituploadinfo", {
						action : 'init'
					});
					that.uploadtable.data({
						count : 0,
						uploadedCount : 0,
						size : 0
					});
				});
				//确定/取消上传文件
				$('.dismissupload').click(function() {
					$(".delitem").each(function(index, currentObject) {
						$(currentObject).click();
					});
				});
				$('#saveupload')
						.click(
								function() {
									$('#myModal').modal("hide");
									$("#images-thumb").css({
										"display" : "block"
									});
									window
											.setTimeout(
													function() {
														var uploadedImages = $("#uploadfiletable .savedFile");
														var picString = "";
														var pageController = window.pageController;
														uploadedImages
																.each(function(
																		index,
																		image) {
																	picString = picString
																			+ "\n"
																			+ pageController
																					.addImageItem($(
																							image)
																							.data(
																									"image"));
																});
														picString = picString
																+ "\n";
														var contentCtl = $("#content");
														contentCtl
																.val(contentCtl
																		.val()
																		.add(
																				picString,
																				contentCtl
																						.data("index")));

													}, 200);
								});
				//initialize read private and commentable
				var currentEntity = $.evalJSON($("#x-script").text());
				this.currentEntity = currentEntity;

				if (currentEntity.isTemp) {
					$('.submit-btn').text('发表');
				} else {
					$('.submit-btn').text('保存');
				}
				var images = currentEntity.images;
				var length = images.length;
				if (length > 0) {
					$("#images-thumb").css("display", "block");
					for ( var i = 0; i < length; i++) {
						var image = images[i];
						this.addImageItem(image);
					}
				}

				var readPrivate = currentEntity.readprivate;
				var commentable = currentEntity.commentable;
				(commentable == true)
						|| $("#cannot_reply").attr("checked", true);
				$("#entity_private" + readPrivate).attr("checked", true);
				//preview button click event handler
				$("#preview-btn")
						.bind(
								'click',
								function() {
									var pageController = window.pageController;
									if (pageController.validateEntityInputs() == false) {
										return false;
									}
									//initial preview content
									$
											.post(
													"/Blog/entity/editepreviewcontent",
													{
														previewContent : $(
																"#content")
																.val(),
														imagesList : $
																.toJSON(pageController
																		.getImagesList())
													},
													function(data) {
														$(
																"#content-preview pre")
																.empty()
																.append(
																		data.content);
														$('#title-preview')
																.text(
																		$(
																				"#title")
																				.val());
														$("#edit-container")
																.css(
																		{
																			display : "none"
																		});
														$('#preview-container')
																.css(
																		{
																			display : "block"
																		});
														pageController
																.scrollPagePosition($(
																		'#title-preview')
																		.position().top - 30);
													}, "json");

								});
				//re edit button click event handler
				$('#reedit-btn')
						.bind(
								"click",
								function() {
									$("#edit-container").css({
										display : "block"
									});
									$('#preview-container').css({
										display : "none"
									});
									window.pageController.scrollPagePosition($(
											'#title').position().top - 30);
								});
				//images remove click event handler
				$('.delete-image').on(
						"click",
						function() {
							var currentimgItem = $(this).parent();
							var currentImage = currentimgItem.data("image");
							that.delImage(currentImage.id, currentImage.name);
							currentimgItem.hide(500, function() {
								var contentCtl = $("#content");
								contentCtl.val(contentCtl.val()
										.replace(
												new RegExp(currentimgItem.find(
														".image-name").text(),
														"g"), ""));
								currentimgItem.detach();
								if ($(".image-item").size() == 0) {
									$("#images-thumb").css({
										"display" : "none"
									});
								}
							});
							return false;
						});

			},
			inituploadinfo : function() {
				var uploadtable = this.uploadtable;
				var uploaditems = uploadtable.find('uploaditem');
				//if has upload item ,update items info;
				if (uploaditem.lenght > 0) {

				} else {
					uploadtable.remove($('.totalfooter'));
				}
			},
			/**
			 **format size number.
			 **/
			countSize : function(size) {
				var tempSize = parseFloat((size / 1024).toFixed(1));
				var sizeType = 'KB'
				if (tempSize > 1024) {
					tempSize = parseFloat((tempSize / 1024).toFixed(1));
					sizeType = 'MB';
				}
				return {
					'size' : tempSize,
					'sizeType' : sizeType
				};
			},
			getSize : function(size, sizeType) {
				var retVal = 0;
				if (sizeType == 'KB') {
					retVal = size * 1024;
				} else if (sizeType == 'MB') {
					retVal = size * 1024 * 1024;
				}
				return retVal;
			},
			/**
			 **refresh the upload image table's conclusion.
			 **/
			refreshUpdatedImgInfo : function(count, uploadedCount, size) {
				var that = pageController;
				var uploadedInfo = $("#uploadfiletable").data();
				var imgsCount = uploadedInfo.count + count;
				var imgUploaded = uploadedInfo.uploadedCount + uploadedCount;
				var imgsSize = uploadedInfo.size + size;
				var formatedSize = that.countSize(imgsSize);
				$("#total-num-image").text(imgUploaded);
				$("#total-size-type").text(formatedSize.sizeType);
				$("#total-size-image").text(formatedSize.size);
				uploadedInfo.count = imgsCount;
				uploadedInfo.size = imgsSize;
				uploadedInfo.uploadedCount = imgUploaded;
				if (imgsCount == 0) {
					$('#uploadfiletable').hide();
				}
			}
		};
		var pageController = window.pageController;
		pageController.init();
		$('#fileupload')
				.fileupload(
						{
							forceIframeTransport : true,
							acceptFileTypes : /(\.|\/)(gif|jpe?g|png)$/i,
							maxFileSize : 5000000, // 5MB
							url : 'saveimagefile',
							dataType : 'json',
							add : function(e, data) {
								var uploadfiletable = $('#uploadfiletable');
								var fileuploader = $('#fileupload');
								var file = data.files[0];
								var itemCount = uploadfiletable
										.find('.uploaditem').length;
								var fileFilter = /(\.|\/)(gif|jpe?g|png)$/i;
								var filterResult = fileFilter.exec(file.name);
								if (itemCount === 0) {
									uploadfiletable.show(600);
								}
								if (itemCount >= 20) {
									var uploaderror = $("#uploaderror");
									uploaderror.text("已经达到上传上限。").css({
										"display" : 'block'
									});
									return;
								}
								var tempid = itemCount + 1;
								var fileitme = $('<tr class="uploaditem" id="tempid_' +
                    tempid +
                    '"><td class="uploadlistname">'
										+ file.name
										+ '</td><td class="uploadlistsize fileloading">上传中...</td><td class="uploadlistdel"><a title="删除图片" class="btn btn-link delitem"><i class="icon-trash"></i></a></td></tr>');
								fileitme.insertBefore($('#totalfooter'));
								var cloneEntity = {};
								var currentEntity = pageController.currentEntity;
								cloneEntity.name = currentEntity.name;
								cloneEntity.id = currentEntity.id;
								fileuploader.fileupload('option', {
									'formData' : [ {
										'name' : 'tempid',
										'value' : tempid
									}, {
										'name' : 'entity',
										'value' : $.toJSON(cloneEntity)
									} ]
								});
								if (filterResult == null) {
									var imageerror = $('<span class="image-error">请选择图片文件(JPG/JPEG, PNG,或GIF) </span>');
									fileitme.addClass('error');
									fileitme.find('.uploadlistsize').text('')
											.removeClass('fileloading');
									fileitme.find('.uploadlistname').append(
											imageerror);
									return;
								}
								data.submit();
							},
							done : function(e, data) {
								$
										.each(
												data.result.imagelist,
												function(index, file) {
													var pageController = window.pageController;
													var error = data.result.error;
													var currentFile = file;
													var tr = $('#tempid_'
															+ currentFile.tempid);
													var uploadSize = $(tr
															.find('.uploadlistsize')[0]);

													uploadSize
															.removeClass("fileloading ");
													tr.data({
														"image" : currentFile
													});
													if (error == true) {
														tr.addClass('error');
														uploadSize.text("");
														var nameCol = $(tr
																.find(".uploadlistname")[0]);

														nameCol
																.text(
																		nameCol
																				.text()
																				+ "   "
																				+ data.result.errorMsg)
																.addClass(
																		"uploadError");
														pageController
																.refreshUpdatedImgInfo(
																		1, 0, 0);
														return;
													}

													tr.attr("id",
															currentFile.id);
													tr.attr("name",
															currentFile.name);
													tr.addClass("savedFile");
													var formatedSize = pageController
															.countSize(currentFile.size);
													uploadSize
															.addClass(
																	"fileUploaded")
															.text(
																	formatedSize.size
																			+ formatedSize.sizeType);

													tr.addClass('warning');
													pageController
															.refreshUpdatedImgInfo(
																	1,
																	1,
																	currentFile.size);
													tr = null;
												});
							}
						});

	});
</script>
</html>
