/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//反转链表
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
        {
            return null;
        }
        
        ListNode old = head;
        ListNode next = old.next;
        old.next = null;
        while(next!=null && next.next!=null)
        {
            ListNode current = next;
            next = next.next;
            current.next = old;
            old = current;
        }
        if(next!=null)
        {
            next.next = old;
        }
        else
        {
            next = old;
        }
        return next;
    }
}
