package com.ds.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AppTest {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();
        System.out.println("Before sorting : " + Arrays.toString(numbers));
        new MergeSort().sort(numbers);
        System.out.println("After sorting : " + Arrays.toString(numbers));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("MergeSort time elapsed : " + elapsedTime);
        isSorted();
    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();
        System.out.println("Before sorting : " + Arrays.toString(numbers));
        new QuickSort().sort(numbers);
        System.out.println("After sorting : " + Arrays.toString(numbers));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quick sort time elapsed : " + elapsedTime);
        isSorted();
    }

    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            new MergeSort().sort(numbers);
            isSorted();
        }
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        isSorted();
    }

    private void isSorted() {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }
}