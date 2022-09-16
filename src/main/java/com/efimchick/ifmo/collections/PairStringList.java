package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


class PairStringList extends ArrayList<String> {

    private final List<String> list = new ArrayList<>();

    public boolean add(String element) {
        if(!element.isEmpty()) {
            list.add(list.size(), element);
            list.add(list.size(), element);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        int i = index;
        if(!c.isEmpty()) {
            for (String value : c) {
                if (index>0 && list.get(index).equals(list.get(index - 1))){
                    list.add((i++)+1, value);
                    list.add((i++)+1, value);
                }
                else {
                    list.add(i++, value);
                    list.add(i++, value);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        if(!c.isEmpty()) {
            for (String value : c) {
                list.add(value);
                list.add(value);
            }
            return true;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        String str = list.get(index);
        list.remove(str);
        list.remove(str);
        return str;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean remove(Object o) {
      if(o != null) {
          int i = list.indexOf((String)o);
          list.remove(i);
          list.remove(i);
          return true;
      }
      return false;
       }


    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    public void add(int index, String element) {
        if (index>0 && list.get(index).equals(list.get(index - 1))){
            list.add(index+1, element);
        list.add(index + 2, element);
    }
        else {
            list.add(index, element);
            list.add(index+1, element);
        }
    }

    public String get(int index) {
        return list.get(index);
    }
    public String set(int index, String element) {
        if (index>0 && list.get(index).equals(list.get(index - 1))){
            list.set(index-1, element);
            list.set(index, element);
        }
        else {
            list.set(index, element);
            list.set(index+1, element);
        }
    return list.get(index);
    }
    @Override
    public int size() {
        return list.size();
    }
}
