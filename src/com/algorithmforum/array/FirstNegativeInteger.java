package com.algorithmforum.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * 
 * @author rajesh.dixit
 * @since Jun 13, 2018 12:15:32 PM
 */
public class FirstNegativeInteger {

    private static void printFirstNegativeIntegerInSlidingWindows(int arr[], int k) {

        Deque<Integer> dQeue = new LinkedList<Integer>();

        int i = 0;

        /** Fill the queue with negative element till k size window. */
        for (i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dQeue.addFirst(i);
            }
        }

        for (; i < arr.length; i++) {
            int windElement = 0;
            if (!dQeue.isEmpty()) {
                windElement = arr[dQeue.peekFirst()];
            }
            System.out.printf("%d ", windElement);


            if (!dQeue.isEmpty() && i - k >= dQeue.peek()) {
                dQeue.removeFirst();
            }

            if (arr[i] < 0) {
                dQeue.addLast(i);
            }

        }

        /* First Negative element of last window. */
        System.out.printf("%d ", arr[dQeue.peek()]);
    }

    /**
     * Driver method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = { -8, 2, 3, -6, 10, 20, 30, -6 };
        int k = 3;
        printFirstNegativeIntegerInSlidingWindows(arr, k);
    }
}
