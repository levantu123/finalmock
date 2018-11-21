package com.auto.api.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.auto.api.lib.ZipOperator;

public abstract class AbstractBackup<A extends AbstractRepository<O>, O extends Request> {
	
	@Autowired
	A repository;
	
	public static final String PATHHOME = System.getProperty("user.home") + File.separator + "AutoMockHome"
			+ File.separator + "Data";
	public static final String PATHZIP = System.getProperty("user.home") + File.separator + "AutoMockHome";

	public byte[] backupAll() throws IOException {
		List<O> list = repository.findAll();
		for (O mock : list) {
			processBackup(mock);
		}
		ZipOperator.zipDir(PATHZIP + "/AutoMock.zip", PATHHOME);
		ZipOperator.cleanData(PATHHOME);
		FileInputStream in = new FileInputStream(PATHZIP + "/AutoMock.zip");
		byte[] zip = new byte[4096];
		in.read(zip);
		in.close();
		return zip;
	}

	public abstract void processBackup(O mock) throws IOException;
}
