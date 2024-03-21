package org.chala_elvira.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinService {
    private final ArrayList<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    private int minElement;
    private int minIndex;

    public MinService(int numberOfElements) {
        generateNumbers(numberOfElements);
        this.minElement = numbers.getFirst();
    }

    public synchronized int getMinElement() {
        return minElement;
    }

    public synchronized void setMinElement(int minElement) {
        this.minElement = minElement;
    }

    public synchronized int getMinIndex() {
        return minIndex;
    }

    public synchronized void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    private void generateNumbers(int numberOfElements) {
        for (int currentElement = 0; currentElement < numberOfElements-1; currentElement++) {
            this.numbers.add(this.random.nextInt(90));
        }
        this.numbers.add(-99);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private synchronized void updateGlobalMin(int localMin, int localMinIndex) {
        if (localMin < this.minElement) {
            setMinElement(localMin);
            setMinIndex(localMinIndex);
        }
    }

    public void findMinNumber(int startPosition, int endPosition) {
        int minIndexLocal = startPosition;
        int minLocal = numbers.get(startPosition);
        for (int currentElement = startPosition + 1; currentElement < endPosition; currentElement++) {
            if (numbers.get(currentElement) < minLocal) {
                minLocal = numbers.get(currentElement);
                minIndexLocal = currentElement;
            }
        }
        updateGlobalMin(minLocal, minIndexLocal);
    }
}
