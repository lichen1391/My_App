<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		$(function(){
			$("#sjdf").click(function(){
				$.ajax({
					type:"post",
					url:"app/essay/list",
					data:{
						title:"",
						publisher:""
					},
					dataType:"json",
					success:function(data){
						//alert(JSON.stringify(data));
						if("01" == data.result){
							alert(data.varList[0].title);
						}else {
							alert('无用户');
						}
					},error:function(){
						alert('没钱交');
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    	<input  type="button" value="钱钱" id="sjdf"/>
  </body>
</html>
