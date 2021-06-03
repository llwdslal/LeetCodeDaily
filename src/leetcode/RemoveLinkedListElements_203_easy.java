package leetcode;

import utils.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 */
public class RemoveLinkedListElements_203_easy {

    public static class Solution{
        public ListNode removeElements(ListNode head, Integer val) {
            while(head != null && head.val == val){
                ListNode temp = head;
                head = head.next;
                temp.next = null;
            }
            if (head == null){
                return null;
            }
            ListNode prev = head;
            while (prev.next!= null){
                if (prev.next.val == val){
                    ListNode temp = prev.next;
                    prev.next = prev.next.next;
                    temp.next = null;
                }else{
                    prev = prev.next;
                }
            }
            return head;
        }
        public ListNode removeElements2(ListNode head, Integer val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            while (prev.next!= null){
                if (prev.next.val == val){
                    ListNode temp = prev.next;
                    prev.next = prev.next.next;
                    temp.next = null;
                }else{
                    prev = prev.next;
                }
            }
            return dummyHead.next;
        }
    }


    public static void main(String[] args) {
        Integer[] arr ={1,2,6,3,4,5,6};
        Integer[] arr2={1,2,6,3,4,5,6,7,8,6,9,6,10};
        ListNode<Integer> listNode1 = new ListNode<>(arr);
        ListNode<Integer> listNode2 = new ListNode<>(arr2);

        Solution solution = new Solution();


        System.out.println(solution.removeElements(listNode1,6));
        System.out.println(solution.removeElements(listNode2,6));
    }
}
