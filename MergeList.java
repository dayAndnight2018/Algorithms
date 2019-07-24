//合并两个排序了的链表
public class MergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
        {
            return list2;
        }
        else if(list2 == null)
        {
            return list1;
        }
        else if(list1 == null && list2 == null)
        {
            return null;
        }
        
        ListNode node = null;
        ListNode current = null;
        
        while(list1!=null && list2 != null)
        {
            ListNode temp;
            if(list1.val<=list2.val)
            {
                temp = list1;
                list1 = list1.next;
            }else{
                temp = list2;
                list2 = list2.next;
            }
            if(node == null)
            {
                node = current = temp;
            }
            else
            {
                current.next = temp;
                current = current.next;
            }
        }
        while(list1!=null)
        {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            
        }
        while(list2!=null)
        {
                current.next = list2;
                current = current.next;
                list2 = list2.next;  
        }
        return node;
    }
    
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null)
        {
            return list2;
        }
        else if(list2 == null)
        {
            return list1;
        }
        else if(list1 == null && list2 == null)
        {
            return null;
        }
        
        ListNode node = null;
        if(list1.val <= list2.val){
          node = list1;
          node.next = Merge(list1.next, list2);
        }
        else{
          node = list2;
          node.next = Merge(list1,list2.next);
        }
        
        return head;
    }
}
