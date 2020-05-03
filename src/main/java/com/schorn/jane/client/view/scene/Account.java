/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view.scene;

import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.ViewerScene;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class Account extends ViewerScene {

    public Account(App.AppConfig appConfig) {
        super(appConfig.getItemPropertyValue(String.class, Account.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, Account.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, Account.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, Account.class, Item.Properties.VISIBLE)
        );
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {
        HTML.Div divElement = HTML.Div.create();
        element.append(divElement);
        divElement.addClass(this.name());
        divElement.addClass("section");
    }

}
