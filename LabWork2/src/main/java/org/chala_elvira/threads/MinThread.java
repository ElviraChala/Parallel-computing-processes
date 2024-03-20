package org.chala_elvira.threads;

public class MinThread extends Thread {
    private final MinService minService;
    private final int startPosition;
    private final int endPosition;

    public MinThread(int startPosition, int endPosition, MinService minService) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.minService = minService;
    }
    
    @Override
    public void run() {
        minService.findMinNumber(this.startPosition, this.endPosition);
    }
}
