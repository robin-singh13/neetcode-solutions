package com.example.demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NeetCodeSolutionsStack {
    public static class MinStack {
        private List<Integer> stackList;
        private int pointer;
        public MinStack() {
            this.stackList = new ArrayList<>();
            this.pointer=-1;
        }

        public void push(int val) {
            this.pointer++;
            this.stackList.add(this.pointer,val);

        }

        public void pop() {
            this.stackList.remove(pointer);
            this.pointer--;

        }

        public int top() {
            return this.stackList.get(this.pointer);
        }

        public int getMin() {
            int min=Integer.MAX_VALUE;
            for(Integer num: this.stackList) {
                min=Math.min(num,min);
            }
            return min;
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new ArrayDeque<>();
        String integerPattern = "-?[0-9]+";
        String matehmaticalOperator = "[+-/*]";
        for(String token : tokens) {
            if(token.matches(integerPattern)) {
                numStack.push(Integer.parseInt(token));
            }
            else if(token.matches(matehmaticalOperator)){
                int secondNumber = numStack.pop();
                int firstNumber = numStack.pop();
                switch(token) {
                    case "+":
                        numStack.push(firstNumber+secondNumber);
                        break;
                    case "-":
                        numStack.push(firstNumber-secondNumber);
                        break;
                    case "*":
                        numStack.push(firstNumber*secondNumber);
                        break;
                    case "/":
                        numStack.push(firstNumber/secondNumber);
                        break;


                }
            }
        }
        return numStack.pop();
    }

    public List<String> generateParenthesis(int n) {
        int open=1;
        int close=0;
        List<String> output = new ArrayList<>();
        backTrackParanthesis("(",open,close,n, output);
        return output;
    }

    private void backTrackParanthesis(String s, int open, int close, int limit, List<String> output) {
        if(open < limit) {
            String newString = s+"(";

            backTrackParanthesis(newString,open+1,close,limit,output);
        }
        if(close < open) {
            String newString = s+")";

            backTrackParanthesis(newString,open,close+1,limit,output);
        }
        else if(open==close && open==limit) {
            output.add(s);
        }
    }
}
