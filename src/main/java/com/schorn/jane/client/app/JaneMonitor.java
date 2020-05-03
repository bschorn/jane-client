/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schorn.jane.client.app;

import com.schorn.jane.client.app.JaneBank;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.schorn.ella.ui.app.App;

/**
 *
 * @author bschorn
 */
public class JaneMonitor extends Thread implements App.Monitor {

    private final AtomicBoolean alive = new AtomicBoolean(true);
    private final JaneBank bank;

    public JaneMonitor(JaneBank bank) {
        this.bank = bank;
    }

    @Override
    public void thumper(Consumer<String> listener) throws Exception {
        Integer waitCycle = this.bank.config().getProperty(Integer.class, "wait.cycle");

        while (this.alive.get()) {
            Thread.sleep(waitCycle);
        }
    }

}
