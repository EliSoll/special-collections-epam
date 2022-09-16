package com.efimchick.ifmo.collections;

import java.util.*;


class SortedByAbsoluteValueIntegerSet extends LinkedHashSet<Integer> {


    private Set<Integer> set = new LinkedHashSet<>();;
    private List<Integer> list = new ArrayList<>();;


    public Set<Integer> sort() {

        list.addAll(set);
        list.sort((Integer o1, Integer o2) -> {
            if(Math.abs(o1)>Math.abs(o2))
                return 1;

            else if (Math.abs(o1)<Math.abs(o2))
                return -1;

            else return 0;
        });
        set = new LinkedHashSet<>();
        set.addAll(list);
        return set;
    }
    @Override
    public boolean add(Integer integer) {
        if(integer != null) {
            set.add(integer);
            this.sort();
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        if(!c.isEmpty()) {
            set.addAll(c);
            this.sort();
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(o != null) {
            set.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {

        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }

}
