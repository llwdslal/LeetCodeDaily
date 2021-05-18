package leetcode.top100.easy;

import utils.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class 合并两个有序链表_21 {

   static class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null){
                return l2;
            }
            if (l2 == null){
                return l1;
            }
            if (l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else{
                l2.next = mergeTwoLists(l2.next,l1);
                return l2;
            }
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newHead = new ListNode(0);
            ListNode cur = newHead;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return newHead.next;
        }
    }
}
