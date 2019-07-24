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

//对于给定的树A和树B，判断B是否是A的一部分
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null){
            return false;
        }
        //检查是否是当前节点的一部分
        boolean yes = isPart(root1,root2);
        if(!yes){
            //检查是否是左子树的一部分
            yes = isPart(root1.left,root2);
        }
        if(!yes){
            //检查是否是右子树的一部分
            yes = isPart(root1.right,root2);
        }
        return yes;
    }
    
    public boolean isPart(TreeNode node1, TreeNode node2){
        //B树没了，说明找完了
        if(node2 == null){
            return true;
        }
        //A树没了，但是B树还有，不是这个节点，返回
        if(node1 == null){
            return false;
        }
        //数值不相等，返回
        if(node1.val != node2.val){
           return false;
        }
        //数值相等？判断左子树是不是一致，右子树是不是一致
        return isPart(node1.left, node2.left) && isPart(node1.right, node2.right);
    }
}
