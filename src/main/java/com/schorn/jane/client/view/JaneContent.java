/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schorn.ella.ui.app.App.AppConfig;
import org.schorn.ella.ui.app.App.AppViewer.Scene;
import org.schorn.ella.ui.app.ViewerStage;
import org.schorn.ella.ui.html.HTML;
import org.schorn.ella.ui.layout.Item;

/**
 *
 * @author bschorn
 */
public class JaneContent extends ViewerStage {

    private final List<Scene> scenes = new ArrayList<>();

    public JaneContent(AppConfig appConfig) {
        super(appConfig.getItemPropertyValue(String.class, JaneContent.class, Item.Properties.ID),
                appConfig.getItemPropertyValue(String.class, JaneContent.class, Item.Properties.NAME),
                appConfig.getItemPropertyValue(String.class, JaneContent.class, Item.Properties.LABEL),
                appConfig.getItemPropertyValue(Boolean.class, JaneContent.class, Item.Properties.VISIBLE)
        );
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
    protected void build0(HTML.Element element) throws Exception {

    }

    private JaneContent() {
        super("jane-content", "content", "Content", Boolean.TRUE);
    }

    static public void main(String[] args) {
        JaneContent item = new JaneContent();
        System.out.println(item.dumpProperties());
    }

}
