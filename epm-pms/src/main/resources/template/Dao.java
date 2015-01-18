package ${project.javaBasicPackagePath}.dao;

import java.util.List;
import java.util.Map;

import ${project.javaBasicPackagePath}.entity.${model.subSystemUpper}${model.modelNameUpper}Bean;

import org.easyworld.core.persistence.mybatis.annotation.MyBatisDaoAnnotation;


@MyBatisDaoAnnotation
public interface ${model.subSystemUpper}${model.modelNameUpper}Dao {
	
	public void insert${model.subSystemUpper}${model.modelNameUpper}(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean);
	
	public List<${model.subSystemUpper}${model.modelNameUpper}Bean> select${model.subSystemUpper}${model.modelNameUpper}sBy${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean);
	
	public List<${model.subSystemUpper}${model.modelNameUpper}Bean> select${model.subSystemUpper}${model.modelNameUpper}sByMap(Map parameter);
	
	public ${model.subSystemUpper}${model.modelNameUpper}Bean select${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Id(String ${model.subSystem}${model.modelNameUpper}Id);
	
	public void update${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean);
	
	public void delete${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Bean(${model.subSystemUpper}${model.modelNameUpper}Bean ${model.subSystem}${model.modelNameUpper}Bean);
	
	public void delete${model.subSystemUpper}${model.modelNameUpper}By${model.modelNameUpper}Id(String ${model.subSystem}${model.modelNameUpper}Id);
}