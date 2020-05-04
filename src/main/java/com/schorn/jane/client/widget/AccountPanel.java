/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.widget;

import java.util.Map;
import java.util.Optional;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Widget;

/**
 *
 * @author bschorn
 */
public class AccountPanel implements Widget {

    @Override
    public String widgetId() {
        return "account-panel";
    }

    @Override
    public String widgetName() {
        return "account-panel";
    }

    @Override
    public void property(Property property, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T property(Property property, Class<T> classType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object property(Property property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tag() {
        return "account-panel";
    }

    @Override
    public Optional<HTML.Element> build() {
        HTML.Div divElement = HTML.Div.create();
        element.append(divElement);
        divElement.addClass(this.name());
        divElement.addClass("section");
        for (Map<String, String> map : this.accounts) {
            divElement.append(this.createItem(map));
        }

    }

    /*
    <div id="acct001" class="account_button">
      <div class="account_description">Checking ...7708</div>
      <div class="account_value"><span class="subscript">$</span>4,785<span class="subscript">91</span></div>
      <div class="account_value_label">AVAILABLE BALANCE</div>
    </div>
     */
    private HTML.Element createItem(Map<String, String> map) throws Exception {
        HTML.Div accountDiv = HTML.Div.create();
        accountDiv.setId(map.get("account_proxy"));
        accountDiv.addClass("account_button");
        HTML.Div accountDesc = HTML.Div.create();
        accountDiv.append(accountDesc);
        accountDesc.addClass("account_description");
        accountDesc.setTextContent(String.format("%s %s",
                map.get("account_name"),
                map.get("account_id_hint")));
        HTML.Div accountValue = HTML.Div.create();
        accountDiv.append(accountValue);
        accountValue.addClass("account_value");
        accountValue.append(HTML.Span.create().addClass("subscript").setTextContent(map.get("account_ccy")));
        String[] amounts = map.get("account_amount").split("\\.");
        if (amounts.length > 0) {
            accountValue.append(HTML.Span.create().setTextContent(amounts[0]));
        }
        if (amounts.length == 2) {
            accountValue.append(HTML.Span.create().addClass("subscript").setTextContent(amounts[1]));
        }
        HTML.Div accountValueLabel = HTML.Div.create();
        accountDiv.append(accountValueLabel);
        accountValueLabel.addClass("account_value_label");
        accountValueLabel.setTextContent("AVAILABLE BALANCE");

        return accountDiv;
    }


    @Override
    public void throwException() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
