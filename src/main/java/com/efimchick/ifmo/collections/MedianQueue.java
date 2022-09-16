package com.efimchick.ifmo.collections;

import java.util.*;
import java.util.function.Consumer;

class MedianQueue extends AbstractQueue<Integer> {
/* offer - push element to the queue
poll - pull element out of the queue
peek - get element on the top of the queue (just get, no pulling out)
iterator - iterate over elements of the queue (no need to keep order)
size - just amount of current queue elements*/

    private Queue<Integer> medianQueue;



    public static void main(String[] args) {
        MedianQueue test = new MedianQueue();
        test.offer(1);
        test.offer(0);
        test.offer(2);

        System.out.println(test);
        System.out.println(test.peek());


    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }
}
