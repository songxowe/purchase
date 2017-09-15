<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>查看询价明细表</title>
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
		<form action="" method="post" id="enquireForm" name="enquireForm">
			<table width="500" height="198" id="quoteTable" align="center" class="datalist"
				style="margin: 10px auto;">
				   <tr>
					<td colspan="2">询价书编号</td>
					<td colspan="2">
					<input class="easyui-textbox" value="${enquire.enquireNum}" readonly="readonly"/></td>
					<td colspan="2">询价书名称</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.enquireName}" readonly="readonly"/></td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2">单位</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.company }" readonly="readonly"/></td>
					<td colspan="2">联系人</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.linkman }" readonly="readonly"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">联系地址</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.address }" readonly="readonly"/></td>
					<td colspan="2">联系电话</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.phone }" readonly="readonly"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">传真</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.fax }" readonly="readonly"/></td>
					<td colspan="2">邮编</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.zip }" readonly="readonly"/></td>
				  </tr>
				  
				  <tr class="altrow">
					<td colspan="2">E-mail</td>
					<td colspan="2"><input class="easyui-textbox" value="${enquire.email }" readonly="readonly"/></td>
					<td colspan="2">截止日期</td>
					<td colspan="2"><input class="easyui-datebox" value="${enquire.endDate }" readonly="readonly"/></td>
				  </tr>
				  
				  <tr>
					<td colspan="2">物资编码</td>
					<td colspan="2">物资名称</td>
					<td>数量</td>
					<td>计量单位</td>
					<td>计划单价</td>
					<td>小计</td>
				  </tr>
				  <tr class="altrow">
					<td colspan="2"><input class="easyui-textbox" value="${enquireDetail.materialCode }" readonly="readonly"/></td>
					<td colspan="2"><input class="easyui-textbox" value="${enquireDetail.materialName }" readonly="readonly"/></td>
					<td><input class="easyui-textbox" value="${enquireDetail.amount }" readonly="readonly"/></td>
					<td><input class="easyui-textbox" value="${enquireDetail.measureUnit }" readonly="readonly"/></td>
					<td><input class="easyui-numberbox" value="${orders.unitPrice }" readonly="readonly"/></td>
					<td><input class="easyui-numberbox" value="${orders.sumPrice }" readonly="readonly"/></td>
				  </tr>
				  
				  <tr>
					<td colspan="8">
						<div align="center">
							<input type="button" id="btn1" value="返回">
						</div>
					</td>
				</tr>
				 
			</table>
		</form>
		
		<script type="text/javascript">
		
			$("#btn1").click(function(){
				$("#editEnquire").window("close",true);
			});
		</script>
	</body>
</html>
