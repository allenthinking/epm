<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/main.jsp"%>
<html>
<head>
	<title><spring:message code="label.${model.subSystem}.${model.modelName}.title"/></title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${r"${ctx}"}/${model.subSystem}/${model.subSystem}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}List"></a></li>
		<li><a href="${r"${ctx}"}/${model.subSystem}/${model.subSystem}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}AddForm"><spring:message code="label.base.add.title"/></a></li>
	</ul>
	
	<form:form id="${model.subSystemUpper}${model.modelNameUpper}Form" modelAttribute="${model.subSystemUpper}${model.modelNameUpper}" action="${r"${ctx}"}/${model.subSystem}/${model.subSystemUpper}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}List" method="post" class="breadcrumb form-search">
		<#list properties as property>
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
		</#list>
		&nbsp;<input id="${model.subSystemUpper}${model.modelNameUpper}QueryBtnSubmit" class="btn btn-primary" type="submit" value="<spring:message code="label.base.action.search.title"/>"/>
	</form:form>
	
	<table id="${model.subSystemUpper}_${model.modelName}_table" class="table table-striped table-bordered table-condensed">
		<thead>
			<#list properties as property>
				<th><spring:message code="label.${model.subSystem}.${model.modelNameUpper}.${property.javaPropertyName}"/></th>
			</#list>
		</thead>
		<tbody>
			<c:forEach item="${r"${"}page.list${r"}"}" var="${model.subSystemUpper}${model.modelNameUpper}">
				<#list properties as property>
				<#if property.displayType == '00'>
				<td><a href="${r"${ctx}"}/${model.subSystem}/${model.subSystem}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}View?${property.javaPropertyName}=${r"${"}${model.subSystem}${model.modelNameUpper}.${property.javaPropertyName}${r"}"}">${r"${"}${model.subSystem}${model.modelNameUpper}.${model.primaryPropertyBean.propertyJavaType}${r"}"}</a></td>
				<#else>
				<td>${r"${"}${model.subSystem}${model.modelNameUpper}.${property.javaPropertyName}${r"}"}</td>
				</#if>
				</#list>
				<td>
					<a href="${r"${ctx}"}/${model.subSystem}/${model.subSystem}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}EditForm?${property.javaPropertyName}=${r"${"}${model.subSystem}${model.modelNameUpper}.${property.javaPropertyName}${r"}"}"><spring:message code="label.base.edit.title"/></a>
					<a href="${r"${ctx}"}/${model.subSystem}/${model.subSystem}${model.modelNameUpper}/${model.subSystem}${model.modelNameUpper}Delete?${property.javaPropertyName}=${r"${"}${model.subSystem}${model.modelNameUpper}.${property.javaPropertyName}${r"}"}" onclick="return confirmx('确认要删除该销售订单管理吗？', this.href)"><spring:message code="label.base.delete.title"/></a>
				</td>
				
			</c:forEach>
		</tbody>
	</table>
</body>

