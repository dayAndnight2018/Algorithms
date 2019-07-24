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
//将二叉树镜像化
//        8
//    	 /  \
//    	6   10
//     / \  / \
//    5  7  9 11
//镜像二叉树
//        8
//    	 /  \
//      10   6
//     / \  / \
//   	11 9  7  5
public class MirrorOfTree {
    public void Mirror(TreeNode root) {        
        if(root!= null){
            changeLeftRight(root);                     
        }
        
    }
    //递归调用即可，先交换父节点的左右子树，再递归交换子节点的左右子树
    public void changeLeftRight(TreeNode root){
        if(root == null || (root.left == null && root.right==null)){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        changeLeftRight(root.left);
        changeLeftRight(root.right);
    }
}
