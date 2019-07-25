//平衡二叉树的判断，任一节点的左右子树深度差异不超过1就是平衡二叉树
public class BalancedBT {
    
    int depth = 0;
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalance(root);
    }
    
    public boolean isBalance(TreeNode node)
    {
        if(node == null){
            depth = 0;
            return true;
        }
        
        //每前进一下就判断
        boolean isLeftBalance = isBalance(node.left);
        int leftDepth = depth;
        //每前进一下就判断
        boolean isRightBalance = isBalance(node.right);
        int rightDepth = depth;
        
        depth = Math.max(leftDepth + 1, rightDepth + 1);
        
        if(isLeftBalance && isRightBalance && Math.abs(leftDepth - rightDepth) <= 1 )
        {
            return true;
        }
        
        return false;
    }
}

//递归查看左右子树的深度
public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int diff = leftDepth - rightDepth;

        if (diff > 1 || diff < -1) {
            return false;
        }

        return IsBalanced_Solution2(root.left) && IsBalanced_Solution2(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeDepth = TreeDepth(root.left);
        int rightTreeDepth = TreeDepth(root.right);

        return leftTreeDepth > rightTreeDepth ? (leftTreeDepth + 1) : (rightTreeDepth + 1);
    }
