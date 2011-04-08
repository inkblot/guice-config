package org.movealong.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: inkblot
 * Date: Apr 7, 2011
 * Time: 7:12:16 AM
 */
public class PropertiesModule extends AbstractModule {

    private final Map<String,Setting> properties;

    public PropertiesModule(String path) {
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream(path));
        } catch (IOException e) {
            throw new ConfigurationException("Could not read properties from classpath resource", e);
        }
        Map<String, Setting> propMap = new HashMap<String, Setting>(p.size());
        Enumeration<Object> propEnum = p.keys();
        while (propEnum.hasMoreElements()) {
            String key = (String) propEnum.nextElement();
            propMap.put(key, new Setting(key, p.getProperty(key)));
        }
        this.properties = Collections.unmodifiableMap(propMap);
    }

    @Override
    protected void configure() {
        for (Map.Entry<String, Setting> entry : properties.entrySet()) {
            bind(Setting.class).annotatedWith(Names.named(entry.getKey())).toInstance(entry.getValue());
        }
    }

    public Setting get(String key) {
        return properties.get(key);
    }

}
