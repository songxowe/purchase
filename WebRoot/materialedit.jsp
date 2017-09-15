<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>物资管理</title>
		<%@ include file="commons/meta.jsp"%>
	</head>

  
 	<body>
		<style>
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
		<form action="" method="post" id="materialForm" name="materialForm">
			<table width="500" height="198" id="materialTable"
				style="margin: 10px auto;">
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							物资名：
						</div>
					</td>
					<td>
						<input class="easyui-validatebox" name="materialName" value="${material.materialName }"/>
						<input type="hidden" name="id" value="${material.id }" />						
					</td>
					<td>
						&nbsp;
					</td>
				</tr>				
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							物质编码：
						</div>
					</td>
					<td>
						<input type="text" class="easyui-textbox" name="materialNum"   value="${material.materialNum }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
								
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							计量单位：
						</div>
					</td>
					<td>
					    <input type="text"  class="easyui-textbox" name="materialUnit" value="${material.materialUnit }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							物资类别：
						</div>
					</td>
					<td>
						<input name="materialType" type="text" class="easyui-textbox" value="${material.materialType }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				<tr>
					<td>
						&nbsp;
					</td>
					<td colspan="2">
						<div align="center">
							<input type="submit" value="保存" />
							<input type="reset" value="重置" />
						</div>
					</td>
					<td height="20">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
	$("#materialForm").form( {
		url : "materialController_save.html",
		success : function(data) {
			if (data) {
				$.messager.show( {
					title : "提示",
					msg : "物资" + data + "成功!"
				});
				$("#editMaterial").window("close",true);
			}
		}
	});
</script>
	</body>
</html>
