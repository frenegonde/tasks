package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        //проверяем, что список не содержит null
        if (inputNumbers.contains(null)) {
            throw new CannotBuildPyramidException();
        }
        //проверяем, что есть достаточное кол-во памяти для работы с этим списком
        try {
            inputNumbers.sort(null);
        } catch (Throwable e) {
            throw new CannotBuildPyramidException();
        }

        //рассчитываем показатели матрицы
        //получаем кол-во строк
        int rowCount = getHeight(inputNumbers.size());
        //получаем кол-во столбцов в строке
        int colCount = getWidth(rowCount);
        int[][] pyramid = new int[rowCount][colCount];
        //заполняем пирамиду
        for (int i = 0, elementIndex = 0; i < pyramid.length; i++) {
            //вычисляем позицию элемента
            int position = rowCount - i - 1;
            //проставляем элементы для каждого уровня
            for (int j = 0; j <= i; j++) {
                pyramid[i][position] = inputNumbers.get(elementIndex);
                elementIndex++;
                position += 2;
            }
        }

        return pyramid;

    }

    public static int getWidth(int height) {
        return height * 2 - 1;
    }

    public static int getHeight(int elementCount) {
        int level = 1;
        while (elementCount > 0) {
            elementCount -= level;
            if (elementCount < 0) {
                throw new CannotBuildPyramidException();
            } else {
                level++;
            }
        }
        return level - 1;
    }


}
