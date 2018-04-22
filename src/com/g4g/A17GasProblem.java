package com.g4g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/gas-station/
public class A17GasProblem {

    void runProblem() {
        List<Integer> A = new ArrayList<>(Arrays.asList(6,3,7));
        List<Integer> B = new ArrayList<>(Arrays.asList(4,6,3));
        System.out.println("Solution : " + canCompleteCircuit(A, B));

    }

    // A is the gas available at i
    // B is the cost to go from i to i+1
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        //we start from index 0
        int start = 0, gasInTank = 0, sumGas = 0, sumCost = 0;
        for(int i = 0; i < n; i++) {
            sumGas += A.get(i);
            sumCost += B.get(i);
            gasInTank += A.get(i) - B.get(i);
            if(gasInTank < 0) {
                start = i+1;
                gasInTank = 0;
            }
        }
        if(sumCost>sumGas) return -1;
        else return start;
    }
}
