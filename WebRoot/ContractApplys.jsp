<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

  <!DOCTYPE HTML>
<html>
  <head>
    <title>合同申请一览表</title>
    <%@ include file="commons/meta.jsp"%>
  </head>
  
  <body>
     <div style="margin: 10px 30px;">
      
      <!-- 新增雇员信息窗口 -->
      <div id="editContractApplysw">

      </div>
      <!-- 合同申请一览表列表的工具栏设置 -->
      <div id="searchContractApplysForm" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          合同申请编号:
          <input type="text" id="contAppNum" />
          <a href="#" class="easyui-linkbutton" iconCls="icon-search"
            onclick=ContractApplys_obj.search();>查询</a>
        </div>
      </div>

      <!-- 合同申请列表显示 -->
      <div style="margin-top: 20px;">
        <table id="contractApplysDataGrid">

        </table>

      </div>
    </div>
    <script type="text/javascript">
  $(function(){
    ContractApplys_obj = {
      search :function(){//查询 
        $("#contractApplysDataGrid").datagrid(
            "load",
            {
              contAppNum : $.trim($("#contAppNum").val()),
            });
      }
    }
    $("#contractApplysDataGrid").datagrid( {
      url : "contractApplysController.html",
      title : "合同申请一览表",
      fitColumns : true,
      striped : true,
      rownumbers : true,
      columns : [ [ {
        field : "id",
        title : "序号",
        width : 100,
        sortable : true
      }, {
        field : "contAppNum",
        title : "合同申请编号",
        width : 100,
        sortable : true
      } , {
        field : "statQuote",
        title : "报价份数",
        width : 100,
        sortable : true
      } , {
        field : "topQuote",
        title : "最高报价",
        width : 100,
        sortable : true
      } , {
          field : "lowQuote",
          title : "最低报价",
          width : 100,
          sortable : true
        } , {
          field : "allSumPrice",
          title : "总金额",
          width : 100,
          sortable : true
        } ,{
          field : "leadAgree",
          title : "厂长意见",
          width : 100,
          sortable : true
        } ,{
          field : "enquireid",
          title : "询价书编号",
          width : 100,
          sortable : true
        } ,{
        field : "op1",
        title : "编制",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var enquireid = rowData["enquireid"];
          return "<a href='#' onclick=getContractApplys("+enquireid+")>编制合同</a>"
        }}] ],
      toolbar : "#searchContractApplysForm",
      pagination : true,
      pageSize : 5,
      pageList : [ 5, 10, 15, 20, 50 ],
      sortName : "id",
      sortOrder : "asc",
    });
  });

  //查看指定菜单
  function getContractApplys(enquireid){
  //alert(enquireid);
    $("#editContractApplysw").window({
      title : "编制合同",
      width : 1300,
      height : 600,
      modal : true,
      minimizable : false,
      href : "quoteController_editcont.html?enquireid="+enquireid,
    });
  }
</script>
  </body>
</html>
