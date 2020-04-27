/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.style;

import org.schorn.ella.ui.html.CSS;
import org.schorn.ella.ui.layout.Style;

/**
 *
 * @author bschorn
 */
public enum AccountsStyle implements Style.Factory {
    ACCOUNTS,
    ACCOUNT_BUTTON,
    ACCOUNT_BUTTON_HOVER,
    ACCOUNT_BUTTON_ACTIVE,
    ACCOUNT_DESCRIPTION,
    ACCOUNT_VALUE,
    ACCOUNT_VALUE_SPAN_SUBSCRIPT,
    ACCOUNT_VALUE_LABEL;

    @Override
    public CSS.Style style() {
        return Style.Repo.get(this);
    }

    static public void init() {
        Style.Repo.set(ACCOUNTS, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.margin, "0px"))
        );
        Style.Repo.set(ACCOUNT_BUTTON, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.margin, "5px"))
                .append(CSS.Rule.create(CSS.Property.padding, "5px"))
                .append(CSS.Rule.create(CSS.Property.box_shadow, "inset 0px 1px 0px 0px #54a3f7"))
                .append(CSS.Rule.create(CSS.Property.background, "-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #007dc1), color-stop(1, #0061a7) )"))
                //.append(CSS.Rule.create(CSS.Property.background, "-moz-linear-gradient( center top, #007dc1 5%, #0061a7 100% )"))
                .append(CSS.Rule.create(CSS.Property.filter, "progid: DXImageTransform.Microsoft.gradient(startColorstr='#007dc1', endColorstr='#0061a7')"))
                .append(CSS.Rule.create(CSS.Property.background_color, "1px"))
                .append(CSS.Rule.create(CSS.Property.border_top_left_radius, "1px"))
                .append(CSS.Rule.create(CSS.Property.border_top_right_radius, "1px"))
                .append(CSS.Rule.create(CSS.Property.border_bottom_right_radius, "1px"))
                .append(CSS.Rule.create(CSS.Property.border_bottom_left_radius, "1px"))
                .append(CSS.Rule.create(CSS.Property.text_indent, "0"))
                .append(CSS.Rule.create(CSS.Property.border, "1px solid #124d77"))
                .append(CSS.Rule.create(CSS.Property.color, "#ffffff"))
                .append(CSS.Rule.create(CSS.Property.text_decoration, "none"))
                .append(CSS.Rule.create(CSS.Property.text_align, "left"))
                .append(CSS.Rule.create(CSS.Property.text_shadow, "0px 1px 0px #154682"))
        );
        Style.Repo.set(ACCOUNT_BUTTON_HOVER, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.background, "-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0061a7), color-stop(1, #007dc1) )"))
                //.append(CSS.Rule.create(CSS.Property.background, "-moz-linear-gradient( center top, #0061a7 5%, #007dc1 100% )"))
                .append(CSS.Rule.create(CSS.Property.filter, "progid: DXImageTransform.Microsoft.gradient(startColorstr='#0061a7', endColorstr='#007dc1')"))
                .append(CSS.Rule.create(CSS.Property.background_color, "#0061a7"))
        );
        Style.Repo.set(ACCOUNT_BUTTON_ACTIVE, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.position, "relative"))
                .append(CSS.Rule.create(CSS.Property.top, "1px"))
        );
        Style.Repo.set(ACCOUNT_DESCRIPTION, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.font_size, "0.95em"))
                .append(CSS.Rule.create(CSS.Property.padding, "3px"))
        );
        Style.Repo.set(ACCOUNT_VALUE, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.font_size, "1.55em"))
                .append(CSS.Rule.create(CSS.Property.padding, "3px"))
        );
        Style.Repo.set(ACCOUNT_VALUE_SPAN_SUBSCRIPT, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.font_size, "0.6em"))
                .append(CSS.Rule.create(CSS.Property.vertical_align, "top"))
        );
        Style.Repo.set(ACCOUNT_VALUE_LABEL, CSS.Block.create()
                .append(CSS.Rule.create(CSS.Property.font_size, "0.7em"))
        );
    }

}
