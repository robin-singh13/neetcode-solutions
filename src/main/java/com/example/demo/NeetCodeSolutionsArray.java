package com.example.demo;

import java.util.*;

public class NeetCodeSolutionsArray {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        
        for(String str : strs) {
            
            
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            StringBuilder sb = new StringBuilder();
            for(Character c : chr)
                sb.append(c);

            if(anagramGroup.get(sb.toString())!= null) {
                List<String> words = anagramGroup.get(sb.toString());
                words.add(str);
                anagramGroup.put(sb.toString(),words);
            } else {
                anagramGroup.put(sb.toString(),new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<List<String>>(anagramGroup.values());
    }

    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> elementFrequency = new HashMap<>();
        List<Integer>[] groupByFrequency = new List[nums.length+1];

        for(int i=0; i<nums.length+1 ; i++) {
            groupByFrequency[i] = new ArrayList<>();
        }
        for(int num : nums) {
            elementFrequency.put(num,elementFrequency.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : elementFrequency.entrySet()) {
            groupByFrequency[entry.getValue()].add(entry.getKey());
        }
        int[] groupByOutput = new int[k];
        int numberOfElementsAdded =0;
        for(int i=groupByFrequency.length-1; i>=0; i--) {
            if(groupByFrequency[i].size() > 0) {
                for(Integer element : groupByFrequency[i]) {
                    if(numberOfElementsAdded<k) {
                        groupByOutput[numberOfElementsAdded] = element;
                        numberOfElementsAdded++;
                    }
                    else break;
                }
            }
        }

        return groupByOutput;
    }

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(Base64.getEncoder().encodeToString(str.getBytes()));
            sb.append(':');
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) {
            return Collections.emptyList();
        }
        if (str.equals(":")) {
            return Arrays.asList("");
        }
        String[] inputstr = str.split(":");
        List<String> output = new ArrayList<>();
        for(String input : inputstr) {
            output.add(new String(Base64.getDecoder().decode(input.getBytes())));
        }
        return output;
    }
    public int[] productExceptSelf(int[] nums) {
        int multiple=1;
        boolean doesZeroExist=false;
        boolean isAllElemetsZero=true;
        for(int num : nums) {
            if(num!=0) {
                isAllElemetsZero=false;
            }
            if(num==0 && doesZeroExist==true) {
                multiple=0;
            }
            if(num==0 && doesZeroExist==false) {
                doesZeroExist=true;
            } else {
                multiple *= num;
            }
        }
        if(isAllElemetsZero) {
            multiple=0;
        }
        int[] output = new int[nums.length];
        for(int i=0; i< nums.length; i++) {
            if(nums[i]!=0 && doesZeroExist) {
                output[i]=0;
            }
            else {
                if(nums[i]==0) {
                    output[i]=multiple;
                } else {
                    output[i] = multiple/nums[i];
                }
            }
        }
        return output;
    }
    public boolean isValidSudoku(char[][] board) {
        // Check all rows
        Map<Character,Integer> isExist = new HashMap<>();
        for(int i=0; i < board.length; i++) {
            for(char num: board[i]) {
                if(num=='.') {
                    continue;
                }
                else if(!isExist.containsKey(num)) {
                    isExist.put(num,1);
                }
                else {
                    System.out.println("Row check failed");
                    return false;
                }
            }
            isExist.clear();
        }
        //Check all columns

        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                if(board[j][i]=='.') {
                    continue;
                }
                if(board[j][i]!='.' && !isExist.containsKey(board[j][i])) {
                    isExist.put(board[j][i],1);
                }
                else {
                    System.out.println("Column check failed");
                    return false;
                }
            }
            isExist.clear();
        }
        //Check grids in 3's
        int currentGridRow=0;
        int currentGridColumn=0;
        while(currentGridColumn < board[0].length) {
            for(int gridRow=currentGridRow; gridRow<currentGridRow+3; gridRow++) {
                for(int gridColumn=currentGridColumn; gridColumn<currentGridColumn+3; gridColumn++){
                    if(board[gridRow][gridColumn]=='.') {
                        continue;
                    }
                    if(board[gridRow][gridColumn]!='.' && !isExist.containsKey(board[gridRow][gridColumn])) {
                        isExist.put(board[gridRow][gridColumn],1);
                    }
                    else {
                        System.out.println("Grid check failed"+currentGridRow+" "+currentGridColumn );
                        return false;
                    }
                }
            }

            isExist.clear();
            currentGridRow+=3;
            if(currentGridRow > board.length-1) {
                currentGridRow=0;
                currentGridColumn+=3;
            }
        }
        return true;
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> sortedList = new TreeSet<>();
        for(int num: nums) {
            sortedList.add(num);
        }
        int maxSequence=0;
        int currentSequence=0;
        int lastNum=-1;
        for(Integer num: sortedList) {
            if(currentSequence==0) {
                currentSequence++;
                lastNum=num;
                continue;
            }
            if(lastNum+1==num) {
                currentSequence++;
            }
            else {
                maxSequence = Math.max(currentSequence,maxSequence);
                currentSequence=1;
            }
            lastNum=num;

        }
        return Math.max(currentSequence,maxSequence);
    }

    public String gcdOfStrings(String str1, String str2) {
        if(str1+str2 != str2+str1) {
            return "";
        }
        int gcdBase = gcdOfLength(str1.length(),str2.length());

        return str1.substring(0,gcdBase-1);
    }

    private int gcdOfLength(int a, int b) {
        if(a == b) {
            return a;
        }
        if(a > b) {
           return gcdOfLength(a-b,b);
        }
        return gcdOfLength(a,b-a);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for(int n: candies) {
            if(n > max) {
                max = n;
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<candies.length; i++) {
            if(candies[i]+extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String output = new String();
        for(int i=words.length-1; i>=0; i++) {
            if(words[i].length() > 0) {
                output += words[i] + " ";
            }
        }
        return output.trim();
    }

    public boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        int lowIndex=0;
        int midIndex=0;

        for(int i=1; i<nums.length; i++) {
           if(nums[i]<low) {
               low = nums[i];
               lowIndex=i;

           } else if(nums[i]>low && nums[i]<mid) {
               mid=nums[i];
               midIndex=i;
           } else if(nums[i] > mid & midIndex>lowIndex && i>midIndex) {
               return true;
           }

        }
        return false;
    }

    public int compress(char[] chars) {
        char lastChar=chars[0];
        int length=0;
        int index=1;
        for(char c: chars ) {
            if(c==lastChar) {
                length++;
            }
            else if(c!=lastChar) {
                if(length > 1) {
                    for(char num: String.valueOf(length).toCharArray()) {
                        chars[index] = num;
                        index++;
                    }
                }
                lastChar = c;
                length=1;
                chars[index] = lastChar;
                index++;
            }
        }
        if(length > 1) {
            for(char num: String.valueOf(length).toCharArray()) {
                chars[index] = num;
                index++;
            }
        }
        return index;
    }

}
