<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Car MS</title>
</head>

<body>
	<h1>Car MS</h1>
	<h3>easyui - SpringMVC - Spring - Mybatis - Oracle</h3>
	
	<form action="" method="post" name="f" id="form">
		<input type="hidden" name="id" value="${car.id }">
		&nbsp;&nbsp;车名：
		<input class="easyui-textbox" name="name" value="${car.name }"
		data-options="required:true"><br><br>
		&nbsp;&nbsp;销售日期：
		<input class="easyui-datebox" name="saleDate" value="${car.saleDate }"><br><br>
		&nbsp;&nbsp;价格：
		<input class="easyui-numberbox" name="price" value="${car.price }"><br><br>
		&nbsp;&nbsp;
		<input type="submit" value="OK">
	</form>
	
	<script type="text/javascript">
		$("#form").form({
			url : "carController_save",
			success : function(data){
			if(data){
					$.messager.show({
						title : "提示",
						msg : "销售汽车"+data+"修改成功"
					});
				$("#editCar").window('close',true);
				}
			}
		});
	</script>
</body>
</html>
