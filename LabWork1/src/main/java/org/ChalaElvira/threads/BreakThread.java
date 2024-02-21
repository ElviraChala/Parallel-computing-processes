package org.ChalaElvira.threads;

import java.util.concurrent.TimeUnit;

public class BreakThread extends Thread {
    private boolean isBreak = false;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isBreak = true;
    }

    public boolean getIsBreak() {
        return isBreak;
    }
}
