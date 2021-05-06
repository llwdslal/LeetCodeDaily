package leetcode.linkedlist;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 提示：
 *
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 */
public class 二进制链表转整数_1290_easy {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        Solution solution = new Solution();

        System.out.println(solution.getDecimalValue(node));

    }

    static class Solution {
        public int getDecimalValue(ListNode head) {
            int result = 0;
            while(head != null){
                result = result << 1 | head.val;
                head = head.next;
            }
            return result;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
