<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>录入需求计划</title>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
</script>
</head>

<body>


	<div style="margin-top:10px;text-align: center;">
		<form id="ff" method="post">
			<div>
				物资编码：<input type="text" name="materialCode" placeholder="物资编码"
					value="${material.materialNum}" class="easyui-validatebox"
					data-options="required:true" readonly="readonly">
			</div>
			<br />
			
			<div>
				物资名称：<input type="text" name="materialName" placeholder="物资名称"
					value="${material.materialName}" class="easyui-validatebox"
					data-options="required:true" readonly="readonly">
			</div>
			<br />
			
			<div>
				需求来源：<input type="text" name="orderSource" placeholder="需求来源"
					class="easyui-validatebox" data-options="required:false">

			</div>

			<br />
			<div>
				数&nbsp;&nbsp;量：<input type="text" id=txtAmount name="amount"
					placeholder="数量" class="easyui-validatebox"
					data-options="required:false" onkeyup="checkInt(this);" onpaste="checkInt(this);" 
					oncut="checkInt(this);" ondrop="checkInt(this);" onchange="checkInt(this);">
					 
			</div>
			<br />
			<div>
				计量单位：<input type="text" name="measureUnit" placeholder="计量单位"
					value="${material.materialUnit}" class="easyui-validatebox"
					data-options="required:true" readonly="readonly">
			</div>
			<br />
			<div>
				预算单价：<input type="text" name="unitPrice" placeholder="预算单价"
					class="easyui-validatebox" data-options="required:false"
					id=txtPrice value=0 onkeyup="checkP(this);"  id=txtPrice onpaste="checkP(this);" oncut="checkP(this);" 
					ondrop="checkP(this);" onchange="checkP(this);">
			</div>
			<br />
			<div>
				预算总价：<input type="text" name="sumPrice" placeholder="预算总价"
					class="easyui-validatebox" data-options="required:false" id=txtTotal readonly>
					

			</div>
			<br />
			<div>
				开始日期：<input type="text" name="startDate" id="startDate" placeholder="开始日期"
					class="easyui-datebox" data-options="required:true">
			</div>
			<br />
			<div>
				结束日期：<input type="text" name="endDate" id="endDate" placeholder="结束日期"
					class="easyui-datebox" data-options="validType:'equaldDate[\'#startDate\']'">
			</div>

			<br />
			<div>
				备&nbsp;&nbsp;注：<input type="text" name="remark" placeholder="备注"
					class="easyui-validatebox" data-options="required:false">
			</div>
			<br />
			<div>
				<input type="submit" value="录入">
			</div>
		</form>
	</div>



	<script type="text/javascript">
		$(function() {
			$.extend($.fn.validatebox.defaults.rules, {  
		       equaldDate: {  
		           validator: function (value, param) {  
		               var start = $(param[0]).datetimebox('getValue');  //获取开始时间    
		               return value > start;                             //有效范围为当前时间大于开始时间    
		           },
		           message: '结束日期应大于开始日期!'                     //匹配失败消息  
		       }  
		   });
			//对表单进行提交，并返回结果
			$("#ff").form({
				url : "ordersf/ordersController_save.do",
				onSubmit : function() { //在提交之前触发，返回false可以终止提交。
	
				},
				success : function(data) { //提交成功后的回调函数。
					//var data = eval('(' + data + ')');
					//WQY 2016-11-06 隐藏alert(data)
					// alert(data);
					if (data.count == 0) {
						alert("录入需求计划失败");
					} else {
						alert("录入需求计划成功");
						$('#materialDataGrid').datagrid('reload');
						$('#editMaterial').window('close');
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
