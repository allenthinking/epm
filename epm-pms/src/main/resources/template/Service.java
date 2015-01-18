package ${project.javaBasicPackagePath}.service;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.easyworld.epm.core.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ${project.javaBasicPackagePath}.entity.${model.subSystemUpper}${model.modelNameUpper}Bean;
import ${project.javaBasicPackagePath}.dao.${model.subSystemUpper}${model.modelNameUpper}Dao;


@Service
public class ${model.subSystemUpper}${model.modelNameUpper}Service{
	
	@Autowired
	private ${model.subSystemUpper}${model.modelNameUpper}Dao ${model.subSystem}${model.modelNameUpper}Dao;
	
	
	
	
	public void modify${model.subSystemUpper}${model.modelNameUpper}(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		this.${model.subSystem}${model.modelNameUpper}Dao.update${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Bean(${model.subSystem}${model.modelNameUpper}Bean);
	}
	
	public void remove${model.subSystemUpper}${model.modelNameUpper}(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		this.${model.subSystem}${model.modelNameUpper}Dao.delete${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Bean(${model.subSystem}${model.modelNameUpper}Bean);
	}
	
	public void remove${model.subSystemUpper}${model.modelNameUpper}ById(String ${model.subSystem}${model.modelNameUpper}Id){
		this.${model.subSystem}${model.modelNameUpper}Dao.delete${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Id(${model.subSystem}${model.modelNameUpper}Id);
	}
	
	public void save${model.subSystemUpper}${model.modelNameUpper}(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		this.${model.subSystem}${model.modelNameUpper}Dao.insert${model.subSystemUpper}${model.modelNameUpper}(${model.subSystem}${model.modelNameUpper}Bean);
	}
	
	public List<${model.subSystemUpper}${model.modelNameUpper}Bean> select${model.subSystemUpper}${model.modelNameUpper}sBy${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean){
		
		List<${model.subSystemUpper}${model.modelNameUpper}Bean> ${model.subSystem}${model.modelNameUpper}s = new ArrayList<${model.subSystemUpper}${model.modelNameUpper}Bean>();
		${model.subSystem}${model.modelNameUpper}s = this.${model.subSystem}${model.modelNameUpper}Dao.select${model.subSystemUpper}${model.modelNameUpper}sBy${model.modelNameUpper}Bean( ${model.subSystem}${model.modelNameUpper}Bean);
		
		return ${model.subSystem}${model.modelNameUpper}s;
	}
	
	public List<${model.subSystemUpper}${model.modelNameUpper}Bean> select${model.subSystemUpper}${model.modelNameUpper}sByMap(Map parameter){
		List<${model.subSystemUpper}${model.modelNameUpper}Bean> ${model.subSystem}${model.modelNameUpper}s = new ArrayList<${model.subSystemUpper}${model.modelNameUpper}Bean>();
		${model.subSystem}${model.modelNameUpper}s = this.${model.subSystem}${model.modelNameUpper}Dao.select${model.subSystemUpper}${model.modelNameUpper}sByMap(parameter);
		
		return ${model.subSystem}${model.modelNameUpper}s;
	}
	
	public ${model.subSystemUpper}${model.modelNameUpper}Bean select${model.subSystemUpper}${model.modelNameUpper}BeanById(String ${model.subSystem}${model.modelNameUpper}Id){
		
		${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper} = new ${model.subSystemUpper}${model.modelNameUpper}Bean();
		
		if(StringUtils.isNotBlank(${model.subSystem}${model.modelNameUpper}Id)){
			${model.subSystem}${model.modelNameUpper} =	this.${model.subSystem}${model.modelNameUpper}Dao.select${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Id(${model.subSystem}${model.modelNameUpper}Id);
			return ${model.subSystem}${model.modelNameUpper};
		}else{
			return ${model.subSystem}${model.modelNameUpper};
		}
		
		
	}
	
}