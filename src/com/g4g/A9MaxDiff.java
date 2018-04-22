package com.g4g;

public class A9MaxDiff {
    void runProgram() {
        int arr[] = {5, 10, 2, 16, 1, 49, 8};
        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < minSoFar) minSoFar = arr[i];
            else if(arr[i] - minSoFar > maxDiff) maxDiff = arr[i] - minSoFar;
        }
        maxDiff = maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
        System.out.println(maxDiff);
    }
}
