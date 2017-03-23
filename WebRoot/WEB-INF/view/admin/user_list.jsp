<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../tags.jsp"%>

 	<title>用户管理</title>
    
  </head>

  
  <body>
	<table id="list" width="100%"></table>

    <div id="tools" style="padding:5px;">
        <div style="margin-bottom:5px;">
            <div id=search_div style="float:left; height:20px;">
                              用户类型：<select name="user_status" id="user_status" class="easyui-combobox"  style="width:120px">
                		<option value="">全部</option>
                		<option value="2">普通用户</option>
                		<option value="3">vip用户</option>
            		</select>&nbsp;
                <input type="text" id="search" class="easyui-textbox" style="width:200px;" placeholder="请输入关键字">
            </div>&nbsp;
            <div href="#" class="easyui-linkbutton" iconcls="icon-search"  onclick="tools.search();"> 查  询 </div>&nbsp;
            <div href="#" class="easyui-linkbutton" iconcls="icon-add"  onclick="tools.add();"> 添  加 </div>&nbsp;
            <div href="#" class="easyui-linkbutton" iconcls="icon-edit"  onclick="tools.edit();"> 修  改 </div>&nbsp;
            <div href="#" class="easyui-linkbutton" iconcls="icon-cancel"  onclick="tools.delete();"> 删  除 </div>
        </div>
    </div>

    <form id="add_form" method="post">
    	<table cellpadding="1" cellspacing="1" style="margin:10px 30px; color: #333; line-height: 2.2em">
        	<tr><td align=left>用户id：</td><td><input type="text" name="user_id" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>用户名：</td><td><input type="text" name="user_name" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>密码：</td><td><input type="text" name="password" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>性别：</td><td><input type="text" name="sex" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>手机：</td><td><input type="text" name="phone" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>居住地：</td><td><input type="text" name="residence" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>职业：</td><td><input type="text" name="profession" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>班级号：</td><td><input type="text" name="classnum" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>专业：</td><td><input type="text" name="specialty" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>用户类型：</td><td><input type="text" id="add_role" name="role_id" class="easyui-combobox" style="width:200px;"></td></tr>
    	</table>
    </form>


    <form id="edit_form" method="post">
    	<table cellpadding="1" cellspacing="1" style="margin:10px 30px; color: #333; line-height: 2.2em">
        	<tr><td align=left>用户id：</td><td><input type="text" disabled name="user_id" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>用户名：</td><td><input type="text" name="user_name" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>密码：</td><td><input type="text" name="password" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>性别：</td><td><input type="text" name="sex" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>手机：</td><td><input type="text" name="phone" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>居住地：</td><td><input type="text" name="residence" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>职业：</td><td><input type="text" name="profession" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>班级号：</td><td><input type="text" name="classnum" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>专业：</td><td><input type="text" name="specialty" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
        	<tr><td align=left>用户类型：</td><td><input type="text" id="edit_role" name="role_id" class="easyui-combobox easyui-validatebox" data-options="required:true,validType:'intOrFloat'" style="width:200px;"></td></tr>
    	</table>
    	<input type="hidden" name="id">
    </form>


  </body>
</html>

<link rel="stylesheet" href="static/css/user_list.css">
<script src="static/js/user_list.js"></script>
