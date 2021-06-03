package leetcode.linkedlist;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *  
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 */
public class 反转链表_206_easy {

    static class Solution2 {
//        public ListNode reverseList(ListNode head) {
//
//        }
    }

    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null){
                ListNode tem = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tem;
            }
            return prev;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
