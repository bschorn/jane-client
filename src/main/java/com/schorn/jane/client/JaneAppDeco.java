/*
 * The MIT License
 *
 * Copyright 2020 bschorn.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.schorn.jane.client;

import com.schorn.jane.client.style.AccountsStyle;
import com.schorn.jane.client.style.JaneStyle;
import com.schorn.jane.client.view.scene.Accounts;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.schorn.ella.ui.app.PhoneAppDeco;
import org.schorn.ella.ui.app.ViewerComponent;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Identifier;
import org.schorn.ella.ui.layout.Page;
import org.schorn.ella.ui.layout.Pane;
import org.schorn.ella.ui.layout.Style;
import org.schorn.ella.ui.layout.Window;
import org.schorn.ella.ui.style.FontStyle;
import org.schorn.ella.ui.style.FrameStyle;
import org.schorn.ella.ui.style.GenericStyle;
import org.schorn.ella.ui.style.PageStyle;
import org.schorn.ella.ui.style.PaneStyle;
import org.schorn.ella.ui.style.Visual;
import org.schorn.ella.ui.style.WidgetStyle;
import org.schorn.ella.ui.style.WindowStyle;
import org.schorn.ella.ui.util.ToString;
import org.schorn.ella.ui.widget.ControlWidgets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bschorn
 */
public class JaneAppDeco implements PhoneAppDeco {

    static private final Logger LGR = LoggerFactory.getLogger(JaneAppDeco.class);

    private static final String OUTFILE = String.format("D:/Users/bschorn/output/%s.html", JaneAppDeco.class.getSimpleName());
    private final URL urlHomeImage;
    private final URL urlHelpImage;
    private final URL urlProfileImage;
    private final URL urlHome;
    private final URL urlHelp;
    private final URL urlProfile;

    private final Style style;
    private final Page page;
    private final Frame headerFrame;
    private final Frame mainFrame;
    private final Window mainPanel;
    private final Frame footerFrame;

    private final List<ViewerComponent> sections = new ArrayList<>();

    public JaneAppDeco(Style style) {
        this.style = style;
        URL urlHomeImage0 = null;
        URL urlHelpImage0 = null;
        URL urlProfileImage0 = null;
        URL urlHome0 = null;
        URL urlHelp0 = null;
        URL urlProfile0 = null;
        Page page0 = null;
        Frame headerFrame0 = null;
        Frame contentFrame0 = null;
        Window mainPanel0 = null;
        Frame footerFrame0 = null;
        try {
            urlHomeImage0 = new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/home.svg");
            urlHelpImage0 = new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/help.svg");
            urlProfileImage0 = new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/profile.svg");
            urlHome0 = new URL("http://www.google.com");
            urlHelp0 = new URL("http://www.google.com");
            urlProfile0 = new URL("http://www.google.com");

            page0 = Page.create();
            page0.setTitle(this.getClass().getSimpleName());
            page0.setViewport("device-width", "1");

            headerFrame0 = Frame.create(Identifier.NONE, Frame.Intent.HEADER);
            contentFrame0 = Frame.create(Identifier.NONE, Frame.Intent.CONTENT);
            footerFrame0 = Frame.create(Identifier.NONE, Frame.Intent.FOOTER);

            mainPanel0 = Window.create(Identifier.create("janeapp"));

            page0.accept(headerFrame0);
            page0.accept(contentFrame0);
            page0.accept(footerFrame0);

        } catch (Exception ex) {
            LGR.error("{}.ctor() - Caught Exception: {}",
                    this.getClass().getSimpleName(),
                    ToString.stackTrace(ex));
        }
        this.urlHomeImage = urlHomeImage0;
        this.urlHelpImage = urlHelpImage0;
        this.urlProfileImage = urlProfileImage0;
        this.urlHome = urlHome0;
        this.urlHelp = urlHelp0;
        this.urlProfile = urlProfile0;
        this.page = page0;
        this.headerFrame = headerFrame0;
        this.mainFrame = contentFrame0;
        this.footerFrame = footerFrame0;
        this.mainPanel = mainPanel0;
        this.mainFrame.accept(this.mainPanel);

        try {
            ControlWidgets.Menu mMain = ControlWidgets.Menu.create(Identifier.create("main"));
            mMain.addItem(ControlWidgets.MenuItem.create(Identifier.create("home"), null).setAnchor(this.urlHome).setImage(this.urlHomeImage));
            mMain.addItem(ControlWidgets.MenuItem.create(Identifier.create("help"), null).setAnchor(this.urlHelp).setImage(this.urlHelpImage));
            mMain.addItem(ControlWidgets.MenuItem.create(Identifier.create("profile"), null).setAnchor(this.urlProfile).setImage(this.urlProfileImage));
            this.footerFrame.accept(mMain);

            /*
            this.style.add(JaneStyle.MENU, ControlWidgets.Menu.Selector.MENU);
            this.style.add(JaneStyle.MENU_ITEM, ControlWidgets.MenuItem.Selector.MENU_ITEM);
            this.style.add(JaneStyle.MENU_ITEM_IMG, ControlWidgets.MenuItem.Selector.ANCHOR_IMAGE);
            this.style.add(GenericStyle.IMG_OBJECT_FIT_CONTAIN, ControlWidgets.MenuItem.Selector.ANCHOR_IMAGE);
            */

        } catch (Exception ex) {
            LGR.error("{}.ctor() - Caught Exception: {}",
                    this.getClass().getSimpleName(),
                    ToString.stackTrace(ex));
        }

    }

    @Override
    public String build() throws Exception {
        this.sections.stream()
                .forEachOrdered(section -> this.mainPanel.accept(section));
        return page.produce(style);
    }

    @Override
    public Frame header() {
        return this.headerFrame;
    }

    @Override
    public Frame content() {
        return this.mainFrame;
    }

    @Override
    public Frame footer() {
        return this.footerFrame;
    }

    @Override
    public void accept(ViewerComponent appSection) {
        this.sections.add(appSection);
    }

    static class AppStyle extends Style.Sheet {

        public AppStyle() {
            Visual.init();
            JaneStyle.init();
            AccountsStyle.init();
            this.add(FontStyle.CALIBRI, Page.Selector.CONTAINER);
            this.add(GenericStyle.BOX_SIZING_BORDER_BOX, Page.Selector.GLOBAL);
            this.add(GenericStyle.ALIGN_CENTER_JUSTIFY_CENTER, Page.Selector.GLOBAL);
            //this.add(PageStyle.FLEX_COLUMN_CONTAINER);
            this.add(PageStyle.BLUE_STEEL);
            //this.add(JaneStyle.PAGE, Page.Selector.CONTAINER);
            this.add(FrameStyle.BLUE_STEEL);
            //this.add(PanelStyle.DEFAULT_CONTAINER);
            this.add(WindowStyle.DEFAULT_LABEL);
            this.add(WindowStyle.BLUE_STEEL);
            this.add(PaneStyle.DEFAULT_CONTAINER);
            this.add(PaneStyle.DEFAULT_LABEL);
            this.add(GenericStyle.GRID_FULL_SOLID_BLACK_ON_TGREY, Pane.Selector.CONTAINER);
            this.add(GenericStyle.TEXT_ALIGN_CENTER_PADDING_2PX, Pane.Selector.LABEL);
            this.add(GenericStyle.BORDER_2PX, Pane.Selector.CONTAINER);
            this.add(WidgetStyle.BLUE_STEEL);
            this.add(WidgetStyle.DEFAULT_LABEL);
            this.add(WidgetStyle.DEFAULT_INPUT);
            this.add(WidgetStyle.LABEL_OVER_INPUT);
            this.add(AccountsStyle.ACCOUNTS, Accounts.Selector.ACCOUNTS);
            this.add(AccountsStyle.ACCOUNT_BUTTON, Accounts.Selector.ACCOUNT_BUTTON);
            this.add(AccountsStyle.ACCOUNT_BUTTON_HOVER, Accounts.Selector.ACCOUNT_BUTTON_HOVER);
            this.add(AccountsStyle.ACCOUNT_BUTTON_ACTIVE, Accounts.Selector.ACCOUNT_BUTTON_ACTIVE);
            this.add(AccountsStyle.ACCOUNT_DESCRIPTION, Accounts.Selector.ACCOUNT_DESCRIPTION);
            this.add(AccountsStyle.ACCOUNT_VALUE, Accounts.Selector.ACCOUNT_VALUE);
            this.add(AccountsStyle.ACCOUNT_VALUE_SPAN_SUBSCRIPT, Accounts.Selector.ACCOUNT_VALUE_SPAN_SUBSCRIPT);
            this.add(AccountsStyle.ACCOUNT_VALUE_LABEL, Accounts.Selector.ACCOUNT_VALUE_LABEL);
            this.add(JaneStyle.MENU, ControlWidgets.Menu.Selector.MENU);
            this.add(JaneStyle.MENU_ITEM, ControlWidgets.MenuItem.Selector.MENU_ITEM);
            this.add(JaneStyle.MENU_ITEM_IMG, ControlWidgets.MenuItem.Selector.ANCHOR_IMAGE);
            this.add(GenericStyle.IMG_OBJECT_FIT_CONTAIN, ControlWidgets.MenuItem.Selector.ANCHOR_IMAGE);
            this.add(JaneStyle.HEADER, Frame.Selector.HEADER);
            this.add(JaneStyle.MAIN, Frame.Selector.CONTENT);
            this.add(JaneStyle.FOOTER, Frame.Selector.FOOTER);
        }

    }
    static public void main(String[] args) {
        JaneAppDeco janeApp = new JaneAppDeco(new AppStyle());
        try {
            //janeApp.accept(new Accounts(true));
            //janeApp.accept(new Account(false));
            Files.write(Paths.get(OUTFILE), janeApp.build().getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
