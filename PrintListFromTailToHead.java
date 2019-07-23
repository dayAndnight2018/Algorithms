import java.util.ArrayList;
import java.util.Stack;

/*
 * 将指定的链表反转打印
 * 
 */
public class PrintListFromTailToHead {

	// 使用栈来存储并弹栈
	public ArrayList<Integer> printListFromTailToHead(ListNode node) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		// 判断链表的合法性
		if (node == null) {
			return list;
		}

		Stack<Integer> stack = new Stack<Integer>();
		while (node != null) {
			stack.push(node.val);
			node = node.next;
		}

		while (!stack.empty()) {
			list.add(stack.pop());
		}

		return list;
	}

	// 使用递归
	public ArrayList<Integer> printListFromTailToHead2(ListNode node) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		// 判断链表的合法性
		if (node == null) {
			return list;
		}

		if(node.next!=null) {
			ArrayList<Integer> temp = printListFromTailToHead2(node.next);
			for(Integer i:temp) {
				list.add(i);
			}
		}
		
		list.add(node.val);

		return list;
	}

}
