package com.framework.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {

	Properties p=new Properties();
	 
	public Properties getProperty() throws IOException{
		InputStream ip=new FileInputStream(new File(System.getProperty("user.dir")+"src/object/object.properties"));
		p.load(ip);
		return p;
	}
}
