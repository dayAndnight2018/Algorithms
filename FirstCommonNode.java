//获取两个链表的第一个公共节点
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1 == null || pHead2 == null)
         {
             return null;
         }
        //获取两个链表的长度
        int len1 = GetLinkLengh(pHead1);
        int len2 = GetLinkLengh(pHead2);
        int diff = Math.abs(len1 - len2);
        ListNode longer = len1 > len2 ? pHead1 : pHead2;
        ListNode shorter = len1 <= len2 ? pHead1 : pHead2;
        //将较长的那个先移动几步，在和另外一个链表一起移动。
        for(int i = 0;i<diff;i++)
        {
            longer = longer.next;
        }
        
        //直到最后或者找到相同的节点
        while(longer !=null && longer.val != shorter.val)
        {
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return longer != null?longer:null;
        
    }
    
    public int GetLinkLengh(ListNode node)
    {
        int len = 0;
        ListNode head = node;
        while(head!=null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
