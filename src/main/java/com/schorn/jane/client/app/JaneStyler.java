/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.app;

import com.schorn.jane.client.style.AccountsStyle;
import com.schorn.jane.client.style.JaneStyle;
import com.schorn.jane.client.view.scene.Accounts;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Page;
import org.schorn.ella.ui.layout.Pane;
import org.schorn.ella.ui.layout.Style;
import org.schorn.ella.ui.style.FontStyle;
import org.schorn.ella.ui.style.FrameStyle;
import org.schorn.ella.ui.style.GenericStyle;
import org.schorn.ella.ui.style.PageStyle;
import org.schorn.ella.ui.style.PaneStyle;
import org.schorn.ella.ui.style.Visual;
import org.schorn.ella.ui.style.WidgetStyle;
import org.schorn.ella.ui.style.WindowStyle;
import org.schorn.ella.ui.widget.ControlWidgets;

/**
 *
 * @author bschorn
 */
public class JaneStyler implements App.AppStyler {

    private final App app;
    private final Style style;

    public JaneStyler(App app) {
        this.app = app;
        this.style = new Style.Sheet();
        Visual.init();
        JaneStyle.init();
        AccountsStyle.init();
        this.style.add(FontStyle.CALIBRI, Page.Selector.CONTAINER);
        this.style.add(GenericStyle.BOX_SIZING_BORDER_BOX, Page.Selector.GLOBAL);
        this.style.add(GenericStyle.ALIGN_CENTER_JUSTIFY_CENTER, Page.Selector.GLOBAL);
        //this.style.add(PageStyle.FLEX_COLUMN_CONTAINER);
        this.style.add(PageStyle.BLUE_STEEL);
        //this.style.add(JaneStyle.PAGE, Page.Selector.CONTAINER);
        this.style.add(FrameStyle.BLUE_STEEL);
        //this.style.add(PanelStyle.DEFAULT_CONTAINER);
        this.style.add(WindowStyle.DEFAULT_LABEL);
        this.style.add(WindowStyle.BLUE_STEEL);
        this.style.add(PaneStyle.DEFAULT_CONTAINER);
        this.style.add(PaneStyle.DEFAULT_LABEL);
        this.style.add(GenericStyle.GRID_FULL_SOLID_BLACK_ON_TGREY, Pane.Selector.CONTAINER);
        this.style.add(GenericStyle.TEXT_ALIGN_CENTER_PADDING_2PX, Pane.Selector.LABEL);
        this.style.add(GenericStyle.BORDER_2PX, Pane.Selector.CONTAINER);
        this.style.add(WidgetStyle.BLUE_STEEL);
        this.style.add(WidgetStyle.DEFAULT_LABEL);
        this.style.add(WidgetStyle.DEFAULT_INPUT);
        this.style.add(WidgetStyle.LABEL_OVER_INPUT);
        this.style.add(AccountsStyle.ACCOUNTS, Accounts.Selector.ACCOUNTS);
        this.style.add(AccountsStyle.ACCOUNT_BUTTON, Accounts.Selector.ACCOUNT_BUTTON);
        this.style.add(AccountsStyle.ACCOUNT_BUTTON_HOVER, Accounts.Selector.ACCOUNT_BUTTON_HOVER);
        this.style.add(AccountsStyle.ACCOUNT_BUTTON_ACTIVE, Accounts.Selector.ACCOUNT_BUTTON_ACTIVE);
        this.style.add(AccountsStyle.ACCOUNT_DESCRIPTION, Accounts.Selector.ACCOUNT_DESCRIPTION);
        this.style.add(AccountsStyle.ACCOUNT_VALUE, Accounts.Selector.ACCOUNT_VALUE);
        this.style.add(AccountsStyle.ACCOUNT_VALUE_SPAN_SUBSCRIPT, Accounts.Selector.ACCOUNT_VALUE_SPAN_SUBSCRIPT);
        this.style.add(AccountsStyle.ACCOUNT_VALUE_LABEL, Accounts.Selector.ACCOUNT_VALUE_LABEL);
        this.style.add(JaneStyle.MENU, ControlWidgets.Menu.Selector.MENU);
        this.style.add(JaneStyle.MENU_ITEM, ControlWidgets.MenuItem.Selector.MENU_ITEM);
        this.style.add(JaneStyle.MENU_ITEM_IMG, ControlWidgets.MenuItem.Selector.ANCHOR_IMAGE);
        this.style.add(GenericStyle.IMG_OBJECT_FIT_CONTAIN, ControlWidgets.MenuItem.Selector.ANCHOR_IMAGE);
        this.style.add(JaneStyle.HEADER, Frame.Selector.HEADER);
        this.style.add(JaneStyle.MAIN, Frame.Selector.CONTENT);
        this.style.add(JaneStyle.FOOTER, Frame.Selector.FOOTER);
    }

    @Override
    public App getApp() {
        return this.app;
    }

    @Override
    public Style getPageStyle() {
        return this.style;
    }

}
