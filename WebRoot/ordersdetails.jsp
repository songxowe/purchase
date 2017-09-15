<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../commons/taglib.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>需求计划明细</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="easyui/jquery.min.js"></script>
</head>

<body>
	<div style="margin-top:10px;text-align: center;">
		
		<table cellSpacing=1 cellPadding=0 width="100%" height="200px"
			bgColor=#336699 border=0>
			<TR bgColor=#ffffff>
				<TD align="center" width="100%" bgColor=#ffffff colSpan=20 height=30>
					<H2>
						<FONT color=#0070c0>需求计划明细</FONT>
					</H2>
				</TD>
			</TR>
			
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">需求计划编号</td>
				<td bgColor="yellow">${requestScope.orders.orderNum}</td>
				<td bgColor="#c0c0c0">物资编码</td>
				<td bgColor="yellow">${requestScope.orders.materialCode}</td>
			</tr>
			
			<TR align="left">
				<TD noWrap width="20%" bgColor="#c0c0c0">物资名称</TD>
				<TD bgColor="yellow" width="30%">${requestScope.orders.materialName}</TD>
				<TD noWrap width="20%" bgColor="#c0c0c0">数量</TD>
				<TD bgColor="yellow" width="30%">${requestScope.orders.amount}</TD>
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">计量单位</TD>
				<TD bgColor="yellow">${requestScope.orders.measureUnit}</TD>
				<TD noWrap bgColor="#c0c0c0">预算单价(元)</TD>
				<TD bgColor="yellow">${requestScope.orders.unitPrice}</TD>
				
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">预算总价(元)</TD>
				<TD bgColor="yellow" colspan="3">${requestScope.orders.sumPrice}</TD>
				
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">开始交货期</TD>
				<TD bgColor="yellow"><fmt:formatDate value="${requestScope.orders.startDate}" pattern="yyy-MM-dd"/> </TD>
				<TD noWrap bgColor="#c0c0c0">结束交货期</TD>
				<TD bgColor="yellow"><fmt:formatDate value="${requestScope.orders.endDate}" pattern="yyy-MM-dd"/> </TD>
				
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">编制人</TD>
				<TD bgColor="yellow">${requestScope.orders.author}</TD>		
				<TD noWrap width="20%" bgColor="#c0c0c0">联系电话</TD>
				<TD bgColor="yellow">${requestScope.orders.phone}</TD>
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">电子邮件</TD>
				<TD bgColor="yellow">${requestScope.orders.email}</TD>
				<TD noWrap width="20%" bgColor="#c0c0c0">联系传真</TD>
				<TD bgColor="yellow">${requestScope.orders.fax}</TD>
				
			</TR>
			<TR align="left">
				<TD noWrap width="20%" bgColor="#c0c0c0">备注</TD>
				<TD bgColor="yellow" colspan="3">${requestScope.orders.remark}</TD>
				
			</TR>

		</table>
		<br>
		
	</div>
	
	<div style="padding: 0 0 0 6px;text-align: center;">

			<input type="button" name="btn" id="btn1" value="关闭">
	</div>
<script type="text/javascript">
$("#btn1").click(function(){
	$("#view").window("close");
});
</script>	
</body>



</html>
