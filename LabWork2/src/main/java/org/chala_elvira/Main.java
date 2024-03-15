package org.chala_elvira;

import org.chala_elvira.threads.MinService;
import org.chala_elvira.threads.MinThead;

public class Main {
    public static void main(String[] args) {
        MinService minService = new MinService(2, 2, 10);
        MinThead minThead = new MinThead(0, 10, minService);

        System.out.println(minService.getNumbers());
        minThead.run();
    }
}
