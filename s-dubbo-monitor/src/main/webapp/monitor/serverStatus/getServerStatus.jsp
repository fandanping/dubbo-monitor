<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%--<base href="<%=basePath%>">
    
    --%>
    <title>monitor</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../../common/plugins/jquery/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="../../common/plugins/bootstrap/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="../../common/plugins/bootstrap/css/bootstrap.css"/>
	<script type="text/javascript" src="js/ServerStatus.js"></script>
	
   
  </head>
  
  <body>
  
  <!-- Button trigger modal -->
	<div id="ShowStatisticInfoService" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#monitorModal" name="com.neusoft.neusipo.apis.search.bizservice.IShowStatisticInfoService">
	  点击我
	</div>
    
    <!-- Modal -->
	<div class="modal fade" id="monitorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">服务状态</h4>
	      </div>
	      <div class="modal-body">
	        平均耗时：                  <span id="serviceAvgElapsed"></span><br/>
	        调用失败的次数:  <span id="serviceFailure"></span><br/>
	        服务最大并发数:  <span id="serviceMaxConcurrent"></span><br/>
	        服务最大调用耗时: <span id="serviceMaxElapsed"></span><br/>
	        服务调用成功的次数:  <span id="serviceSuccess"></span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	     
	      </div>
	    </div>
	  </div>
	</div>

     
     
    
  </body>
</html>
