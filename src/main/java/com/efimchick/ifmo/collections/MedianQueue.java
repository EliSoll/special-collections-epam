package com.efimchick.ifmo.collections;

/* offer - push element to the queue
poll - pull element out of the queue
peek - get element on the top of the queue (just get, no pulling out)
iterator - iterate over elements of the queue (no need to keep order)
size - just amount of current queue elements*/
import java.sql.Array;
import java.util.*;
import java.util.function.Consumer;


class MedianQueue extends PriorityQueue<Integer> {

    @Override
    public Integer peek() {
        ArrayList<Integer> list = new ArrayList<>(this);
        list.sort(null);
        return list.get((list.size() - 1) / 2);
    }

    @Override
    public Integer poll() {
        Integer toRemove = peek();
        remove(toRemove);
        return toRemove;
    }
}

