package org.chala_elvira.model;

import org.chala_elvira.service.Manager;

import java.util.concurrent.TimeUnit;

public class Produser implements Runnable {
    private final int numberProducts;

    private final Manager manager;

    public Produser(int numberProducts, Manager manager) {
        this.numberProducts = numberProducts;
        this.manager = manager;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < numberProducts; i++) {
            String item = String.valueOf(i);
            try {
                manager.getBuffer().acquire();
                TimeUnit.MILLISECONDS.sleep(100);
                while (manager.isFull()) {
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                System.out.println("Put item " + item);
                manager.addItemToStorage(item);

                manager.getBuffer().release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
