/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import java.util.Properties;
import org.schorn.ella.ui.ClassLocator;
import org.schorn.ella.ui.app.App;

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

    private final ClassLocator classLocator;

    private JaneBootstrap(String[] args) {
        Properties properties = System.getProperties();
        this.classLocator = ClassLocator.create(properties);
    }

    @Override
    public <T> T get(Class<T> classT, Object... options) {
        return this.classLocator.newInstance(classT);
    }

}
