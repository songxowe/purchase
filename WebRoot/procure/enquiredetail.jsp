<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>询价书明细</title>
    <%@ include file="../commons/meta.jsp"%>
	
	
	
		<LINK href="js/style.css" rel=stylesheet>
		<SCRIPT language=JavaScript src=""></SCRIPT>
  </head>
  
  <body>

   <TABLE style="LINE-HEIGHT: 30px" cellSpacing="1" cellPadding="0" width="100%" bgColor="#336699" borderColorLight="#006699" border="0">
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=1 cellPadding=3 width="100%" border=0>
        <TBODY>
        <TR bgColor=#ffffff>
          <TD align="middle" width="100%" bgColor=#ffffff colSpan=20 
            height=22><B>
            <H2><FONT color=#0070c0>询价书明细</FONT> </H2></B></TD></TR>
        <TR bgColor=#99ccff>
          <TD noWrap width="20%">询价书编号</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.enquireNum }</TD>
          <TD noWrap width="20%">询价书名称</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.enquireName }</TD></TR>
        <TR bgColor=#99ccff>
          <TD noWrap width="20%">单位</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.company }</TD>
          <TD noWrap width="20%">联系人</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.linkman }</TD></TR>
        <TR bgColor=#99ccff>
          <TD noWrap width="20%">联系地址</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.address }</TD>
          <TD noWrap width="20%">联系电话</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.phone }</TD></TR>
        <TR bgColor=#99ccff>
          <TD noWrap width="20%">联系传真</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.fax }</TD>
          <TD noWrap width="20%">邮编</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.zip }</TD></TR>
        <TR bgColor=#99ccff>
          <TD noWrap width="20%">Email</TD>
          <TD bgColor=#f2f8ff noWrap>${enquire.email }</TD>
          <TD noWrap width="20%">报价截止时间</TD>
          <TD bgColor=#f2f8ff noWrap>
          	<fmt:formatDate value="${enquire.endDate }" pattern="yyyy-MM-dd"/> 
		  </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=1 cellPadding=0 width="100%" bgColor=#ffffff borderColorLight=#ffffff border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=1 cellPadding=3 width="100%" 
        border=0><B>我公司欲采购下述物资，如贵单位有兴趣，可参与网上报价。详细物资情况如下：</B> 
        <TBODY></TBODY></TABLE></TD></TR></TBODY></TABLE>
</table></td></tr></table>

<TABLE style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0     width="100%"  bgColor=#336699 borderColorLight=#006699 border=1>
 
<tr>
<td>
 <TABLE cellSpacing=1 cellPadding=3 width="100%" border=0>
        <TBODY>
       
        <TR bgColor=#99ccff>
          <TD noWrap align=middle>物资编码</TD>
          <TD noWrap align=middle>物资名称</TD>
          <TD noWrap align=middle>数量</TD>
          <TD noWrap align=middle>计量<BR>单位</TD>
          <TD noWrap align=middle>开始询价时间</TD>
          <TD noWrap align=middle>标准</TD>
          <TD noWrap align=middle>生产厂家</TD>
          <TD noWrap align=middle>包装</TD>
          </TR>
          <c:forEach items="${ enquireDetailList}" var="list">
        <TR bgColor=#f2f8ff>
          <TD align=middle>${ list.materialCode}<BR></TD>
          <TD align=middle>${list.materialName }<BR></TD>
          <TD align=middle>${list.amount }<BR></TD>
          <TD align=middle>${list.measureUnit }<BR></TD>
          <TD align=middle><fmt:formatDate value="${list.startDate }" pattern="yyyy-MM-dd"/> <BR></TD>
          <TD align=middle>${list.standard }<BR></TD>
          <TD align=middle >${list.factory}<BR></TD>
          <TD align=middle>${list.wrap }<BR></TD></TR>
         </c:forEach>
          </TBODY></TABLE>
</td></tr></table>


<TABLE style="LINE-HEIGHT: 30px" cellSpacing=1 cellPadding=0     width="100%"  bgColor=#336699 borderColorLight=#006699 border=0>
<tr>
<td>

<table cellpadding="3" cellspacing="1" border="0" width="100%">
  
    <tr bgColor=#f2f8ff>
    <td nowrap>报价有效期</td>
    <td><fmt:formatDate value="${enquire.endDate }" pattern="yyyy-MM-dd"/><span style="width:100%">
      
    </span></td>
	</tr>
    <tr bgColor=#f2f8ff>
    <td nowrap>询价说明</td>
    <td style="width:100%"><textarea name="textarea" rows="4" readonly style="width:100%">
    ${enquire.remark }
    </textarea>&nbsp;</td>
    </tr>
</table></td></tr></table> 

<script Language="JavaScript" src="js/pub_Calendar.js"></script>

<CENTER>
<BR>&nbsp;
<input onClick="window.close();" type="button" name="back" value="关闭本页面" />
</CENTER>

  </body>
</html>
