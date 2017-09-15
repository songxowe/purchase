<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>需求计划一览表</title>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
</script>


</head>

<!-- 设置权限 -->


<body>


	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">

		<!-- 3.设置 toolbar -->
		<div id="searchOrdersViewForm" style="padding: 10px">
			<!-- 6.操作按钮 (plain:为true时显示简洁效果)-->



			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px">
				物资编码:<input placeholder="物资编码" type="text" id="materialCode"
					size="6" /> 物资名称:<input placeholder="物资名称" type="text"
					id="materialName" size="6" /> 状态:<select id="status">
					<option value="">--请选择--</option>
					<option value="C001-10">未确认</option>
					<option value="C001-20">已确认</option>
				</select> <a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="ordersView_obj.search();">查询</a>
			</div>

			<div id="view"></div>
			<div id="edit"></div>

			<div style="margin-bottom: 10px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="ordersView_obj.ensure();">确定</a> <a href="#"
					class="easyui-linkbutton" iconCls="icon-search" plain="true"
					onclick="ordersView_obj.details();">详情</a> <a href="#"
					class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="ordersView_obj.edit();">修改</a> 
			</div>



		</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top:10px;text-align: center;">
			<h1>需求计划一览表</h1>
			<table id="ordersViewDataGrid">

			</table>

		</div>



	</div>
	<script type="text/javascript">
		$(function() {
			ordersView_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#ordersViewDataGrid").datagrid('load', {
						materialCode : $.trim($("#materialCode").val()),
						materialName : $.trim($("#materialName").val()),
						status : $.trim($("#status").val()),
					});
				},
	
				ensure : function() { // 6.确定
					// 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
					var rows = $("#ordersViewDataGrid").datagrid("getSelections");
					if (rows.length == 1) {
						if (this.editRow == undefined) { // edit
							var rowIndex = $("#ordersViewDataGrid").datagrid("getRowIndex", rows[0]);
							$.ajax({
								type : "post",
								url : "ordersf/ordersController_ensure?id=" + rows[0].id,								
								success : function(data) {
									if (data) {
										// 隐藏载入状态
										$("#ordersViewDataGrid").datagrid("loaded");
										// 加载和显示第一页的所有行
										$("#ordersViewDataGrid").datagrid("load");
										// 取消选择所有当前页中所有的行
										$("#ordersViewDataGrid").datagrid("unselectAll");
										$.messager.show({
											title : "提示",
											msg : data + "个需求计划被确认"
										});
									}
								}
							});
	
	
						}
	
					}
					else if (rows.length > 1) {
						$.messager.alert("警告", "只能选中一行", "warning");
					}
					else {
						$.messager.alert("警告", "必须选中一行", "warning");
					}
	
				},
	
				details : function() { // 7.详情
					// 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
					var rows = $("#ordersViewDataGrid").datagrid("getSelections");
					if (rows.length == 1) {
						if (this.editRow == undefined) { // edit
							var rowIndex = $("#ordersViewDataGrid").datagrid(
								"getRowIndex", rows[0]);
							//$("#ordersViewDataGrid").datagrid("beginEdit", rowIndex);
							//this.editRow = rowIndex; // 设置当前选中行为编辑行
							$('#view').window({
								title : '需求计划明细',
								width : 600,
								height : 400,
								closed : false,
								cache : false,
								href : "ordersf/ordersController_details.html?id=" + rows[0].id,
								//modal : true
							});
						// window.location="materialController_goadd.html?id="+rows[0].id; 
						}
	
					}
					else if (rows.length > 1) {
						$.messager.alert("警告", "只能选中一行", "warning");
					}
					else {
						$.messager.alert("警告", "必须选中一行", "warning");
					}
	
				},
	
				edit : function() { // 8.修改
					// 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
					var rows = $("#ordersViewDataGrid").datagrid("getSelections");
					if (rows.length == 1) {
						if (this.editRow == undefined) { // edit
							var rowIndex = $("#ordersViewDataGrid").datagrid(
								"getRowIndex", rows[0]);
							$('#edit').window({
								title : '修改需求计划',
								width : 600,
								height : 400,
								closed : false,
								cache : false,
								href : "ordersf/ordersController_details.html?id=" + rows[0].id + "&type='edit'",
								//modal : true
							});
						}
					}
					else if (rows.length > 1) {
						$.messager.alert("警告", "只能选中一行", "warning");
					}
					else {
						$.messager.alert("警告", "必须选中一行", "warning");
					}
	
				}
			}
	
	
			// 2.自动加载表格数据
			$("#ordersViewDataGrid").datagrid({
				url : "ordersf/ordersController.html",
				title : "需求计划一览表",
				fitColumns : true, // 自动展开/收缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				singleSelect:true,
				columns : [ [ { // -- 列开始 ---------
					field : 'id', // field 名必需与json数据中的 属性名一致
					title : '序号',
					width : 50,
					checkbox : true,
					sortable : true
				}, {
					field : 'materialCode',
					title : '物资编码',
					width : 100,
					sortable : true,
				}, {
					field : 'materialName',
					title : '物资名称',
					width : 100,
					sortable : true,
				}, {
					field : 'amount',
					title : '数量',
					width : 100,
					sortable : true,
				}, {
					field : 'orderSource',
					title : '采购类型',
					width : 100,
					sortable : true,
				}, {
					field : 'status',
					title : '采购状态',
					width : 100,
					sortable : true,					
				} ] ], // -- 列结束 ---------
				toolbar : "#searchOrdersViewForm",
				pagination : true, // -- 分页设置 ----
				pageSize : 5, // rows:每页显示的记录条数 (page 控件自动计算)
				pageList : [ 5, 10, 15, 20, 50 ], // 设置每页条数的列表
				sortName : "id", // sort:排序列 (默认)
				sortOrder : "asc", // order:升序/降序 (默认)
	
			});
	
	
		});
	</script>

</body>
</html>
