package leetcode;


public class MergeTwoSortedLists_21_easy {
    public static void main(String[] args) {
      //  l1 = [1,2,4], l2 = [1,3,4]
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        ListNode result = solution2.mergeTwoLists(l1,l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newHead = new ListNode();
            ListNode tail = newHead;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    tail.next = l1;
                    l1 = l1.next;
                }else{
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            tail.next = l1 == null ? l2 : l1;

            return newHead.next;
        }
    }

    static class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null){
                return l2;
            }else if (l2 == null){
                return l1;
            }else if (l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else{
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
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
