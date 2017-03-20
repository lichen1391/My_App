/**
 * 用户列表
 */

//生成数据表格
$('#list').datagrid({
	url: 'user/list',
    fit: false,
    fitColumns: true,
    striped: true,
    rownumbers: true,
    border: false,
    pagination: true,
    pageSize: 15,
    pageList: [10, 15, 30, 60, 100],
    singleSelect : true,
    sortName: "user_id",
    sortOrder: "asc",
    pageNumber: 1,
    cache:false,
    toolbar: '#tools',
    columns: [[
        { field: 'user_id',  title: "用户id", width: 100},
        { field: 'user_name',  title: "用户名", width: 100},
        { field: 'password',  title: "密码", width: 80},
        { field: 'sex',  title: "性别", width: 30},
        { field: 'phone',  title: "手机", width: 80},
		{ field: 'residence',  title: "居住地", width: 120},
		{ field: 'profession',  title: "职业", width: 120},
		{ field: 'classnum',  title: "班级号", width: 80},
		{ field: 'specialty',  title: "专业", width: 120},
		{ field: 'role_name',  title: "用户类型", width: 80, formatter : function(val, rec) {
			switch (val) {
			case '管理员' : return "<span class='admin_user'>管理员</span>";
			case '普通用户' : return "<span>普通用户</span>";
			case 'VIP用户' : return "<span class='vip_user'>VIP用户</span>";
			default: return "--";
		}
	}},
		] ],

});


//工具按钮的点击事件
tools = {
    reload : function() {
        $('#list').datagrid('reload', {});
    },
    search:function(){
        var param = {
            'search' : $('#search').val(),
            'search_value' : $('#user_status').combobox("getValue"),
        };
        $('#list').datagrid('reload', param);
    },
    redo: function () {
        $('#list').datagrid('unselectAll');
    },

    add: function () {
        $('#add_form').dialog('open');
        $('#add_form').panel('move', {top: 10});
        $('#add_form').dialog('resize', {});
    },
    edit: function () {
        var rows = $('#list').datagrid('getSelections');
        var obj = rows[0];
        if (rows.length > 1) {
            $.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
        } else if (rows.length == 1) {
            $('#edit_form').form('load', {
            	id : obj.id,
                user_id : obj.user_id,
                user_name: obj.user_name,
                password: obj.password,
                sex: obj.sex,
                phone: obj.phone,
                residence: obj.residence,
                profession: obj.profession,
                classnum: obj.classnum,
                specialty: obj.specialty,
                role_id: obj.role_id,
            }).dialog('open');
            $('#edit_form').panel('move', {top: 20});
            $('#edit_form').dialog('resize', {});

        } else if (rows.length == 0) {
            $.messager.alert('警告操作！', '编辑记录至少选定一条数据！', 'warning');
        }
    },
    
    delete: function () {
    	$.messager.confirm("提示","确定要删除吗？",function(){
	        var rows = $('#list').datagrid('getSelections');
	        var obj = rows[0];
	        if (rows.length == 0) {
	            $.messager.alert('警告操作！', '请选择要删除的数据！', 'warning');
	        }
	        $.ajax({
	        	url : "user/delete",
	    		dataType : "json",
	    		type : "post",
	    		data : {"id":obj.id},
	    		success : function(data){
	    			if(data == 1){
	    				$.messager.show({
							title : '提示',
							msg : '删除成功',
						});
						$('#list').datagrid('reload');
	    			}else{
	    				$.messager.show({
							title : '提示',
							msg : '删除失败',
						});
	    			}
	    		}
	        });
    	});
    }

};

//点击新增按钮弹出对话框
$('#add_form').dialog({
    title: '添加用户信息',
    width: 380,
    modal: true,
    resizable: true,
    closed: true,
    cache: false,
    closable: false,
    buttons: [{
        text: '提交',
        iconCls: 'icon-ok',
        handler: function () {
            $('#add_form').form("submit", {
            	url: 'user/save',
            	onSubmit : function(param) { 
					if ($(this).form('validate')) {
						$.messager.progress({
							text : '正在修改中...',
						});
						return true;
					} else
						return false;
				},
				success : function(data) {
					$.messager.progress('close');
					//data = $.parseJSON(data);
					if (data == 1) {
						$.messager.show({
							title : '提示',
							msg : '新增成功',
						});
						$('#add_form').dialog('close').form('reset');
						$('#list').datagrid('reload');
					}else if(data == 2){
						$.messager.show({
							title : '提示',
							msg : '用户已存在！',
						});
					} else {
						$.messager.alert('提示', '出现错误', 'warning');
					}
				}
			});
		},
	}, {
        text: '取消',
        iconCls: 'icon-redo',
        handler: function () {
            $('#add_form').dialog('close').form('reset');
        },
    }],
    onClose: function () {
        $('#add_form').form('reset');
    },
});


//点击修改按钮弹出对话框
$('#edit_form').dialog({
    title: '修改用户数据',
    width: 380,
    modal: true,
    resizable: true,
    closed: true,
    cache: false,
    closable: true,
    buttons: [{
        text: '提交',
        iconCls: 'icon-edit',
        handler: function () {
        	$('#edit_form').form("submit", {
				url: 'user/save',
				onSubmit : function(param) {
					if ($(this).form('validate')) {
						$.messager.progress({
							text : '正在修改中...',
						});
						return true;
					} else
						return false;
				},
				success : function(data) {
					$.messager.progress('close');
					//data = $.parseJSON(data);
					if (data == 1) {
						$.messager.show({
							title : '提示',
							msg : '修改成功',
						});
						$('#edit_form').dialog('close').form('reset');
						$('#list').datagrid('reload');
					}else if(data == 2){
						$.messager.show({
							title : '提示',
							msg : '用户已存在！',
						});
					} else {
						$.messager.alert('提示', '出现错误', 'warning');
					}
				}
			});
		},
	}, {
        text: '取消',
        iconCls: 'icon-redo',
        handler: function () {
            $('#edit_form').dialog('close').form('reset');
        },
    }],
    onClose: function () {
        $('#edit_form').form('reset');
    },
});


$('#add_role').combobox({
    url:'user/roleList',
    valueField:'role_id',
    textField:'role_name'
});

$('#edit_role').combobox({
    url:'user/roleList',
    valueField:'role_id',
    textField:'role_name'
});

