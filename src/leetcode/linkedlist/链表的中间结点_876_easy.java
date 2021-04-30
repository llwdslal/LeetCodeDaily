package leetcode.linkedlist;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class 链表的中间结点_876_easy {

   static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            // 1 2 3 4 5
            // 1 2 3 4
            while (fast.next!= null){
                //节点数为偶数时 按题目 返回第二个中间节点 slow 需要后移一位
                if (fast.next.next == null){
                    slow = slow.next;
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
