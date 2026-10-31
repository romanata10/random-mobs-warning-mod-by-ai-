package org.slf4j;
public interface Logger {
    void warn(String format, Object... arguments);
    void info(String format, Object... arguments);
    void error(String format, Object... arguments);
}
