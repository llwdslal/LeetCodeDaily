package leetcode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class RemoveDuplicatesFromSortedList_83_easy {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4))))));
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(l1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null){
                return head;
            }
            ListNode current = head;
            while (current.next != null){
                if (current.val ==  current.next.val){
                    current.next = current.next.next;
                }else{
                    current = current.next;
                }
            }
            return head;
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
