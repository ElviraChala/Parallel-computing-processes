package org.chala_elvira.threads;

public class MinThead extends Thread{
    private int startPosition;
    private int finishPosition;
    private MinService minService;


    public MinThead(int startPosition, int finishPosition, MinService minService){
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;
        this.minService = minService;
    }

    @Override
    public void run(){
        int min = minService.partFindMinNumber(startPosition, finishPosition);
        System.out.println(min);
    }
}
