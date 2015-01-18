package org.easyworld.epm.core.utils;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toLowerCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toUpperCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	/**
	 * camel convert the under line
	 * @param param
	 * @return
	 */
	public static String underlineConvertCamel(String param) {
		Pattern p = Pattern.compile("[A-Z]");
		if (param == null || param.equals("")) {
			return "";
		}
		StringBuilder builder = new StringBuilder(param);
		Matcher mc = p.matcher(param);
		int i = 0;
		while (mc.find()) {
			builder.replace(mc.start() + i, mc.end() + i, "_"
					+ mc.group().toLowerCase());
			i++;
		}

		if ('_' == builder.charAt(0)) {
			builder.deleteCharAt(0);
		}
		return builder.toString();
	}
	
	 /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
     * 例如：HELLO_WORLD->HelloWorld
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String camelConvertUnderline(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
    public static String unicodeToGB(String s)   {      
        StringBuffer sb = new StringBuffer();      
        StringTokenizer   st   =   new   StringTokenizer(s,"\\u");      
        while   (st.hasMoreTokens())   {      
            sb.append(   (char)   Integer.parseInt(st.nextToken(),   16));      
        }      
        return   sb.toString();      
    }  
	public static String toUnicodeString(String s) {
	   StringBuffer sb = new StringBuffer();
	   for (int i = 0; i < s.length(); i++) {
	     char c = s.charAt(i);
	     if (c >= 0 && c <= 255) {
	       sb.append(c);
	     }
	     else {
	      sb.append("\\u"+Integer.toHexString(c));
	     }
	   }
	   return sb.toString();
	 }
	
	/**
	 * remove the string blank and convert is 
	 * such as user name - > userName,User Name->userName
	 * @param s
	 * @return
	 */
	public static String removeBlank(String s){
		s = s.replace(" ", "_");
		s = StringUtils.camelConvertUnderline(s);
		return s;
	}
	public static void main(String args[]) {
		String userName = "User Name";
		userName = userName.replace(" ", "_");
		
		System.out.println(StringUtils.camelConvertUnderline(userName));
	}
}
