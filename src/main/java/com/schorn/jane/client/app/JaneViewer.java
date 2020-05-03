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
import org.schorn.ella.ui.EllamentProvider;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.layout.Page;

/**
 *
 * @author bschorn
 */
public class JaneViewer implements App.AppViewer {

    private final App app;
    private final List<App.AppViewer.Component> components = new ArrayList<>();
    private final Page page;
    private final String stageId;

    public JaneViewer(App app) {
        this.app = app;
        this.components.add(new JaneHeader(app.config()));
        JaneContent content = new JaneContent(app.config());
        this.stageId = content.id();
        this.components.add(content);
        this.components.add(new JaneFooter(app.config()));
        this.page = EllamentProvider.provider().createPage();
    }

    @Override
    public Component component(String id) {
        return this.component(Component.class, id);
    }

    @Override
    public <T extends Component> T component(Class<T> classT, String id) {
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
    public List<Component> components() {
        return Collections.unmodifiableList(this.components);
    }

    @Override
    public App getApp() {
        return this.app;
    }

    /*
    public String display() {
        return this.page.produce();
    }
     */
    @Override
    public Stage stage() {
        return this.component(Stage.class, this.stageId);
    }

    @Override
    public Page page() {
        return this.page;
    }
}
