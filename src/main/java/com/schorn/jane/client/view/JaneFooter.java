/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view;

import java.net.URL;
import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.ViewerComponent;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Identifier;
import org.schorn.ella.ui.layout.Item;
import org.schorn.ella.ui.layout.Pane;
import org.schorn.ella.ui.layout.Window;
import org.schorn.ella.ui.widget.ControlWidgets;

/**
 *
 * @author bschorn
 */
public class JaneFooter extends ViewerComponent {

    private final Frame frame;
    private final Window window;
    private final Pane pane;
    
    public JaneFooter(AppConfig appConfig) throws Exception {
        super(appConfig.getItemPropertyValue(String.class, JaneFooter.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, JaneFooter.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, JaneFooter.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, JaneFooter.class, Item.Properties.VISIBLE)
        );
        this.frame = Frame.create(Identifier.NONE, Frame.Intent.FOOTER);
        this.window = Window.create(Identifier.create(this.name()), this.label());
        this.pane = Pane.create(Identifier.create(this.name()), this.label());

        URL urlHomeImage = new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/home.svg");
        URL urlHelpImage = new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/help.svg");
        URL urlProfileImage = new URL("file:///D:/Users/bschorn/documents/GitHub/inter-ui/src/main/resources/images/profile.svg");
        URL urlHome = new URL("http://www.google.com");
        URL urlHelp = new URL("http://www.google.com");
        URL urlProfile = new URL("http://www.google.com");

        ControlWidgets.Menu mMain = ControlWidgets.Menu.create(Identifier.create("main"));
        mMain.addItem(ControlWidgets.MenuItem.create(Identifier.create("home"), null).setAnchor(urlHome).setImage(urlHomeImage));
        mMain.addItem(ControlWidgets.MenuItem.create(Identifier.create("help"), null).setAnchor(urlHelp).setImage(urlHelpImage));
        mMain.addItem(ControlWidgets.MenuItem.create(Identifier.create("profile"), null).setAnchor(urlProfile).setImage(urlProfileImage));
        this.pane.accept(mMain);
        this.frame.accept(this.window);
        this.window.accept(this.pane);
    }

    @Override
    public Frame frame() {
        return this.frame;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    private JaneFooter() {
        super("jane-footer", "footer", "Footer", Boolean.TRUE);
        this.frame = null;
        this.window = null;
        this.pane = null;
    }

    static public void main(String[] args) {
        JaneFooter item = new JaneFooter();
        System.out.println(item.dumpProperties());
    }

}
