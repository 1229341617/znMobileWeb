package com.yonyou.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
	
	public static File writeFile(byte[] bytes, String filePath,
			String fileName) throws Exception {
		File file = new File(filePath, fileName);
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		try {
			File dir = new File(filePath);
			if (!(dir.exists())) {
				dir.mkdirs();
			}
			file = new File(filePath + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
			bos.flush();
			bos.close();
			fos.close();
		} catch (Exception e) {
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (fos != null)
				fos.close();
		}
		return file;
	}

}
