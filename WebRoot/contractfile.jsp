<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

  <!DOCTYPE HTML>
<html>
  <head>
    <title>合同归档</title>
    <%@ include file="commons/meta.jsp"%>
  </head>
  
  <body>
     <div style="margin: 10px 30px;">
      
      <!-- 新信息窗口 -->
      <div id="editContractFile">

      </div>
      <!-- 合同归档的工具栏设置 -->
      <div id="searchContractFileForm" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          合同申请编号:
          <input type="text" id="contNum" />
          <a href="#" class="easyui-linkbutton" iconCls="icon-search"
            onclick=ContractFile_obj.search();>查询</a>
        </div>
      </div>

      <!-- 合同归档显示 -->
      <div style="margin-top: 20px;">
        <table id="ContractFileDataGrid">

        </table>

      </div>
    </div>
    <script type="text/javascript">
  $(function(){
    ContractFile_obj = {
      search :function(){//查询 
        $("#ContractFileDataGrid").datagrid(
            "load",
            {
              contNum : $.trim($("#contNum").val()),
            });
      }
    }
    $("#ContractFileDataGrid").datagrid( {
      url : "contractFile.html",
      title : "合同归档表",
      fitColumns : true,
      striped : true,
      rownumbers : true,
      columns : [ [ {
        field : "id",
        title : "序号",
        width : 100,
        sortable : true
      }, {
        field : "contNum",
        title : "合同编码",
        width : 100,
        sortable : true
      } , {
        field : "seller",
        title : "供应商",
        width : 100,
        sortable : true
      } , {
        field : "contDate",
        title : "签订日期",
        width : 100,
        sortable : true
      } ,{
          field : "contType",
          title : "合同类型",
          width : 100,
          sortable : true
        } , {
        field : "op1",
        title : "编制",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          var status= rowData["status"];
          if(status=='C001-160'){
          	return "合同已归档";
          }
          return "<a href='#' onclick=sendCont("+id+")>合同归档</a>"
        }}] ],
      toolbar : "#searchcontractFileForm",
      pagination : true,
      pageSize : 5,
      pageList : [ 5, 10, 15, 20, 50 ],
      sortName : "id",
      sortOrder : "asc",
    });
  });

function sendCont(id){
	$.messager.confirm('提示','确认归档吗',function(result){
		if(result){
			$.ajax({
				url:"contractFilecomplete",
				data:"id="+id,
				success:function(data){
				if(data>0){
					$.messager.show({
						title:"提示",
						msg:"合同已归档"
					});
				}else{
					alert("提交失败");
				}
				$("#ContractFileDataGrid").datagrid('reload');
				}
			});
		}
	});
}
</script>
  </body>
</html>
