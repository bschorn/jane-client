/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.app;

import org.schorn.ella.ui.app.App;

/**
 *
 * @author bschorn
 */
public class JaneStyler implements App.AppStyler {

    private final App app;

    public JaneStyler(App app) {
        this.app = app;
    }

    @Override
    public App getApp() {
        return this.app;
    }

}
