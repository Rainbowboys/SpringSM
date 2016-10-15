<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTf-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#testJson").on("click",function(){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/items/testJson.action",
				dataType:'json',
				contentType:"application/json;charset=utf-8",
				data:'{"name":"测试商品","price":99.9}',
				success:function(data){
					alert(data);
				}
			})
		})
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#testkeytoJson").on("click",function(){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/items/testkeytoJson.action",
				dataType:'json',
				data:"name=测试商品&price=99.9",
				success:function(data){
					alert(data);
				}
			})
		})
	});
</script>

<title>json数据交互</title>
</head>
<body>
	<button id="testJson">测试json数据</button>
	<button id="testkeytoJson">测试json数据</button>
</body>
</html>