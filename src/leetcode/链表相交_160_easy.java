package leetcode;


public class 链表相交_160_easy {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(10);
        ListNode node1 = new ListNode(100);
        ListNode node2 = new ListNode(101);
        ListNode node3 = new ListNode(102);
        ListNode node4 = new ListNode(103);
        ListNode node5 = new ListNode(104);
        ListNode node6 = new ListNode(105);
        ListNode node7 = new ListNode(106);
        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        headB.next = node7;
        node7.next = node5;
        Solution solution = new Solution();
        System.out.println(solution.getIntersectionNode(headA,headB));

    }


    static public class Solution {
        /**
         * 设 headA 长 a; headB 长 b； 相交部分 长 c
         * 双指针 A,B ：
         * A 遍历完 headA 后遍历 headB
         * B 遍历完 headB 后遍历 headA
         * 直到 A B 所指的值相等
         *
         * a + (b - c) = b + (a - c)
         *
         * c = 0 : 链表不相交
         * c > 0 : 链表相交相交， 交点为 A 或 B 指向的 node
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            ListNode node1 = headA;
            ListNode node2 = headB;
            while (node1 != node2){
                node1 = node1 == null ? headB : node1.next;
                node2 = node2 == null ? headA : node2.next;
            }
            return node1;
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
