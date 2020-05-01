/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.ScreenComponent;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneHeader extends ScreenComponent {

    public JaneHeader(App app) {
        super(app.config().getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.ID),
                app.config().getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.NAME),
                app.config().getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.LABEL),
                app.config().getItemPropertyValue(Boolean.class, JaneHeader.class, Item.Properties.VISIBILE)
        );
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {

    }

}
