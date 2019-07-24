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

//一棵树的先序遍历与对称先序遍历是一样的，那就是对称的。
public class SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return just(pRoot,pRoot);
    }
    
    boolean just(TreeNode left, TreeNode right){        
        if(left == null && right == null){
            return true;
        }
        
        if(left == null || right == null){
            return false;
        }
        
        if(left.val != right.val){
            return false;
        }
        
        return just(left.left,right.right) && just(left.right,right.left);
    }
}
