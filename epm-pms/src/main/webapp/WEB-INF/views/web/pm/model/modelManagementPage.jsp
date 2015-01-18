<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/main.jsp"%>
<html>
<head>
<title>User</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<div>
		<table id=""
			class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>Model Number</th>
					<th>Model Name</th>
					<th>Model Alias</th>
					<th>Reference Table</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${models}" var="model">
					<td>${model.modelId}</td>
					<td>${model.modelName}</td>
					<td>${model.modelAlias}</td>
					<td>${model.tableName}</td>
					<td><a
						href="${ctx}/pm/model/editPmModelForm?pmModelBeanId=${model.modelId}">Edit</a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>