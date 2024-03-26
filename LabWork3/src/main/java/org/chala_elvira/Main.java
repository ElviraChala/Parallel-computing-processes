package org.chala_elvira;

import org.chala_elvira.model.Consumer;
import org.chala_elvira.model.Produser;
import org.chala_elvira.service.Manager;

public class Main {
    public static void main(String[] args) {
        final int BUFFER = 300;
        final int NUMBER_OF_PRODUCTS = 10000;
        Manager manager = new Manager(BUFFER);

        new Consumer(NUMBER_OF_PRODUCTS, manager);
        new Produser(NUMBER_OF_PRODUCTS, manager);
    }
}
