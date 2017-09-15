<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>计划审批</title>
<%@ include file="commons/meta.jsp"%>

</head>

<body>
	<div style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
			onclick="stockPanner_obj.showEdit('edit')">审批</a>

		<div id="editstockPanner"></div>
		<div id="stockPannerForm"></div>
		<div style="margin-top: 20px;">
			<table id="stockPannerDataGrid">
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			stockPanner_obj = {
				showEdit : function(state) {
					var url = "stockPannerController_findByIdstockPanner.html";
					//审批
					info = "审批计划表 ";
					var rows = $("#stockPannerDataGrid").datagrid("getSelections");
					if (rows.length == 1) {
						id = rows[0].id;
						var inmappingId=rows[0].inmappingId;
						url += "?id=" + id+"&inmappingId="+inmappingId;
					} else {
						$.messager.alert("警告", "必须选中一行", "warning");
						return;
					}
	
					$("#editstockPanner").window({
						title : info,
						width : 550,
						height : 480,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$("#stockPannerDataGrid").datagrid(
								"reload");
						}
					});
				}
			}
			$("#stockPannerDataGrid").datagrid({
				url : "stockPannerController_liststockPanner.html",
				title : "采购申请列表",
				fitColumns : true,
				striped : true,
				rownumbers : true,
				columns : [ [  {
					hidden:"true",
					field : "inmappingId",
					title : "关联表主键ID",
					width : 50,
					sortable : true
				},{
					field : 'id',
					title : '序号',
					width : 100,
					sortable : true
				}, {
					field : 'stockName',
					title : '采购计划名称',
					width : 100,
					sortable : true,
				}, {
					field : 'status',
					title : '状态',
					width : 100,
					sortable : true,
				}, {
					field : 'budget',
					title : '总金额',
					width : 100,
					sortable : true,
				}, {
					field : 'endDate',
					title : '截止时间',
					width : 100,
					sortable : true,
				},{
					field : 'enquireName',
					title : '对应询价书',
					width : 100,
					sortable : true,
				}, {
					field : "op1",
					title : "操作",
					width : 100,
					formatter : function(value, rowData, rowIndex) {
						var id = rowData["id"];
						return "<a href='#' onclick=getStockPanner(" + id + ")>查看</a>"
					}
				} ] ],
				toolbar : "#searchStockPannerForm",
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 15, 20, 50 ],
				sortName : "id",
				sortOrder : "asc",
			})
		});
	
		//查看指定菜单
		function getStockPanner(id) {
			$("#stockPannerForm").window({
				title : "查看计划详情",
				width : 800,
				height : 480,
				modal : true,
				minimizable : false,
				href : "stockPannerController_viewstockPanner.html?id=" + id
			});
		}
	</script>
</body>
</html>

