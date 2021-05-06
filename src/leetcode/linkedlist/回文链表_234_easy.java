package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class 回文链表_234_easy {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(2));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPalindrome(node1));
    }


    static class Solution2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null){
                return true;
            }
            //1 获取链表中间节点
            //[1,2,3,4] ->  2  ; [1,2,3,4,5] -> 3
            ListNode middleNode = getMiddleNode(head);
            //2 反转中间节点~尾部部分的链表
            //[1,2,3,4] ->  2  ; 反转 [3,4]
            //[1,2,3,4,5] -> 3 ; 反转 [4,5]
            ListNode reverse = reverseList(middleNode.next);
            ListNode font = head;
            ListNode end = reverse;
            //由 2 ，反转的链表长度 小于等于前半段链表长度，所以用 end 作为循环结束条件
            while (end != null){
                if (font.val != end.val){
                    return false;
                }
                font = font.next;
                end = end.next;
            }
            return true;
        }

//        private ListNode reverseList(ListNode listNode) {
//            if (listNode == null || listNode.next == null){
//                return listNode;
//            }
//            ListNode newHead = reverseList(listNode.next);
//            listNode.next.next = listNode;
//            listNode.next = null;
//            return newHead;
//        }

        private ListNode reverseList(ListNode listNode) {
            ListNode prev = null;
            ListNode curr = listNode;
            while (curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        /**
         * 快慢指针 ，快指针1次2步，慢指针1次1步 。
         * 快指针指向链表尾部时，慢指针指向链表中间
         * [1,2,3,4] -> 2  ; [1,2,3,4,5] -> 3
         * @param head
         * @return
         */
        private ListNode getMiddleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    static class Solution {
        /**
         * 1. 链表转数组
         * 2. 首尾双指针判断是否是回文
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            List<Integer> arr = new ArrayList();
            ListNode curr = head;
            while (curr != null){
                arr.add(curr.val);
                curr = curr.next;
            }
            int headIndex = 0;
            int tailIndex = arr.size() - 1;
            while (headIndex < tailIndex){
                if (!arr.get(headIndex).equals(arr.get(tailIndex))){
                    return false;
                }
                headIndex++;
                tailIndex--;
            }
            return true;
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
