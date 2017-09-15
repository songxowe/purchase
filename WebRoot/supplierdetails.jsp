<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>供应商基本信息</title>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
</script>
</head>
<!--  
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>
-->

<body>


	<div style="margin-top:10px;text-align: center;">
		<table cellSpacing=1 cellPadding=0 width="100%" height="200px"
			bgColor=#336699 border=0>
			<TR bgColor=#ffffff>
				<TD align="center" width="100%" bgColor=#ffffff colSpan=20 height=30>
					<H2>
						<FONT color=#0070c0>供应商基本信息</FONT>
					</H2>
				</TD>
			</TR>
			
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">供应商编号</td>
				<td bgColor="#d6f1f1" colspan="3">${requestScope.supplier.supplierNum}</td>				
			</tr>
			
			<TR align="left">
				<TD noWrap width="20%" bgColor="#c0c0c0">供应商证书编号</TD>
				<TD bgColor="#d6f1f1" width="30%">${requestScope.supplier.certificate}</TD>
				<TD noWrap width="20%" bgColor="#c0c0c0">公司名称</TD>
				<TD bgColor="#d6f1f1" width="30%">${requestScope.supplier.company}</TD>
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">公司性质</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.kind}
				
					</TD>
				<TD noWrap bgColor="#c0c0c0">法人代表</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.corporation}</TD>
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">公司地址</TD>
				<TD bgColor="#d6f1f1"> ${requestScope.supplier.address}</TD>
				<TD noWrap bgColor="#c0c0c0">邮编</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.zip}</TD>
				
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">注册资金</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.regFund}</TD>		
				<TD noWrap width="20%" bgColor="#c0c0c0">联系人</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.contact}</TD>
			</TR>
			
			<TR align="left">
				<TD noWrap bgColor="#c0c0c0">联系电话</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.phone}</TD>
				<TD noWrap width="20%" bgColor="#c0c0c0">联系传真</TD>
				<TD bgColor="#d6f1f1">${requestScope.supplier.fax}</TD>
				
			</TR>
			<TR align="left">
				<TD noWrap width="20%" bgColor="#c0c0c0">电子邮箱</TD>
				<TD bgColor="#d6f1f1" >${requestScope.supplier.email}</TD>
				<TD noWrap width="20%" bgColor="#c0c0c0">业绩</TD>
				<TD bgColor="#d6f1f1" >${requestScope.supplier.achievement}</TD>				
			</TR>

		</table>
		<br>
		
	</div>
	
	<div style="padding: 0 0 0 6px;text-align: center;">
	
			
	</div>


<script type="text/javascript">

	
</script>
</body>
</html>
