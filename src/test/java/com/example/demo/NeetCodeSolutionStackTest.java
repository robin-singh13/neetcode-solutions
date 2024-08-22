package com.example.demo;

import com.example.demo.NeetCodeSolutionsStack.MinStack;
import org.junit.jupiter.api.Test;

public class NeetCodeSolutionStackTest {
    NeetCodeSolutionsStack neetCodeSolutionsStack = new NeetCodeSolutionsStack();

    @Test
    public void sanityMinStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(-2147483648);
        System.out.println(minStack.getMin());  // return 0
        minStack.pop();
        System.out.println(minStack.getMin());  // return 0
        minStack.pop();
        System.out.println(minStack.getMin());
          // return 1
    }

    @Test
    public void sanityEvalRPN() {
        String[] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(neetCodeSolutionsStack.evalRPN(tokens));
    }

    @Test
    public void sanityGenerateParenthesis() {
        System.out.println(neetCodeSolutionsStack.generateParenthesis(3));
    }
}
