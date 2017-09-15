
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>报价列表</title>
    <%@ include file="../commons/meta.jsp"%>
  </head>

  <body>
    <div style="margin: 10px 30px;">
      
      <!-- 新增雇员信息窗口 -->
      <div id="editQuote">

      </div>
      
      <!-- 雇员列表的工具栏设置 -->
      <div id="searchQuoteForm" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          	标题:
          <input class="easyui-textbox" type="text" id="quoTitle" />
         &nbsp;&nbsp;
         	开始日期:
         <input class="easyui-datebox" id="beginDate" size="10">
         &nbsp;&nbsp;
         	结束日期
		 <input class="easyui-datebox" id="endDate" size="10">
		 &nbsp;&nbsp;
          <a href="#" class="easyui-linkbutton" iconCls="icon-search"
            onclick=quote_obj.search();>查询</a>
        </div>
      </div>

      <!-- 雇员列表显示 -->
      <div style="margin-top: 20px;">
        <table id="quoteDataGrid">

        </table>

      </div>
    </div>
    <script type="text/javascript">
  $(function() {
    quote_obj = {
      search : function() {
        $("#quoteDataGrid").datagrid(
            "load",
            {
              enquireName : $.trim($("#quoteTitle").val()),
              beginDate : $("#beginDate").datebox('getValue'),
			  endDate : $("#endDate").datebox('getValue'),
            });
      }
    }
    
    $("#quoteDataGrid").datagrid( {//+${sessionScope["NEWER_USER_LOGIN_INFO"].id}
      url : "quoteController_quoteList.html?userId="+${sessionScope["NEWER_USER_LOGIN_INFO"].id},
      title : "报价书列表",
      fitColumns : true,
      singleSelect : true,
      striped : true,
      rownumbers : true,
      columns : [ [ {
        field : "id",
        title : "序号",
        width : 100,
        sortable : true
      }, {
        field : "queTitle",
        title : "标题",
        width : 100,
        sortable : true
      } , {
        field : "queDate",
        title : "提交日期",
        width : 100,
        sortable : true
      } , {
        field : "endDate",
        title : "截止日期",
        width : 100,
        sortable : true
      } ,{
          field : "status",
          title : "状态",
          width : 100,
          sortable : true
        },{
        field : "op1",
        title : "操作",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          return "<a href='#' onclick=getQuoteDetail("+id+")>查看</a>"
        }
      }  ] ],
      toolbar : "#searchQuoteForm",
      pagination : true,
      pageSize : 5,
      pageList : [ 5, 10, 15, 20, 50 ],
      sortName : "id",
      sortOrder : "asc",
    });
  });

	function getQuoteDetail(id){
		$("#editQuote").window({
	      title : "修改报价详情书",
	      width : 800,
	      height : 480,
	      modal : true,
	      minimizable : false,
	      href : "quoteController_findByQuote.html?quoteId="+id
	    });
	}
</script>
  </body>
</html>
<!--  -->