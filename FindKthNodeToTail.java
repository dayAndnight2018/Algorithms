/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//求链表的倒数第K个节点
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0 )
        {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        int length = k;
        
        //先让前面的指针走K步，然后在一起走，前面的指针走到最后，后面的指针指向倒数第K个节点
        while(length > 1 && node2 != null)
        {
            node2 = node2.next;
            length--;
        }
                
        if(length > 1 || node2 == null)
        {
            return null;
        }
        
        while(node2.next != null)
        {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}
