package com.algorithmforum.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * @author rajesh.dixit
 * @since Jun 13, 2018 12:15:32 PM
 */
public class SlidingWindowMaximum {

    private static void printMax(int arr[], int k) {

        Deque<Integer> dQeue = new LinkedList<Integer>();
        int i = 0;

        /** Fill element for k size window. */
        for (i = 0; i < k; i++) {
            while (!dQeue.isEmpty() && arr[i] > arr[dQeue.peek()]) {
                dQeue.removeFirst();
            }
            dQeue.addFirst(i);
        }

        for (; i < arr.length; i++) {
            System.out.printf("%d ", arr[dQeue.peek()]);

            if (!dQeue.isEmpty() && i - k >= dQeue.peek()) {
                dQeue.removeFirst();
            }

            while (!dQeue.isEmpty() && arr[i] > arr[dQeue.peekLast()]) {
                dQeue.removeLast();
            }
            dQeue.addLast(i);
        }

        /* Maximum element of last window. */
        System.out.printf("%d ", arr[dQeue.peek()]);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        printMax(arr, k);
    }
}
