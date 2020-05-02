/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.schorn.ella.ui.app.ViewComponent;
import org.schorn.ella.ui.html.CSS;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Style;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bschorn
 */
public class Accounts extends ViewComponent implements Consumer<Map<String, String>> {

    static final Logger LGR = LoggerFactory.getLogger(Accounts.class);
    static private final String IMG_URL = "http://ecm.capitalone.com/EASE/assets/images/BANK/L1/bg_360_sml.jpg";
    static private final String ITEM_STYLE;

    static {
        CSS.Rule rule1 = CSS.Rule.create(CSS.Property.background_image, String.format("url(\"%s\")", IMG_URL));
        CSS.Rule rule2 = CSS.Rule.create(CSS.Property.min_height, "180px");
        ITEM_STYLE = String.format("%s; %s;", rule1.render(), rule2.render());
    }

    private final List<Map<String, String>> accounts = new ArrayList<>();

    public Accounts(boolean visible) {
        super("100", "accounts", "Accounts", visible);
    }

    @Override
    protected void build0(HTML.Element element) throws Exception {
        HTML.Div divElement = HTML.Div.create();
        element.append(divElement);
        divElement.addClass(this.name());
        divElement.addClass("section");
        for (Map<String, String> map : this.accounts) {
            divElement.append(this.createItem(map));
        }
    }

    @Override
    public void accept(Map<String, String> map) {
        accounts.add(map);
    }

    /**
     * Selectors
     */
    public enum Selector implements Style.Selectors {
        ACCOUNTS(CSS.Selector.create("div.accounts")),
        ACCOUNT_BUTTON(CSS.Selector.create("div.account_button")),
        ACCOUNT_BUTTON_HOVER(CSS.Selector.create("div.account_button:hover")),
        ACCOUNT_BUTTON_ACTIVE(CSS.Selector.create("div.account_button:active")),
        ACCOUNT_DESCRIPTION(CSS.Selector.create("div.account_description")),
        ACCOUNT_VALUE(CSS.Selector.create("div.account_value")),
        ACCOUNT_VALUE_SPAN_SUBSCRIPT(CSS.Selector.create("div.account_value span.subscript")),
        ACCOUNT_VALUE_LABEL(CSS.Selector.create("div.account_value_label"));

        private final CSS.Selector selector;

        Selector(CSS.Selector selector) {
            this.selector = selector;
        }

        @Override
        public CSS.Selector selector() {
            return this.selector;
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

    static List<Map<String, String>> testAccounts() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> details1 = new HashMap<>();
        details1.put("account_proxy", "X1001");
        details1.put("account_name", "Jane Checking");
        details1.put("account_id_hint", "...6874");
        details1.put("account_ccy", "$");
        details1.put("account_amount", "3,492.78");
        list.add(details1);
        Map<String, String> details2 = new HashMap<>();
        details2.put("account_proxy", "B2006");
        details2.put("account_name", "Jane Savings");
        details2.put("account_id_hint", "...4509");
        details2.put("account_ccy", "$");
        details2.put("account_amount", "12,456.91");
        list.add(details2);

        return list;
    }
}
