<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>填写供应商信息</title>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
</script>
</head>
<!--  
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>
-->

<body>
	

	<div style="margin-top:10px;text-align: center;">
		<form id="ff" method="post">
	
		<table id="registerTable" cellSpacing=1 cellPadding=0 width="100%" height="200px"
			bgColor=#f6f6f6 border=0>
			<TR bgColor=#ffffff>
				<TD align="center" width="100%" bgColor=#ffffff colSpan=20 height=30>
					<H2>
						<FONT color=#0070c0>填写供应商信息</FONT>
					</H2>
				</TD>
			</TR>
			
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">公司名称</td>
				<td bgColor="#59acff" >
					<input type="text" name="company" placeholder="公司名称"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>	
				<td noWrap width="20%" bgColor="#c0c0c0">供应商证书编号</td>
				<td bgColor="#59acff" >
					<input type="text" name="certificate" placeholder="供应商证书编号"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>			
			</tr>
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">法人代表</td>
				<td bgColor="#59acff" >
					<input type="text" name="corporation" placeholder="法人代表"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>	
				<td noWrap width="20%" bgColor="#c0c0c0">注册资金</td>
				<td bgColor="#59acff" >
					<input type="text" name="regFund" placeholder="注册资金"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>						
			</tr>
			
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">地址</td>
				<td bgColor="#59acff" >
					<input type="text" name="address" placeholder="地址"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>	
				<td noWrap width="20%" bgColor="#c0c0c0">邮编</td>
				<td bgColor="#59acff" >
					<input type="text" name="zip" placeholder="邮编"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>						
			</tr>
			
				<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">联系人</td>
				<td bgColor="#59acff" >
					<input type="text" name="contact" placeholder="联系人"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>	
				<td noWrap width="20%" bgColor="#c0c0c0">电话</td>
				<td bgColor="#59acff" >
					<input type="text" name="phone" placeholder="电话"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>						
			</tr>
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">电子邮箱</td>
				<td bgColor="#59acff" >
					<input type="text" name="email" placeholder="电子邮箱"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>	
				<td noWrap width="20%" bgColor="#c0c0c0">传真</td>
				<td bgColor="#59acff" >
					<input type="text" name="fax" placeholder="传真"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>						
			</tr>                             			
			<tr align="left">
				<td noWrap width="20%" bgColor="#c0c0c0">公司性质</td>
				<td bgColor="#59acff" colspan="1">
					<select id="kind" name="kind"  class="easyui-validatebox"
						data-options="required:true" >>
                       <option value="" selected>--请选择--</option>
						<option value="G000-1">国有企业</option>
						<option value="G000-2">集体企业</option>
						<option value="G000-3">股份合作企业</option>
						<option value="G000-4">有限责任公司</option>
						<option value="G000-5">股份有限公司</option>
						<option value="G000-6">私营独资企业</option>
						<option value="G000-7">中外合资经营企业</option>
						
					</select>
					
				</td>	
				<td noWrap width="20%" bgColor="#c0c0c0">业绩</td>
				<td bgColor="#59acff" >
					<input  type="text" name="achievement" placeholder="业绩"
						 class="easyui-validatebox"
						data-options="required:true" >
				</td>	
									
			</tr>
					
					
		</table>
		<br>
		<div id="dd"></div>
		
		<div style="padding: 0 0 0 6px;text-align: center;">
			<input  type="submit" value="保存/请确认信息将不会被修改/删除" >  
			<input type="reset" value="清除">
		
	
		</div>
	
	</form>	
	</div>
	
	


	<script type="text/javascript">
		$(function() {
			//对表单进行提交，并返回结果
			$("#ff").form({
				url : "supplierController_add.do",
				onSubmit : function() { //在提交之前触发，返回false可以终止提交。
	   return re=$("#ff").form('validate');
				},
				
				success : function(data) { //提交成功后的回调函数。success
				//alert(data);
					//var data = eval('(' + data + ')');
			
				
					if (data>0) {
						$.messager.show({
						title:"提示",
                        msg:"填写成功  "
                    });
					}
					else {
						$.messager.show({
						
                      title : "提示",
                      msg : "填写失败",
                       clear:true
                    });
						  
				}
				return re=$("#ff").form('clear');
			}
		});
		 
	});
</script>
</body>
</html>
