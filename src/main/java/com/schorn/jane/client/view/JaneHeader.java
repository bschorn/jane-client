/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view;

import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.ViewerComponent;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Identifier;
import org.schorn.ella.ui.layout.Item;
import org.schorn.ella.ui.layout.Window;

/**
 *
 * @author bschorn
 */
public class JaneHeader extends ViewerComponent {

    private final Frame frame;
    private final Window window;

    public JaneHeader(AppConfig appConfig) throws Exception {
        super(appConfig.getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, JaneHeader.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, JaneHeader.class, Item.Properties.VISIBLE)
        );
        this.frame = Frame.create(Identifier.NONE, Frame.Intent.HEADER);
        this.window = Window.create(Identifier.create(this.name()), this.label());
        this.frame.accept(this.window);
    }

    @Override
    public Frame frame() {
        return this.frame;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private JaneHeader() {
        super("jane-header", "header", "Header", Boolean.TRUE);
        this.frame = null;
        this.window = null;
    }

    static public void main(String[] args) {
        JaneHeader item = new JaneHeader();
        System.out.println(item.dumpProperties());
    }

}
