package io.github.ivanb.struct;

import io.github.ivanb.Struct;

public class List<T> implements Struct {
    private Object[] arr;
    private T type;

    private List(Object[] arr, T clazz) {
        this.type = clazz;
        this.arr = arr;
    }

    public List() {

    }

    public static <T> List<T> of(T tClass) {
        return new List<>(new Object[]{}, tClass);
    }

    private void add(T elem) {
        Object[] newArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = elem;
        arr = newArr;
    }

    @Override
    public String toString() {
        String result = "";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
           sb.append(arr[i]).append(" ");
        }
        if (!sb.isEmpty()) {
            result = sb.substring(0, sb.length() -1);
            result += "]";
        }
        return result;
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private T get(int index) {
        return (T) arr[index];
    }


    @Override
    public void show() {
        List list = List.of(Integer.class);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(0);
        list.add(22);
        list.add(-5);
        System.out.println(list);

        System.out.println(list.get(0));

        List list2 = List.of(String.class);
        list2.add(1);
        list2.add("2");
        list2.add("a");
        System.out.println(list2.get(0).getClass());
        System.out.println(list2.get(1).getClass());
        System.out.println(list2);


    }
}
