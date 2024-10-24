package com.example.demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCodeQueue {

    static class RecentCounter {
        Deque<Integer> timeseries;
        public RecentCounter() {
            timeseries = new ArrayDeque<>();
        }

        public int ping(int t) {
            timeseries.add(t);
            int lowRange = t-3000;
            while(!timeseries.isEmpty()) {
                int currTime = timeseries.peek();
                if(currTime < lowRange) {
                    timeseries.pop();
                } else {
                    break;
                }
            }
            return timeseries.size();
        }
    }

    public String predictPartyVictory(String senate) {
        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();
        int n = senate.length();

        for(int i=0;i<senate.length();i++) {
            char c = senate.charAt(i);
            if(c=='R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }
        while(!radiantQueue.isEmpty() && !direQueue.isEmpty()){
            int rIndex = radiantQueue.pop();
            int dIndex = direQueue.pop();

            if(rIndex < dIndex) {
                radiantQueue.add(rIndex+n);
            } else {
                direQueue.add(dIndex+n);
            }
        }
        return radiantQueue.size() > direQueue.size() ? "Radiant" : "Dire";
    }
}
