<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>财务部合同审批</title>
<%@ include file="commons/meta.jsp"%>

</head>

<body>
	<div style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
			onclick="contap_obj.showEdit('edit')">审批</a>
		
		<div id="editContap"></div>

		<div style="margin-top: 20px;">
			<table id="contapDataGrid">
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			contap_obj = {
				showEdit : function(state) {
					var url = "ContractApplyPlanerController_findById.html";
					 //修改
						info = "合同申请列表 ";
						var rows = $("#contapDataGrid").datagrid("getSelections");
						if (rows.length == 1) {
							id = rows[0].id;
							var inmappingId=rows[0].inmappingId;
							url += "?id=" + id+"&inmappingId="+inmappingId;
						} else {
							$.messager.alert("警告", "必须选中一行", "warning");
							return;
						}
					
					$("#editContap").window({
						title : info,
						width : 550,
						height : 480,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$("#contapDataGrid").datagrid(
								"reload");
						}
					});
				}
			}
			$("#contapDataGrid").datagrid({
				url : "contractApplyPlanerController_list.html",
				title : "合同申请列表",
				fitColumns : true,
				striped : true,
				rownumbers : true,
				columns : [ [  {
					hidden:"true",
					field : "inmappingId",
					title : "关联表主键ID",
					width : 50,
					sortable : true
				}, {
					field : "id",
					title : "序号",
					width : 50,
					sortable : true
				}, {
					field : "stockname",
					title : "采购计划名称",
					width : 100,
					sortable : true
				}, {
					field : "status",
					title : "合同申请进度",
					width : 100,
					sortable : true
				}, {
					field : "allSumPrice",
					title : "总额（元）",
					width : 100,
					sortable : true
				},{
					field : "endDate",
					title : "签订时间",
					width : 100,
					sortable : true
				},{
					field : "对应合同表",
					title : "对应合同表",
					width : 100,
					sortable : true
				}, {
					field : "op1",
					title : "操作",
					width : 100,
					formatter : function(value, rowData, rowIndex) {
						var id = rowData["id"];
						return "<a href='#' onclick=getContap(" + id + ")>查看</a>"
					}
					
				} ] ],
				toolbar : "#searchContapForm",
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 15, 20, 50 ],
				sortName : "id",
				sortOrder : "asc",
			})
		});
	
		//查看指定菜单
		function getContap(id) {
			$("#editContap").window({
				title : "查看信息详情",
				width : 550,
				height : 480,
				modal : true,
				minimizable : false,
				href : "contractApplyPannerController_viewstockPanner.html?id=" + id
			});
		}
	</script>
</body>
</html>

