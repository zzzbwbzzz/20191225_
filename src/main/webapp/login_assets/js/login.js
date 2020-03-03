$(function(){
	$('#username_blank').focusout(function(){
		if(null == $(this).val() || $(this).val().length == 0){
			$(this).attr('placeholder','请输入用户名！')
		}
	})
	$('#password_blank').focusout(function(){
		if(null == $(this).val() || $(this).val().length == 0){
			$(this).attr('placeholder','请输入密码！')
		}
	})
	$('#loginButton').click(function(){
		var username = $("#username_blank").val()
		var password = $("#password_blank").val()
		if(null == username || "" == username){
			alert("用户名或密码为空")
		}
		if(null == password || "" == password){
			alert("用户名或密码为空")
		}
		$.ajax({
			type:"get",
			url:"/20191225_/manage/user/login.do",
			data:{
				name:username,
				psw:password
			},
			success:function(response){
				if(response.status == 1){
					if(response.data.role == 1)
						window.location.replace("/20191225_/adminIndex.html")
					if(response.data.role == 0)
						window.location.replace("/20191225_/user/index.html")
				}else{
					alert(response.msg)
				}
			},
			error:function(jqXHR, textStatus, errorThrown){
				alert(textStatus)
			}
		})
	})
})