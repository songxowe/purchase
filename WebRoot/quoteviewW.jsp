<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"	prefix="spring" %>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE HTML >
<html>
<head>
<title>询价书详情</title>
<%@ include file="commons/meta.jsp"%>
<meta charset="utf-8">
<style>
textarea{resize:none}
table tr td{solid:red}
</style>
<BODY>
	<div style="width:99%;height:100%" align="center">
	<TABLE style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0
		width="100%" bgColor="#6FB7FF" borderColorLight="blue" border=0>
		<TBODY>
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=3 width="100%" border="1" >
						<TBODY>
							<TR bgcolor="#6FB7FF">
								<TD align=middle width="100%"  bgcolor="#6FB7FF" colSpan=20
									height=22><B>
										<H2>
											<FONT color=black>询价书明细
								</B> <A
									onclick="window.open('../help/Help.asp?Value=询价书明细信息','child','status=NO,scrollbars=yes,toolbar=no,menubar=no,location=no,left=200,top=100,width=700,height=400')"
									href="javascript:void(null)"></A> </FONT>
								</H2></TD>
							</TR>
							<TR class=t1>
								<TD  width="20%">询价书编号</TD>
								<TD class=t2 >${enquire.enquireNum }</TD>
								<TD  width="20%">询价书名称</TD>
								<TD class=t2 >${enquire.enquireName }</TD>
							</TR>
							<TR class=t1>
								<TD  width="20%">单位</TD>
								<TD class=t2 >${enquire.company }</TD>
								<TD  width="20%">联系人</TD>
								<TD class=t2 >${enquire.linkman }</TD>
							</TR>
							<TR class=t1>
								<TD  width="20%">联系地址</TD>
								<TD class=t2 >${enquire.address }</TD>
								<TD  width="20%">联系电话</TD>
								<TD class=t2 >${enquire.phone }</TD>
							</TR>
							<TR class=t1>
								<TD  width="20%">联系传真</TD>
								<TD class=t2 >${enquire.fax }</TD>
								<TD  width="20%">邮编</TD>
								<TD class=t2 >${enquire.zip }</TD>
							</TR>
							<TR class=t1>
								<TD  width="20%">Email</TD>
								<TD class=t2 >${enquire.email }</TD>
								<TD  width="20%">报价截止时间</TD>
								<TD class=t2 ><spring:eval expression="enquire.endDate" /></TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=1 cellPadding=0 width="100%" bgcolor="#6FB7FF"
		borderColorLight=#ffffff border=0>
		<TBODY>
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=3 width="100%" border=0>
						<B>我公司欲采购下述物资，如贵单位有兴趣，可参与网上报价。详细物资情况如下：</B>
						<TBODY></TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	</table>
	</td>
	</tr>
	</table>

	<TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0
		width="100%" bgColor="#6FB7FF" borderColorLight="#6FB7FF" border=1>
		<tr>
			<td>
				<TABLE cellSpacing=1  width="100%" border=0>

						<TR >
							<TD align="center">物资编码</TD>
							<TD align="center">物资名称</TD>
							<TD align="center">数量</TD>
							<TD align="center">计量单位</TD>
							<TD align="center">交货期</TD>
							<TD align="center">协议价格（元）</TD>
							<TD align="center">预算总金额（元）</TD>
							<TD align="center">计划价（元/不含税）</TD>
							<TD align="center">报价有效期</TD>
						</TR>
						<TR >
							<TD align="center">${enquire.enquDetail.materialCode }</TD>
							<TD align="center">${enquire.enquDetail.materialName }</TD>
							<TD align="center">${enquire.enquDetail.amount }</TD>
							<TD align="center">${enquire.enquDetail.measureUnit }</TD>
							<TD align="center"><spring:eval expression="enquire.enquDetail.endDate" /></TD>
							<TD align="center">${enquire.order.unitPrice }</TD>
							<TD align="center">${enquire.order.sumPrice }</TD>
							<TD align="center">${enquire.order.unitPrice }</TD>
							<TD align="center"><spring:eval expression="enquire.endDate" /></TD>
						</TR>
				</TABLE>
			</td>
		</tr>
	</table>

	<TABLE style="LINE-HEIGHT: 30px" cellSpacing=0 cellPadding=0
		width="100%" bgcolor="#6FB7FF" borderColorLight="#6FB7FF" border=0>
		<tr>
			<td>
				<table cellpadding="3" cellspacing="1" border="0" width="100%">					
					<tr class="t2">
						<td >询价说明</td>
						<td style="width:100%">
						<textarea name="textarea" rows="4" readonly style="width:100%" >${enquire.remark }</textarea></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="button" value="关闭" <c:choose><c:when test="${empty flag }">id="btn1"</c:when><c:otherwise>id="btn2"</c:otherwise></c:choose> >
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	$("#btn1").click(function(){
		$("#quirevieww").window('close');
	});
	$("#btn2").click(function(){
		$("#contAppvieww").window('close');
	});
</script>
</body>

</html>
