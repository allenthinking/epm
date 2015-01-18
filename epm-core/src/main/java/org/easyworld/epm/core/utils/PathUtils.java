package org.easyworld.epm.core.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class PathUtils {
    /**
     * 获�?�当�?�?行程�?jar包所在路径
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getProjectPath() throws UnsupportedEncodingException{
        URL url = PathUtils.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = URLDecoder.decode(url.getPath(), "UTF-8");
        if(filePath.endsWith(".jar"))
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        return filePath;
    }
    /**
     * 返回当�?classpath路径
     * @return
     * @throws IOException
     */
    public static String currentPath() throws IOException{
        File   directory =   new   File( ". "); 
        //�?�得当�?路径
        return directory.getCanonicalPath(); 

    }
    /**
     * 获�?�一个Class的�?对路径
     * 
     * @param clazz
     * @return Class的�?对路径
     * 
     */
    public static String getPathByClass(Class clazz) {
            String path = null;
            try {
                    URI uri = clazz.getResource("").toURI();
                    File file = new File(uri);
                    path = file.getCanonicalPath();
            } catch (URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            return path;

    }
    
    /**
     * 获�?�一个文件相对于一个Class相对的�?对路径
     * 
     * @param clazz
     *            Class对象
     * @param relativePath
     *            Class对象的相对路径
     * @return 文件�?对路径
     */
    public static String getFilePathByClass(Class clazz, String relativePath) {
            String filePath = null;
            String clazzPath = getPathByClass(clazz);
            StringBuffer sbPath = new StringBuffer(clazzPath);
            sbPath.append(File.separator);
            sbPath.append(relativePath);
            File file = new File(sbPath.toString());
            try {
                    filePath = file.getCanonicalPath();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            return filePath;

    }

    public static void createPath(String needToCreate){
    	File filePath = new File(needToCreate);
    	if (!filePath.exists()) {
    		filePath.mkdirs();
    	}
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(PathUtils.getFilePathByClass(PathUtils.class,"../"));
        System.out.println(PathUtils.currentPath());
        System.out.println(PathUtils.getFilePathByClass(PathUtils.class,"../"));
    }
}
