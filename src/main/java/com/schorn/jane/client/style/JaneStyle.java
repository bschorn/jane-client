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
package com.schorn.jane.client.style;

import org.schorn.ella.ui.html.CSS;
import org.schorn.ella.ui.html.CSSProperty;
import org.schorn.ella.ui.layout.Style;

/**
 *
 * @author bschorn
 */
public enum JaneStyle implements Style.Factory {
    HEADER,
    FOOTER,
    MAIN,
    MENU,
    MENU_ITEM,
    MENU_ITEM_IMG;

    @Override
    public CSS.Style style() {
        return Style.Repo.get(this);
    }

    static public void init() {
        Style.Repo.set(HEADER, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.height, "40px"))
                .append(CSS.Rule.create(CSS.Property.border, "1px solid rgba(0,0,0, 0.4)"))
                //.append(CSS.Rule.create(CSS.Property.background_image, "linear-gradient(180deg, #fff, #ddd, 40%, #ccc)"))
                .append(CSS.Rule.create(CSS.Property.background_color, "rgba(225,225,225,0.5)"))
                .append(CSS.Rule.create(CSS.Property.padding, "2px"))
        );
        Style.Repo.set(FOOTER, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.height, "40px"))
                .append(CSS.Rule.create(CSS.Property.border, "1px solid rgba(0,0,0, 0.4)"))
                //.append(CSS.Rule.create(CSS.Property.background_image, "linear-gradient(180deg, #fff, #ddd, 40%, #ccc)"))
                .append(CSS.Rule.create(CSS.Property.background_color, "white"))
                .append(CSS.Rule.create(CSS.Property.padding, "2px"))
        );
        Style.Repo.set(MAIN, CSS.Block.create()
                //.append(CSS.Selector.createClass("main"))
                .append(CSS.Rule.create(CSSProperty.flex_grow.unit(1)))
                //.append(CSS.Rule.create(CSS.Property.background_color, "white"))
                .append(CSS.Rule.create(CSS.Property.padding, "5px"))
        );
        Style.Repo.set(MENU, CSS.Block.create()
                //.append(CSS.Selector.createClass("menu"))
                .append(CSS.Rule.create(CSSProperty.display.flex))
                .append(CSS.Rule.create(CSSProperty.flex_direction.row))
                .append(CSS.Rule.create(CSSProperty.flex_wrap.wrap))
                .append(CSS.Rule.create(CSSProperty.justify_content.space_between))
                .append(CSS.Rule.create(CSSProperty.align_items.center))
        );
        Style.Repo.set(MENU_ITEM, CSS.Block.create()
                //.append(CSS.Selector.createClass("menu-item"))
                .append(CSS.Rule.create(CSS.Property.padding, "0px"))
                .append(CSS.Rule.create(CSS.Property.width, "45px"))
                .append(CSS.Rule.create(CSS.Property.height, "45px"))
        );
        Style.Repo.set(MENU_ITEM_IMG, CSS.Block.create()
                //.append(CSS.Selector.createClass("menu-item-img"))
                .append(CSS.Rule.create(CSS.Property.width, "32px"))
        );
    }
    /*
.header,
.footer {
  height: 30px;
  border: 1px solid rgba(0, 0, 0, 0.5);
  background-image: linear-gradient(180deg, #fff, #ddd 40%, #ccc);
  padding: 5px;
}

.main {
  flex-grow: 1;
  background-color: tan;
  padding: 5px;
}

ul.menu {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.menu-item {
  border: 1px solid white;
  padding: 5px;
}
.fit-picture {
    width: 16px;
}
     */

}
