package com.efimchick.ifmo.collections;

/* offer - push element to the queue
poll - pull element out of the queue
peek - get element on the top of the queue (just get, no pulling out)
iterator - iterate over elements of the queue (no need to keep order)
size - just amount of current queue elements*/
import java.util.*;


class MedianQueue extends AbstractQueue<Integer> {


    private Queue<Integer> medianQueue = new LinkedList<>();
    private List<Integer> medianQueueSorted = new ArrayList<>();

    @Override
    public Integer poll() {
        this.sortOrder();
        return medianQueue.poll();
    }

    @Override
    public Integer peek() {
        this.sortOrder();
        return medianQueue.peek();
    }

    public void sortOrder() {

        Collections.sort((List) medianQueue);
        int arr[] = new int[medianQueue.size()];
        int i = 0;
        for (Integer num : medianQueue) {
            arr[i] = num;
            i++;
        }
        int n = arr.length;
        Integer result = Median.findMedian(arr, n);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(result);
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.addAll(medianQueue);
        list.addAll(q);
        for (Integer num : list) {
            medianQueue.add(num);
        }
    }
    @Override
    public boolean remove(Object o) {
         medianQueue.remove(o);
         return true;
    }

    @Override
    public Iterator<Integer> iterator() {

        return medianQueue.iterator();
    }

    @Override
    public int size() {
        return medianQueue.size();
    }

    @Override
    public boolean offer(Integer integer) {
        return medianQueue.offer(integer);
    }

    @Override
    public void clear() {
        medianQueue.clear();
    }

    @Override
    public String toString() {

        return medianQueue.toString();
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return medianQueue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return medianQueue.removeAll(c);
    }



    public static void main(String[] args) {
        MedianQueue test = new MedianQueue();
        test.offer(1);
        test.offer(0);
        test.offer(2);
        test.offer(5);
        test.offer(0);
        test.offer(5);


        System.out.println(test);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test);
        System.out.println(test.size());


    }
}
class Median
{
    static int a, b;

    static int[] swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    static int Partition(int[] arr, int l, int r)
    {
        int lst = arr[r], i = l, j = l;
        while (j < r)
        {
            if (arr[j] < lst)
            {
                arr = swap(arr, i, j);
                i++;
            }
            j++;
        }
        arr = swap(arr, i, r);
        return i;
    }


    static int randomPartition(int[] arr, int l, int r)
    {
        int n = r - l + 1;
        int pivot = (int) (Math.random() % n);
        arr = swap(arr, l + pivot, r);
        return Partition(arr, l, r);
    }

    static int MedianUtil(int[] arr, int l, int r, int k)
    {
        if (l <= r)
        {


            int partitionIndex = randomPartition(arr, l, r);

            if (partitionIndex == k)
            {
                b = arr[partitionIndex];
                if (a != -1)
                    return Integer.MIN_VALUE;
            }

            else if (partitionIndex == k - 1)
            {
                a = arr[partitionIndex];
                if (b != -1)
                    return Integer.MIN_VALUE;
            }

            if (partitionIndex >= k)
                return MedianUtil(arr, l, partitionIndex - 1, k);

            else
                return MedianUtil(arr, partitionIndex + 1, r, k);
        }

        return Integer.MIN_VALUE;
    }

    static int findMedian(int[] arr, int n)
    {
        int ans;
        a = -1;
        b = -1;

        if (n % 2 == 1)
        {
            MedianUtil(arr, 0, n - 1, n / 2);
            ans = b;
        }


        else
        {
            MedianUtil(arr, 0, n - 1, n / 2);
            ans = (a + b) / 2;
        }
return ans;
    }

    public static void main(String[] args)
    {
        int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
        int n = arr.length;
        findMedian(arr, n);
    }
}
