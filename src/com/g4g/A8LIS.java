package com.g4g;

public class A8LIS {
    //For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80}
    // is 6 and LIS is {10, 22, 33, 50, 60, 80}.

    void runProgram() {
        int nums[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int size = nums.length;
        int lis[] = new int[size];

        //base condition
        if(size == 0){
            System.out.println(0);
            return;
        }

        //initialise the LIS array with 1
        for(int i = 0; i<size; i++){
            lis[i] = 1;
        }

        for(int i = 1; i < size; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        //find the max element in LIS array and return
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< size; i++) {
            if(lis[i] > max) max = lis[i];
        }
        System.out.println(max);
    }


}
