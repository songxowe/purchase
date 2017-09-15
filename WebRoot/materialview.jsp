<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>物资</title>
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
		<form action="" method="post" id="materialForm">
			<table width="500" height="198" id="materialTable"
				style="margin: 10px auto;">
				<tr>
					<td width="25" height="35" style="">
						&nbsp;
					</td>
					<td width="117">
						<div align="right">
							序号：
						</div>
					</td>
					<td width="269">
						${material.id }
					</td>
					<td width="69">
						&nbsp;
					</td>
				</tr>
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
						${material.materialName}
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
							物资编码：
						</div>
					</td>
					<td>
						${material.materialNum }
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
						${material.materialUnit }
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
						${material.materialType}
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
							<a href='#' class="easyui-linkbutton" onclick="closeWindowOfEmpView()">返回</a>
						</div>
					</td>
					<td height="20">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	<script type="text/javascript">
		function closeWindowOfEmpView(){
			$("#editMaterial").window("close",true);
		}
	</script>
	</body>
</html>
