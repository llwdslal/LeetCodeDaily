package leetcode.linkedlist;


/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 提示：
 * <p>
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 */
public class 移除链表元素_203_easy {


    /**
     * 新建哨兵节点优化 Solution1
     * 重点 使用哨兵节点
     */
    static class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode sentinel = new ListNode(-1, head);

            ListNode prev = sentinel;
            ListNode cur = head;
            while (cur != null){
                if (cur.val == val){
                    prev.next = cur.next;
                }else{
                    prev = cur;
                }
                cur = cur.next;
            }
            return sentinel.next;
        }
    }

    static class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            // 处理头部
            while (head != null && head.val == val) {
                head = head.next;
            }
            // 处理其他部分
            ListNode prev = new ListNode(-1, head);
            ListNode curr = head;
            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
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
