package org.chala_elvira.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinService {
    private final int numberOfParts;
    private final int numberOfThread;
    private final ArrayList numbers;

    public MinService(int numberOfParts, int numberOfThread) {
        this.numberOfParts = numberOfParts;
        this.numberOfThread = numberOfThread;
        numbers = new ArrayList<>();
        setNumbers(numbers);
    }

    private void setNumbers(ArrayList numbers) {
        Random random = new Random(156);
        for (int i = 0; i < numbers.size(); i++) {
            this.numbers.add(random.nextInt());
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

    private int partFindMinNumber(int startPosition, int finishPosition) {
        int localMin = startPosition;
        for (int currentElement = startPosition + 1; currentElement < finishPosition; currentElement++) {
            if (currentElement > localMin) {
                localMin = currentElement;
            }
        }
        return localMin;
    }

}
