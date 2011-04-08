package org.movealong.config;

/**
* Created by IntelliJ IDEA.
* User: inkblot
* Date: Apr 7, 2011
* Time: 10:53:51 PM
*/
public class Setting {
    private final String key;
    private final String value;

    public Setting(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }

    public boolean booleanValue() {
        return Boolean.parseBoolean(value());
    }

    public byte byteValue() {
        return Byte.parseByte(value());
    }

    public Class<?> classValue() throws ClassNotFoundException {
        return Class.forName(value());
    }

    public double doubleValue() {
        return Double.parseDouble(value());
    }

    public float floatValue() {
        return Float.parseFloat(value());
    }

    public int intValue() {
        return Integer.parseInt(value());
    }

    public long longValue() {
        return Long.parseLong(value());
    }

    public short shortValue() {
        return Short.parseShort(value());
    }
}
