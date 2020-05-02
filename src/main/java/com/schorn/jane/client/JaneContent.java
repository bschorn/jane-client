/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.ViewComponent;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneContent extends ViewComponent {

    public JaneContent(App app) {
        super(app.config().getItemPropertyValue(String.class, JaneContent.class, Item.Properties.ID),
                app.config().getItemPropertyValue(String.class, JaneContent.class, Item.Properties.NAME),
                app.config().getItemPropertyValue(String.class, JaneContent.class, Item.Properties.LABEL),
                app.config().getItemPropertyValue(Boolean.class, JaneContent.class, Item.Properties.VISIBLE)
        );
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {

    }

    private JaneContent() {
        super("jane-content", "content", "Content", Boolean.TRUE);
    }

    static public void main(String[] args) {
        JaneContent item = new JaneContent();
        System.out.println(item.dumpProperties());
    }

}
