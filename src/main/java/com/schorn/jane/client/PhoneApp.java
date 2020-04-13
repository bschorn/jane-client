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

import com.schorn.jane.client.style.JaneStyle;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.schorn.ella.ui.html.CSS;
import org.schorn.ella.ui.layout.Aspect;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Item;
import org.schorn.ella.ui.layout.Page;
import org.schorn.ella.ui.layout.Style;
import org.schorn.ella.ui.util.ToString;
import org.schorn.ella.ui.visual.AspectStyle;
import org.schorn.ella.ui.visual.FontStyle;
import org.schorn.ella.ui.visual.FrameStyle;
import org.schorn.ella.ui.visual.GenericStyle;
import org.schorn.ella.ui.visual.PageStyle;
import org.schorn.ella.ui.visual.PanelStyle;
import org.schorn.ella.ui.visual.Visual;
import org.schorn.ella.ui.visual.WidgetStyle;
import org.schorn.ella.ui.widget.ControlWidgets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bschorn
 */
public class PhoneApp {
    static private final Logger LGR = LoggerFactory.getLogger(PhoneApp.class);

    private static final String OUTFILE = String.format("D:/Users/bschorn/output/%s.html", PhoneApp.class.getSimpleName());

    private final Style style;
    private final Page page;
    private final Frame header;
    private final Frame content;
    private final Frame footer;

    public PhoneApp(Style style) {
        this.style = style;
        Page page0 = null;
        Frame header0 = null;
        Frame content0 = null;
        Frame footer0 = null;
        try {
            page0 = Page.create();
            page0.setTitle(this.getClass().getSimpleName());
            page0.setViewport("device-width", "1");

            header0 = Frame.create(Item.Name.create("header"));
            content0 = Frame.create(Item.Name.create("content"));
            footer0 = Frame.create(Item.Name.create("footer"));

            page0.accept(header0);
            page0.accept(content0);
            page0.accept(footer0);

        } catch (Exception ex) {
            LGR.error("{}.ctor() - Caught Exception: {}",
                    this.getClass().getSimpleName(),
                    ToString.stackTrace(ex));
        }
        this.page = page0;
        this.header = header0;
        this.content = content0;
        this.footer = footer0;

        try {
            ControlWidgets.Menu mMain = ControlWidgets.Menu.create(Item.Name.create("main").toString());
            ControlWidgets.MenuItem miHome = ControlWidgets.MenuItem.create(Item.Name.create("home").toString());
            miHome.setAnchor(new URL("http://www.google.com"));
            miHome.setImage(new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/home.svg"));
            mMain.addItem(miHome);
            ControlWidgets.MenuItem miHelp = ControlWidgets.MenuItem.create(Item.Name.create("help").toString());
            miHome.setAnchor(new URL("http://www.google.com"));
            miHome.setImage(new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/help.svg"));
            mMain.addItem(miHelp);
            ControlWidgets.MenuItem miProfile = ControlWidgets.MenuItem.create(Item.Name.create("profile").toString());
            miHome.setAnchor(new URL("http://www.google.com"));
            miHome.setImage(new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/profile.svg"));
            mMain.addItem(miProfile);

            this.footer.accept(mMain);

            this.style.add(JaneStyle.MENU, CSS.Selector.createClass(mMain.customTag()));
            this.style.add(JaneStyle.MENU_ITEM, CSS.Selector.createClass(miHome.customTag()));
            this.style.add(JaneStyle.MENU_ITEM_IMG, CSS.Selector.create(String.format("li.%s img", miHome.customTag())));

        } catch (Exception ex) {
            LGR.error("{}.ctor() - Caught Exception: {}",
                    this.getClass().getSimpleName(),
                    ToString.stackTrace(ex));
        }

        CSS.Selector x = CSS.Selector.createClass(this.footer.name());
        this.style.add(JaneStyle.FOOTER, CSS.Selector.createClass(this.footer.name()));
        this.style.add(JaneStyle.HEADER, CSS.Selector.createClass(this.header.name()));
        this.style.add(JaneStyle.MAIN, CSS.Selector.createClass(this.content.name()));

    }

    public String build() throws Exception {
        return page.produce(style);
    }

    public Frame header() {
        return this.header;
    }

    public Frame content() {
        return this.content;
    }

    public Frame footer() {
        return this.footer;
    }

    static class PhoneStyle extends Style.Sheet {

        public PhoneStyle() {
            Visual.init();
            JaneStyle.init();
            this.reset();
            this.add(FontStyle.ARIAL85, Page.Selector.CONTAINER);
            this.add(GenericStyle.BOX_SIZING_BORDER_BOX, Page.Selector.GLOBAL);
            this.add(GenericStyle.ALIGN_CENTER_JUSTIFY_CENTER, Page.Selector.GLOBAL);
            this.add(PageStyle.FLEX_COLUMN_CONTAINER);
            this.add(FrameStyle.DEFAULT_CONTAINER);
            this.add(PanelStyle.DEFAULT_CONTAINER);
            this.add(PanelStyle.DEFAULT_LABEL);
            this.add(AspectStyle.DEFAULT_CONTAINER);
            this.add(AspectStyle.DEFAULT_LABEL);
            this.add(GenericStyle.GRID_FULL_SOLID_BLACK_ON_TGREY, Aspect.Selector.CONTAINER);
            this.add(GenericStyle.TEXT_ALIGN_CENTER_PADDING_2PX, Aspect.Selector.LABEL);
            this.add(GenericStyle.BORDER_2PX, Aspect.Selector.CONTAINER);
            this.add(WidgetStyle.DEFAULT_CONTAINER);
            this.add(WidgetStyle.DEFAULT_LABEL);
            this.add(WidgetStyle.DEFAULT_INPUT);
            this.add(WidgetStyle.LABEL_OVER_INPUT);
            //this.add(WidgetStyle.LABEL_LEFT_INPUT);
        }

    }
    static public void main(String[] args) {
        PhoneApp phoneApp = new PhoneApp(new PhoneStyle());
        try {
            Files.write(Paths.get(OUTFILE), phoneApp.build().getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
