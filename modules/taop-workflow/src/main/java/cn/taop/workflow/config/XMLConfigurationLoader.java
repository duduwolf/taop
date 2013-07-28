/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过XML获取
 * 
 * @author duduwolf
 */
public class XMLConfigurationLoader implements ConfigurationLoader {
	
	/**
	 * 默认XML加载器的构造方法
	 */
	public XMLConfigurationLoader() {
		
	}

	/**
	 * 通过构造方法传入的流程id读取流程配置描述 
	 * 
	 * @param id  流程配置唯一性标识，通过XML读取流程配置时，
	 * 此id可为filePath(String)、URL(URI)、File等类型
	 */
	public XMLConfigurationLoader(Serializable id) {
		loadConfiguration(id);
	}

	@Override
	public void loadConfiguration(Serializable id) {
		if (id == null) {
			throw new ConfigurationException("流程配置出错，传入的流程标识为空", new NullPointerException());
		}
		
		File file = null;
		InputStream is = null;
		
		if (id instanceof String) {
			file = new File((String)id);
		} else if (id instanceof URI) {
			file = new File((URI)id);
		} else if (id instanceof File) {
			file = (File)id;
		} else if (id instanceof URL) {
			//远程URL的配置文件特殊处理
			handleURL(id);
			return;
		} else {
			throw new ConfigurationException("读取配置文件出错：" +
					"当前传入的流程配置id类型不可知，流程id=" + id);
		}
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new ConfigurationException("读取配置文件出错：路径为【" 
					+ file.getAbsolutePath() + "】文件未找到", e);
		}
		
		StringBuffer sb = new StringBuffer();
		String lineEnd = System.getProperty("line.separator");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is , "UTF-8"));
			String line = "NOTNULL";
			while (line != null) {
				line = br.readLine();
				if (line != null)
					sb.append(line + lineEnd);
			}
			br.close();
		} catch (IOException ioe) {
			throw new ConfigurationException("读取流程配置文件时出错：" + ioe.getMessage(), ioe);
		}
		
		if (sb.length() == 0) {
			log.warn("装载的XML配置文件为空，配置文件路径为：" + file.getAbsolutePath());
		}
		
		this.xmlData = sb.toString();
	}
	
	/**
	 * 处理远程URL的文件
	 * @param id 远程文件地址
	 */
	private void handleURL(Serializable id) {
		URL url = null;
		URLConnection urlconnection = null;
		try {
			url = new URL(id.toString());
		} catch (MalformedURLException e1) {
			throw new ConfigurationException("读取远程流程配置文件【" 
					+ id + "】时出错：" + e1.getMessage(), e1);
		}
		try {
			urlconnection = url.openConnection();
		} catch (IOException e1) {
			throw new ConfigurationException("读取远程流程配置文件【" 
					+ id + "】时出错：" + e1.getMessage(), e1);
		}
		HttpURLConnection httpConnection = (HttpURLConnection) urlconnection;
		try {
			int responseCode = httpConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream in = httpConnection.getInputStream();
				BufferedReader is = new BufferedReader(new InputStreamReader(in));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = is.readLine()) != null) {
					buffer.append(line);
				}
				this.xmlData = buffer.toString();
			}
		} catch (IOException e) {
			throw new ConfigurationException("读取远程流程配置文件【" 
					+ id + "】时出错：" + e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see cn.taop.workflow.config.ConfigurationLoader#getConfigurationString()
	 */
	@Override
	public String getConfigurationString() {
		return xmlData;
	}

	private String xmlData = null;
	
	static final Logger log = LoggerFactory.getLogger(XMLConfigurationLoader.class);

}
