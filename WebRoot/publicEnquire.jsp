
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>公共询价</title>
    <%@ include file="commons/meta.jsp"%>
  </head>

  <body>
    <div style="margin: 10px 30px;">
      
      <div id="editEnquire">

      </div>
      
      <!-- 新增雇员信息窗口 -->
      <div id="addQuote">
			
      </div>
      
      <!-- 雇员列表的工具栏设置 -->
      <div id="searchEnquireFormP" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
          	标题:
          <input class="easyui-textbox" type="text" id="enquireName" />
         &nbsp;&nbsp;
         	开始日期:
         <input class="easyui-datebox" id="beginDate" size="10">
         &nbsp;&nbsp;
         	结束日期
		 <input class="easyui-datebox" id="endDate" size="10">
		 &nbsp;&nbsp;
          <a href="#" class="easyui-linkbutton" iconCls="icon-search"
            onclick=enquire_obj.search();>查询</a>
        </div>
      </div>

      <!-- 雇员列表显示 -->
      <div style="margin-top: 20px;">
        <table id="enquireDataGridP">

        </table>

      </div>
    </div>
    <script type="text/javascript">
  $(function() {
    enquire_obj = {
      search : function() {
        $("#enquireDataGridP").datagrid(
            "load",
            {
              enquireName : $.trim($("#enquireName").val()),
              beginDate : $("#beginDate").datebox('getValue'),
			  endDate : $("#endDate").datebox('getValue'),
            });
      }
    }
    
    $("#enquireDataGridP").datagrid( {//+${sessionScope["NEWER_USER_LOGIN_INFO"].id}
      url : "quoteController_enquireList.html?stockType=C000-1",
      title : "公共询价书列表",
      singleSelect : true,
      fitColumns : true,
      striped : true,
      rownumbers : true,
      columns : [ [ {
        field : "id",
        title : "序号",
        width : 100,
        sortable : true
      }, {
        field : "enquireName",
        title : "标题",
        width : 100,
        sortable : true
      } , {
        field : "buildDate",
        title : "提交日期",
        width : 100,
        sortable : true
      } , {
        field : "endDate",
        title : "截止日期",
        width : 100,
        sortable : true
      } ,{
          field : "stockType",
          title : "采购类型",
          width : 100,
          sortable : true
        } , {
          field : "linkman",
          title : "联系人",
          width : 100,
          sortable : true
        },{
        field : "op1",
        title : "操作",
        width : 100,
        formatter : function(value, rowData, rowIndex){
          var id = rowData["id"];
          return "<a href='#' onclick=getEnquireDetail("+id+")>查看</a>"
        }
      },{
        field : "op2",
        title : "竞标",
        width : 100,
        formatter : function(value, rowData, rowIndex){
        var enquireId = rowData["id"];
          return "<a href='#' onclick=addQuote("+enquireId+")>报价</a>"
        }
      }  ] ],
      toolbar : "#searchEnquireFormP",
      pagination : true,
      pageSize : 5,
      pageList : [ 5, 10, 15, 20, 50 ],
      sortName : "id",
      sortOrder : "asc",
    });
  });

	function getEnquireDetail(id){
		$("#editEnquire").window({
	      title : "查看询价详情书",
	      width : 1200,
	      height : 480,
	      modal : true,
	      minimizable : false,
	      href : "quoteController_enquireView.html?enquireId="+id
	    });
	}
	
	function addQuote(enquireId){
		$("#addQuote").window({
	      title : "竞标报价",
	      width : 1500,
	      height : 520,
	      modal : true,
	      minimizable : false,
	      href : "quoteController_addQuote.html?enquireId="+enquireId
	    });
	}
</script>
  </body>
</html>
<!--  -->