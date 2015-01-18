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
	<ul class="nav nav-tabs">
		<li class="active">
			<a href="${ctx}/pm/validation/validationManagementPage"><spring:message code="label.basic.action.list" /></a>
		</li>
		<li class="active">
			<a href="${ctx}/pm/validation/validationManagementPage"><spring:message
					code="label.basic.action.add" /></a>
		</li>
	</ul>
	
	<form:form id="validation_search_form" action="${ctx}/pm/validation/validationManagementPage" method="post"
	class="breadcrumb form-search">
		<label><spring:message
				code="label.epm.pm.validation.projectId" /></label>
		<input name="projectId" class="input-samll" type="text"/>
	</form:form>
</body>
</html>