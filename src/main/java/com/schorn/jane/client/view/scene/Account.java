/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.ViewerScene;
import org.schorn.ella.ui.layout.Item;
import org.schorn.ella.ui.layout.Window;

/**
 *
 * @author bschorn
 */
public class Account extends ViewerScene {

    private final List<Window> windows = new ArrayList<>();

    public Account(App.AppConfig appConfig) {
        super(appConfig.getItemPropertyValue(String.class, Account.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, Account.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, Account.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, Account.class, Item.Properties.VISIBLE)
        );
    }

    @Override
    public List<Window> windows() {
        return Collections.unmodifiableList(this.windows);
    }

}
