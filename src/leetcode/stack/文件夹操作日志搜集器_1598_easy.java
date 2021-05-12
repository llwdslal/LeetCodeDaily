package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class 文件夹操作日志搜集器_1598_easy {

    class Solution2 {
        public int minOperations(String[] logs) {
            int counter = 0;
            for (int i = 0; i < logs.length; i++) {
                String operation = logs[i];
                if (operation.equals("../")) {
                    counter = --counter < 0 ? 0 : counter;
                } else if (!operation.equals("./")) {
                    counter++;
                }
            }
            return counter;
        }
    }

    static class Solution {
        public int minOperations(String[] logs) {
            Deque<String> stack = new ArrayDeque<>();
            for (int i = 0; i < logs.length; i++) {
                String operation = logs[i];
                if (operation.equals("../")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!operation.equals("./")) {
                    stack.push(operation);
                }
            }
            return stack.size();
        }
    }
}
