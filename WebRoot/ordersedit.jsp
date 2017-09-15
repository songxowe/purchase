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

<title>修改需求计划</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="easyui/jquery.min.js"></script>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
</script>
</head>

<body>
	<div style="margin-top:10px;text-align: center;">
		<form id="ff" method="post">
		<input type="hidden" name="id" value="${requestScope.orders.id}">
		<table cellSpacing=1 cellPadding=0 width="100%" height="200px"
			bgColor=#336699 border=0>
			<TR bgColor=#ffffff>
				<TD align="center" width="100%" bgColor=#ffffff colSpan=20 height=30>
					<H2>
						<FONT color=#0070c0>修改需求计划</FONT>
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
				<TD bgColor="yellow" width="30%"><input type="text" name="amount"
						value="${requestScope.orders.amount}"
						placeholder="数量" class="easyui-validatebox"
						data-options="required:false" id=txtAmount onkeyup="checkInt(this);" onpaste="checkInt(this);" 
					oncut="checkInt(this);" ondrop="checkInt(this);" onchange="checkInt(this);"></TD>
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">计量单位</TD>
				<TD bgColor="yellow">${requestScope.orders.measureUnit}</TD>
				<TD noWrap bgColor="#c0c0c0">预算单价(元)</TD>
				<TD bgColor="yellow"><input type="text" name="unitPrice" placeholder="预算单价"
					value="${requestScope.orders.unitPrice}" class="easyui-validatebox" 
					data-options="required:false" id=txtPrice onpaste="checkP(this);" oncut="checkP(this);" 
					ondrop="checkP(this);" onchange="checkP(this);"></TD>
				
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">预算总价(元)</TD>
				<TD bgColor="yellow" colspan="3">
				<input type="text" name="sumPrice" placeholder="预算总价" value="${requestScope.orders.sumPrice}"
					class="easyui-validatebox" data-options="required:false" id=txtTotal readonly>
				</TD>
				
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">开始交货期</TD>
				<TD bgColor="yellow"><input type="text" name="startDate" placeholder="开始日期"
						value="${requestScope.orders.startDate}"
						class="easyui-datebox" data-options="required:false"> </TD>
				<TD noWrap bgColor="#c0c0c0">结束交货期</TD>
				<TD bgColor="yellow"><input type="text" name="endDate" placeholder="结束日期"
						value="${requestScope.orders.endDate}"
						class="easyui-datebox" data-options="required:false"></TD>
				
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
				<TD bgColor="yellow" colspan="3"><input type="text" name="remark" placeholder="备注"
						value="${requestScope.orders.remark}"
						class="easyui-validatebox" data-options="required:false"></TD>
				
			</TR>

		</table>
		<br>
		<input type="submit" value="修改">
		</form>
	</div>
	
	<div style="padding: 0 0 0 6px;text-align: center;">

			
			
	</div>
<script type="text/javascript">
		$(function() {
			//对表单进行提交，并返回结果
			$("#ff").form({
				url : "ordersf/ordersController_edit.html",
				onSubmit : function() { //在提交之前触发，返回false可以终止提交。
	
				},
				success : function(data) { //提交成功后的回调函数。
					if (data == 1) {
						alert("需求计划修改失败");
						$('#ordersViewDataGrid').datagrid('reload'); 
						$('#edit').window('close'); 
					}
					else {						
						alert("需求计划修改成功");
						$('#ordersViewDataGrid').datagrid('reload');
						$('#edit').window('close');
						 
				}
			}
		});
		 
	});
</script>	
<script type="text/javascript">
		function checkInt(o) {
			theV = isNaN(parseInt(o.value)) ? 0 : parseInt(o.value);
			if (theV != o.value) {
				o.value = theV;
			}
			txtTotal.value = txtAmount.value * txtPrice.value;
		}
		function checkP(o) {
			theV = isNaN(parseFloat(o.value)) ? 0 : parseFloat(o.value);
			theV = parseInt(theV * 100) / 100;
			if (theV != o.value) {
				theV = (theV * 100).toString();
				theV = theV.substring(0, theV.length - 2) + "." + theV.substring(theV.length - 2, theV.length)
				o.value = theV;
			}
			txtTotal.value = txtAmount.value * txtPrice.value;
		}
	</script>
</body>



</html>
