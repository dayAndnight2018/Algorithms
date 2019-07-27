//之字形打印二叉树
import java.util.ArrayList;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Stack;

public class PrintTreeWithZigzag {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {        
        ArrayList<ArrayList<Integer>> list = new  ArrayList<ArrayList<Integer>>();
        if(pRoot == null)
        {
            return list;
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int flag = 1;
        Stack<TreeNode> queue1 = new Stack<TreeNode>();
        Stack<TreeNode> queue2 = new Stack<TreeNode>();
        queue1.add(pRoot);
        
        while(!queue1.isEmpty() || !queue2.isEmpty())
        {
            //当前遍历奇数行，先遍历左，后遍历右
            if(flag == 1)
            {
                TreeNode node = queue1.pop();
                temp.add(node.val);
                if(node.left != null)
                {
                    queue2.push(node.left);
                }
                if(node.right != null)
                {
                    queue2.push(node.right);
                }
                if(queue1.isEmpty() && !temp.isEmpty())
                {
                    flag ^= 1;
                    list.add(new ArrayList<Integer>(temp));
                    temp.clear();
                }
            }
            else
            {
                //当前遍历偶数行，先遍历右，后遍历左
                TreeNode node = queue2.pop();
                temp.add(node.val);
                if(node.right != null)
                {
                    queue1.push(node.right);
                }
                if(node.left != null)
                {
                    queue1.push(node.left);
                }
                if(queue2.isEmpty() && !temp.isEmpty())
                {
                    flag ^= 1;
                    list.add(new ArrayList<Integer>(temp));
                    temp.clear();
                }
            }
        }
        
        return list;
    }

}
