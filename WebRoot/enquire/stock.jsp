<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>未编制询价书一览表</title>
<%@ include file="../commons/meta.jsp"%>
</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">
		<!-- 3.设置 toolbar -->

		<!-- 1.显示表格数据 -->
		<div style="margin-top: 10px">
			<div id="searchStockFormzz" style="padding: 10px">
				<div style="padding: 0 0 0 6px">
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
						onclick="stock_obj.modify()">编制</a>&nbsp; 
						采购计划名称：
						<input type="text" id="sename" size="6" />&nbsp; 
						采购类型: <select id="stype">
						<option value="">全部</option>
						<option value="c000-1">公开求购</option>
						<option value="c000-2">定向询价</option>

						</select> 
					<a href="#" class="easyui-linkbutton" iconCls="icon-search"
						onclick="stock_obj.search();">查询</a>
				</div>
			</div>
			<div style="margin-top: 10px">
				<table id="stockDataGrid">

				</table>

			</div>
			<div id="dd"></div>
		</div>

		<script type="text/javascript">
			$(function() {
				stock_obj = {
					editRow : undefined,
					search : function() { // 5.条件查询
						$("#stockDataGrid").datagrid('load', {
							sename : $.trim($("#sename").val()),
							stype : $("#stype").val()
						});
		
					},
					modify : function() {
						var url = "stenqiController.do";
						var id = 0;
						var rows = $("#stockDataGrid").datagrid("getSelections");
						if (rows.length == 1) {
							if (this.editRow == undefined) { // edit
							var rowIndex = $("#stockDataGrid").datagrid(
								"getRowIndex", rows[0]);
							
							$("#dd").dialog({
								title : '编制询价书',
								width : 1000,
								height : 650,
								closed : false,
								cache : false,
								modal : true,
								href : "procurefu/procurefuController_goadd.do?id=" + rows[0].id
							});
						}
					}
						else if (rows.length > 1) {
							$.messager.alert("警告", "不能选中多行", "warning");
							return;
						}
						else if (rows.length == 0) {
							$.messager.alert("警告", "必须选中一个用户", "warning");
							return;
						}
					}
				}
		
		
				// 2.自动加载表格数据
				$("#stockDataGrid").datagrid({
					url : "enquire/stenqiController.do",
					title : '未编制询价书列表',
					fitColumns : true, // 自动展开/收缩列
					striped : true, // 显示斑马线效果
					rownumbers : true, // 行号
					columns : [ [ { // -- 列开始 ---------
						field : 'id', // field 名必需与json中的名一致
						title : '序号',
						width : 50,
						checkbox : true,
						sortable : true
					}, {
						field : 'sename',
						title : '采购计划名称',
						width : 100,
						sortable : true,
						editor : {
							type : "validatebox",
							options : {
								required : true
							}
						}
					}, {
						field : 'stype',
						title : '采购类型',
						width : 100,
						sortable : true,
						formatter:function(value,rowData,rowIndex){
						    var data=rowData["stype"];
						    if(data=="C000-1"){
						        return "公开求购";
						    }else if(data="C000-2"){
						        return "定向询价";
						    }
						},
						editor : {
							type : "validatebox",
							options : {
								required : true
							}
						}
					},
						{
							field : 'sudate',
							title : '采购计划下达时间',
							width : 100,
							sortable : true,
							editor : {
								type : "datebox",
								options : {
									required : true
								}
							}
						}, {
							field : 'edate',
							title : '计划报价截止时间',
							width : 100,
							sortable : true,
							editor : {
								type : "datebox",
								options : {
									required : true
								}
							}
						} ] ], // -- 列结束 ---------
					toolbar : "#searchStockFormzz",
					pagination : true, // -- 分页设置 ----
					pageSize : 5, // rows:每页显示的记录条数 (page 控件自动计算)
					pageList : [ 5, 10, 15, 20, 50 ], // 设置每页条数的列表
					sortName : "id", // sort:排序列 (默认)
					sortOrder : "asc", // order:升序/降序 (默认)
		
					// 11.在用户完成编辑一行的时候触发(点击 保存 按钮)，参数包括：
					// rowIndex：编辑行的索引，索引从0开始。
					// rowData：对应于完成编辑的行的记录。
					// changes：更改后的字段(键)/值对。
		
				});
			});
			//状态下拉菜单	
		</script>
</body>
</html>