/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view.scene;

import com.schorn.jane.client.widget.AccountPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.ViewerScene;
import org.schorn.ella.ui.html.CSS;
import org.schorn.ella.ui.layout.Identifier;
import org.schorn.ella.ui.layout.Item;
import org.schorn.ella.ui.layout.Style;
import org.schorn.ella.ui.layout.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bschorn
 */
public class Accounts extends ViewerScene implements Consumer<Map<String, String>> {

    static final Logger LGR = LoggerFactory.getLogger(Accounts.class);
    static private final String IMG_URL = "http://ecm.capitalone.com/EASE/assets/images/BANK/L1/bg_360_sml.jpg";
    static private final String ITEM_STYLE;

    static {
        CSS.Rule rule1 = CSS.Rule.create(CSS.Property.background_image, String.format("url(\"%s\")", IMG_URL));
        CSS.Rule rule2 = CSS.Rule.create(CSS.Property.min_height, "180px");
        ITEM_STYLE = String.format("%s; %s;", rule1.render(), rule2.render());
    }

    private final List<Window> windows = new ArrayList<>();
    private final AccountPanel accountPanel = new AccountPanel();
    private final List<Map<String, String>> accounts = new ArrayList<>();

    public Accounts(AppConfig appConfig) throws Exception {
        super(appConfig.getItemPropertyValue(String.class, Accounts.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, Accounts.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, Accounts.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, Accounts.class, Item.Properties.VISIBLE)
        );
        this.windows.add(Window.create(Identifier.create(this.name()), this.label()));

    }

    /*
    protected void build0(HTML.Element element) throws Exception {
    }
     */

    @Override
    public void accept(Map<String, String> map) {
        accounts.add(map);
    }

    @Override
    public List<Window> windows() {
        return Collections.unmodifiableList(this.windows);
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
