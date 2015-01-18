package org.easyworld.epm.core.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	public  static File createFile(String needCreateFile){
		File file = new File(needCreateFile);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;
		
	}
}
