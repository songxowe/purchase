<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>合同申请列表</title>
<%@ include file="commons/meta.jsp"%>
  </head>

  <body>
    <div style="margin: 10px 30px;">
    <!-- 弹窗 -->
    <div id="contAppvieww"></div>
      <!--工具栏设置 -->
      <div id="tools" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          合同申请编号:
          <input type="text" id="contAppNum" name="contAppNum"/>
         &nbsp;&nbsp;
          <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="contApp_obj.search();">查询</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="contApp_obj.clear()">重新加载</a>
        </div>
      </div>

      <!-- 询价书列表显示 -->
      <div style="margin-top: 20px;">
        <table id="contAppDataGrid">

        </table>

      </div>
    </div>
    <script type="text/javascript">
    	$(function() {
    		contApp_obj = {
    			search : function() {
    				$("#contAppDataGrid").datagrid("load", {
    					contAppNum : $.trim($("#contAppNum").val()),
    				});
    			},
    			clear : function(){
    				$("#contAppNum").val("");
    				$("#contAppDataGrid").datagrid("load",{ });
    			}
    			
    		}
    
    		$("#contAppDataGrid").datagrid({
    			url : "contAppList",
    			title : "合同申请列表",
    			fitColumns : true,
    			striped : true,
    			rownumbers : true,
    			singleSelect : true,
    			columns : [ [ {
    				field : "id",
    				title : "",   				
    				checkbox : true
    			},{
    				field : "contAppNumber",
    				title : "合同申请编号",
    				width : 100,
    				sortable : true,
    			},{
    				field : "statQuote",
    				title : "报价份数",
    				width : 100,
    				sortable : true
    			}, {
    				field : "allSumPrice",
    				title : "总金额",
    				width : 100,
    				sortable : true
    			}, {
    				field : "status",
    				title : "状态",
    				width : 100,
    				sortable : true
    			},{
    				field : "op1",
    				title : "查看询价书",
    				width : 100,
    				formatter : function(value, rowData, rowIndex) {
    					var cid = rowData["id"];
    					return "<a href='#' onclick=showEnquire(" + cid + ")>查看询价书</a>"
    				}
    			},{
    				field : "op2",
    				title : "合同送审",
    				width : 100,
    				formatter : function(value, rowData, rowIndex) {
    					var status= rowData["status"];
    					var mid= rowData["mid"];
    					if(status!='合同申请未报批'){
    						return null;
    					}
    					return "<a href='#' onclick=sendContApp(" + mid + ")>合同送审</a>"
    				}
    			}
    			] ],
    			toolbar : "#tools",
    			pagination : true,
    			pageSize : 5,
    			pageList : [ 5, 10, 15, 20, 50 ],
    			sortName : "contAppNum",
    			sortOrder : "asc",
    		});
    	});
    
    	//查看指定菜单
    	function showEnquire(cid) {
    		$("#contAppvieww").window({
    			title : "询价书明细",
    			width : 1150,
    			height : 570,
    			modal : true,
    			minimizable : false,
    			href : "findEnquire?cid="+cid
    		});
    	}
    	
    	function sendContApp(mid) {
    		$.messager.confirm('提示', '确认后，合同申请将送审', function(r){
				if (r){
	    			$.ajax({
	    				url:"sendContApp",
	    				data:"mid="+mid,
	    				success:function(data){
	    					if(data>0){
	    						$.messager.show({
	    							tital:"提示",
	    							msg:"合同已送审"
	    						});
	    					}else{
	    						$.messager.alert("提示","提交失败");
	    					}
	    					$("#contAppDataGrid").datagrid("reload");
	    				}
	    			});
				}
			});


    	}

    </script>
  </body>
</html>
