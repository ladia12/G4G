package com.g4g;

import java.util.ArrayList;

public class A7StockBuyAndSell {

     class Interval {
         int buy;
         int sell;
     }

    void runProgram() {

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695, 100, 90, 100};
        int n = price.length;
        ArrayList<Interval> intervals = calculateBuySell(price, n);
        printIntervals(intervals);
    }

    private ArrayList<Interval> calculateBuySell(int price[], int n) {
        if (n == 0 || n == 1) return null;

        ArrayList<Interval> intervals = new ArrayList<>();
        Interval interval = new Interval();
        for(int i = 1; i < n; i++) {
            if(price[i] > price[i-1]) {
                if(interval.buy == 0) interval.buy = price[i-1];
            }else if(interval.buy > 0) {
                interval.sell = price[i-1];
                intervals.add(interval);
                interval = new Interval();
            }
        }
        if(interval.buy > 0) {
            interval.sell = price[n-1];
            intervals.add(interval);
        }
        return intervals;
    }

    private void printIntervals(ArrayList<Interval> intervals) {
         for(Interval interval: intervals) {
             System.out.println("Buy: " + interval.buy + ", Sell: " + interval.sell);
         }
    }
}
