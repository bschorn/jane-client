/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import org.schorn.ella.ui.ClassLocator;
import org.schorn.ella.ui.app.App;
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
    public App.Config getConfig(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(App.Config.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (App.Config) constructor.newInstance(app);
    }

    @Override
    public App.Controller getController(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(App.Controller.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (App.Controller) constructor.newInstance(app);
    }

    @Override
    public App.View getView(App app) throws Exception {
        Class<?> implClass = this.classLocator.getImplClass(App.View.class);
        Constructor constructor = implClass.getDeclaredConstructor(App.class);
        return (App.View) constructor.newInstance(app);
    }

}
