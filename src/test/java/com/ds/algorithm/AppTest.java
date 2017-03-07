package com.ds.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AppTest {
    private final static int SIZE = 7;
    private final static int MAX = 20;
    private int[] numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
        /*System.out.println("Before sorting : " + Arrays.toString(numbers));*/
    }

    @After
    public void tearDown() throws Exception {
        /*System.out.println("After sorting : " + Arrays.toString(numbers));*/
    }

    @Test
    public void testBubbleSort() {
        new BubbleSort().sort(numbers);
        isSorted();
    }

    @Test
    public void testInsertionSort() {
        new InsertionSort().sort(numbers);
        isSorted();
    }

    @Test
    public void testMergeSort() {
        new MergeSort().sort(numbers);
        isSorted();
    }

    @Test
    public void testQuickSort() {
        new QuickSort().sort(numbers);
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
        Arrays.sort(numbers);
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