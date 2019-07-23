/*
 * 
 * problem 9: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 */
import java.util.Stack;

/*
 * 解题思路： 一个存数据，一个弹数据
 * 存数据直接压栈即可
 * 弹数据，如果栈不为空，直接弹出，否则，依次将存数据的栈的数据压入弹出栈，再弹出
 */
public class QueueWithTwoStack {

	Stack<Integer> stack1 = new Stack<Integer>();	//插入栈
	Stack<Integer> stack2 = new Stack<Integer>();	//弹出栈

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (!stack2.empty()) {
			return stack2.pop();
		} else {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
			return pop();
		}
	}
}
