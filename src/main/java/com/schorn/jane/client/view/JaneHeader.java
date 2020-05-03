/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view;

import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.ViewerComponent;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneHeader extends ViewerComponent {

    public JaneHeader(AppConfig appConfig) {
        super(appConfig.getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, JaneHeader.class, Item.Properties.VISIBLE)
        );
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {

    }

    private JaneHeader() {
        super("jane-header", "header", "Header", Boolean.TRUE);
    }

    static public void main(String[] args) {
        JaneHeader item = new JaneHeader();
        System.out.println(item.dumpProperties());
    }
}
