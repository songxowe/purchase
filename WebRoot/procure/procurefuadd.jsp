<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html>
<head>
<title>编制询价书</title>
<%@ include file="../commons/meta.jsp"%>
</head>
<!--  
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="../login.jsp" />
</c:if>
-->

<body>
	<div style="padding: 0 0 0 6px;text-align: center;">
	<h3>编制询价书</h3>
	</div>
	
	<form action="" method="post" id="form1" name="form1">
	<table style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0
			width="100%" bgColor=#336699  border=0>
		<tr>
			<td width="20%" bgColor="#99ccff">询价书名称</td>
			<td width="30%" bgColor="#f2f8ff">
				<input type="text" name="enquireName" placeholder="询价书名称"
						 class="easyui-validatebox"
						data-options="required:true" >
			</td>
			<td width="20%" bgColor="#99ccff">公司名称</td>
			<td width="30%"><input type="text" name="company" placeholder="公司名称"
						  class="easyui-validatebox"
						data-options="required:true" ></td>
		</tr>
		
		<tr>
			<td bgColor="#99ccff">联系人</td>
			<td width="30%" bgColor="#f2f8ff">
				<input type="text" name="linkman" placeholder="联系人"
						 value="${stock.author}" class="easyui-validatebox"
						data-options="required:true" >
			</td>
			<td bgColor="#99ccff">联系地址</td>
			<td width="30%" bgColor="#f2f8ff">
				<input type="text" name="address" placeholder="联系地址"
						  class="easyui-validatebox"
						data-options="required:true" >
			</td>
		</tr>
		
		<tr>
			<td bgColor="#99ccff">联系电话</td>
			<td width="30%" bgColor="#f2f8ff">
				<input type="text" name="phone" placeholder="联系电话"
						  class="easyui-validatebox"
						data-options="required:true" >
			</td>
			<td bgColor="#99ccff">联系传真</td>
			<td width="30%" bgColor="#f2f8ff">
				<input type="text" name="fax" placeholder="联系传真"
						  class="easyui-validatebox"
						data-options="required:true" >
			</td>

		</tr>
		<tr>
			<td bgColor="#99ccff">Email</td>
			<td  bgColor="#f2f8ff" >
				<input type="text" name="email" placeholder="Email"
						  class="easyui-validatebox"
						data-options="required:true" >
			</td>
			<td bgColor="#99ccff">邮编</td>
			<td width="30%" bgColor="#f2f8ff">
				<input type="text" name="zip" placeholder="邮编"
						  class="easyui-validatebox"
						data-options="required:true" >
			</td>
		</tr>
		
		<tr>
			<td bgColor="#99ccff">报价截止时间</td>
			<td  bgColor="#f2f8ff" colspan="3">
				<input type="text" name="endDate" placeholder="报价截止时间"
					value="${stock.endDate}" class="easyui-datebox" data-options="required:false">
			</td>			
		</tr>		
	</table>
	
	<h4>我公司欲采购下述物资，如贵单位感兴趣，可参与网上报价。详细物资情况如下：</h4>
	<c:forEach items="${requestScope.list}" var="orders" varStatus="rows">
		<div style="padding: 0 0 0 6px;text-align: center;">
			<h4>需求计划  ${rows.index + 1 }</h4>
		</div>
		<table style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0
			width="100%" bgColor=#99ccff  border=0>
			<tr  bgColor="#f2f8ff">
				<td width="20%">物资编码</td>
				<td width="30%">${orders.materialCode}</td>
				<td width="20%">物资名称</td>
				<td width="30%">${orders.materialName}</td>
			</tr>
			
			<tr  bgColor="#f2f8ff">
				<td width="20%">单价</td>
				<td width="30%">${orders.unitPrice}</td>
				<td width="20%">数量</td>
				<td width="30%">${orders.amount}</td>
			</tr>
			
			<tr  bgColor="#f2f8ff">
				<td width="20%">计量单位</td>
				<td width="30%">${orders.measureUnit}</td>
				<td width="20%">总价</td>
				<td width="30%">${orders.sumPrice}</td>
			</tr>			
		</table>
	</c:forEach>
	<table style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0
			width="100%" bgColor=#99ccff  border=0>
			<tr>
				<td width="20%">询价说明</td>
				<td width="80%">
					<textarea id="remark" name="remark" rows="4" cols="80"></textarea>
				</td>
			</tr>
	</table>
		<div style="padding: 0 0 0 6px;text-align: center;">
			<input type="submit" value="编制">  
			<input type="reset"  value="重置">
		</div>
	</form>
	<script type="text/javascript">
		$(function() {
				
				
				$("#form1").form({
				url : "procurefu/procurefuController_add.do",
				onSubmit : function() { //在提交之前触发，返回false可以终止提交。
	
				},
				success : function(data) { //提交成功后的回调函数。
					//var data = eval('(' + data + ')');
					
					if (data) {
						alert("编制询价书成功");
						$('#dd').window('close'); 
						$('#stockDataGrid').datagrid('reload');
					}
					else {
						alert("编制询价书失败");
				}
			}
		});	
	});
	</script>
</body>
</html>
