package utils;

public class ListNode<E> {
    public E val;
    public ListNode<E> next;

    public ListNode(E val) {
        this.val = val;
    }

    public ListNode(E[] array) {
        this.val = array[0];
        ListNode<E> cur = this;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode<>(array[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<E> cur = this;
        while (cur != null){
            sb.append(cur.val.toString());
            sb.append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
