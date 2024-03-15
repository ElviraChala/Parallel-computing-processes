package org.chala_elvira.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinService {
    private final int numberOfParts;
    private final int numberOfThread;
    private final ArrayList<Integer> numbers;


    private final int numberOfElements;

    public MinService(int numberOfParts, int numberOfThread, int numberOfElements) {
        this.numberOfParts = numberOfParts;
        this.numberOfThread = numberOfThread;
        this.numberOfElements = numberOfElements;
        numbers = new ArrayList<>();
        setNumbers();
    }

    private void setNumbers() {
        Random random = new Random();
        for (int i = 0; i < this.numberOfElements; i++) {
            this.numbers.add(random.nextInt(90));
        }
    }

    public int getNumberOfParts() {
        return numberOfParts;
    }

    public int getNumberOfThread() {
        return numberOfThread;
    }

    public List getNumbers() {
        return numbers;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public int partFindMinNumber(int startPosition, int finishPosition) {
        int localMin = numbers.get(startPosition);
        for (int currentElement = startPosition + 1; currentElement < finishPosition; currentElement++) {
            if (numbers.get(currentElement) < localMin) {
                localMin = numbers.get(currentElement);
            }
        }
        return localMin;
    }

}
