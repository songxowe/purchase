
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>询价书列表</title>
<%@ include file="commons/meta.jsp"%>
  </head>

  <body>
    <div style="margin: 10px 30px;">
    <!-- 弹窗-->
      <div id="quirevieww"></div>
      
      <!--工具栏设置 -->
      <div id="toolbar" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          询价书名称:
          <input type="text" id="enquireName" name="enquireName"/>
         &nbsp;&nbsp;截止日期：
          <input class="easyui-datebox" id="beginDate" name="beginDate">到
          <input class="easyui-datebox" id="endDate" name="endDate">
          <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="enquire_obj.search();">查询</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="enquire_obj.clear()">重新加载</a>
        </div>
      </div>

      <!-- 询价书列表显示 -->
      <div style="margin-top: 20px;">
        <table id="enquireDataGrid">

        </table>

      </div>
    </div>
    <script type="text/javascript">
    	$(function() {
    		enquire_obj = {
    			search : function() {
    				$("#enquireDataGrid").datagrid("load", {
    					enquireName : $.trim($("#enquireName").val()),
    					beginDate : $("#beginDate").datebox('getValue'),
    					endDate : $("#endDate").datebox('getValue')
    				});
    			},
    			clear : function(){
    				$("#enquireName").val("");
    				$("#enquireDataGrid").datagrid("load",{ });
    			}
    			
    		}
    
    		$("#enquireDataGrid").datagrid({
    			url : "enquireList",
    			title : "已揭示报价的询价书",
    			fitColumns : true,
    			striped : true,
    			rownumbers : true,
    			singleSelect : true,
    			columns : [ [ {
    				field : "enquireNum",
    				title : "询价书编号",
    				width : 100,
    				sortable : true,
    				checkbox : true
    			}, {
    				field : "enquireName",
    				title : "询价书名称",
    				width : 100,
    				sortable : true
    			}, {
    				field : "buildDate",
    				title : "创建时间",
    				width : 100,
    				sortable : true
    			}, {
    				field : "endDate",
    				title : "截止时间",
    				width : 100,
    				sortable : true
    			}, {
    				field : "minPrice",
    				title : "最低报价",
    				width : 100,
    				sortable : true
    			}, {
    				field : "maxPrice",
    				title : "最高报价",
    				width : 100,
    				sortable : true
    			}, {
    				field : "op1",
    				title : "查看",
    				width : 100,
    				formatter : function(value, rowData, rowIndex) {
    					var eid = rowData["id"];
    					return "<a href='#' onclick=getEnquire(" + eid + ")>查看</a>"
    				}
    			},{
    				field : "op2",
    				title : "编制合同申请",
    				width : 100,
    				formatter : function(value, rowData, rowIndex) {
    					var eid = rowData["id"];
    					return "<a href='#' onclick=editContApp(" + eid + ")>编制合同申请</a>"
    				}
    			}
    			] ],
    			toolbar : "#toolbar",
    			pagination : true,
    			pageSize : 5,
    			pageList : [ 5, 10, 15, 20, 50 ],
    			sortName : "enquireNum",
    			sortOrder : "asc",
    		});
    	});
    
    	//查看指定菜单
    	function getEnquire(eid) {
    		$("#quirevieww").window({
    			title : "询价书明细",
    			width : 1150,
    			height : 570,
    			modal : true,
    			minimizable : false,
    			href : "findEnquire?eid="+eid
    		});
    	}
    	
    	function editContApp(eid) {
    		$("#quirevieww").window({
    			title : "编制合同申请",
    			width : 1150,
    			height : 430,
    			modal : true,
    			minimizable : false,
    			href : "editContractApply?eid="+eid,
    			onClose : function() {
						$("#enquireDataGrid").datagrid("reload");
					}
    		});
    	}

    </script>
  </body>
</html>
