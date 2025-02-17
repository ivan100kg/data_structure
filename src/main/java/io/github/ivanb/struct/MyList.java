package io.github.ivanb.struct;

import io.github.ivanb.Struct;

public class MyList<T> implements Struct {
    private Object[] arr;
    private T type;

    private MyList(Object[] arr, T clazz) {
        this.type = clazz;
        this.arr = arr;
    }

    public MyList() {

    }

    public static <T> MyList<T> of(T tClass) {
        return new MyList<>(new Object[]{}, tClass);
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
        MyList myList = MyList.of(Integer.class);
        myList.add(12);
        myList.add(13);
        myList.add(14);
        myList.add(0);
        myList.add(22);
        myList.add(-5);
        System.out.println(myList);

        System.out.println(myList.get(0));

        MyList myList2 = MyList.of(String.class);
        myList2.add(1);
        myList2.add("2");
        myList2.add("a");
        System.out.println(myList2.get(0).getClass());
        System.out.println(myList2.get(1).getClass());
        System.out.println(myList2);


    }
}
