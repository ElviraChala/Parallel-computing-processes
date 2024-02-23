package org.chala_elvira.threads;

import java.util.concurrent.TimeUnit;

public class BreakThread extends Thread {
    private volatile boolean isBreak = false;
    private final int allowedTimeSeconds;

    public BreakThread(int allowedTimeSeconds) {
        this.allowedTimeSeconds = allowedTimeSeconds;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(allowedTimeSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isBreak = true;
    }

    public boolean getIsBreak() {
        return isBreak;
    }
}
