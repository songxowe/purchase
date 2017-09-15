<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>物资管理</title>
<%@ include file="commons/meta.jsp"%>
</head>

<body>
	<div style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add"
        onclick="material_obj.showEdit('add')">添加</a>&nbsp;&nbsp; <a href="#"
			class="easyui-linkbutton" iconCls="icon-remove"
			onclick="material_obj.remove()">删除</a>&nbsp;&nbsp; <a href="#"
			class="easyui-linkbutton" iconCls="icon-edit"
			onclick="material_obj.showEdit('edit')">修改</a>
		<!-- 新增雇员信息窗口 -->
		<div id="editMaterial"></div>
		<!-- 雇员列表的工具栏设置 -->
		<div id="searchMaterialForm" style="padding: 10px;">
			<div style="padding: 0 0 0 6px;">
				物资编码: <input placeholder="物资编码" type="text" id="materialNum"
					size="10" /> 物资名称: <input placeholder="物资名称" type="text"
					id="materialName" size="10" /> &nbsp; <a href="#"
					class="easyui-linkbutton" iconCls="icon-search"
					onclick=material_obj.search();>查询</a>
			</div>
		</div>

		<!-- 物资列表显示 -->
		<div style="margin-top: 20px;">
			<table id="materialDataGrid">

			</table>

		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			material_obj = {
				search : function() {
					$("#materialDataGrid").datagrid('load', {
						materialNum : $.trim($("#materialNum").val()),
						materialName : $.trim($("#materialName").val()),
					});
				},
				showEdit : function(state) {
					var url = "materialController_findById.html";
					var info = "";
					var mid = 0;
					if (state=='add') { //新增
						info = "新增物资信息";
					} else { //修改
						info = "修改物资信息";
						var rows = $("#materialDataGrid").datagrid("getSelections");
						if (rows.length == 1) {
							mid = rows[0].id;
							url += "?id=" + mid;
						} else {
							$.messager.alert("警告", "必须选中一行", "warning");
							return;
						}
					}
	
					$("#editMaterial").window({
						title : info,
						width : 600,
						height : 640,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$("#materialDataGrid").datagrid('reload');
						}
					});
				},
				remove : function() {
					var rows = $("#materialDataGrid").datagrid("getSelections");
					if (rows.length > 0) {
						$.messager.confirm("消息", "确认真的要删除所选的数据吗", function(flag) {
							if (flag) {
								var mids = [];
								for (var i = 0; i < rows.length; i++) {
									mids.push(rows[i].id);
								}
								$.ajax({
									type : "post",
									url : "materialController_remove.html",
									data : {
										mids : mids.join(","),
									},
									beforeSend : function() {
										$("#materialDataGrid").datagrid("loading");
									},
									success : function(data) {
										if (data) {
											$("#materialDataGrid").datagrid("loaded");
											$("#materialDataGrid").datagrid("load");
											$("#materialDataGrid").datagrid("unselectAll");
											$.messager.show({
												title : "提示",
												msg : data + "个雇员被删除"
											});
										}
									}
								});
							}
						});
					} else {
						$.messager.alert("警告", "请选中要删除的数据", "warning");
					}
				}
			}
	
	
			$("#materialDataGrid").datagrid({
				url : "materialController.html",
				title : '物资列表',
				fitColumns : true,
				striped : true,
				rownumbers : true,
				singleSelect:true,
				columns : [ [ {
					field : "id",
					title : "序号",
					width : 100,
					sortable : true
				}, {
					field : 'materialNum',
					title : '物资编码',
					width : 100,
					sortable : true,
				}, {
					field : 'materialName',
					title : '物资名称',
					width : 200,
					sortable : true,
				}, {
					field : 'materialUnit',
					title : '计量单位',
					width : 100,
					sortable : true,
				}, {
					field : 'materialType',
					title : '物资类型',
					width : 100,
					sortable : true,
				}, {
					field : "op1",
					title : "操作",
					formatter : function(value, rowData, rowIndex) {
						var id = rowData["id"];
						return "<a href='#' onclick=getMaterial(" + id + ")>查看</a>"					
					}
				},{
					field : "op2",
					title : "操作",
					formatter : function(value, rowData, rowIndex) {
						var id = rowData["id"];
						return "<a href='#' onclick=getOrders(" + id + ")>采购</a>"					
					}
				} ] ],
				toolbar : "#searchMaterialForm",
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 15, 20, 50 ],
				sortName : "id",
				sortOrder : "asc",
			});
		});
	
		//查看指定菜单
		function getMaterial(id) {
			$("#editMaterial").window({
				title : "查看物资详情",
				width : 550,
				height : 480,
				modal : true,
				minimizable : false,
				href : "materialController_view.html?id=" + id
			});
		}
		
		function getOrders(id) {
			$("#editMaterial").window({
				title : "编制需求计划",
				width : 550,
				height : 480,
				modal : true,
				minimizable : false,
				href : "materialController_goadd.html?id=" + id
			});
		}
	</script>
</body>
</html>
