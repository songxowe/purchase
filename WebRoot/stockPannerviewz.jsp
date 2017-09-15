<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>采购明细</title>
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
		<form action="" method="post" id="stockPannerForm" name="stockPannerForm">
			<table width="500" height="198" id="stockPannerTable" align="center" class="datalist"
				style="margin: 10px auto;">
				   <tr>
					<td colspan="2">采购计划编号</td>
					<td colspan="2">${stocks.stockNum}</td>
					<td colspan="2">采购计划名称</td>
					<td colspan="2">${stocks.stockName }</td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">公司名称</td>
					<td colspan="2">株洲南车时代电气股份有限公司</td>
					<td colspan="2">编制人</td>
					<td colspan="2">${stocks.author }</td>
				  </tr>
				  <tr>
					<td colspan="2">预算金额(元)</td>
					<td colspan="2">${stocks.budget }</td>
					<td colspan="2" class="">计划询价开始时间</td>
					<td colspan="2">${stocks.sstartDate }</td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">计划报价截止时间</td>
					<td colspan="2">${stocks.endDate }</td>
					<td colspan="4"></td>
				  </tr>
				  <tr>
					<td>物资编码</td>
					<td>物资名称</td>
					<td>数量</td>
					<td>计量单位</td>
					<td>交货期</td>
					<td>协议价格（元）</td>
					<td>预算总金额（元）</td>
					<td>计划价（元/不含税）</td>
				  </tr>
				  <tr class="altrow">
					<td>${stocks.materialCode }</td>
					<td>${stocks.materialName }</td>
					<td>${stocks.amount }</td>
					<td> ${stocks.measureUnit }</td>
					<td>${stocks.ostartDate }</td>
					<td></td>
					<td>${stocks.sumPrice }</td>
					<td>${stocks.unitPrice }</td>
				  </tr>
				  <tr>
					<td colspan="2">采购方式</td>
					<td colspan="6"> ${stocks.stockType }</td>
				  </tr>
				  
			</table>
		</form>
	</body>
</html>
