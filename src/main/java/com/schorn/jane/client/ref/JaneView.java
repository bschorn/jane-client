/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.ref;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.ViewComponent;

/**
 *
 * @author bschorn
 */
public class JaneView implements App.View {

    private final App app;
    private final List<Component> components = new ArrayList<>();

    public JaneView(App app) {
        this.app = app;
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
    public void accept(ViewComponent screenComponent) {
        this.components.add(screenComponent);
    }

    @Override
    public App getApp() {
        return this.app;
    }

}
