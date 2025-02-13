package io.github.ivanb.struct;

import io.github.ivanb.Struct;

public class Array implements Struct {
    private int[] arr;

    @Override
    public void show() {
        int[] arr;          // declare
        arr = new int[3];   // allocate
        arr[0] = 1;         // initialize
        arr[1] = 2;
        arr[2] = 3;

        // declare + allocate
        int[] arr2 = new int[3];

        // allocate + initialize
        arr2 = new int[]{1, 2, 3};

        // declare + allocate + initialize
        int[] arr3 = new int[]{1, 2, 3};
        int[] arr4 = {1, 2, 3};

        // operation
        this.arr = new int[]{1, 2, 3};
        print(this.arr);
        System.out.println("get by index arr[0] = " + this.arr[0]);
        this.arr[0] = 100;
        System.out.println("set arr[0] = 100");
        System.out.println("get by index arr[0] = " + this.arr[0]);
        print(this.arr);
        int value = 22;
        int index = 3;
        System.out.println("add elem value = " + value + " to index " + index);
        this.arr = addElemToIndex(arr, index, value);
        print(this.arr);
        value = 9;
        System.out.println("add elem value = " + value);
        this.arr = addElem(this.arr, value);
        print(this.arr);
        System.out.println("pop elem twice");
        this.arr = popElem(this.arr);
        this.arr = popElem(this.arr);
        print(this.arr);
        index = 0;
        System.out.println("pop elem from index " + index);
        this.arr = popElemFromIndex(arr, index);
        print(this.arr);
    }

    private int[] addElem(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[i];
        newArr[arr.length] = value;
        return newArr;
    }

    private int[] popElem(int[] arr) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++)
            newArr[i] = arr[i];
        return newArr;
    }

    private int[] popElemFromIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length)
            throw new IllegalArgumentException("diapason of index must be [0;" + (arr.length - 1) + "]");
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (index == i) {
                for (int j = i; j < newArr.length; j++) {
                    newArr[j] = arr[j + 1];
                }
                break;
            }
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private int[] addElemToIndex(int[] arr, int index, int value) {
        if (index < 0 || index > arr.length)
            throw new IllegalArgumentException("diapason of index must be [0;" + arr.length + "]");
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (index == i) {
                newArr[i] = value;
                for (int j = i + 1; j < newArr.length; j++) {
                    newArr[j] = arr[j - 1];
                }
                break;
            }

            newArr[i] = arr[i];
        }

        return newArr;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
