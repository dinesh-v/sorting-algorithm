package com.ds.algorithm;

class BubbleSort implements Sort {
    private static void bubbleSort(int[] array) {
        bubbleSort:
        {
            for (int i = 0; i < array.length - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break bubbleSort;
                }
            }
        }
    }

    public void sort(int[] array) {
        bubbleSort(array);
    }
}