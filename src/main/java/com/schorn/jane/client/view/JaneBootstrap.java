/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import org.schorn.ella.ui.ClassLocator;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.App.AppController;
import org.schorn.ella.ui.app.App.AppStyler;
import org.schorn.ella.ui.app.App.AppViewer;
import org.schorn.ella.ui.util.CommandLineArgs;
import org.schorn.ella.ui.util.ToString;

/**
 *
 * @author bschorn
 */
public class JaneBootstrap implements App.Bootstrap {

    static public App.Bootstrap create(String[] args) {
        JaneBootstrap bootstrap = new JaneBootstrap(args);
        /*
        TODO
         */

        return bootstrap;
    }

    private final Properties properties;
    private final ClassLocator classLocator;

    private JaneBootstrap(String[] args) {
        this.properties = new Properties();
        this.properties.putAll(System.getProperties());
        CommandLineArgs cmdLineArgs = CommandLineArgs.create(args);
        try {
            URL urlObject = getClass().getClassLoader().getResource("bootstrap.properties").toURI().toURL();
            URLConnection urlConnection = urlObject.openConnection();
            this.properties.load(urlConnection.getInputStream());
        } catch (Exception ex) {
            System.err.println(ToString.stackTrace(ex));
        }
        this.properties.putAll(cmdLineArgs.getProperties());
        this.classLocator = ClassLocator.create(this.properties);
        String propertiesFile = this.properties.getProperty("properties.file");
        try {
            URL urlObject = getClass().getClassLoader().getResource(propertiesFile).toURI().toURL();
            URLConnection urlConnection = urlObject.openConnection();
            this.properties.load(urlConnection.getInputStream());
        } catch (Exception ex) {
            System.err.println(ToString.stackTrace(ex));
        }
    }

    @Override
    public Properties getProperties() {
        return this.properties;
    }

    @Override
    public AppConfig getConfig(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(AppConfig.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (AppConfig) constructor.newInstance(app);
    }

    @Override
    public AppController getController(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(AppController.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (AppController) constructor.newInstance(app);
    }

    @Override
    public AppViewer getViewer(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(AppViewer.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (AppViewer) constructor.newInstance(app);
    }

    @Override
    public AppStyler getStyler(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(AppStyler.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (AppStyler) constructor.newInstance(app);
    }
}
