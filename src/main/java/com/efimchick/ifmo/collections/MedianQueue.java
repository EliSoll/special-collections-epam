package com.efimchick.ifmo.collections;


import java.util.*;



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

