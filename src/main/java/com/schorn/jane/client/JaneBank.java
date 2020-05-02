/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client;

import java.util.Arrays;
import org.schorn.ella.ui.app.App;
import org.schorn.ella.ui.app.BankApp;
import org.schorn.ella.ui.app.ViewComponent;

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
        Arrays.asList(new ViewComponent[]{
            new JaneHeader(this),
            new JaneContent(this),
            new JaneFooter(this)})
                .stream()
                .forEachOrdered(this.screen());

    }

    static public void main(String[] args) {
        try {
            Bootstrap bootstrap = JaneBootstrap.create(args);
            JaneBank bank = JaneBank.create(bootstrap);
            JaneMonitor monitor = bank.call();
            monitor.start();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public JaneMonitor call() throws Exception {

        return new JaneMonitor(this);
    }

}
