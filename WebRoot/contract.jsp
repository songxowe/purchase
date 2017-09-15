<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<script src="easyui/jquery.min.js"></script>
<script src="easyui/jquery.easyui.min.js"></script>
<script src="easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />

<title>编制合同</title>
</HEAD>
<BODY>

<TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0 width="100%" 
bgColor="6FB7FF"  border=1>
  <TR>
    <TD>
    <form id="form132" method="post" name="form1">
    <input type="hidden" id="eid" value="${enquireid}" name="eid">
    <input type="hidden" id="qid" name="qid">
      <TABLE cellSpacing=1 cellPadding=3 width="100%" border=1>
		<tr bgColor="6FB7FF" width="100%"><td width="100%" colspan=21>
			<div>
			</div></td>
		</tr>
        <TR bgColor="6FB7FF">
          <TD align=middle bgColor="6FB7FF" colSpan=20 
            height=22>
			
            <H2><FONT color=#0070c0>编制合同
        </FONT></H2></TD></TR> 
        <TR class=t2>
          <TD>合&nbsp;&nbsp;同&nbsp;&nbsp;号</TD>
          <TD width="26%"><input type="text" value="${contract.contNum}" name="contNum" readonly="readonly"></TD>
          <TD width="11%">签订日期</TD>
          <TD width="19%"><spring:eval expression="contract.contDate"/></TD>
          <TD width="8%" class=t2>合同类型</TD>
          <TD width="20%"><input type="text" name="contType" value="采购合同" /></TD>
          </TR>
         <TR class=t2>
          <TD>合同标的物</TD>
          <TD width="26%"><input type="text" name="contItem"/></TD>
          <TD width="11%">标准号</TD>
          <TD width="19%"><span style="font-size:18px;">
          	<select id="standardNo" name="standardNo" style="width: 154px; ">  
    			<option value="GB1001-1986" selected>GB1001-1986</option>  
   			 	<option value="GB1002-1996">GB1002-1996</option> 
   			 	<option value="GB1003-1999">GB1003-1999</option> 
			</select>  
			</span></TD>
          <TD width="8%" class=t2>备注</TD>
          <TD width="20%"><input type="text" name="remark"/></TD>
         </TR>
        <TR class=t2>
          <TD>买&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方</TD>
          <TD><input type="text" name="buyer"/></TD>         
          <TD width="11%">采购类型</TD>
          <TD>
          	<span style="font-size:18px;">
          	<select id="stockType" name="stockType" style="width: 154px; ">  
    			<option value="F100-1" selected>公开求购</option>  
   			 	<option value="F101-2">定向求购</option> 
			</select>  
			</span></TD>
			<TD class=t2>币&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</TD>
          	<TD><input type="text" name="money" value="人民币" readonly="readonly"/></TD>
			</TR>
        <TR class=t2 style="width: 953px; ">
          <TD class=t2>税&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;率</TD>
          <TD><input type="text" name="taxRate" value="1" readonly="readonly" /></TD>
          <TD >包装物是否回收</TD>
          <TD>
          	<span style="font-size:18px;">
          		<select id="wrapBack" name="wrapBack" style="width: 155px; ">  
    				<option value="B000-0" selected>不回收</option>  
   			 		<option value="B000-1">回收</option> 
				</select>  
			</span>
		 </TD>
			<TD >验收标准</TD>
         	 <TD><span style="font-size:18px;">
          	<select id="verifyStand" name="verifyStand" style="width: 158px; ">  
    			<option value="Y000-1">国际（国家）标准	</option>  
   			 	<option value="Y000-2" selected>行业标准</option> 
   			 	<option value="Y000-3">企业标准</option>
			</select>  
			</span></TD>
		</TR>
        <TR class=t2>
          <TD>付款条件</TD>
          <TD style="width: 200px; ">
          <span style="font-size:18px;">
          	<select id="payCond" name="payCond" style="width: 157px; ">  
    			<option value="F000-1">货到验收合格、自收到有效发票后90天付款</option>  
   			 	<option value="F000-2">货到验收合格、自收到有效发票后付款</option>
   			 	<option value="F000-3">现场考核后付款</option> 
   			 	<option value="F000-4" selected>货到验收合格、自收到有效发票后30天付款</option>  
   			 	<option value="F000-5">款到发货</option>  
   			 	<option value="F000-6">其它约定</option>   
			</select>  
	
			</span></TD>
          <TD>验收时间</TD>
          <TD><input class="easyui-datebox" name="vdate" /></TD>
          <TD>质量要求及技术标准</TD>
          <TD><span style="font-size:18px;">
          	<select id="qualityStand" name="qualityStand" style="width: 157px; ">  
    			<option value="Z000-1">军标</option>  
   			 	<option value="Z000-2">国际标</option>
   			 	<option value="Z000-3">铁标</option>  
   			 	<option value="Z000-4"selected>国标</option> 
   			 	<option value="Z000-5">需方提供的技术文件标准</option>  
   			 	<option value="Z000-6">供方企业标准</option>  
   			 	<option value="Z000-7">其他</option>    
			</select>  
			</span></TD>
          </TR>
        <TR class=t2>
          <TD>运输费用负担</TD>
          <TD><span style="font-size:18px;">
          	<select id="transport" name="transport" style="width: 154px; ">  
    			<option value="Y002-1" selected>供方</option>  
   			 	<option value="Y002-2">需方</option>  
			</select>  
			</span></TD>
          <TD>付款方式</TD>
          <TD>
          	<span style="font-size:18px;">
          	 <select id="payWay" name="payWay" style="width: 157px; ">  
    			<option value="F001-1" selected>汇兑（电汇、信汇）</option>  
   		 		<option value="F001-2">托收承付</option>
   		 		<option value="F001-3">银行支票</option> 
   		 		<option value="F001-4">银行本票</option> 
   		 		<option value="F001-5">银行汇票</option> 
   		 		<option value="F001-6">委托收款</option> 
   		 		<option value="F001-7">商业票据</option> 
		     </select>  
			</span>
			</TD>
			<TD>提货地点</TD>
          <TD><span style="font-size:18px;">
          	<select id="place" name="place" style="width: 160px; ">  
    			<option value="J000-1">供方所在地</option>  
   			 	<option value="J000-2" selected>需方所在地</option>  
			</select>  
			</span></TD></TR>
        <TR class=t2>
          <TD colSpan=2>逾期违约：供方逾期交货的，应按逾期交货金额每日千分之 <INPUT type="number"
            style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; FONT-WEIGHT: bold; BORDER-BOTTOM-COLOR: black; BORDER-LEFT: 0px; WIDTH: 50px" 
             alt=请输入逾期交货违约金比例。 maxLength=50  name="outPerm" 
            Chk="1"> 向需方支付违约金，逾期超过 <INPUT type="number"
            style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; FONT-WEIGHT: bold; BORDER-BOTTOM-COLOR: black; BORDER-LEFT: 0px; WIDTH: 50px" 
            alt=请输入逾期天数。 maxLength=50  name="outDay" Chk="1"> 
            天，需方有权解除合同。 </TD>
            <TD>包装要求</TD>
            <TD><span style="font-size:18px;">
          	<select id="wrapRequire" name="cwrap" style="width: 159px; ">  
    			<option value="B001-1" selected>散装</option>  
   			 	<option value="B001-2">托盘</option>
   			 	<option value="B001-3">卷带</option> 
   			 	<option value="B001-4">管装</option> 
   			 	<option value="B001-5">防静电</option> 
   			 	<option value="B001-6">防震,防潮,防挤压</option> 
   			 	<option value="B001-7">防摩擦</option> 
   			 	<option value="B001-8">整箱</option> 
   			 	<option value="B001-9">整卷</option>   
			</select>  
		
			</span></TD>
			<TD>运输方式</TD>
            <TD><span style="font-size:18px;">
          	<select id="tran" name="tran" style="width: 160px; ">  
    			<option value="Y001-1">铁快</option>  
   			 	<option value="Y001-2">EMS航空</option>
   			 	<option value="Y001-3">中铁快运</option> 
   			 	<option value="Y001-4" selected>普邮</option> 
   			 	<option value="Y001-5">送货</option> 
   			 	<option value="Y001-6">提货</option> 
   			 	<option value="Y001-7">汽运</option> 
   			 	  
			</select>  
			</span></TD></TR>
			 <TR class=t2>
			 	<TD>卖方</TD>
          		<TD width="26%"><input type="text" name="seller" id="seller" readonly/></TD>
          		<TD>制造厂</TD>
          		<TD width="26%"><input type="text" name="factory"/></TD>
          		<TD >合同总金额</TD>
          		<TD width="26%"><input type="text" name="contPrice" id="totals" readonly/></TD>
         </TR>
       </TABLE>
       </form>
       </TD></TR>
       </TABLE>
<TABLE style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0 width="100%" 
bgColor="6FB7FF"  bordesr=0>
 
  <TR>
    <TD>
      <TABLE cellSpacing=1 cellPadding=3 width="100%" border=1>
       
        <TR>
          <TD align=middle bgColor="6FB7FF" colSpan=20><B>提供产品</B></TD></TR>
        <TR class=t2>
          <TD align=middle>供应商</TD>
          <TD align=middle>供应商编号</TD>
          <TD align=middle>物资编码</TD>
          <TD align=middle>物资名称</TD>
          <TD align=middle>数量</TD>
          <TD align=middle>单价<BR>(含税)</TD>
          <TD align=middle>计量单位</TD>
          <TD align=middle>运杂费<BR>(元)</TD>
          <TD align=middle>总价</TD>
          <TD align=middle>其他费用<BR>(元)</TD>
          <TD align=middle>总计<BR>(元)</TD>
          <TD align=middle>到货期</TD>

          </TR>
        <c:forEach var="prep" items="${requestScope.preparecontract}">
 	<tr class="tr1">
 		<td class="td1"><label><input type="radio" name="quoteid" value="${prep.quoteId }" onclick="change('${prep.company}',this)"/>
 		${prep.company}</label></td>
 		<td>${prep.snum}</td>
 		<td>${prep.materialCode}</td>
 		<td>${prep.materialName}</td>
 		<td>${prep.amount}</td>
 		<td>${prep.unitPrice}</td>
 		<td>${prep.measureUnit}</td>
 		<td>${prep.sumPrice}</td>
 		<td>${prep.mixPrice}</td>
 		<td>${prep.otherPrice}</td>
 		<td>${prep.totalPrice}</td>
 		<td>
 		<fmt:formatDate value="${prep.endDate}" pattern="yyyy-MM-dd"/>
 		</td>
 	</tr>
 	</c:forEach>
 	<tr>
 		<td align="center" colspan="12">
 			<input type="button" id="btn132" value="编制合同">&nbsp;&nbsp;
 			<input type="button" id="btn2" value="取消">
 		</td>
 	</tr>
    </TABLE>
<script type="text/javascript">
function change(txt,th){
	$("#seller").val(txt);
	var a=$(th).parent().parent().siblings()[9];
	$("#totals").val($(a).text());
}

$("#btn132").click(function(){
	$("#form132").form('submit',{
		url:"contractController",
		onSubmit:function(){
			var a=$("input:radio:checked").val();
			$("#qid").val(a);
		},
		success:function(){
			alert("编制合同完成");
			$("#contractApplysDataGrid").datagrid('reload');
			$("#editContractApplysw").window("close");
		}
	});
});
$("#btn2").click(function(){
	$("#editContractApplysw").window("close");
});
</script>
</BODY></HTML>
