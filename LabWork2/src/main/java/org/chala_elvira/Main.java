package org.chala_elvira;

import org.chala_elvira.threads.MinService;
import org.chala_elvira.threads.MinThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_PARTS = 5;
    private static final int NUMBER_OF_ELEMENTS = 10;

    public static void main(String[] args) {
        MinService minService = new MinService(NUMBER_OF_ELEMENTS);

        int partSize = NUMBER_OF_ELEMENTS / NUMBER_OF_PARTS;

        List<MinThread> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PARTS; i++) {
            int start = i * partSize;
            int end = Math.min((i + 1) * partSize, NUMBER_OF_ELEMENTS);
            MinThread thread = new MinThread(start, end, minService);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        });

        System.out.println(minService.getNumbers());
        System.out.println("Min element: " + minService.getMinElement());
        System.out.println("Index of min element: " + minService.getMinIndex());
    }
}
