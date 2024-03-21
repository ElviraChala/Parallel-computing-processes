package org.chala_elvira;

import org.chala_elvira.threads.MinService;
import org.chala_elvira.threads.MinThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_PARTS = 8;
    private static final int NUMBER_OF_ELEMENTS = 100000000;

    public static void main(String[] args) {
        MinService minService = new MinService(NUMBER_OF_ELEMENTS);

        int partSize = NUMBER_OF_ELEMENTS / NUMBER_OF_PARTS;
        int lastSize = NUMBER_OF_ELEMENTS % NUMBER_OF_PARTS;


        List<MinThread> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PARTS; i++) {
            int start = i * partSize;
            int end = (i + 1) * partSize;
            end += (i == NUMBER_OF_PARTS-1) ? lastSize : 0;

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

//        System.out.println(minService.getNumbers());
        System.out.println("Min element: " + minService.getMinElement());
        System.out.println("Index of min element: " + minService.getMinIndex());
    }
}
