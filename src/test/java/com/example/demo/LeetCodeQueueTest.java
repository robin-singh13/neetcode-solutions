package com.example.demo;

import org.junit.jupiter.api.Test;

public class LeetCodeQueueTest {

    LeetCodeQueue leetCodeQueue = new LeetCodeQueue();

    @Test
    public void sanityRecentCounter() {
        LeetCodeQueue.RecentCounter recentCounter = new LeetCodeQueue.RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
