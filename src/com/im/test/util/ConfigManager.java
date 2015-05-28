package com.im.test.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigManager {
	
	private static final Log log = LogFactory.getLog(ConfigManager.class);

	private static ConfigManager instance;
	
	private static Configuration config;
	
	public static ConfigManager getInstance(){
		if(instance == null){
			synchronized (ConfigManager.class) {
				instance = new ConfigManager(); 
			}
		}
		return instance;
	}
	
	public Configuration getConfig(){
		return config;
	}
	
	private ConfigManager(){
		loadConfig();
	}

	public void loadConfig() {
		loadConfig("config.xml");
	}

	public void loadConfig(String configFileName) {
		try {
			ConfigurationFactory factory = new ConfigurationFactory(configFileName);
			config = factory.getConfiguration();
			log.info("Configuration loaded: " + configFileName);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
            throw new RuntimeException("Configuration loading error: "
                    + configFileName, e);
		}
	}
}
