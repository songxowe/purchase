<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>供应商物资信息一览表</title>
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
		<div id="searchsuMaSupViewForm" style="padding: 10px">
			<!-- 6.操作按钮 (plain:为true时显示简洁效果)-->



			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px">
				供应商名称:<input placeholder="供应商名称" type="text"
					id="company" size="6" /> 
				物资名称:<input placeholder="物资" type="text"
					id="materialName" size="6" /> 
					
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="suMaSupView_obj.search();">查询</a>
			</div>

			

		



		</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top:10px;text-align: center;">
			<h1>供应商物资信息一览表</h1>
			<table id="suMaSupViewDataGrid">

			</table>

		</div>
		


	</div>
	<script type="text/javascript">
		$(function() {
			suMaSupView_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#suMaSupViewDataGrid").datagrid('load', {
						materialName : $.trim($("#materialName").val()),
						company : $.trim($("#company").val()),
					});
				},				
			}
	
	
			// 2.自动加载表格数据
			$("#suMaSupViewDataGrid").datagrid({
				url : "supplierController_listView.do",
				title : "供应商物资信息一览表",
				fitColumns : true, // 自动展开/收缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				columns : [ [ { // -- 列开始 ---------
					field : '', // field 名必需与json数据中的 属性名一致
					title : '',
					width : 50,
					checkbox : true,
					sortable : true
				}, {
					field : 'supplierNum',
					title : '供应商编号',
					width : 100,
					sortable : true,
				},{
					field : 'certificate',
					title : '供应商证书编号',
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
					field : 'materialNum',
					title : '物资编码',
					width : 100,
					sortable : true,
				}, {
					field : 'materialName',
					title : '物资名称',
					width : 100,
					sortable : true,
				}, {
					field : 'materialType',
					title : '物资类别',
					width : 100,
					sortable : true,
				} ] ], // -- 列结束 ---------
				toolbar : "#searchsuMaSupViewForm",
				pagination : true, // -- 分页设置 ----
				pageSize : 5, // rows:每页显示的记录条数 (page 控件自动计算)
				pageList : [ 5, 10, 15, 20, 50 ], // 设置每页条数的列表
				sortName : "company", // sort:排序列 (默认)
				sortOrder : "asc", // order:升序/降序 (默认)
	
			});
	
	
		});
	</script>

</body>
</html>
