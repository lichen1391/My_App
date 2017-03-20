/**
 *  主页js文件
 */

//退出登录
function logout(){
	var msg = "您确定要退出吗？";
	if (confirm(msg)==true){
		$.ajax({
			url : "system/logout",
			dataType : "json",
			type : "post",
			success : function(data){
				if(data == "success"){
					window.location = "login_page";
				}
			}
		});
	}else{
		
	}
	
}


//获取验证码
	$.ajax({
		url : "custom/validate_code",
		dataType : "json",
		type : "post",
		success : function(data){
			var code;
			if(data){
				for(code in data){
					$("#validate_code").append("<span style=\"margin:5px;font-size:20px;line-height:38px;\">"+data[code]+"</span>");
				}
			}else{
				$("#validate_code").append("<span style=\"margin:2px;font-size:20px;line-height:38px;\">验证码无效</span>");
			}
			
		}
	});

//点击刷新验证码
function refresh_validate_code(){
	$.ajax({
		url : "custom/validate_code",
		dataType : "json",
		type : "post",
		async : false,
		success : function(data){
			var code;
			if(data){
				$("#validate_code").empty();
				for(code in data){
					$("#validate_code").append("<span style=\"margin:5px;font-size:20px;line-height:38px;\">"+data[code]+"</span>");
				}
			}else{
				$("#validate_code").append("<span style=\"margin:2px;font-size:20px;line-height:38px;\">验证码无效</span>");
			}
			
		}
	});
}

//验证验证码是否输入正确
function validate_code(){
	var code = $("input[name='validate']").val();
	var reg = /^([a-zA-Z0-9]){4}$/;
	if(reg.test(code)){
		var flag;
		$.ajax({
			url : "custom/validate",
			dataType : "json",
			type : "post",
			data : {"code":code},
			async : false,
			success : function(data){
				if(data == 1){
					flag = true;
				}else{
					flag = false;
				}
			}
		});
		if(flag == true){
			return true;
		}else{
			alert("验证码错误");
			refresh_validate_code();
			return false;
		}
	}else{
		return false;
	}
	
}
