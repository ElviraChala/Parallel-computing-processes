package org.chala_elvira.threads;

public class MainThread extends Thread {
    private final BreakThread breakThread;
    private final int sequenceStep;
    private long sequenceSum;
    private long elementsCount;
    private final long id;


    public MainThread(BreakThread breakThread, int sequenceStep, long id) {
        this.breakThread = breakThread;
        this.sequenceStep = sequenceStep;
        this.id = id;
        this.sequenceSum = 0;
        this.elementsCount = 0;
    }

    public long getSequenceSum() {
        return sequenceSum;
    }

    public long getElementsCount() {
        return elementsCount;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void run() {
        while (!breakThread.getIsBreak()) {
            sequenceSum += sequenceStep;
            elementsCount++;
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Thread " + id +
                ": Sum = " + sequenceSum +
                ", Elements count = " + elementsCount;
    }
}
