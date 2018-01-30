<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <%--<head><%--
    <base href="<%=basePath%>">
    
    --%><title>My JSP 'login.jsp' starting page</title>
    
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
	<script type="text/javascript" src="js/login.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">
     

  </head>
  
  <body class="login"><%--
      <form action="<%=basePath %>/monitor/login/security_check" method="post">
    <input type="text" name="username" placeholder="输入用户名">  
    <input type="password" name="password" placeholder="输入密码">  
    <button type="submit" name="submit" class="" id="login-submit-btn">登录</button>  
  </form>
  
 --%>
     
 
 <div class="logo">
   MONITOR SYSTEM
 </div>
 <div class="content">
    <form class="login-form" action="<%=basePath %>/monitor/login/security_check" method="post">
        <div class="form-title"> 
          <span class="form-title"> Welcome.</span>
           <span class="form-subtitle"> Please login.</span>
        </div>
        <div class="form-group">
           <label class="control-label" style="display:none">Username</label>
           <input id="username" class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="username" value="">
        </div>
        <div class="form-group">
			<label class="control-label"  style="display:none">Password</label>
			<input id="userpwd" class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="password" value="">
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-primary btn-block uppercase">Login</button>
		</div>
		
		
    </form>
 </div>
 
 
 <div class="modal fade login-tip" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">提示信息</h4>
      </div>
      <div class="modal-body">
        <p>用户名或密码输入错误，请重新输入&hellip;</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  </body>
</html>
