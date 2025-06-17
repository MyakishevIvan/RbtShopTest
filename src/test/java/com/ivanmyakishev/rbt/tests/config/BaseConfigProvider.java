package com.ivanmyakishev.rbt.tests.config;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public abstract  class BaseConfigProvider <T extends Config>{
    protected final T config;

    public BaseConfigProvider(Class<T> configClass) {
        this.config = ConfigFactory.create(configClass, System.getProperties());
        readConfiguration();
    }
    
    protected void readConfiguration() {
        System.out.println("Loaded config: " + config.getClass().getSimpleName());
    }
}
