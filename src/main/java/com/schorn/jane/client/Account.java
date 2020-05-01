/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import org.schorn.ella.ui.app.ScreenComponent;
import org.schorn.ella.ui.html.HTML;

/**
 *
 * @author bschorn
 */
public class Account extends ScreenComponent {

    public Account(boolean visible) {
        super("101", "account", "Account", visible);
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {
        HTML.Div divElement = HTML.Div.create();
        element.append(divElement);
        divElement.addClass(this.name());
        divElement.addClass("section");
    }

}
