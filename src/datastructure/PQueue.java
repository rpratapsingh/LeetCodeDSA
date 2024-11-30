package datastructure;

import java.util.*;

public class PQueue<T extends Comparable<T>> {
    private int heapSize;
    private int heapCapacity;
    private List<T> heap = null;

    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PQueue() {
        this(1);
    }

    public PQueue(int size) {
        heap = new ArrayList<>(size);
    }

    public PQueue(T[] elements) {
        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<>(heapCapacity);
        for (int i = 0; i < heapSize; i++) {
            mapAdd(elements[i], i);
            heap.add(elements[i]);
        }
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i++) {
            sink(i);
        }
    }

    public PQueue(Collection<T> elements) {
        this(elements.size());
        for (T element : elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    public int size() {
        return heapSize;
    }

    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    public T pool() {
        if (isEmpty()) return null;
        return removeAt(0);
    }

    public boolean contains(T element) {
        if (element == null) return false;
        return map.containsKey(element);
    }

    public void add(T element) {
        if (element == null) throw new IllegalArgumentException();
        if (heapSize < heapCapacity) {
            heap.set(heapSize, element);
        } else {
            heap.add(element);
            heapCapacity++;
        }
        mapAdd(element, heapSize);
        swim(heapSize);
        heapSize++;
    }

    private boolean less(int i, int j) {
        T nodeOne = heap.get(i);
        T nodeTwo = heap.get(j);
        return nodeOne.compareTo(nodeTwo) <= 0;
    }

    private void swim(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && less(index, parent)) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void sink(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = left;
            if (right < heapSize && less(right, left)) {
                smallest = right;
            }
            if (left >= heapSize || less(index, smallest)) {
                break;
            }
            swap(smallest, index);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T iElement = heap.get(i);
        T jElement = heap.get(j);
        heap.set(i, jElement);
        heap.set(j, iElement);
        mapSwap(iElement, jElement, i, j);
    }


    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        Integer index = mapGet(element);
        if (index != null) {
            removeAt(index);
        }
        return index != null;
    }


    private T removeAt(int i) {
        if (isEmpty()) {
            return null;
        }
        heapSize--;
        T removedData = heap.get(i);
        swap(i, heapSize);

        heap.set(heapSize, null);
        mapRemove(removedData, heapSize);

        if (i == heapSize) {
            return removedData;
        }
        T element = heap.get(i);
        sink(i);
        if (heap.get(i).equals(element)) {
            swim(i);
        }
        return removedData;
    }

    public boolean isMinHeap(int index) {
        if (index >= heapSize) {
            return true;
        }

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < heapSize && !less(index, left)) {
            return false;
        }
        if (right < heapSize && !less(index, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }

    private void mapAdd(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
        } else {
            set.add(index);
        }
    }

    private void mapRemove(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        set.remove(index);
        if (set.size() == 0) {
            map.remove(value);
        }
    }

    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        if (set != null) {
            set.last();
        }
        return null;
    }

    private void mapSwap(T valueOne, T valueTwo, int indexOne, int indexTwo) {
        Set<Integer> setOne = map.get(valueOne);
        Set<Integer> setTwo = map.get(valueTwo);

        setOne.remove(indexOne);
        setTwo.remove(indexTwo);

        setOne.add(indexTwo);
        setOne.add(indexOne);
    }

    @Override
    public String toString() {
        return heap.toString();
    }


}
