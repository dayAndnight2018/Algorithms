//找到链表的中间节点，对于奇数个节点，返回中间的那个，否则返回中间任意一个
public ListNode findMedian(ListNode head) {
        if (head == null) return null;

        ListNode before = head;
        ListNode after = head;
        //快的指针走两步，慢的走一步，快的到头，慢的到中间
        while (before.next != null && before.next.next != null) {
            before = before.next.next;
            after = after.next;
        }

        return after;
    }
