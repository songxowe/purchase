<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>询价书明细</title>
    <%@ include file="../commons/meta.jsp"%>
  </head>

<body>
    <c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	  <c:redirect url="login.jsp"/>
	</c:if>
  <div style="margin: 10px 30px">
    <!-- 设置 toolbar -->
    <div id="searchEnquireForm" style="padding: 10px">
      <!-- 修改询价-->
      <div style="margin-bottom: 10px">
        <a href="#" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true"
           onclick="enquire_obj.edit();">询价详情</a>
      </div>
    
      <!-- 条件查询 -->
      <div style="padding: 0 0 0 6px">
        询价书名称：<input  type="text" id="enquireName" size="6"/>
        状态：<select id="status">
          <option value="">全部</option>
          <option value="C001-70">未发布</option>
          <option value="C001-80">已截止</option>
          <option value="C001-90">未揭示</option>
          <option value="C001-100">已揭示</option>
        </select>
        <a href="#" class="easyui-linkbutton"
           iconCls="icon-search"
           onclick="enquire_obj.search();">查询</a>
      </div>
    </div>
     
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="enquireDataGrid">
        
      </table>
    </div>
    <div id="enquireEditWin"></div>
  </div>
  
  <script type="text/javascript">
    $(function(){
    	enquire_obj = { 
        editRow : undefined,
        search : function(){ // 条件查询
          $("#enquireDataGrid").datagrid('load',{
            enquireName : $.trim($("#enquireName").val()),
            status : $("#status").val()
          });
        },
        edit : function(){ // 修改操作
          // 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
          var rows = $("#enquireDataGrid").datagrid("getSelections");
          if(rows.length == 1){
            if(this.editRow == undefined){ // edit
             var rowIndex = $("#enquireDataGrid").datagrid(
                    "getRowIndex", rows[0]);
              //$("#contAppIViewDataGrid").datagrid("beginEdit", rowIndex);
              //this.editRow = rowIndex; // 设置当前选中行为编辑行
              $('#enquireEditWin').dialog({    
			    title: '询价书详情',    
			    width: 1024,    
			    height:600,    
			    closed: false,    
			    cache: false,    
			    href: "enquireController_getW.do?id="+rows[0].id,    
			    modal: true  
			}); 
            }
          }else if(rows.length > 1){
             $.messager.alert("警告", "只能选中一行","warning");
          }else{
            $.messager.alert("警告", "必须选中一行","warning");
          }
        }
       
    	}
    	
    	// 自动加载表格数据
    	$("#enquireDataGrid").datagrid({
    		url : "enquire/enquireXController_list.do",
    		title : "询价书列表",
    		fitColumns : true, // 自动展开/收缩列
        striped : true,    // 显示斑马线效果
        rownumbers : true, // 行号
        columns:[[{ // -- 列开始 ---------
          field : 'id',  // field 名必需与json数据中的 属性名一致
          title : '序号',
          width : 50,
          checkbox : true,
          sortable : true
        },{
          field : 'enquireName',
          title : '询价书标题',
          width : 100,
          sortable : true,
          editor : {
            type : "validatebox",
            options : {
              required : true
            }
          }
        },{
          field : 'startDate',
          title : '询价提交时间',
          width : 100,
          sortable : true,
          editor : {
            type : "datebox",
            options : {
              required : true
            }
          }
        },{
          field : 'endDate',
          title : '询价截止时间',
          width : 100,
          sortable : true,
          editor : {
            type : "datebox",
            options : {
              required : true
            }
          }
        },{
          field : 'status',
          title : '询价书状态',
          width : 100,
          sortable : true,
        },{
          field : 'stockType',
          title : '采购计划类型',
          width : 100,
          sortable : true,
          formatter:function(value,rowData,rowIndex){
             var data=rowData["stockType"];
             if(data=="C000-1"){
                 return "公开求购";
             }else if(data=="C000-2"){
                 return "定向求购";
             }
          },
          editor : {
            type : "validatebox",
            options : {
              required : true
            }
          }
        }]], // -- 列结束 ---------
        toolbar : "#searchEnquireForm",
        pagination : true, // -- 分页设置 ----
        pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
        sortName : "id", // sort:排序列 (默认)
        sortOrder : "asc",  // order:升序/降序 (默认)
    	});
    });
  </script>
</body>
</html>
