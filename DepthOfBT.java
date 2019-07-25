/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//求树的最大深度
public class DepthOfBT {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //递归计算左子树深度
        int left = TreeDepth(root.left);
        //递归计算右子树深度
        int right = TreeDepth(root.right);
        //左子树右子树深度较大者深度+1
        return left>right?left+1:right+1;
    }
}
