package org.javacore.pattern.factorymethod;

interface LoggerFactory {
     Logger createLogger();
     Logger createLogger(String args);
     Logger createLogger(Object obj);
}
