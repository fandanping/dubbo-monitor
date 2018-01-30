var neusipo_statistics_monitor=
	(function(){
	

	var _getServerStatus=function queryServerStatus(){
	//	alert("1");
	//	alert($("#ShowStatisticInfoService").attr("name"));
		
		//具体js代码
	    $.ajax({
	    	url:"/neusipo/statistics/service.action",
	    	type:"post",
	    	dataType : 'json',
	    	data:{
					serverinterface : $("#ShowStatisticInfoService").attr("name"),
					
		    },
		    success:function(response){
		    	//alert("成功");
		    	var result=response.dubboStatistics;
		    	var serviceAvgElapsed=result.serviceAvgElapsed;
		    	var serviceFailure=result.serviceFailure;
		        var serviceMaxConcurrent=result.serviceMaxConcurrent;
		        var serviceMaxElapsed=result.serviceMaxElapsed;
		        var serviceSuccess=result.serviceSuccess;
		    	
		      //  alert("serviceAvgElapsed:"+serviceAvgElapsed);
		      //  alert("serviceFailure:"+serviceFailure);
		      //  alert("serviceMaxConcurrent:"+serviceMaxConcurrent);
		     //  alert("serviceMaxElapsed:"+serviceMaxElapsed);
		      //  alert("serviceSuccess:"+serviceSuccess);
		        
		    	$("#serviceAvgElapsed").text(serviceAvgElapsed);
		    	$("#serviceFailure").text(serviceFailure);
		    	$("#serviceMaxConcurrent").text(serviceMaxConcurrent);
		    	$("#serviceMaxElapsed").text(serviceMaxElapsed);
		    	$("#serviceSuccess").text(serviceSuccess);
		    	
		    	
		    	//alert("success");
		    },
		    error:function(response){
		    	alert("失败");
		    }
			
	    	 
	    })
		
		
	}
	
	return{
		getServerStatus:_getServerStatus  //暴露接口
	}
	
})();


$(function(){
	
	$("#ShowStatisticInfoService").click(function(){
		neusipo_statistics_monitor.getServerStatus();
	})
	
})