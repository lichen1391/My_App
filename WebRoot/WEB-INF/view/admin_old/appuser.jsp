<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'appuser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#sjdf").click(function() {
			var user = $("#username").val();
			var pwd = $("#password").val();
			$.ajax({
				type : "post",
				url : "app/activate",
				data : {
					files : {
						"HEADSCULPTURE" : '123'
					},
					values : {
						"NAME" : '于晶',
						"PHONE" : '13706942316',
						"PASSWORD" : '1234',
						"CLASSNUM" : '95211'
					}
				},
				dataType : "json",
				cache : false,
				success : function(data) {
					console.log(JSON.stringify(data.list));
				},
				error : function() {
					alert('没钱交');
				}
			});
		});
		$("#xxoo").click(function() {
			$.ajax({
				type : "post",
				url : "app/test/toke.do",
				data : {
					publisher : '黄晓明',
					publisher_id : '12010101',
					title : '吃饭了'
				},
				dataType : "json",
				cache : false,
				success : function(data) {
					console.log(JSON.stringify(data));
				},
				error : function() {
					alert('没钱交');
				}
			});
		});

		/*$("#sjdf").click(function(){
			var user=$("#username").val();
			var pwd=$("#password").val();
			var url="appuser/login.do?USERNAME="+user+"&PASSWORD="+pwd+"&callback=?";
			$.getJSON(url, {} , function(data) {    
				if("01" == data.result){
					alert('查找成功');
				}else {
					alert('无用户');
				}  
		    }); 
		});	*/
	});
</script>
</head>

<body>
	<form id="formId" enctype="multipart/form-data">
		
		用户：<input id="username" name="username" type="text" /><br /> 密码：<input
			id="password" name="password" type="password" /><br /> <input
			type="button" value="上缴党费" id="sjdf" /> <input type="button"
			value="多交党费" id="xxoo" />
	</form>
</body>
</html>
