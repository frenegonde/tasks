package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        //проверяем, что списки не равны null
        if (x == null || y == null) {
            throw new IllegalArgumentException();
        }
        int nextIndex = 0; //текущий индекс из списка y
        int prevIndex; //прыдущий индекс из списка y

        for (int i = 0; i < x.size(); i++) {
            //если y не содержит элемент из x, то возвраем false
            if (!y.contains(x.get(i))) {
                return false;
            }
            //запоминаем предыдущий индекс из y
            prevIndex = nextIndex;
            nextIndex = y.indexOf(x.get(i)); //получаем следующий индекс из y
            //если следующий индекс оказался меньше предыдущего, значит числа из x хранятся в y в другом порядке
            //возвращем false
            if (nextIndex < prevIndex) {
                return false;
            }
        }
        //если не встретили противоречий, возвращаем true
        return true;
    }
}
