package com.ds.algorithm;

class MergeSort implements SortingAlgorithm {
    public void sort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, middle, rightEnd);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int middle, int rightEnd) {
        int left = leftStart;
        int right = middle + 1;
        int index = leftStart;
        while (left <= middle && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, middle - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }
}