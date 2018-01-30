$(function(){
	//$("input").attr("value","");
	//用户名密码错误跳转
	var s = window.location.search;
	if (s.indexOf("error") != -1){
		//alert('用户名或密码有误，请重新输入！');
		$('.login-tip').modal('show');

	
	}

})