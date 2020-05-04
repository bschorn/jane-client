/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.app;

import com.schorn.jane.client.view.JaneContent;
import com.schorn.jane.client.view.JaneFooter;
import com.schorn.jane.client.view.JaneHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.schorn.ella.ui.EllamentProvider;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.layout.Frame;
import org.schorn.ella.ui.layout.Item;
import org.schorn.ella.ui.layout.Page;

/**
 *
 * @author bschorn
 */
public class JaneViewer implements App.AppViewer, Consumer<Frame> {

    private final App app;
    private final List<App.AppViewer.Component> components = new ArrayList<>();
    private final Page page;
    private final String stageId;

    public JaneViewer(App app) throws Exception {
        this.app = app;
        this.components.add(new JaneHeader(app.config()));
        this.components.add(new JaneContent(app.config()));
        this.components.add(new JaneFooter(app.config()));
        this.stageId = app.config().getProperty(String.class, String.format("%s.stageId", this.getClass().getSimpleName()));
        this.page = EllamentProvider.provider().createPage();
        this.page.setTitle(this.app.name());
        this.page.setViewport("device-width", "1");

        this.components.stream().map(t -> t.frame()).forEachOrdered(this);
    }

    @Override
    public <T extends Item> T component(Class<T> classT, String id) {
        Optional<T> optComponent = this.components.stream()
                .filter(c -> c.id().equalsIgnoreCase(id))
                .filter(c -> classT.isInstance(c))
                .map(c -> classT.cast(c))
                .findAny();
        if (optComponent.isPresent()) {
            return (T) optComponent.get();
        }
        return (T) null;
    }

    @Override
    final public List<Item> items() {
        return Collections.unmodifiableList(this.components);
    }

    @Override
    public App getApp() {
        return this.app;
    }

    @Override
    public Stage stage() {
        return this.component(Stage.class, this.stageId);
    }

    @Override
    public Page page() {
        return this.page;
    }

    @Override
    public void accept(Frame frame) {
        this.page.accept(frame);
    }
}
