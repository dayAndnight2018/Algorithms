//将二叉树进行逐行打印

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
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null)
        {
            return list;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int left = 1;
        int children = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        //对每一行，便利每个节点，使用left记录剩余节点数，使用children统计下一层节点数。
        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();
            temp.add(current.val);
            left -- ;
            
            if(current.left != null)
            {
                queue.add(current.left);
                children ++;
            }
            if(current.right != null)
            {
                queue.add(current.right);
                children ++;
            }
            if(left ==0)
            {
                list.add(new ArrayList(temp));
                temp.clear();
                left = children;
                children = 0;
            }
        }
        
        return list;
    }
    
}
