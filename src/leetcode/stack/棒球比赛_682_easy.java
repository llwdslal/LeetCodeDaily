package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：ops = ["1"]
 * 输出：1
 */
public class 棒球比赛_682_easy {
    static class Solution {
        public int calPoints(String[] ops) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < ops.length; i++) {
                String op = ops[i];
                if (op.equals("+")){
                    int top = stack.pop();
                    int val = top + stack.peek();
                    stack.push(top);
                    stack.push(val);
                }else if (op.equals("D")){
                    stack.push(stack.peek() * 2);
                }else if (op.equals("C")){
                    stack.pop();
                }else{
                    stack.push(Integer.parseInt(op));
                }
            }
            int result = 0;
            while (!stack.isEmpty()){
                result += stack.pop();
            }
            return result;
        }
    }
}
