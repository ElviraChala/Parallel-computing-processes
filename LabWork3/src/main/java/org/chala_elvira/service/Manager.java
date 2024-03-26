package org.chala_elvira.service;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Manager {
    private final int numberProducts;

    private Semaphore buffer;

    private ArrayList<String> storage;

    public Manager(int numberProducts) {
        this.numberProducts = numberProducts;
        this.buffer = new Semaphore(numberProducts);
        this.storage = new ArrayList<>();
    }

    public synchronized Semaphore getBuffer() {
        return buffer;
    }

    public synchronized ArrayList<String> getStorage() {
        System.out.println(this.storage);
        return this.storage;
    }

    public synchronized void setStorage(ArrayList<String> storage) {
        this.storage = storage;
    }

    public synchronized void addItemToStorage(String item) {
        this.storage.add(item);
        System.out.println(this.storage);
    }

    public boolean isFull() {
        return storage.size() == numberProducts;
    }

    public boolean isEmpty(){
        return storage.isEmpty();
    }
}
