<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编制采购计划</title>
    <%@ include file="commons/meta.jsp"%>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>编制采购计划</title>
  </head>
  
  <body>
    <center>

    <h2><font color=#0070C0>编制采购计划</font></h2>

 <form id="stockadd" method="post" onsubmit="sub()">
 <input type="hidden" name="suppliers" id="suppliers">
<input type="hidden" value="${mappingId }" name="mappingId">
<TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0 width="100%"  border=1>
<tr>
<td>
<table cellpadding="3" cellspacing="0" border="1" width="100%">

 <tr>
       <tr class="t1">
       
<td bgcolor="#6FB7FF">采购计划编号</td>
      	<td bgcolor="#6FB7FF">
      	
      	<input type="text" name="stockNum" value="${stock.stockNum }" readonly>
      	</td>
<td bgcolor="#6FB7FF"><font color=red>采购计划名称</font></td>
      <td bgcolor="#6FB7FF">
      	<input type="text" name="stockName" size="20" maxlength="100" value="${stock.stockName }"  Chk=1 alt="请输入采购计划名称。">
      </td>      
</tr>
       <tr class="t1" bgcolor="#6FB7FF">
<td>公司名称</td>
      	<td>
        	株洲南车时代电气股份有限公司
		</td>
<td>编制人</td>
       <td>
       <input type="text" name="author" size="20"  readonly value="${sessionScope['NEWER_USER_LOGIN_INFO'].username}"></td>
</tr>
       <tr class="t1" bgcolor="#6FB7FF">
<td><font color=red>预算金额(元)</font></td>
       <td>
       <input type="text" name="budget" size="20" maxlength="20" value="${stock.budget }"  onKeyPress="check_num_dot()" Chk=3></td>
<td>采购计划编制时间</td>
       <td>
       <fmt:formatDate value='${stock.buildDate }' pattern='yyyy-MM-dd hh:mm:ss' />
       
       </td>
</tr>

<tr class="t1" bgcolor="#6FB7FF">
	<td><font color=red>计划询价开始时间</font></td>
    <td><input class="easyui-datetimebox" size="20" name="startDate" maxlength="20"  onKeyPress="check_num_dot()" Chk=3></td>
	   <td><font color=red>计划报价截止时间</font></td>
       <td><input class="easyui-datetimebox" size="20" name="endDate" maxlength="20"  onKeyPress="check_num_dot()" Chk=3></td>
</tr>
</table></td></tr></table>

<TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0 width="100%"  border=1>
<tr>
<td>
<table cellpadding="3" cellspacing="0" border="1" width="100%">

    <tr class="t1" bgcolor="#6FB7FF">
    <td nowrap align="center">物资编码</td>
    <td nowrap align="center">物资名称</td>
    <td nowrap align="center">数量</td>
    <td nowrap align="center">计量<br>单位</td>
    <td nowrap align="center">预算单价<br>（元）</td>
    <td nowrap align="center">交货期</td> 
    <td nowrap align="center">预算总金额<br>（元）</td>
    <!--
    <td nowrap align="center">录入详细<br>交货情况</td>
    -->
    </tr>
 
       <tr class="t2" >
       <td align="center">${orders.materialCode }<br></td>
       <td align="center">${orders.materialName }<br></td>
       <td align="center">${orders.amount }<br></td>
       <td align="center">${orders.measureUnit }<br></td>
       <td align="center">${orders.unitPrice }<br></td>
       <td align="center">	<fmt:formatDate value='${orders.startDate }' pattern='yyyy-MM-dd hh:mm:ss' /><br></td>
       <td align="center">${orders.sumPrice }<br></td>
       <!--
       <td align="center"><a href="javascript:openwindown('../Project/Project_Delivery.asp?p_projno=1000201001251787&p_orderno=1000201011133266&p_ordernum=1')"><img src="../images/Open.gif" border="0" WIDTH="18" HEIGHT="12"></a></td>
       -->
       </tr>
 
</table></td></tr></table>

<TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0  width="100%" border=1>
<tr>
<td>
<table cellpadding="3" cellspacing="0" border="1" width="100%">

 <tr  class="t1" bgcolor="#6FB7FF">
 <td width=15% align="center"><font color=red>采购方式</font></td>
 <td colspan=3>

    <SELECT name="stockType"  id="select1">
          <OPTION value="C000-1" selected>公开求购</OPTION>
          <OPTION value="C000-2" >定向询价</OPTION>
    </SELECT>

</td>
</tr>
<tr  class="t1" >
<td bgcolor="#6FB7FF">满足条件的供应商列表</td>

<td align="center" colspan="3">
<div id="div1">
  <TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0 width="100%" border=1>
	<tr class="t1">
		<th bgcolor="#6FB7FF">
			<font color="black">供应商名称</font>		</th>
	</tr>
	<c:forEach items="${supplier}" var="sup">
	<tr class="t2">
		<td align="center">
			${sup.company }
		</td>
	</tr>
	</c:forEach>
  </table>
  </div>
  
  <div id="div2" style="display:none">
  	<table>
 		<tr>
			<td>
				<c:forEach items="${supplier}" var="sup">
				<label><input type="checkbox" value="${sup.id }" name="supp">${sup.company }</label><br>
				</c:forEach>
			</td>
		</tr>
	</table>
  </div>
 
</td>

<tr  class="t1" >
	<td width=15% align="center" nowrap bgcolor="#6FB7FF">说明：<br>（400字以内）</td>
	<td colspan=3>
	<TEXTAREA NAME="remark" ROWS=3 COLS=77 style="width:100%">

	</TEXTAREA>
	</td>
</tr>

</table></td></tr></table>

<br>
<input type="submit" value="确定" >
<input type="button" value="重设" onClick="form.reset()">

</form>

</center>
<script type="text/javascript">
$(function(){
	$("#select1").change(function(){
		var a=$("#select1").val();
		if(a=='C000-1'){
			$("#div1").show();
			$("#div2").hide();
		}else{
			$("#div2").show();
			$("#div1").hide();
		}
	});
});
function sub(){
	var boxes = document.getElementsByName("supp");
    var val = []
    for(i=0;i<boxes.length;i++){
        if(boxes[i].checked == true){
            val.push(boxes[i].value);
        }
    }
    $("#suppliers").val(val.toString());
    
}

$(function() {
			//对表单进行提交，并返回结果
			$("#stockadd").form({
				url : "stockAllController_add",
				onSubmit : function() { //在提交之前触发，返回false可以终止提交。
	
				},
				success : function(data) { //提交成功后的回调函数。
					//var data = eval('(' + data + ')');
					//WQY 2016-11-06 隐藏alert(data)
					// alert(data);
					if (data.count == 0) {
						alert("采购计划录入失败");
					} else {
						alert("采购计划录入成功");
						$('#editStock').window('close');
						$('#stockDataGrid').datagrid('reload');
					}
				}
			});
	
		});
</script>
  </body>
</html>
