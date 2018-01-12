package com.g4g;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
public class A2MinWindowString {
    void runProgram() {
        String str = "aabcbcdbca";
        int count = countDistinct(str);
        printSmallestWindow(count, str);
    }

    private int countDistinct(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), 1);
        }
        return map.keySet().size();
    }

    private void printSmallestWindow(int count, String str) {
        int i = 0;
        int n = str.length() - 1;
        int countSoFar = 0;
        int ans = Integer.MAX_VALUE;
        int ansStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0; j <= n; j++) {

            char cur = str.charAt(j);
            Integer value = map.get(cur);

            //Check if character is not there in map
            if(value == null) {
                map.put(cur, 1);
                countSoFar++;
            } else {
                map.put(cur, (value + 1));
            }

            // substring contains all distinct characters
            if(countSoFar == count) {

                //Try to reduce countSoFar
                while (map.get(str.charAt(i)) > 1) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                    i++;
                }

                //update answer if required
                if((j-i+1) < ans) {
                    ans = j-i+1;
                    ansStart = i;
                }

            }
        }
        System.out.println(str.substring(ansStart, ansStart + ans));
    }

}
