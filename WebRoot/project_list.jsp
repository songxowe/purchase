<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>采购计划一览表</title>
		<%@ include file="commons/meta.jsp"%>
		<script type="text/javascript">
</script>
	</head>

<body>
	<div style="margin: 10px 30px">	
	<a href="#" class="easyui-linkbutton" iconCls="icon-add"
        onclick="stock_obj.part()">报批</a>&nbsp;&nbsp;
      <div id="editStocks2"></div>
      
	  <div id="searchStocksForm2" style="padding: 10px;">
		  <div style="padding: 0 0 0 6px">
		    采购计划名称:<input type="text" class="easyui-validatebox" id="stockName" size="6">
	  <!--计划状态:<select id="status">
						<option value="">全部</option>
						<option value="C001-30">未确定</option>
						<option value="C001-40">待审</option>
						<option value="C001-50">未下达</option>
						<option value="C001-51">未通过</option>
						<option value="C001-60">已下达</option>
			</select>  -->
		   采购类型:<select id="stockType">
						<option value="">全部</option>
						<option value="C000-1">公开求购</option>
						<option value="C000-2">定向询价</option>
			</select>
		    <a href="#" class="easyui-linkbutton" 
		      iconCls="icon-search" onclick="stock_obj.search()">查询</a>
		  </div>
		</div>

		<div style="margin-top: 10px">
			<table id="stocksDataGrid2">

			</table>
		</div>
</div>
	<script type="text/javascript">
	  $(function(){
		 stock_obj= {
			  search : function(){
				  $("#stocksDataGrid2").datagrid('load',{
					  stockName : $.trim($("#stockName").val()),
					  stockType : $.trim($("#stockType").val()),					  
				  });
				},
			  part : function(){
		  		var url = "";
		  		var info = "";
		  		var id = 0;
		  		var rows= $("#stocksDataGrid2").datagrid("getSelections");            
		  		if(rows.length ==1) {
		  			$.messager.confirm("消息","点击确定后，将报批采购计划",function(flag){
		  				if(flag){
		  				id = rows[0].id;
				  			$.ajax({
				  					type : "post",						
				  					url : "idMappingController_saveIdMapping.html?status=C001-40&id="+id,
				  					beforeSend : function(){
				  					$("#stocksDataGrid2").datagrid("loading");
				  					},
				  				success : function(data){
				                if(data) {
				                    $("#stocksDataGrid2").datagrid("loaded");
				                    $("#stocksDataGrid2").datagrid("load");
				                    $("#stocksDataGrid2").datagrid("unselectAll");     
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
		  
		  $("#stocksDataGrid2").datagrid({
			url : "stocksController_list.html?status=C001-30",
	        title : '采购计划一览表',
	        fitColumns : true, 
	        striped : true,    
	        rownumbers : true, 
	        singleSelect:true,
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
	         field : 'enquireName',
	         title : '对应询价书',
	         width : 100,
	         sortable : true,
	       },{
        field : "op1",
        title : "操作",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          return "<a href='#' onclick=getStocks2("+id+")>查看</a>"
        }
	      } ] ],
	      toolbar : "#searchStocksForm2",
	      pagination : true,
	      pageSize : 5,
	      pageList : [ 5, 10, 15, 20, 50 ],
	      sortName : "stockName",
	      sortOrder : "asc",
	    });
	  });
	
	  //查看指定菜单
	  function getStocks2(id){
	    $("#editStocks2").window({
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
