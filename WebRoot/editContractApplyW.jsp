<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>编制合同申请</title>
<script src="easyui/jquery.min.js"></script>
</head>

<body>
	<form method="post" id="form1" name="form1">
	<table class="datalist">
		<tr>
			<th colspan="9">编制合同申请</th>
		</tr>
		<tr>
			<td class="altrow">询价书名称：</td>
			<td colspan="3">${enquire.enquireName }</td>
			<td colspan="2" class="altrow">报价份数：</td>
			<td colspan="3">
				<input type="text" class="txt1" name="statQuote" readonly value="${fn:length(enquire.quotes) }">
			</td>
		</tr>
		<tr>
			<td class="altrow">最高报价（元）：</td>
			<td colspan="3">
				<input type="text" class="txt1" name="topQuote" readonly value="${enquire.maxPrice }">
			</td>
			<td colspan="2" class="altrow">最低报价（元）：</td>
			<td colspan="3">
				<input type="text" class="txt1" name="lowQuote" readonly value="${enquire.minPrice }">
			</td>
		</tr>
		<tr class="altrow">
			<td>物资：</td>
			<td colspan="4">${enquire.enquDetail.materialName }&nbsp;[${enquire.enquDetail.materialCode }]</td>
			<td colspan="2">数量：${enquire.enquDetail.amount }&nbsp;${enquire.enquDetail.measureUnit }</td>
			<td colspan="2"> 计划价（元/不含税）:&nbsp;${enquire.order.unitPrice }</td>
		</tr>
		<tr class="altrow">
			<td width="200">供应商</td>
			<td width="50">数量</td>
			<td width="140">单价（元/含税）</td>
			<td width="120">运杂费（元）</td>
			<td width="130">其他费用（元）</td>
			<td width="100">总计（元）</td>
			<td width="130">计划开始交货期</td>
			<td width="130">开始交货期</td>
			<td width="130">结束交货期</td>
		</tr>
		<c:forEach items="${enquire.quotes }" var="quo">
		<tr>
			<td style="font-weight:boldl;color:blue">▶&nbsp;&nbsp;&nbsp;${quo.quoCompany}</td>
			<td >${quo.quoteDetail.amount}</td>
			<td >${quo.quoteDetail.unitPrice}</td>
			<td >${quo.quoteDetail.mixPrice}</td>
			<td >${quo.quoteDetail.otherPrice}</td>
			<td class="sum">${quo.quoteDetail.totalPrice}</td>
			<td ><spring:eval expression="enquire.enquDetail.startDate" /></td>
			<td ><spring:eval expression="quo.quoteDetail.startDate" /></td>
			<td ><spring:eval expression="quo.quoteDetail.endDate" /></td>
		</tr>
		</c:forEach>
		<tr>
			<td style="text-align:center">总金额（元）</td>
			<td colspan="8" id="total"></td>
		</tr>
		
		<tr>
			<td style="text-align:center">备注</td>
			<td colspan="8"><input type="text" name="remark"  size="130"></td>
		</tr>
		
		<tr height="50">
			<td style="text-align:center" colspan="9">
				<input type="hidden" id="allSumPrice" name="allSumPrice">
				<input type="hidden" name="eid" value="${enquire.id }">
				<input type="button" value="编制合同申请" id="sub">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="取消" id="btn155">
			</td>
		</tr>
	</table>
	</form>
	
	
<script type="text/javascript">
	$(function(){
		var total=0;
		$(".sum").each(function(data){
			total=total+parseInt($(this).text());
		});
		$("#total").text(total.toFixed(1));
		$("#allSumPrice").val(total);
	});
	
	$("#sub").click(function(){
		$("#form1").form('submit',{
			url:"addContractApply",
			success:function(data){		
					if(data>0){
						$.messager.show({
						title:"提示",
						msg:'编制合同申请成功'
						});
					}else{
						alert("提交失败！");
					}																
				$("#quirevieww").window('close');				
			}
		});
	});
	


	$("#btn155").click(function(){
		$("#quirevieww").window('close')
	});
</script>
<style>
.txt1{border:0;background:none}
.datalist {
	border: 1px solid #0058a3; /* 表格边框 */
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 15px;
}

.datalist caption {
	padding-bottom: 5px;
	font: bold 1.4em;
	text-align: left;
}

.datalist th {
	border: 1px solid #0058a3; /* 行名称边框 */
	background-color: #4bacff; /* 行名称背景色 */
	color: #FFFFFF; /* 行名称颜色 */
	font-weight: bold;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 12px;
	padding-right: 12px;
	text-align: center;
}

.datalist td {
	border: 1px solid #0058a3; /* 单元格边框 */
	text-align: left;
	padding-top: 4px;
	padding-bottom: 7px;
	padding-left: 10px;
	padding-right: 10px;
}

.datalist tr.altrow {
	background-color: #c7e5ff; /* 隔行变色 */
}

.datalist tr td.altrow {
	background-color: #c7e5ff; /* 单元格变色 */
}

.input {
	width: 200px;
	height: 20px;
	border: 1px solid #95B8E7;
}

.btn {
	width: 100px;
	height: 20px;
	border: 1px solid #95B8E7;
}
</style>
</body>
</html>
