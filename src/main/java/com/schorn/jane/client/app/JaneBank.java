/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.app;

import com.schorn.jane.client.view.JaneBootstrap;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.BankApp;

/**
 *
 * @author bschorn
 */
public class JaneBank extends BankApp<JaneMonitor> {

    static public JaneBank create(App.Bootstrap bootstrap) throws Exception {
        return new JaneBank(bootstrap);
    }

    private JaneBank(Bootstrap bootstrap) throws Exception {
        super(bootstrap);
    }

    static public void main(String[] args) {
        try {
            Bootstrap bootstrap = JaneBootstrap.create(args);
            JaneBank bank = JaneBank.create(bootstrap);
            JaneMonitor monitor = bank.call();
            monitor.start();
            String output = bank.config().getProperty(String.class, "output.file");
            if (output != null) {
                String pageView = bank.viewer().page().produce(bank.styler().getPageStyle());
                Files.write(Paths.get(output), pageView.getBytes());
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public JaneMonitor call() throws Exception {

        return new JaneMonitor(this);
    }

    @Override
    public String name() {
        return this.config().getProperty(String.class, String.format("%s.name", this.getClass().getSimpleName()));
    }

}
