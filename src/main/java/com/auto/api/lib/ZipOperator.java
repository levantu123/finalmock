package com.auto.api.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOperator {
	public static void cleanData(String dir) {
		File dirObj = new File(dir);
		cleanDir(dirObj);
	}

	private static void cleanDir(File dirObj) {
		File[] files = dirObj.listFiles();

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				cleanDir(files[i]);
			}
			files[i].delete();
		}
	}

	public static void zipDir(String zipFileName, String dir) throws IOException {
		File dirObj = new File(dir);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		addDir(dirObj, out, "");
		out.flush();
		out.close();
	}

	static void addDir(File dirObj, ZipOutputStream out, String path) throws IOException {
		File[] files = dirObj.listFiles();
		byte[] tmpBuf = new byte[4096];

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {

				addDir(files[i], out, path + files[i].getName() + "/");
				continue;
			}
			FileInputStream in = new FileInputStream(files[i]);
			out.putNextEntry(new ZipEntry(path + files[i].getName()));
			int len;
			while ((len = in.read(tmpBuf)) > 0) {
				out.write(tmpBuf, 0, len);
			}
			out.closeEntry();
			in.close();
		}
	}
}
