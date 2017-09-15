<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>合同明细</title>
		<%@ include file="commons/meta.jsp"%>
	</head>

	<body>
		<style>
.datalist{  
    border:1px solid #0058a3;   /* 表格边框 */  
    font-family:Arial;  
    border-collapse:collapse;   /* 边框重叠 */  
    background-color:#eaf5ff;   /* 表格背景色 */  
    font-size:14px;  
}  
.datalist caption{  
    padding-bottom:5px;  
    font:bold 1.4em;  
    text-align:left;  
}  
.datalist th{  
    border:1px solid #0058a3;   /* 行名称边框 */  
    background-color:#4bacff;   /* 行名称背景色 */  
    color:#FFFFFF;              /* 行名称颜色 */  
    font-weight:bold;  
    padding-top:4px; padding-bottom:4px;  
    padding-left:12px; padding-right:12px;  
    text-align:center;  
}  
.datalist td{  
    border:1px solid #0058a3;   /* 单元格边框 */  
    text-align:left;  
    padding-top:4px; padding-bottom:4px;  
    padding-left:10px; padding-right:10px;  
}  
.datalist tr.altrow{  
    background-color:#c7e5ff;   /* 隔行变色 */  
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
		<form action="" method="post" id="ContapForm" name="ContapForm">
			<table width="100%" height="198" id="stockPannerTable" align="center" class="datalist"
				style="margin: 10px auto;">
				   <tr>
					<td colspan="2">采购计划名称</td>
					<td colspan="2">${contractApplyPanner.stockname}</td>
					<td colspan="2">报价份数</td>
					<td colspan="2">1</td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">最高报价</td>
					<td colspan="2">${contractApplyPanner.topQuote }</td>
					<td colspan="2">最低报价</td>
					<td colspan="2">${contractApplyPanner.lowQuote }</td>
				  </tr>
				  <tr>
					<td colspan="2">供应商</td>
					<td colspan="2">${contractApplyPanner.supplierNum }</td>
					<td colspan="2" class="">报价时间</td>
					<td colspan="2"><spring:eval expression="contractApplyPanner.startDate"/></td>
				  </tr>
				  <tr class="altrow">
					<td colspan="9">计划报价</td>
				  </tr>
				  <tr>
					<td>供应商</td>
					<td>数量</td>
					<td>单价</td>
					<td>运杂费(元/含税)</td>
					<td>其他(元/含税)</td>
					<td>总计(元/含税)</td>
					<td>计划开始开始时间</td>
					<td>计划结束时间</td>
				  </tr>
				  <tr class="altrow">
					<td>${contractApplyPanner.supplierNum }</td>
					<td>${contractApplyPanner.amount }</td>
					<td>${contractApplyPanner.unitPrice }</td>
					<td> ${contractApplyPanner.mixPrice }</td>
					<td>${contractApplyPanner.otherPrice }</td>
					<td>${contractApplyPanner.totalPrice}</td>
					<td><spring:eval expression="contractApplyPanner.startDate"/></td>
					<td><spring:eval expression="contractApplyPanner.endDate"/></td>
				  </tr>
				  <tr>
					<td colspan="2">需求计划数量</td>
					<td colspan="2">${contractApplyPanner.amount }</td>
					<td colspan="2">订货数量</td>
					<td colspan="2">${contractApplyPanner.amount }</td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">总金额</td>
					<td colspan="6">${contractApplyPanner.totalPrice}</td>
				  </tr>
			</table>
		</form>
	</body>
</html>
