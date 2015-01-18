package org.easyworld.pm.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easyworld.epm.core.utils.FileUtils;
import org.easyworld.epm.core.utils.PathUtils;
import org.easyworld.epm.core.utils.StringUtils;
import org.easyworld.pm.bean.PmGenerateResaultBean;
import org.easyworld.pm.bean.PmGenerateResourceBean;
import org.easyworld.pm.bean.PmModelBean;
import org.easyworld.pm.bean.PmProjectBean;
import org.easyworld.pm.bean.PmProjectCommonBean;
import org.easyworld.pm.bean.PmProjectLanguageBean;
import org.easyworld.pm.bean.PmProjectPropertyBean;
import org.easyworld.pm.bean.PmPropertyBean;
import org.easyworld.pm.bean.PmPropertyEventBean;
import org.easyworld.pm.bean.PmPropertyLanguageBean;
import org.easyworld.pm.bean.PmRunTimeVariableBean;
import org.easyworld.pm.bean.PmTemplateBean;
import org.easyworld.pm.dao.PmPropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class PmEngineService {

	@Autowired
	private PmProjectService pmProjectSerice;

	@Autowired
	private PmTemplateService pmTemplateService;

	@Autowired
	private PmModelService pmModelService;

	@Autowired
	private PmPropertyService pmPropertyService;

	@Autowired
	private PmPropertyDao pmPropertyDao;

	private Template freemarkerTemplate;

	private Writer writer;

	/**
	 * generate code ,this is major interface of the code engine
	 * 
	 * @param projectId
	 * @param modelId
	 */
	public PmGenerateResaultBean generate(String projectId, String modelId) {

		PmGenerateResaultBean result = new PmGenerateResaultBean();
		PmGenerateResourceBean resource = this.initEngineByModelId(projectId,
				modelId);

		List<PmGenerateResaultBean> generateResult = this
				.generateCode(resource);

		return result;
	}

	/**
	 * initialize the engine with model id
	 * 
	 * @param projectId
	 * @param modelId
	 * @return Map ,this map will store the generate data, such as template,
	 *         model , property.
	 */
	public PmGenerateResourceBean initEngineByModelId(String projectId,
			String modelId) {
		PmGenerateResourceBean resource = new PmGenerateResourceBean();
		String projectPath = "";

		Configuration freeMarkerCfg = null;

		PmProjectBean project = this.pmProjectSerice
				.getPmProjectByProjectId(projectId);
		List<PmProjectPropertyBean> projectPropertise = project
				.getProjectProperties();

		String jspBasicPath = "";

		Map<String, Object> initializationValue = new HashMap<String, Object>();

		List<PmTemplateBean> templates = this.pmTemplateService
				.loadTemplateByProjectId(projectId);

		PmModelBean model = this.pmModelService.getModelByModelId(modelId);

		model.setSubSystemUpper(StringUtils.toUpperCaseFirstOne(model
				.getSubSystem()));
		model.setModelNameUpper(StringUtils.toUpperCaseFirstOne(model
				.getModelName()));
		List<PmPropertyBean> properties = this.pmPropertyService
				.getPropertiesByModel(modelId);

		this.initialize(properties);

		/*
		 * initialize model information
		 */
		for (PmPropertyBean property : properties) {
			if (property.getPrimaryType().equals("00")) {
				model.setPrimaryPropertyBean(property);
			}
		}

		try {
			projectPath = PmEngineService.class.getClassLoader()
					.getResource("").toURI().getPath();
			projectPath = projectPath + "/template";
			freeMarkerCfg = new Configuration();

			freeMarkerCfg.setDirectoryForTemplateLoading(new File(projectPath));
			freeMarkerCfg.setObjectWrapper(new DefaultObjectWrapper());

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PmProjectCommonBean commonProperty = new PmProjectCommonBean();

		for (PmProjectPropertyBean property : projectPropertise) {
			if (property.getPropertyType().equals("00")) {
				if (property.getPropertyKey().equals("00")) {
					jspBasicPath = property.getPropertyValue();
				} else if (property.getPropertyKey().equals("01")) {
					commonProperty.setSpringMVCJSPPrefix(property
							.getPropertyValue());
				} else {
					jspBasicPath = "/web/";

				}

			}
		}
		commonProperty.setJspBasicPath(jspBasicPath);

		resource.setProject(project);
		resource.setModel(model);
		resource.setProperties(properties);
		resource.setTemplates(templates);
		resource.setFreeMarkerCfg(freeMarkerCfg);
		resource.setPmProjectCommonBean(commonProperty);
		return resource;
	}

	/**
	 * load the event information
	 * 
	 * @return
	 */
	public List<PmPropertyEventBean> initializeValidation(String propertyId) {
		List<PmPropertyEventBean> events = new ArrayList<PmPropertyEventBean>();
		events = this.pmPropertyDao
				.selectPropertyEventsByPropertyId(propertyId);
		return events;
	}

	/**
	 * initialize the property
	 * 
	 * @param properties
	 * @return
	 */
	public List<PmPropertyBean> initialize(List<PmPropertyBean> properties) {
		if (properties.size() > 0) {
			for (PmPropertyBean property : properties) {
				String propertyName = property.getPropertyName();
				if (property.equals("") || null == property) {

				} else {
					String camelPropertyName = StringUtils
							.underlineConvertCamel(propertyName);
					String propertyType = property.getPropertyType();
					property.setDbColumnName(camelPropertyName);
					property.setHtmlElementName(camelPropertyName);
					property.setJavaPropertyName(propertyName);
					property.setJavaPropertyNameUpper(StringUtils
							.toUpperCaseFirstOne(propertyName));
					if (propertyType.equals("0")) {
						property.setPropertyJavaType("String");
						property.setDbColumnType("varchar");
					}

					List<PmPropertyEventBean> events = this
							.initializeValidation(property.getPropertyId());
					property.setEvents(events);

				}
			}
		}

		return properties;
	}

	/**
	 * generate Java Code
	 * 
	 * @param init
	 * @return generate result
	 */
	public List<PmGenerateResaultBean> generateCode(
			PmGenerateResourceBean resource) {
		List<PmGenerateResaultBean> result = new ArrayList<PmGenerateResaultBean>();

		try {

			Configuration cfg = resource.getFreeMarkerCfg();
			List<PmTemplateBean> sourceTemplates = resource.getTemplates();
			if (sourceTemplates.size() > 0) {
				for (PmTemplateBean item : sourceTemplates) {

					String tfn = item.getTemplateFileName();
					String tt = item.getTemplateType();
					freemarkerTemplate = cfg.getTemplate(tfn, "UTF-8");
					if (tt.equals("JAVA")) {
						this.generateJavaCode(item, freemarkerTemplate,
								resource);
					} else if (tt.equals("MyBatisDaoMapper")) {// Generate
																// MyBatis
																// Mapper Code
						this.generateMyBatisMapper(item, freemarkerTemplate,
								resource);
					} else if (tt.equals("JSP")) {// Generate JSP file
						this.generateJSP(item, freemarkerTemplate, resource);
					} else if (tt.equals("i18nMessages")) {// Generate JSP file
						this.generateMessages(item, freemarkerTemplate,
								resource);
					}
				}
			} else {

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * generate JAVA code by Java code template.
	 * 
	 * @param Codetemplate
	 * @param freemarkerTemplate
	 * @param model
	 * @return
	 */
	public PmGenerateResaultBean generateJavaCode(PmTemplateBean tempate,
			Template freemarkerTemplate, PmGenerateResourceBean resource) {
		try {
			String projectPath = resource.getProject().getProjectPath();
			String projectDomain = resource.getProject().getProjectDomain();
			String subSystem = resource.getModel().getSubSystem();
			String modelName = resource.getModel().getModelName();
			String sourceType = tempate.getSourceType();
			String tempateFileName = tempate.getTemplateFileName();

			String packageBasicPath = projectDomain + "." + subSystem;

			resource.getProject().setJavaBasicPackagePath(packageBasicPath);

			packageBasicPath = packageBasicPath + "." + sourceType;

			String sourceStorePath = projectPath + "/src/"
					+ packageBasicPath.replace(".", "/");

			PathUtils.createPath(sourceStorePath);

			String filePath = sourceStorePath + "/"
					+ StringUtils.toUpperCaseFirstOne(subSystem)
					+ StringUtils.toUpperCaseFirstOne(modelName)
					+ StringUtils.toUpperCaseFirstOne(tempateFileName);
			File outFile = FileUtils.createFile(filePath);

			writer = new FileWriter(outFile);

			freemarkerTemplate.process(resource, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * generate Mybatis Mapper configuration file
	 * 
	 * @param tempate
	 * @param freemarkerTemplate
	 * @param resource
	 * @return
	 */
	public PmGenerateResourceBean generateMyBatisMapper(PmTemplateBean tempate,
			Template freemarkerTemplate, PmGenerateResourceBean resource) {
		try {
			String projectPath = resource.getProject().getProjectPath();
			String projectDomain = resource.getProject().getProjectDomain();
			String subSystem = resource.getModel().getSubSystem();
			String sourceType = tempate.getSourceType();
			String modelName = resource.getModel().getModelName();
			String tempateFileName = tempate.getTemplateFileName();

			String packageBasicPath = projectDomain + "." + subSystem;

			resource.getProject().setJavaBasicPackagePath(packageBasicPath);

			String sourceStorePath = projectPath + "/resource/mappings/mysql/";

			PathUtils.createPath(sourceStorePath);

			String filePath = sourceStorePath
					+ StringUtils.toUpperCaseFirstOne(subSystem)
					+ StringUtils.toUpperCaseFirstOne(modelName)
					+ StringUtils.toUpperCaseFirstOne(tempateFileName);
			File outFile = FileUtils.createFile(filePath);

			writer = new FileWriter(outFile);

			freemarkerTemplate.process(resource, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public PmGenerateResourceBean generateJSP(PmTemplateBean tempate,
			Template freemarkerTemplate, PmGenerateResourceBean resource) {
		try {
			String projectPath = resource.getProject().getProjectPath();
			String projectDomain = resource.getProject().getProjectDomain();

			String subSystem = resource.getModel().getSubSystem();
			String sourceType = tempate.getSourceType();
			String modelName = resource.getModel().getModelName();
			String tempateFileName = tempate.getTemplateFileName();

			String packageBasicPath = projectDomain + "." + subSystem + "."
					+ sourceType;

			resource.getProject().setJavaBasicPackagePath(packageBasicPath);

			String sourceStorePath = projectPath + "/src/webapp"
					+ resource.getPmProjectCommonBean().getSpringMVCJSPPrefix()
					+ resource.getPmProjectCommonBean().getJspBasicPath();

			PathUtils.createPath(sourceStorePath);

			String filePath = sourceStorePath + "/" + subSystem
					+ StringUtils.toUpperCaseFirstOne(modelName)
					+ StringUtils.toUpperCaseFirstOne(tempateFileName);
			File outFile = FileUtils.createFile(filePath);

			writer = new FileWriter(outFile);

			freemarkerTemplate.process(resource, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public PmGenerateResourceBean generateMessages(PmTemplateBean tempate,
			Template freemarkerTemplate, PmGenerateResourceBean resource) {
		try {
			String projectPath = resource.getProject().getProjectPath();
			String projectDomain = resource.getProject().getProjectDomain();
			String subSystem = resource.getModel().getSubSystem();
			String sourceType = tempate.getSourceType();
			String modelId = resource.getModel().getModelId();
			String tempateFileName = tempate.getTemplateFileName();
			List<PmProjectLanguageBean> languages = resource.getProject()
					.getProjectLanguages();

			for (PmProjectLanguageBean language : languages) {
				String languageKey = language.getLanguageKey();

				Map paramter = new HashMap();
				paramter.put("languageKey", languageKey);
				paramter.put("modelId", modelId);

				List<PmPropertyLanguageBean> propertyLanguages = this.pmPropertyService
						.getPropertyWithLanguage(paramter);
				if (languageKey.equals("cn")) {
					for (PmPropertyLanguageBean properptyLanguage : propertyLanguages) {
						String nunicodeValue = StringUtils
								.toUnicodeString(properptyLanguage
										.getLanguageValue());
						properptyLanguage.setLanguageValue(nunicodeValue);
					}
				}
				PmRunTimeVariableBean runtimeVariable = new PmRunTimeVariableBean();
				runtimeVariable.setGeneratePropertyLanguage(propertyLanguages);
				resource.setRuntimeVariable(runtimeVariable);

				String packageBasicPath = projectDomain + "." + subSystem + "."
						+ sourceType;
				resource.getProject().setJavaBasicPackagePath(packageBasicPath);

				String sourceStorePath = projectPath + "/resource/i18n/";

				PathUtils.createPath(sourceStorePath);

				String filePath = sourceStorePath + "/" + tempateFileName;

				filePath = filePath.replace("x", languageKey);

				File outFile = FileUtils.createFile(filePath);

				writer = new FileWriter(outFile);

				freemarkerTemplate.process(resource, writer);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * generate the source store path.
	 * 
	 * @param resource
	 * @return
	 */
	public String generateSourcePath(PmGenerateResourceBean resource) {
		return "";
	}

	public static void main(String[] args) {
		File directory = new File(".");
		try {
			System.out.println(directory.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
