<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>采购计划明细信息</title>
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
		<form action="" method="post" id="quoteDetailForm" name="quoteDetailForm">
			<table width="500" height="198" id="stocksTable" align="center" class="datalist"
				style="margin: 10px auto;">
				   <tr>
				   	
					<td colspan="2">物资编码</td>
					<td>
					<input type="hidden" name="id" value="${quoteDetail.id }">
					<input type="hidden" name="quoteId" value="${quoteDetail.quoteId }">
					<input type="hidden" name="orderId" value="${quoteDetail.orderId }">
					<input class="easyui-textbox" name="materialCode" value="${quoteDetail.materialCode }" readonly="readonly"/></td>
					<td colspan="2">物资名称</td>
					<td><input class="easyui-textbox" name="materialName" value="${quoteDetail.materialName }" readonly="readonly"/></td>
				  	<td colspan="2">计量单位</td>
				  	<td><input class="easyui-textbox" name="measureUnit" value="${quoteDetail.measureUnit }" readonly="readonly"/></td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">单价</td>
					<td><input type="number" id="unitPrice" name="unitPrice" value="${quoteDetail.unitPrice }" 
					  /></td>
					<td colspan="2">数量</td>
					<td><input type="number" id="amount" name="amount" value="${quoteDetail.amount }"
					 /></td>
					<td colspan="2">小计</td>
					<td><input type="number" id="sumPrice" name="sumPrice" value="${quoteDetail.sumPrice }" readonly="readonly" 
					 /></td>
				  </tr>
				  <tr>
					<td colspan="2">运杂费</td>
					<td><input type="number" id="mixPrice" name="mixPrice" value="${quoteDetail.mixPrice }" /></td>
					<td colspan="2">其他费用</td>
					<td><input type="number" id="otherPrice" name="otherPrice" value="${quoteDetail.otherPrice }" /></td>
					<td colspan="2">总计</td>
					<td><input type="number" id="totalPrice" name="totalPrice" value="${quoteDetail.totalPrice }" readonly="readonly" /></td>
				  </tr>
				  <tr>
				  	<td colspan="2">起始到货日期</td>
				  	<td><input class="easyui-datebox" name="startDate" value="${quoteDetail.startDate }"/></td>
				  	<td colspan="2">结束到货日期</td>
				  	<td><input class="easyui-datebox" name="endDate" value="${quoteDetail.endDate }"/></td>
				  	<td colspan="2">包装</td>
				  	<td><input class="easyui-textbox" name="wrap" value="${quoteDetail.wrap }" /></td>
				  </tr>
				  
				  <tr>
					<td colspan="2">标准</td>
					<td><input name="standard" class="easyui-combobox" value="${quoteDetail.standard }" data-options="valueField: 'value',textField: 'label',data: 
					[{label: '军标',value: 'Z000-1'},{label: '国际标',value: 'Z000-2'},
					{label: '铁标',value: 'Z000-3'},{label: '国标',value: 'Z000-4'},
					{label: '需厂房说明',value: 'Z000-5'},{label: '其他',value: 'Z000-6'}]"></td>
					<td colspan="2">生产厂家</td>
					<td><input class="easyui-textbox" name="factory" value="${quoteDetail.factory }" /></td>
					<td colspan="2">生产年限</td>
					<td><input name="prodYear" class="easyui-combobox" value="${quoteDetail.prodYear }" data-options="valueField: 'value',textField: 'label',data: 
					[{label: '一年',value: 'S003-1'},{label: '两年',value: 'S003-2'},
					{label: '三年',value: 'S003-3'}]" ></td>
				  </tr>
				  
				  <tr>
					<td colspan="9">
						<div align="center">
							<input type="submit" value="保存" />
							<input type="button" id="btn1" value="返回">
						</div>
					</td>
				</tr>
			</table>
		</form>
		
	<script type="text/javascript">
		$("#quoteDetailForm").form( {
		url : "quoteController_editQuoteDetail.html",
		success : function(data) {
			if (data) {
				$.messager.show( {
					title : "提示",
					msg : "商品" + data + "成功!"
				});
				$("#editQuote").window("close",true);
			}
		}
	});
	
	$("#unitPrice,#amount").change(function(){
		var sum=$("#unitPrice").val()*$("#amount").val();
		$("#sumPrice").val(sum);
	});
	
	$("#sumPrice,#mixPrice,#otherPrice").change(function(){
		var num1=$("#sumPrice").val();
		var num2=$("#mixPrice").val();
		var num3=$("#otherPrice").val();
		var sum=parseInt(num1)+parseInt(num2)+parseInt(num3);
		$("#totalPrice").val(sum);
	});

	$("#btn1").click(function(){
			$("#editQuote").window("close",true);
		});
	</script>

	</body>
</html>
