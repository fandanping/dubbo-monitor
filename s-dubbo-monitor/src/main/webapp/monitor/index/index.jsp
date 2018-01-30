<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link rel="stylesheet" type="text/css" href="<%=basePath %>/monitor/index/css/index.css">
  </head>
  
  <body><%--
             系统的 首页面  ，你好
    <form action="<%=basePath %>/monitor/logout" method="post">
	    <button type="submit" name="submit" class="" id="login-submit-btn">退出</button>  
  </form>
  
 --%><div class="header">
     <div class="logout">
          <form action="/monitor/logout" method="post">
	           <button type="submit" name="submit" class="" id="login-submit-btn">退出</button>  
         </form>
     </div>
 </div>
 <div class="main">
 
 </div>
 <div class="footer">
 
 </div>
  
  
  </body>
</html>
