<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>物资详情</title>
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
		<form action="" method="post" id="stockForm">
			<table width="500" height="198" id="stockTable"
				style="margin: 10px auto;">
				<tr>
					<td width="25" height="35" style="">
						&nbsp;
					</td>
					<td width="117">
						<div align="right">
							需求计划编号：
						</div>
					</td>
					<td width="269">
						${orders.orderNum }
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
							产品编码：
						</div>
					</td>
					<td>
						${orders.materialCode }
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
							产品名称：
						</div>
					</td>
					<td>
						${orders.materialName }
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
							数量：
						</div>
					</td>
					<td>
						${orders.amount }
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
						${orders.measureUnit }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							预算单价（元）
						</div>
					</td>
					<td>
						${orders.unitPrice }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							开始交货期：
						</div>
					</td>
					<td>
					<fmt:formatDate value='${orders.startDate }' pattern='yyyy-MM-dd hh:mm:ss' />
						
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							业务员：
						</div>
					</td>
					<td>
						${orders.author }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							电子邮件：
						</div>
					</td>
					<td>
						${orders.email }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							联系电话：
						</div>
					</td>
					<td>
						${orders.phone }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							联系传真：
						</div>
					</td>
					<td>
						${orders.fax }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				</tr>
					<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							备注：
						</div>
					</td>
					<td>
						${orders.remark }
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				
				
			</table>
		</form>
		<script type="text/javascript">
			function closeWindowOfStockView(){
				$("#editStock").window("close",true);
			}
		</script>
	</body>
</html>
