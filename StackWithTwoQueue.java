import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * 使用两个队列实现一个栈
 * 
 * 
 */
public class StackWithTwoQueue {

	Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    
    //queue1压入数据
    public void push(int node) {
        queue1.add(node);
    }
    
    //弹出时，先把数据转移到queue2，再转移回来。
    public int pop() {
    	int res = 0;
    	
    	while(!queue1.isEmpty()) {
    		//最后一个元素，也就是最后进来的元素，需要弹出
    		res = queue1.poll();
    		//不是最后一个元素就转移
    		if(!queue1.isEmpty()) {
    			queue2.add(res);
    		}    		
    	}
    	while(!queue2.isEmpty()) {
    		queue1.add(queue2.poll());
    	}    	
    	return res;
    }
}
