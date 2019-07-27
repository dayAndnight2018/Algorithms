//带有min功能的栈结构
import java.util.Stack;

//建立两个栈，一个存储值，一个存储最小值，新来的比原来的大，存储原来的，否则存储新的。
public class Solution {
    Stack<Integer> container = new Stack<Integer>();
    Stack<Integer> help = new Stack<Integer>();
    
    public void push(int node) {
        container.push(node);
        if(help.isEmpty())
        {
            help.push(node);
        }
        else
        {
            if(help.peek() >= node)
            {
                help.push(node);
            }
            else
            {
                help.push(help.peek());
            }
        }
    }
    
    public void pop() {
        if(!container.isEmpty())
        {
            container.pop();
            help.pop();
        }
    }
    
    public int top() {
        if(!container.isEmpty())
        {
            return container.peek();
        }
        return -1;
    }
    
    public int min() {
        if(!help.isEmpty())
        {
            return help.peek();
        }
        return -1;
    }
}
