package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class 比较含退格的字符串_844_easy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab#c","ad#c"));
    }

    // TODO: 2021/5/13  双指针 
   static class Solution {
        public boolean backspaceCompare(String s, String t) {
            Deque<Character> sStack = transStrToStack(s);
            Deque<Character> tStack = transStrToStack(t);
            if (sStack.size() != tStack.size()){
                return false;
            }

            while (!sStack.isEmpty()){
                if (sStack.pop() != tStack.pop()){
                    return false;
                }
            }
            return true;
        }

        private Deque<Character> transStrToStack(String str){
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '#' && !stack.isEmpty()){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
            return stack;
        }
    }
}
