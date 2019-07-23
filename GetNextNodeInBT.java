
/*
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNodeInBT {
	
	/*
	 * 解题思路：
	 * 
	 * 对于给定的节点的中根遍历顺序分三种情况：
	 * 
	 * 1.该节点有右子树，那么，下一个节点就是右子树的最深左子树。
	 * 2. 该节点没有右子树，是作为左子树出现的，下一个节点就是它的父节点
	 * 3.该节点没有右子树，本身是父节点的右子树，需要遍历它的父节点，直至父节点是父节点的左子树，那么这个父节点就是下一个位置
	 * 
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
        {
            return null;
        }
        
        TreeLinkNode next = null;
        if(pNode.right != null){
            TreeLinkNode right = pNode.right;
            while(right.left != null){
                right = right.left;
            }
            next = right;
        }else if(pNode.next!=null){
            TreeLinkNode current = pNode;
            TreeLinkNode parent = pNode.next;
            while(parent != null && current == parent.right){
                current = parent;
                parent = parent.next;
            }
            
            next = parent;
        }
        
        return next;
    }
}
