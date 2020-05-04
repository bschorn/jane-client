/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view;

import com.schorn.jane.client.view.scene.Account;
import com.schorn.jane.client.view.scene.Accounts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.App.AppViewer.Scene;
import org.schorn.ella.ui.app.ViewerStage;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Identifier;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneContent extends ViewerStage {

    private final Frame frame;
    private final List<Scene> scenes = new ArrayList<>();

    public JaneContent(AppConfig appConfig) throws Exception {
        super(appConfig.getItemPropertyValue(String.class, JaneContent.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, JaneContent.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, JaneContent.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, JaneContent.class, Item.Properties.VISIBLE)
        );
        this.frame = Frame.create(Identifier.NONE, Frame.Intent.CONTENT);
        this.scenes.add(new Accounts(appConfig));
        this.scenes.add(new Account(appConfig));
        this.scenes.stream().forEachOrdered(s -> {
            s.windows().stream().forEachOrdered(w -> this.frame.accept(w));
        });
    }

    @Override
    public List<Scene> scenes() {
        return Collections.unmodifiableList(this.scenes);
    }

    @Override
    public Scene scene(String id) {
        return this.scenes.stream()
                .filter(s -> s.id().equalsIgnoreCase(id))
                .findAny()
                .get();
    }

    @Override
    public Frame frame() {
        return this.frame;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private JaneContent() {
        super("jane-content", "content", "Content", Boolean.TRUE);
        this.frame = null;
    }

    static public void main(String[] args) {
        try {
            JaneContent item = new JaneContent();
            System.out.println(item.dumpProperties());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
