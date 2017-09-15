<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>未编采购计划的需求一览表</title>
    <%@ include file="commons/meta.jsp"%>
  </head>

  <body>
    <div style="margin: 10px 30px;">
    
    	<div id="editStock">

      	</div>
      	
      <!-- 雇员列表的工具栏设置 -->
      <div id="searchStockForm" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          物资编码:
          <input type="text" id="materialCode" />
         &nbsp;&nbsp;物资名称:
         <input type="text" id="materialName" />
         
          <a href="#" class="easyui-linkbutton" iconCls="icon-search"
            onclick=stock_obj.search();>查询</a>&nbsp;&nbsp;
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit"
        onclick="stock_obj.showEdit('edit')">编制采购计划</a>
        
        <!-- 编制采购计划窗口 -->
      <div id="editStock">

      </div>
        
        </div>
       </div>

      <!-- 列表显示 -->
      <div style="margin-top: 20px;">
        <table id="stockDataGridzz">

        </table>

      </div>
    </div>
    
    <script type="text/javascript">
  $(function() {
    stock_obj = {
      search : function() {//查询
        //获得部门号
        //var deptno = $('#dept').combobox('getValue');  
        // alert(deptno);
        $("#stockDataGridzz").datagrid(
            "load",
            {
              materialCode : $.trim($("#materialCode").val()),
              materialName : $.trim($("#materialName").val()),
            });
      },
      showEdit : function(state){
        var url = "stockAllController_findById.html";
        var info = "编制采购计划";
        var id = 0;
        var rows = $("#stockDataGridzz").datagrid("getSelections");
          if(rows.length == 1){
            id = rows[0].id;
            var mappingId = rows[0].mappingId;
            url += "?id="+id+"&mappingId="+mappingId;
          }else{
            $.messager.alert("警告", "必须选中一行", "warning");
            return;
          }
          $("#editStock").window({
          title : info,
          width : 1000,
          height : 600,
          modal : true,
          minimizable : false,
          href : url,
          onClose : function(){
            $("#stockDataGridzz").datagrid(
            "reload");
            //$('#dept').combobox('reload');    
          }
        });
    	}
      }
   });
  
    $("#stockDataGridzz").datagrid( {
      url : "stockAllController.html",
      title : "未编采购计划的需求一览表",
      fitColumns : true,
      striped : true,
      rownumbers : true,
      singleSelect:true,
      columns : [ [{
        field : "materialCode",
        title : "物资代码",
        width : 100,
        sortable : true
      } , {
        field : "materialName",
        title : "物资名称",
        width : 200,
        sortable : true
      } , {
        field : "amount",
        title : "数量",
        width : 100,
        sortable : true
      } , {
          field : "sumPrice",
          title : "预算价格",
          width : 100,
          sortable : true
        } , {
          field : "buildDate",
          title : "需求计划编制时间",
          width : 100,
          sortable : true
        },{
        hidden:"true",
          field : "mappingId",
          title : "关联id",
          width : 100,
          sortable : true
        },{
        field : "op1",
        title : "操作",
        width : 100,
		formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          return "<a href='#' onclick=getStock("+id+")>查看</a>"
        }
      } ] ],
      toolbar : "#searchStockForm",
      pagination : true,
      pageSize : 5,
      pageList : [ 5, 10, 15, 20, 50 ],
      sortName : "materialCode",
      sortOrder : "asc",
    });
    
     function getStock(id){
    $("#editStock").window({
      title : "查看物资详情",
      width : 550,
      height : 480,
      modal : true,
      minimizable : false,
      href : "stockAllController_view.html?id="+id
    });
    
    
  }
   
</script>
  </body>
</html>
