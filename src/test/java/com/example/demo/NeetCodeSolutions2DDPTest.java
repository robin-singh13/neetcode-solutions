package com.example.demo;

import org.junit.jupiter.api.Test;

public class NeetCodeSolutions2DDPTest {
    NeetCodeSolutions2DDP neetCodeSolutions2DDP = new NeetCodeSolutions2DDP();

    @Test
    public void sanityLCS() {
        assert neetCodeSolutions2DDP.longestCommonSubsequence("cat","crabt") == 3;
    }
}
