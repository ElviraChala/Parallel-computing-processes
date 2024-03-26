package org.chala_elvira.model;

import org.chala_elvira.service.Manager;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private final int numberProducts;

    private final Manager manager;

    public Consumer(int numberProducts, Manager manager) {
        this.numberProducts = numberProducts;
        this.manager = manager;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < numberProducts; i++) {
            try {
                manager.getBuffer().release();
                TimeUnit.MILLISECONDS.sleep(300);
                while (manager.isEmpty()){
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                System.out.println("Took item " + manager.getStorage().remove(0));

                manager.getBuffer().acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
