package org.movealong.config;

/**
 * Created by IntelliJ IDEA.
 * User: inkblot
 * Date: Apr 7, 2011
 * Time: 7:26:59 AM
 */
public class ConfigurationException extends RuntimeException {
    private final String property;

    public ConfigurationException(String message) {
        this(message, null, null);
    }

    public ConfigurationException(String message, Throwable cause) {
        this(message, cause, null);
    }

    public ConfigurationException(String message, Throwable cause, String property) {
        super(message, cause);
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
