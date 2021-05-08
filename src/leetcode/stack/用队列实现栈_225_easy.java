package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 */
public class 用队列实现栈_225_easy {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.top());
    }

   static class MyStack {

        private Queue<Integer> mainQueue;
        private Queue<Integer> helperQueue;


        /** Initialize your data structure here. */
        public MyStack() {
            mainQueue = new LinkedList<>();
            helperQueue = new LinkedList<>();
        }


       /**
        * 栈 后进先出，队列 先进先出， 所以每次 push 要保证 x 在 mainQueue 队首。
        * 1. helperQueue 除了在处理 push 都是空队列
        * 2. mainQueue,helperQueue 互换 ，此时 mainQueue 是空队列 ，将 x add 到队首
        * 3. 将 helperQueue 中所有元素依次添加到 mainQueue 中
        * @param x
        */
        public void push(int x) {
            Queue<Integer> tempQueue = helperQueue;
            helperQueue = mainQueue;
            mainQueue = tempQueue;

            mainQueue.add(x);

            while (helperQueue.size() > 0){
                mainQueue.add(helperQueue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return mainQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return mainQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return mainQueue.isEmpty();
        }
    }
}
