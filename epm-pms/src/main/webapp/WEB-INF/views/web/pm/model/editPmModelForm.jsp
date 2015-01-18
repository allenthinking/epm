<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/main.jsp"%>
<html>
<head>
<title>User</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

		initPage();

		$("#go_generate_bean_btn").bind("click", function() {
			generateBeanCode();
		});

		$("#select_html_type").bind("change", function() {
			updatePropertyType();
		});

		$("#input_default_value").bind("blur", function() {
			dealWithInputDefaultValue();
		});

		$("#go_add_property_btn").click(function() {
			loadPropertyForm();
		});

		$("#add_property_btn").bind("click", function() {
			addPropertyBasicValue();
		});

		$("#add_new_property_btn").bind("click", function() {
			inistializeProprtyForm();
		});

		$("#property_default_value_item").bind("blur", function() {
			dealWithPropertyDefaultValueAjax();
		});

		/***view form*/
		$("#property_display_value_item").bind("blur", function() {
			modifyPropertyDisplayNameWithAjax();
		});

		$("#property_database_tab").bind("click", function() {

		});

		//@
		$("#property_validation_tab").bind("click", function() {
			loadPropertyValidationInfo();
		});
	});

	var loadPropertyValidationInfo = function() {
		var propertyId = $("#property_id").val();

		$("#property_validation_form")
				.dataTable(
						{
							"processing" : true,
							"serverSide" : true,
							"ajax" : {
								"url" : "${ctx}/pm/property/loadPropertyValidationWithAjax?propertyId="
										+ propertyId,
								"type" : "get"
							},
							"columns" : [ {
								"data" : "propertyId"
							}, {
								"data" : "validationId"
							} ]
						});

		/**
		$.ajax({
			type : 'get',
			url : "${ctx}/pm/property/loadPropertyValidationWithAjax",
			data : {
				propertyId : propertyId
			},
			success : function(msg) {
				$("#property_validation_form").attr("data-url",
						JSON.stringify(msg));
			}
		});*/

	};

	var generateBeanCode = function() {
		var projectId = $("#project_id").val();
		var modelId = $("#managed_model_id").val();
		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/pm/engine/generateBeanCodeWithAjax",
			data : {
				projectId : projectId,
				modelId : modelId
			},
			complete : function() {

			},
			success : function(msg) {

			}
		});
	};
	var loadPropertyDatabaseInfo = function() {
		var propertyId = $("#property_id").val();

		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/pm/property/loadPmProertyDatabaseWihtAjax",
			data : {
				propertyId : propertyId
			},
			complete : function() {

			},
			success : function(msg) {

			}
		});
	};
	var updatePropertyType = function() {
		var propertyId = $("#property_id").val();
		var propertyHtmlType = $("#select_html_type").find("option:selected")
				.val();

		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/pm/property/modifyPmProertyTypeWihtAjax",
			data : {
				propertyId : propertyId,
				propertyHtmlType : propertyHtmlType
			},
			complete : function() {

			},
			success : function(msg) {
				changeElementDefault();
			}
		});
	};
	var dealWithPropertyDefaultValueAjax = function() {

		var defaultValueItem = $("#property_default_value_item").val()
		var propertyId = $("#property_id");
		var managedModelId = $("#managed_model_id").val();
		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/pm/property/addPmProertyDefaultWihtAjax",
			data : {
				propertyId : propertyId,
				propertyDefaultValue : defaultValueItem,
				modelId : managedModelId,
			},
			complete : function() {
			},
			success : function(msg) {

			}
		});
	};

	var inistializeProprtyForm = function() {
		$("#display_name").val("");
		$("#property_value").val("");
		$("#select_property_type").find("option:selected").val("0");
		$("#property_size").val("");

		$("#add_property_btn").show();
		$("#add_new_property_btn").hide();
	};

	/** Property Basic Information **/
	var addPropertyBasicValue = function() {
		var displayName = $("#display_name").val();
		var propertyDescription = $("#property_description").val();
		var propertyType = $("#select_property_type").find("option:selected")
				.val();

		var primaryType = $("#select_property_primary_type").find(
				"option:selected").val();
		var propertySize = $("#property_size").val();
		var managedModelId = $("#managed_model_id").val();
		var displayType = $("#select_property_display_type").find(
				"option:selected").val();
		
		var htmlType = $("#select_property_html_type").find("option:selected")
		.val();
		$
				.ajax({
					type : "get",
					dataType : "json",
					url : "${ctx}/pm/property/addPmProertyBeanWihtAjax",
					data : {
						modelId : managedModelId,
						displayName : displayName,
						propertyDescription : propertyDescription,
						propertySize : propertySize,
						propertyType : propertyType,
						primaryType : primaryType,
						displayType : displayType,
						htmlType:htmlType
					},
					complete : function() {
					},
					success : function(msg) {
						var newProperty = "<tr>"
								+ "<td>"
								+ msg.propertyName
								+ "</td>"
								+ "<td>"
								+ msg.propertyValue
								+ "</td>"
								+ "<td>"
								+ msg.propertyType
								+ "</td>"
								+ "<td><a href='${ctx}/pm/property/editPmPropertyForm?porpertyId='"
								+ msg.propertyType + "'>Edit</a></td>"
								+ "</tr>";
						$("#model_property_list").append(newProperty);

						if (("#property_id")) {
							$("#property_id").remove();
						}
						var newPropertyId = "<input name='proertyId' value='"+msg.propertyId+"' type='hidden' id='property_id'/>";
						$("#model_property_list").append(newPropertyId);

						loadPropertyViewFormAjax();
						$("#property_addtional_form").show();
						$("#add_property_btn").hide();
						$("#add_new_property_btn").show();
					}
				});

	};
	var loadPropertyForm = function() {
		var buttonStatus = $("#property_add_form").attr("type");
		if (buttonStatus == 'hide') {

		}

		$("#add_property_form").show();
		$("#add_new_property_btn").hide();
	};

	/**View Area**/
	var loadPropertyViewFormAjax = function() {
		var managedPropertyId = $("#property_id").val();
		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/pm/property/loadPropertyBasicViewWithAjax",
			data : {
				propertyId : managedPropertyId
			},
			success : function(msg) {
				//Property view information
				$("#property_element_key_item").val(msg.htmlElementName);
				$("#property_element_value_item").val(msg.propertyName);

				//Property Columng Information
				$("#property_db_column_name").val(msg.dbColumnName);
				$("#property_db_column_type").val(msg.dbColumnType);
			}
		});
	};
	var dealWithInputDefaultValue = function() {
		var defaultValue = $("#input_default_value").val();
		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/erp/ErpSaleOrder/addSaleOrderByProductAndNumber",
			data : {
				propertyId : propertyId,
				defaultValue : defaultValue
			},
			complete : function() {
			},
			success : function(msg) {

			}
		});
	};

	var modifyPropertyDisplayNameWithAjax = function() {
		var propertyId = $("#property_id").val();
		var propertyDisplayName = $("#property_display_value_item").val();

		$.ajax({
			type : "get",
			dataType : "json",
			url : "${ctx}/pm/property/modifyPropertyDisplayNameWithAjax",
			data : {
				propertyId : propertyId,
				propertyDisplayName : propertyDisplayName
			},
			success : function(msg) {

			}
		})
	};

	var changeElementDefault = function() {

		$(".default_value").hide();

		var checkedType = $("#select_html_type").find("option:selected").val();

		if (checkedType == '0') {//Input
			$(".default_value").hide();
			$("#html_input_default").show();
		} else if (checkedType == '1') {//Check Box
			$(".default_value").hide();

		} else if (checkedType == '2') {

		} else if (checkedType == '3') {

		} else if (checkedType == '4') {

		} else if (checkedType == '5') {

		}

	}

	var initPage = function() {

		$("#property_addtional_form").hide();
		$('#myTab a:first').tab('show');//初始化显示哪个tab 

		$('#myTab a').click(function(e) {
			e.preventDefault();//阻止a链接的跳转行为 
			$(this).tab('show');//显示当前选中的链接及关联的content 
		})

		$("#add_property_form").hide();
		$(".default_value").hide();
	}
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
							<form:hidden path="modelId" id="managed_model_id" />
							<form:hidden path="projectId" id="project_id" />
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

				</div>
			</div>
		</div>

		<div class="row">
			<div>
				<table id=""
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Property Name</th>
							<th>property Value</th>
							<th>property Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="model_property_list">
						<c:forEach items="${properties}" var="property">
							<tr>
								<td>${property.propertyName}</td>
								<td>${property.propertyValue}</td>
								<td>${property.propertyType}</td>
								<td><a
									href="${ctx}/pm/property/editPmPropertyForm?porpertyId=${property.propertyId}">Edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button type="submmit" class="btn btn-primary"
					id="go_add_property_btn">Manage Property</button>
				<button type="submmit" class="btn btn-primary"
					id="go_generate_bean_btn">Generate Code</button>
			</div>
		</div>
	</div>

	<div class="row" id="add_property_form">
		<div class="col-lg-12">
			<div class="panel panel-default bootstrap-admin-no-table-panel">
				<div class="panel-heading">
					<div class="text-muted bootstrap-admin-box-title">Property
						Management</div>
				</div>
				<div
					class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">

					<form action="" id="property_add_form" class="form-horizontal">
						<legend>Property Basic Information</legend>
						<fieldset>
							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">Display
									Name</label>
								<div class="col-lg-3">
									<input name="displayName" class="form-control"
										id="display_name" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">Property
									Description</label>
								<div class="col-lg-3">
									<input name="propertyDescription" class="form-control"
										id="property_description" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">Property
									Type</label>
								<div class="col-lg-3">
									<div class="btn-group">
										<select id="select_property_type" name="propertyType"
											id="property_type">
											<option value="0">String</option>
											<option value="1">Number-Integer</option>
											<option value="2">Number-Float</option>
											<option value="2">Number-Double</option>
											<option value="2">Boolean</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">Displays
									Type</label>
								<div class="col-lg-3">
									<div class="btn-group">
										<select id="select_property_display_type" name="displayType">
											<option value="00">Display Name</option>
											<option value="01">Others</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">Primary
									Type</label>
								<div class="col-lg-3">
									<div class="btn-group">
										<select id="select_property_primary_type" name="primaryType"
											id="primary_type">
											<option value="00">Primary Index</option>
											<option value="01">Others...</option>

										</select>
									</div>
								</div>
							</div>


							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">HTML
									Type</label>
								<div class="col-lg-3">
									<div class="btn-group">
										<select id="select_property_html_type" name="propertyHtmlType"
											id="primary_type">
											<option value="00">Input</option>
											<option value="01">Check Box</option>
											<option value="02">Radio</option>
											<option value="03">Select</option>
											<option value="05">Password</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label" for="focusedInput">Property
									Size</label>
								<div class="col-lg-3">
									<input name="propertySize" class="form-control"
										id="property_size" />
								</div>
							</div>
						</fieldset>

						<div id="property_addtional_form">
							<legend>Property Addtion Information</legend>
							<ul class="nav nav-tabs" id="myTab">
								<li class="active"><a href="#view">View</a></li>
								<li><a href="#database" id="property_database_tab">Database</a></li>
								<li><a href="#validation" id="property_validation_tab">Validation</a></li>
								<li><a href="#event">Event</a></li>
								<li><a href="#locational">Locational</a></li>
							</ul>

							<div class="tab-content">
								<div class="tab-pane active" id="view">
									<div id="property_html_form">
										<div class="form-group">
											<label class="col-lg-1 control-label" for="focusedInput">Element
												Name </label>
											<div class="col-lg-2">
												<div class="btn-group">
													<input name="elementValue" class="form-control"
														id="property_element_value_item" />
												</div>
											</div>
										</div>

										<div class="form-group">
											<label class="col-lg-1 control-label" for="focusedInput">Element
												Key </label>
											<div class="col-lg-2">
												<div class="btn-group">
													<input name="elementKey" class="form-control"
														id="property_element_key_item" />
												</div>
											</div>
										</div>
									</div>

									<div id="element_default_value">
										<div class="form-group  default_value" id="html_input_default">
											<label class="col-lg-2 control-label" for="focusedInput">Default
												Value</label>
											<div class="col-lg-3">
												<input name="default_value" class="form-control"
													id="property_default_value_item">
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="database">
									<div class="form-group">
										<label class="col-lg-1 control-label" for="focusedInput">Column
											Name </label>
										<div class="col-lg-2">
											<div class="btn-group">
												<input name="dbColumnName" class="form-control"
													id="property_db_column_name" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-1 control-label" for="focusedInput">Column
											Type </label>
										<div class="col-lg-2">
											<div class="btn-group">
												<input name="dbColumnType" class="form-control"
													id="property_db_column_type" />
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="validation">
									<table id="property_validation_form" class="display"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th data-field="propertyId">Item ID</th>
												<th data-field="validationId">Item Name</th>
											</tr>
										</thead>
									</table>

								</div>
								<div class="tab-pane" id="event">settings...</div>
								<div class="tab-pane" id="locational">settings...</div>
							</div>
						</div>

						<div id="property_form_action">
							<legend></legend>
							<button class="btn btn-lg btn-success" type="button"
								id="add_property_btn">Add Property</button>

							<button class="btn btn-lg btn-warning" type="button"
								id="add_new_property_btn">Add New Property</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>