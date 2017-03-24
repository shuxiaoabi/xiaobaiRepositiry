package com.shu.hamal.canal.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @author shuxiaobai
 */
public class HamalPropertyConfigurer extends PropertyPlaceholderConfigurer {

	private static Map<String, String> propertiesMap;  
	  
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,  
            Properties props)throws BeansException { 
  
        super.processProperties(beanFactory, props);  
        propertiesMap = new HashMap<String, String>();  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            propertiesMap.put(keyStr, value);  
        }  
    }  
  
    public static String getHamalProperty(String name) {  
        return propertiesMap.get(name);  
    }
}
