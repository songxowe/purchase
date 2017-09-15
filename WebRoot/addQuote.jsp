<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>新增报价</title>
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
		<form action="" method="post" id="quoteForm" name="quoteForm">
			<table width="500" height="198" id="quoteTable" align="center" class="datalist"
				style="margin: 10px auto;">
	
				   <tr>
					<td colspan="2">询价书编号</td>
					<td colspan="2">
					<input type="hidden" name="orderId" value="${orders.id }">
					<input type="hidden" name="enquireId" value="${enquireDetail.enquireId }">
					<input type="hidden" name="userId" value="${sessionScope['NEWER_USER_LOGIN_INFO'].id}">
					<input class="easyui-textbox" name="enquireNum" value="${enquire.enquireNum}" readonly="readonly"/></td>
					<td colspan="2">报价书标题</td>
					<td colspan="2"><input class="easyui-textbox" name="queTitle"/></td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">询价公司</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.company }" readonly="readonly"/></td>
					<td colspan="2">报价单位</td>
					<td colspan="2"><input class="easyui-textbox" name="quoCompany"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">询价单位地址</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.address }" readonly="readonly"/></td>
					<td colspan="2">报价单位地址</td>
					<td colspan="2"><input class="easyui-textbox" name="quoAddress"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">询价联系人</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.linkman }" readonly="readonly"/></td>
					<td colspan="2">报价联系人</td>
					<td colspan="2"><input class="easyui-textbox" name="quoLinkman"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">电话</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.phone }" readonly="readonly"/></td>
					<td colspan="2">电话</td>
					<td colspan="2"><input class="easyui-textbox" name="quoPhone"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">传真</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.fax }" readonly="readonly"/></td>
					<td colspan="2">传真</td>
					<td colspan="2"><input class="easyui-textbox" name="quoFax"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">邮箱</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.email }" readonly="readonly"/></td>
					<td colspan="2">邮箱</td>
					<td colspan="2"><input class="easyui-textbox" name="quoEmail"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">询价时间</td>
					<td colspan="2"><input class="easyui-datebox" value="${enquire.buildDate }" readonly="readonly"/></td>
					<td colspan="2">报价时间</td>
					<td colspan="2"><input class="easyui-datebox" name="quoDate"/></td>
				  </tr>
				  <tr>
					<td colspan="2">物资编码</td>
					<td colspan="2">物资名称</td>
					<td>数量</td>
					<td>计量单位</td>
					<td>起始到货期</td>
					<td>结束到货期</td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2"><input class="easyui-textbox" name="materialCode" value="${enquireDetail.materialCode }" readonly="readonly"/></td>
					<td colspan="2"><input class="easyui-textbox" name="materialName" value="${enquireDetail.materialName }" readonly="readonly"/></td>
					<td><input type="number" id="amount" name="amount" value="${enquireDetail.amount }" readonly="readonly"/></td>
					<td><input class="easyui-textbox" name="measureUnit" value="${enquireDetail.measureUnit }" readonly="readonly"/></td>
					<td><input class="easyui-datebox" name="startDate" value="${enquireDetail.startDate }" readonly="readonly"/></td>
					<td><input class="easyui-datebox" name="endDate" value="${enquireDetail.endDate }" readonly="readonly"/></td>
				  </tr>
				  
				 <tr>
				 	<td>标准</td>
				 	<td>生产厂家</td>
				 	<td>包装</td>
					<td>单价</td>
					<td>总价</td>
					<td>运杂费</td>
					<td>其他</td>
					<td>总计</td>
				  </tr>
				  <tr class="altrow">
					<td><input class="easyui-textbox" name="standard" value="${enquireDetail.standard }" readonly="readonly"/></td>
					<td><input class="easyui-textbox" name="factory" value="${enquireDetail.factory }" readonly="readonly"/></td>
					<td><input class="easyui-textbox" name="wrap" value="${enquireDetail.wrap }" readonly="readonly"/></td>
					<td><input type="number" id="unitPrice" name="unitPrice" /></td>
					<td><input type="number" id="sumPrice" name="sumPrice" /></td>
					<td><input type="number" id="mixPrice" name="mixPrice" /></td>
					<td><input type="number" id="otherPrice" name="otherPrice" /></td>
					<td><input type="number" id="totalPrice" name="totalPrice"/></td>
				  </tr>
				  
				  <tr class="altrow">
				  	<td>生产年限</td>
				  	<td><input name="prodYear" class="easyui-combobox" data-options="valueField: 'value',textField: 'label',data: [{label: '一年',value: 'S003-1',selected:true},{label: '两年',value: 'S003-2'},{label: '三年',value: 'S003-3'}]" ></td>
					<td colspan="2">说明</td>
					<td colspan="6" ><input type="text" class="easyui-textbox" style="width:700px" name="quoRemark" value="${quote.quoRemark }" /></td>
				  </tr>
				  
				  <tr>
					<td colspan="8">
						<div align="center">
							<input type="submit" value="保存" />
							<input type="button" id="btn1" value="返回">
						</div>
					</td>
				</tr>
				 
			</table>
		</form>
		
		<script type="text/javascript">
		$("#quoteForm").form( {
		url : "quoteController_saveQuote.html",
		success : function(data) {
			if (data) {
				$.messager.show( {
					title : "提示",
					msg : "商品" + data + "成功!"
				});
				$("#addQuote").window("close",true);
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
		$("#addQuote").window("close",true);
	});			
		</script>
	</body>
</html>
