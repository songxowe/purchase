<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
<head>
<title>财务部长审批</title>
<%@ include file="commons/meta.jsp"%>
</head>

<body>
	<style>
.input {
	width: 200px;
	height: 20px;
	border: 1px solid #95B8E7;
}
</style>
	<form action="" method="post" id="contalForm">
	<input type="hidden" name="id" value="${contractApply.id}">
		<table width="500" height="192" id="contalTable"
			style="margin: 10px auto;">
			<tr>
				<td><input type="hidden" name="inmappingId"
					value="${inmappingId }"> <input type="hidden" name="id"
					value="${contractApplys.id }"> 审批人序号:</td>
				<td><input type="text" class="easyui-textbox" name="leaderId"
					value="${sessionScope['NEWER_USER_LOGIN_INFO'].id}" /></td>
			</tr>
			<tr>
				<td>审批人:</td>
				<td><input type="text" class="easyui-textbox" name="leader"
					value="${sessionScope['NEWER_USER_LOGIN_INFO'].username}" /></td>
			</tr>
			<tr>
				<td>审批时间:</td>
				<td>
				<fmt:formatDate value='${contractApplys.leadDate }' pattern='yyyy-MM-dd hh:mm:ss' />
				
			</td>
			</tr>
			<tr>
				<td>是否同意:</td>
				<td><select name="leadAgree">
						<option value="">--请选择--</option>
						<option value="S002-1">同意</option>
						<option value="S002-0">不同意</option>
				</select></td>
			</tr>
			<tr>
				<td>审批意见:</td>
				<td><input class="easyui-textbox" data-options="multiline:true"
					name="leadOpinion" style="width:300px;height:100px"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<input type="submit" value="保存" /> <input type="reset" value="重置" />
					</div>
				</td>
				<td height="20">&nbsp;</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$("#contalForm").form({
			url : "contractApplyLeaderController_addLeaderleadAgree.html",
			success : function() {
					$.messager.show({
						title : "提示",
						msg : "审批成功!"
					});
					$("#editContall").window("close", true);
				}
			}
		);
	</script>


</body>
</html>
