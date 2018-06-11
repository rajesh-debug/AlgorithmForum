package com.algorithmforum.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a graph with n vertices.
 * Create an edge from node n_i to n_j if the element in position i should be in position j in the correct ordering.
 * You will now have a graph consisting of several non-intersecting cycles. I argue that
 * the minimum number of swaps needed to order the graph correctly is M = sum (c in cycles) size(c) - 1
 * 
 * Take a second to convince yourself of that...if two
 * items are in a cycle, one swap can just take care of them. If three items are in a cycle, you can swap a pair to put one in the right spot, and a two-cycle
 * remains, etc. If n items are in a cycle, you need n-1 swaps. (This is always true even if you don't swap with immediate neighbors.) Given that, you may now
 * be able to see why your algorithm is optimal. If you do a swap and at least one item is in the right position, then it will always reduce the value of M by
 * 1. For any cycle of length n, consider swapping an element into the correct spot, occupied by its neighbor. You now have a correctly ordered element, and a
 * cycle of length n-1. Since M is the minimum number of swaps, and your algorithm always reduces M by 1 for each swap, it must be optimal.
 * 
 * 
 * 
 * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 * 
 * @author rajesh.dixit
 * @since May 31, 2018 9:47:33 AM
 */
class MinSwapsToSortArray {

    public static int findMinSwapsToSort(int[] ar) {
        int n = ar.length;
        Map<Integer, Integer> m = new HashMap<>();
        
        // Store the element and their index into the map.
        for (int i = 0; i < n; i++) {
            m.put(ar[i], i);
        }
        
        // Sort the array
        Arrays.sort(ar);
        
        // Store index to come after sorting
        for (int i = 0; i < n; i++) {
            ar[i] = m.get(ar[i]);
        }
        
        // Garbage collect the map.
        m = null;
        
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int index = ar[i];
            if (index < 0) {
                continue;
            }
            int cycle = 1;
            while (index != i) {
                int nextIdx = ar[index];
                ar[index] = -1;
                index = nextIdx;
                cycle++;
            }
            ar[i] = -1;
            swaps = swaps + (cycle - 1);
        }
        return swaps;
    }

    // Driver program to test the above function
    public static void main(String[] args) {
        int[] a = { 5, 4, 2, 1, 3 };
        System.out.println(findMinSwapsToSort(a));
    }
}