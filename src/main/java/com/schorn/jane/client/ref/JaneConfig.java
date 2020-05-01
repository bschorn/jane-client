/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.ref;

import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneConfig implements App.Config {

    @Override
    public <T> T getProperty(Class<T> classT, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T getItemPropertyValue(Class<T> classT, Class<?> classFor, Item.Property property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
