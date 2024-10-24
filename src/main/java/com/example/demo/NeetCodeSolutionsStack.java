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

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int asteroid: asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
            }
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                if(stack.peek() == -asteroid) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i=stack.size()-1;

        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }

    public String decodeString(String s) {
        Deque<Integer> numberStack = new ArrayDeque<>();
        Deque<String> sbStack = new ArrayDeque<>();
        StringBuilder currSb = new StringBuilder();
        int num=0;

        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num*10+(c-'0');
            } else if(c == '[') {
                numberStack.push(num);
                sbStack.push(currSb.toString());
                num=0;
                currSb = new StringBuilder();
            } else if (c == ']') {
                int count = numberStack.pop();
                StringBuilder tempSb = new StringBuilder(sbStack.pop());
                while(count > 0) {
                    tempSb.append(currSb);
                    count--;
                }
                currSb = tempSb;
            } else {
                currSb.append(c);
            }
        }
        return currSb.toString();

    }
}
