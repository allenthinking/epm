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
	<div class="col-md-10">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header">
					<h1>
						<spring:message code="label.epm.pm.model.managementPageTitle" />
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="panel-heading">
						<div class="text-muted bootstrap-admin-box-title">Model
							Basic</div>
					</div>
					<div
						class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form:form id="inputForm" modelAttribute="pmModelBean"
							action="${ctx}/erp/ErpUser/erpUserEdit" method="post"
							class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label class="col-lg-2 control-label" for="focusedInput"><spring:message
											code="label.epm.pm.model.managementPageTitle" /></label>
									<div class="col-lg-3">
										<form:input id="model_name" path="modelName"
											class="form-control" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-lg-2 control-label" for="focusedInput"><spring:message
											code="label.epm.pm.model.modelAlias" /></label>
									<div class="col-lg-3">
										<form:input id="model_alias" path="modelAlias"
											class="form-control" value="This is focused..." />
									</div>
								</div>
							</fieldset>
						</form:form>
					</div>
					<div class="bootstrap-admin-panel-content">
						<ul class="nav nav-tabs">
							<li><a href="#">Tab 1</a></li>
							<li class="active"><a href="#">Tab 2</a></li>
							<li><a href="#">Tab 3</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</body>
</html>