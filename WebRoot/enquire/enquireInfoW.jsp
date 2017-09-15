<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>

  <head> 
    <title>询价书详情</title>
    <%@ include file="/commons/meta.jsp"%>
  </head>
  <body>
      <!-- MainForm -->
         <div id="MainForm">
      <div class="form_boxB">
       <h2 align="center">询价书明细信息</h2>
        <table>
          <tr>
          <td>询价书编号</td><td>${enquire.enquireNum}</td><td>询价书名称</td><td>${enquire.enquireName}</td>
          </tr>
          <tr>
          <td>单位</td><td>${enquire.company }</td><td>联系人</td><td>${enquire.linkman }</td>
          </tr>
          <tr>
          <td>联系地址</td><td>${enquire.address}</td><td>联系电话</td><td>${enquire.phone}</td>
          </tr>
          <tr>
          <td>联系传真</td><td>${enquire.fax }</td><td>联系传真</td><td>${enquire.zip }</td>
          </tr>
          <tr>
          <td>Email</td><td>${enquire.email }</td><td>报价截止时间</td><td><fmt:formatDate value="${enquire.endDate}" pattern="yyyy-MM-dd"/></td>
          </tr>
   
          </table>  
          
          我公司欲采购下述物资，如贵单位有兴趣，可参与网上报价。详细物资情况如下：       
          <table>
          <c:forEach items="${list }" var="data">
            <tr>
                  <td colspan="4">需求计划</td>
            </tr>
            <tr>
              <td>物资编码</td><td>${data.materialCode}</td><td>物资名称</td><td>${data.materialName}</td>
            </tr>
             <tr>
              <td>计量单位</td><td>${data.measureUnit}</td><td>数量</td><td>${data.amount}</td>
            </tr>
             <tr>
              <td>单价(元/含税)</td><td>${data.unitPrice}</td><td>总价(元/含税)</td><td>${data.sumPrice}</td>
            </tr>
            <tr>
              <td>报价开始时间</td><td><fmt:formatDate value="${data.startDate }" pattern="yyyy-MM-dd"/></td><td>报价截止时间</td><td><fmt:formatDate value="${enquire.endDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
            
          </c:forEach>          
          </table>
          <tr>
          <td>询价说明</td><td colspan="3"><textarea rows="3" cols="100">${enquire.remark }</textarea></td>
          </tr>
          <center><a href="#" class="easyui-linkbutton"
           iconCls="icon-clear"
           onclick="enquireshow_obj.close();">关闭</a></center>
      </div>
    </div>
    <script type="text/javascript">
        $(function(){
          enquireshow_obj ={
            close:function(){
                $("#enquireEditWin").window("close");
            }
          } 
        });
  
    </script>
  </body>
</html>
