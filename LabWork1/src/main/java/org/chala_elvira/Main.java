package org.chala_elvira;

import org.chala_elvira.threads.BreakThread;
import org.chala_elvira.threads.MainThread;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int SEQUENCE_STEP = 2;
    private static final int  ALLOWED_TIME_SECONDS = 2;

    public static void main(String[] args) {
        BreakThread breakThread = new BreakThread(ALLOWED_TIME_SECONDS);
        for (int countthreads = 0; countthreads < NUM_THREADS; countthreads++) {
            new MainThread(breakThread, SEQUENCE_STEP, countthreads).start();
        }
        new Thread(breakThread).start();
    }
}
