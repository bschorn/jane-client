/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.app;

import com.schorn.jane.client.view.JaneContent;
import com.schorn.jane.client.view.JaneFooter;
import com.schorn.jane.client.view.JaneHeader;
import java.util.Properties;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneConfig implements App.AppConfig {

    private final App app;
    private final Properties properties;

    public JaneConfig(App app) {
        this.app = app;
        this.properties = this.app.bootstrap().getProperties();
    }

    @Override
    public <T> T getProperty(Class<T> classT, String name) {
        String value = this.properties.getProperty(name);
        if (value != null) {
            if (classT.equals(String.class)) {
                return (T) value;
            }
            if (classT.equals(Boolean.class)) {
                return (T) Boolean.valueOf(value);
            }
            if (classT.equals(Integer.class)) {
                return (T) Integer.valueOf(value);
            }
            if (classT.equals(Double.class)) {
                return (T) Double.valueOf(value);
            }
        }
        return null;
    }

    @Override
    public <T> T getItemPropertyValue(Class<T> classT, Class<?> classFor, Item.Property property) {
        return this.getProperty(classT, String.format("%s.%s", classFor.getSimpleName(), property.getName()));
    }

    @Override
    public App getApp() {
        return this.app;
    }

    static public void main(String[] args) {
        JaneHeader.main(new String[0]);
        JaneContent.main(new String[0]);
        JaneFooter.main(new String[0]);
    }

}
