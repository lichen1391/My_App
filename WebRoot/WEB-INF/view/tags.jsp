<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="keywords" content=" ">
	<meta name="description" content="">
        
	<script src="static/js/easyui/jquery.min.js"></script>
	<script src="static/js/easyui/jquery.easyui.min.js"></script>
	<script src="static/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="static/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" href="static/js/easyui/themes/icon.css">
	
	