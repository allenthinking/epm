package ${project.javaBasicPackagePath}.entity;


public class ${model.subSystemUpper}${model.modelNameUpper}Bean {
<#list properties as property>
	private ${property.propertyJavaType} ${property.propertyName};
</#list>

<#list properties as property>
	public void set${property.javaPropertyNameUpper}(${property.propertyJavaType} ${property.javaPropertyName}){
		this.${property.javaPropertyName} = ${property.javaPropertyName};
	}
	
	public ${property.propertyJavaType} get${property.javaPropertyNameUpper}(){
		return ${property.propertyName};
	}
</#list>
}