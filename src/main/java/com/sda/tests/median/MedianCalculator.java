package com.sda.tests.median;

import java.util.Arrays;

public class MedianCalculator {

    static int getMedian(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        Arrays.sort(array);

        if (array.length % 2 == 0) {

            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2;

        } else {
            return array[array.length / 2];
        }
    }

}
