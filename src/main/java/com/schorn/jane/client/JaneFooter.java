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
public class JaneFooter extends ViewComponent {

    public JaneFooter(App app) {
        super(app.config().getItemPropertyValue(String.class, JaneFooter.class, Item.Properties.ID),
                app.config().getItemPropertyValue(String.class, JaneFooter.class, Item.Properties.NAME),
                app.config().getItemPropertyValue(String.class, JaneFooter.class, Item.Properties.LABEL),
                app.config().getItemPropertyValue(Boolean.class, JaneFooter.class, Item.Properties.VISIBLE)
        );
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {

    }

    private JaneFooter() {
        super("jane-footer", "footer", "Footer", Boolean.TRUE);
    }

    static public void main(String[] args) {
        JaneFooter item = new JaneFooter();
        System.out.println(item.dumpProperties());
    }

}
