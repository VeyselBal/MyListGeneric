package MyListGeneric;


import java.util.Arrays;

public class MyList<T> {

    int count = 0;
    T[] arr;

    public MyList() {
        arr = (T[]) new Object[10];
    }

    public MyList(int capacity) {
        arr = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (count <= this.arr.length) {
            arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        arr[count] = data;
        count++;
    }

    public int size() {
        int count = 0;
        for (T i : arr) {
            if (i != null)
                count++;
        }
        return count;
    }

    public Integer getCapacity() {
        return this.arr.length;
    }

    public T get(int index) {
        if (index >= arr.length || index < 0) {
            return null;
        }
        return arr[index];
    }

    public void remove(int index) {
        if (!(index >= arr.length || index < 0)) {
            for (int i = index + 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            count--;
        }
    }

    public void set(int index, T data) {
        if (!(index >= arr.length || index < 0)) {
            arr[index] = data;
        }
    }

    public String toString() {
        String name = "";
        for (T n : arr) {
            if (n != null) {
                name += n + ",";
            }
        }
        return "[" + name + "]";
    }

    public int indexOf(T data) {
        for (int i = 0; i < arr.length; i++) {
            if (data == arr[i])
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (data == arr[i])
                return i;
        }
        return -1;
    }

    boolean isEmpty() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                return false;
            }
        }
        return true;
    }

    public T[] toArray() {
        return (T[]) arr;
    }

    public void clear() {
        arr = (T[]) new Object[10];
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> list = new MyList<>(finish - start + 1);

        for (int i = start; i <= finish; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public boolean contains(T data) {
        for (int i = 0; i < arr.length; i++) {
            if (data == arr[i])
                return true;
        }
        return false;
    }
}

