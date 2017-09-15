<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>未下达采购计划一览表</title>
    <%@ include file="commons/meta.jsp"%>
  </head>

  <body>
    <div style="margin: 10px 30px;">
      <a href="#" class="easyui-linkbutton" iconCls="icon-add"
        onclick="stocks_obj.part()">下达</a>&nbsp;&nbsp;
      <div id="editStocks3">

      </div>
      <div id="searchStocksForm3" style="padding: 10px;"></div>
      <div style="margin-top: 20px;">
        <table id="stocksDataGrid3">

        </table>

      </div>
    </div>
    <script type="text/javascript">
  $(function() {
  	stocks_obj = {
  		part : function(){
  		var url = "";
  		var info = "";
  		var id = 0;
  		var rows= $("#stocksDataGrid3").datagrid("getSelections");            
  		if(rows.length ==1) {
  			$.messager.confirm("消息","点击确定后，将下达采购计划",function(flag){
  				if(flag){
  				id = rows[0].id;
		  			$.ajax({
		  					type : "post",						
		  					url : "idMappingController_saveIdMapping.html?status=C001-60&id="+id,
		  					beforeSend : function(){
		  					$("#stocksDataGrid3").datagrid("loading");
		  					},
		  				success : function(data){
		                if(data) {
		                    $("#stocksDataGrid3").datagrid("loaded");
		                    $("#stocksDataGrid3").datagrid("load");
		                    $("#stocksDataGrid3").datagrid("unselectAll");     
		                }
		              }
		  		  });		
  				}
  			});
  		}else{
            $.messager.alert("警告", "必须选中一行", "warning");
            return;
          }       
  		}
  	}
    $("#stocksDataGrid3").datagrid( {
      url : "stocksController_list.html?status=C001-50",
      title : "采购计划一览表",
      fitColumns : true,
      striped : true,
      rownumbers : true,
      columns : [ [ {
        field : "id",
        title : "序号",
        width : 100,
        sortable : true
      }, {
        field : "stockName",
        title : "采购计划名称",
        width : 100,
        sortable : true
      }, {
        field : "stockType",
        title : "采购类型",
        width : 100,
        sortable : true
      }, {
        field : "status",
        title : "采购进度",
        width : 100,
        sortable : true
      }, {
	    field : 'submitDate',
	    title : '采购计划下达时间',
	    width : 100,
	    sortable : true,
	  }, {
	    field : 'enquireName',
	    title : '对应询价书',
	    width : 100,
	    sortable : true,
	  }, {
        field : "op1",
        title : "操作",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          return "<a href='#' onclick=getStocks1("+id+")>查看</a>"
        }
      } ] ],
      toolbar : "#searchStocksForm3",
      pagination : true,
      pageSize : 5,
      pageList : [ 5, 10, 15, 20, 50 ],
      sortName : "stockName",
      sortOrder : "asc",
    });
  });

  //查看指定菜单
  function getStocks1(id){
    $("#editStocks3").window({
      title : "采购计划明细信息",
      width : 1500,
      height : 450,
      modal : true,
      minimizable : false,
      href : "stocksController_view.html?id="+id
    });
  }
</script>
  </body>
</html>
