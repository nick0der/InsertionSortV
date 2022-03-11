package com.company;

import java.util.Random;
import java.util.Arrays;
import java.io.*;

public class Main {

    static void shuffle(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    static void visual(int[] array, boolean flag, int k) {

        int rows = array.length;
        int cols = Arrays.stream(array).max().getAsInt();

        String[][] data = new String[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                data[i][j] = " ";
            }
        }


        for (int i = 0; i < rows; i++){
            if ((flag) && (i == k)) {
                for (int j = cols-1; j >= cols - array[i]; j--){
                    data[i][j] = "#";
                }
            } else {
                for (int j = cols-1; j >= cols - array[i]; j--){
                    data[i][j] = "|";
                }

            }
        }

        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                System.out.print(data[j][i]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    public static void main(String[] args)
    {
        int amount = 15;
        int[] arr = new int[amount];
        for (int i = 0; i < amount; i++){
            arr[i] = i + 1;
        }

        shuffle(arr);
        for (int i = 0; i < amount; i++){
            System.out.print(arr[i] + " ");
        }
        visual(arr, false, 0);

        //Start sorting
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j>=0; j--){
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    //Visual representation
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    visual(arr, true, j);

                }
            }
        }

        visual(arr, false, 0);

        for (int i = 0; i < amount; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

    }
}
