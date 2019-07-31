public class Solution {    
    class ListNode{
        int val;
        public ListNode(int val)
        {
            this.val = val;
        }
        ListNode next;
    }
    
	int count = 0;
	
    public int InversePairs(int [] array) {
        ListNode node = new ListNode(array[array.length-1]);

        for(int i = array.length -2;i>=0;i--)
        {
            node = addNode(node,array[i]);
        }
        return count % 1000000007;
    }
    
    public ListNode addNode(ListNode node,int value)
    {
        if(node == null)
        {
            node = new ListNode(value);
            return node;
        }
        
        ListNode current = node;
        ListNode last = null;
        
        while(current != null && current.next != null && value > current.val)
        {
            last = current;
            current = current.next;
            count++;
        }
        
        if(value > current.val)
        {
            current.next = new ListNode(value);
            count++;
			System.out.println("尾插"+value);
        }
        else
        {
            if(last == null)
            {
                ListNode leader = new ListNode(value);
                leader.next = node;
                node = leader;
				System.out.println("头插"+value);
            }
            else
            {
                ListNode temp = new ListNode(value);
                last.next = temp;
                temp.next = current;
				System.out.println("中插"+value);
            }
        }
		
		System.out.println("插入"+value+"逆序对"+count);
        
        return node;
        
    }
	
	public static void main(String args[])
	{
		Solution s = new Solution();
		System.out.println(s.InversePairs(new int[]{5,7,2,3,4,9,11,20,18}));
	}
}
