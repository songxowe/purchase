<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>未通过审批采购计划一览表</title>
		<%@ include file="commons/meta.jsp"%>
		<script type="text/javascript">
</script>
	</head>

<body>
	<div style="margin: 10px 30px">	
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
        onclick="stock_obj.remove()">删除</a>&nbsp;&nbsp;
      <div id="editStocks1"></div>
      
	  <div id="searchStocksForm1" style="padding: 10px;">
		  <div style="padding: 0 0 0 6px">
		    计划状态:<select id="status">
						<option value="">全部</option>
						<option value="未确定">未确定</option>
						<option value="待审">待审</option>
						<option value="驳回">驳回</option>
						<option value="下达">下达</option>
						<option value="通过">通过</option>
						<option value="废弃">废弃</option>
			</select>
		    <a href="#" class="easyui-linkbutton" 
		      iconCls="icon-search" onclick="stock_obj.search()">查询</a>
		  </div>
		</div>

		<div style="margin-top: 10px">
			<table id="stocksDataGrid1">

			</table>
		</div>
</div>
	<script type="text/javascript">
	  $(function(){
		 stock_obj= {
			  search : function(){
				  $("#stocksDataGrid1").datagrid('load',{
					  status : $.trim($("#status").val()),
				  });
				},
			  remove : function(){
		  		var url = "";
		  		var info = "";
		  		var id = 0;
		  		var rows= $("#stocksDataGrid1").datagrid("getSelections");            
		  		if(rows.length ==1) {
		  			$.messager.confirm("消息","点击确定后，将删除采购计划",function(flag){
		  				if(flag){
		  				id = rows[0].id;
				  			$.ajax({
				  					type : "post",						
				  					url : "stocksController_remove.html?id="+id,
				  					beforeSend : function(){
				  					$("#stocksDataGrid1").datagrid("loading");
				  					},
				  				success : function(data){
				                if(data) {
				                    $("#stocksDataGrid1").datagrid("loaded");
				                    $("#stocksDataGrid1").datagrid("load");
				                    $("#stocksDataGrid1").datagrid("unselectAll");     
				                }
				              }
				  		  });		
		  				}
		  			});
		  		}else{
		            $.messager.alert("警告", "只能选中一行！", "warning");
		            return;
		          }       
		  		}	
			}
		  
		  $("#stocksDataGrid1").datagrid({
			url : "stocksController_list.html?status=C001-51",
	        title : '采购计划一览表',
	        fitColumns : true, 
	        striped : true,    
	        rownumbers : true, 
	        columns:[[{ 
	          field : 'id',
	          title : '序号',
	          width : 50,
	          sortable : true
	        }, {
	          field : 'stockName',
	          title : '采购计划名称',
	          width : 50,
	          sortable : true,
	        }, {
	          field : 'stockType',
	          title : '采购类型',
	          width : 50,
	          sortable : true,
	        }, {
	         field : 'status',
	         title : '状态',
	         width : 200,
	         sortable : true,
	       }, {
	         field : 'submitDate',
	         title : '采购下达时间',
	         width : 100,
	         sortable : true,
	       },{
	         field : 'author',
	         title : '审批人',
	         width : 100,
	         sortable : true,
	       },{
        field : "op1",
        title : "操作",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          return "<a href='#' onclick=getStocks3("+id+")>查看</a>"
        }
	      } ] ],
	      toolbar : "#searchStocksForm1",
	      pagination : true,
	      pageSize : 5,
	      pageList : [ 5, 10, 15, 20, 50 ],
	      sortName : "stockName",
	      sortOrder : "asc",
	    });
	  });
	
	  //查看指定菜单
	  function getStocks3(id){
	    $("#editStocks1").window({
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
