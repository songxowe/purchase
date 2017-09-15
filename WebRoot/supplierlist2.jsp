<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>供应商信息一览表</title>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
</script>


</head>

<!-- 设置权限 -->


<body>


	<!-- easyui步骤:
	1.复制easyui 所需的js/css文件
	2.jsp页面导入js/css文件
	 -->

	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">

		<!-- 3.设置 toolbar -->
		<div id="searchOSupplierForm" style="padding: 10px">
			<!-- 6.操作按钮 (plain:为true时显示简洁效果)-->



			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px">
				公司编码:<input placeholder="公司编码" type="text" id="supplierNum"
					size="6" /> 
				公司名称:<input placeholder="公司名称" type="text"
					id="company" size="6" /> 
				
					
					
					公司性质：
				
					<select id="kind">
						<option value="">
							--请选择--
					    <option value="G000-1">国有企业</option>
						<option value="G000-2">集体企业</option>
						<option value="G000-3">股份合作企业</option>
						<option value="G000-4">有限责任公司</option>
						<option value="G000-5">股份有限公司</option>
						<option value="G000-6">私营独资企业</option>
						<option value="G000-7">中外合资经营企业</option>
					</select>
					
					
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="supplier_obj.search();">查询</a>
			</div>

			<div id="dd"></div>
</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top:10px;text-align: center;">
			<h1>供应商信息一览表</h1>
			<table id="supplierDataGrid">

			</table>

		</div>
		
		<div id="dds"></div>


	<script type="text/javascript">
		$(function() {
			supplier_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#supplierDataGrid").datagrid('load', {
						supplierNum : $.trim($("#supplierNum").val()),
						company : $.trim($("#company").val()),
						kind : $.trim($("#kind").val()),
					});
				},
	
				basic : function() { // 6.基本信息
					// 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
					var rows = $("#supplierDataGrid").datagrid("getSelections");
					if (rows.length == 1) {
						if (this.editRow == undefined) { // edit
							var rowIndex = $("#supplierDataGrid").datagrid(
								"getRowIndex", rows[0]);								
							$('#dds').window({
								title : '供应商基本信息',
								width : 600,
								height : 400,
								closed : false,
								cache : false,
								href : "supplierController_supplier.do?id=" +rows[0].id,
								
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
				
			
			register : function() { // 7.注册信息
					// 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
					var rows = $("#supplierDataGrid").datagrid("getSelections");
					if (rows.length == 1) {
						if (this.editRow == undefined) { // edit
							var rowIndex = $("#supplierDataGrid").datagrid(
								"getRowIndex", rows[0]);								
							$('#dd').window({
								title : '供应商注册信息',
								width : 600,
								height : 400,
								closed : false,
								cache : false,
								href : "supplierController_register.do?id=" +rows[0].id,
								modal : true
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
	
				
	
			
				
				
			}
	
	
			// 2.自动加载表格数据
			$("#supplierDataGrid").datagrid({
				url : "supplierController_list.dao",
				title : "供应商信息一览表",
				fitColumns : true, // 自动展开/收缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				columns : [ [ { // -- 列开始 ---------
					field : 'id', // field 名必需与json数据中的 属性名一致
					title : '序号',
					width : 50,
					checkbox : true,
					sortable : true
				}, {
					field : 'supplierNum',
					title : '供应商编号',
					width : 100,
					sortable : true,
				}, {
					field : 'company',
					title : '公司名称',
					width : 100,
					sortable : true,
				}, {
					field : 'kind',
					title : '公司性质',
					width : 100,
					sortable : true,
					formatter:function(value,rowDate,rowIndex){
						var s=rowDate["kind"];
						if(s=="G000-1"){
							return "国有企业"
						}else if(s=="G000-2"){
							return "集体企业"
						}else if(s=="G000-3"){
							return "股份合作企业"
						}else if(s=="G000-4"){
							return "有限责任公司"
						}else if(s=="G000-5"){
							return "股份有限公司"
						}else if(s=="G000-6"){
							return "私营独资企业"
						}else if(s=="G000-7"){
							return "中外合资经营企业"
						}
						
					}
				}, {
					field : 'contact',
					title : '联系人',
					width : 100,
					sortable : true,
				},{
					field : 'phone',
					title : '电话',
					width : 100,
					sortable : true,
				},{
        field : "op1",
        title : "操作",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id= rowData["id"];
          return "<a href='#' onclick=getSupplier("+id+")>查看</a>"
        }
      } ] ], // -- 列结束 ---------
				toolbar : "#searchOSupplierForm",
				pagination : true, // -- 分页设置 ----
				pageSize : 5, // rows:每页显示的记录条数 (page 控件自动计算)
				pageList : [ 5, 10, 15, 20, 50 ], // 设置每页条数的列表
				sortName : "id", // sort:排序列 (默认)
				sortOrder : "asc", // order:升序/降序 (默认)
	
			});
	
	
		});
		function getSupplier(id){
 //alert(id)
    $("#supplierDataGrid").window({
      title : "查看个人信息详情",
      width : 550,
      height : 480,
      modal : true,
      minimizable : false,
      href : "supplierController_supplier.html?id="+id
    });
  }
	</script>

</body>
</html>
