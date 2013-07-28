<%@ page contentType="text/html;charset=UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Taop工作流演示系统</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires",-1);%>
<link href="js/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/swfupload.js"></script>
<script type="text/javascript" src="js/swfupload.queue.js"></script>
<script type="text/javascript" src="js/fileprogress.js"></script>
<script type="text/javascript" src="js/handlers.js"></script>
<script type="text/javascript">
var swfu;

window.onload = function() {
	var settings = {
		flash_url : "js/swfupload.swf",
		upload_url: "${ctx}/upload/up",
		post_params: {"id" : "123"},
		file_size_limit : "1 GB",
		file_types : "*.*",
		file_types_description : "All Files",
		file_upload_limit : 100,
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel"
		},
	
		// Button settings
		button_width: "65",
		button_height: "29",
		button_placeholder_id: "uploadButton",
		button_text: '<span style="color:blue" title="hello">添加附件</span>',
		button_text_style: ".theFont { font-size: 16; color: blue;}",
		button_text_left_padding: 12,
		button_text_top_padding: 3,
		
		// The event handler functions are defined in handlers.js
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete	// Queue plugin event
	};
	
	swfu = new SWFUpload(settings);
};
</script>
</head>
<body>
<h2>Hello World!</h2>
<h2>${ctx}/js</h2>
<h3><%=pageContext.getRequest()%></h3>
<form id="form1" action="${ctx}/upload/up" method="post" enctype="multipart/form-data">
<span id="uploadButton"></span><div class="fieldset flash" id="fsUploadProgress"></div>
<div class="fieldset flash" id="fsUploadProgress">
<span class="legend">Upload Queue</span>
<div id="divStatus">0 Files Uploaded</div>
<div>
	<span id="spanButtonPlaceHolder"></span>
	<input id="btnCancel" type="button" value="Cancel All Uploads" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
</div>
</div>
</form>
</body>
</html>
