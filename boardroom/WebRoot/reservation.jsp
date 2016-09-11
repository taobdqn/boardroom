<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reservation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script src="jquery-1.8.3.js"></script>
  <script src="fs/ckeck.js"></script>
  
  
  <body>
    <form action="DoRe" method="post">
    	<table align="center" border="1px" width="400px">
    		<tr>
    			<td colspan="2" bgcolor="green" style="text-align:center">预定会议室</td>
    		</tr>
    		<tr>
    			<td>会议室名称:</td>
    			<td><select name="meetingRoom">
    				<option>第一会议室</option>
    				<option>第二会议室</option>
    				<option>第三会议室</option>
    			</select></td>
    		</tr>
    		<tr>
    			<td>预定日期</td>
    			<td><input type="text" name="time" style="width='100%';height=100%"></td>
    		</tr>
    		<tr>
    			<td>预定者</td>
    			<td><input type="text" name="userName" width="100%" height="100%"></td>
    		</tr>
    		<tr>
    			<td  colspan="2" style="text-align:center">
    				<input type="submit" value="提交" onclick="return checkall() && checkTime()">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
