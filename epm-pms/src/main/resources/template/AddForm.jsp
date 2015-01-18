<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/main.jsp"%>
<html>
<head>
	<title>${model.modelAlias}</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		${r"$(document).ready(function() {"}
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${r"${ctx}"}/${model.subSystem}/${model.subSystemUpper}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}List"></a></li>
		<li class="active"><a href="${r"${ctx}"}/${model.subSystem}/${model.subSystemUpper}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}SaveForm"></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="${model.subSystem}${model.modelNameUpper}" action="${r"${ctx}"}/${model.subSystem}/${model.subSystemUpper}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}Edit" 
		method="post" class="form-horizontal">
	<#list properties as property>
		<div class="control-group">
			<label class="control-label"><spring:message code="label.${model.subSystem}.${model.modelName}.${property.propertyName}"/></label>
			<div class="controls">
				<#if property.propertyHtmlType == '0'>
				<form:input id="${property.htmlElementName}" path="${property.javaPropertyName}"/>
				
				<#elseif property.propertyHtmlType == '1'>
				<#elseif property.propertyHtmlType == '2'>
				<#elseif property.propertyHtmlType == '3'>
				<#elseif property.propertyHtmlType == '4'>
				<#elseif property.propertyHtmlType == '5'>
				<form:password id="${property.htmlElementName}" path="${property.javaPropertyName}"/>
				<#else>
				</#if>
			</div>
		</div>
	</#list>
	
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="<spring:message code='label.basic.action.submit'/>" />&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>