<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()
			+ "://"
			+ request.getServerName()
			+ (request.getServerPort() == 80 ? "" : ":"
					+ request.getServerPort()) + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function deleteUserById(id){
	$.ajax({
			url:"<%=basePath%>/Home/userAction!deleteUser",
			type:'post',
			data:{'id':id},
			success:function(data){
				$("#user_"+id).remove();
			}			
	});
}
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<s:iterator value="userList" var="user">
			<tr id="user_${user.id }">
				<td>${user.name }</td>
				<td>${user.age }</td>
				<td><a href="javascript:void(0);"
					onclick="javascript:deleteUserById(${user.id });">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	==============================================================
	<form action="<%=basePath%>/Home/userAction!addUser" method="post">
		姓名：<input name="user.name" /><br /> 
		年龄：<input name="user.age" /> 
		<input type="submit" value="添加" />
	</form>
</body>
</html>
