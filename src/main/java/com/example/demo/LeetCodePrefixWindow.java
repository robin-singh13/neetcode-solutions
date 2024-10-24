package com.example.demo;

public class LeetCodePrefixWindow {

    public int largestAltitude(int[] gain) {
        int[] point = new int[gain.length+1];
        point[0] = 0;
        int currIndex=1;
        for(int i=0; i<gain.length;i++) {
            point[currIndex] = point[currIndex-1] + gain[i];
            currIndex++;
        }
        int maxGain = Integer.MIN_VALUE;
        for(int i=0;i<point.length;i++) {
            if(point[i] > maxGain) {
                maxGain = point[i];
            }
        }
        return maxGain;
    }

}
