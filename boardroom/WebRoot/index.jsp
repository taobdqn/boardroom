<%@page import="cn.bd.entity.destineinfo"%>
<%@page import="cn.bd.impdao.ImpDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form>
    	<table align="center" border="1px" width="600px" >
    		<tr >
    			<td style="text-align:center" colspan="4"  bgcolor="green"><h4>会议室信息</h4></td>
    		</tr>
    		<tr>
    			<td>编号</td>
    			<td>会议室名称</td>
    			<td>预定人</td>
    			<td>时间</td>
    		</tr>
    		<%
    		ImpDao impDao=new ImpDao();
    		List<destineinfo> list=impDao.queryDinfo();
    		request.setAttribute("list1", list);
    		 %>
    		 <c:forEach var="entry" items="${list1 }" varStatus="status">
    		 
    		<!--  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
    		 <tr <c:if test="${status.index % 2==0}">
    		 style="background-color:rgb(219,241,212);"</c:if>>
    		 
    		 	<td>${entry.getId() }</td>
    		 	<td>${entry.getRoom_name() }</td>
    		 	<td>${entry.getDestine_name() }</td>
    		 	<td>${entry.getDestine_time() }</td>
    		 </tr>
    		 </c:forEach>
    		 <tr style="border:none">
    		 	<td colspan="4" style="text-align:right"><a href="reservation.jsp">预定</a></td>
    		 </tr>
    	</table>
    </form>
  </body>
</html>
