package com.algorithmforum.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
           Queue<Integer> qi = new LinkedList<>();
           qi.add(50);
           qi.add(100);
           qi.add(25);

           Integer x = qi.peek();
           System.out.println(x);

           x = qi.peek();
           System.out.println(x);
           System.out.println(qi);
    }
}