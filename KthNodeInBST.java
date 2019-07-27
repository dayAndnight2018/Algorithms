//找到二叉搜索树第K大的值
public class KthNodeInBST {

    int count = 0; // 递归全局变量
    //按照中序遍历的原则进行遍历二叉树得到的就是有序的序列，先左，再根，最后右
    TreeNode KthNode(TreeNode pRoot, int k)
    {
       if(pRoot!=null)
       {
          TreeNode node = KthNode(pRoot.left,k);
          if(node != null)
          {
            return node;
          }
          counter ++;
          if(counter == k)
          {
            return pRoot;
          }
          node = KthNode(pRoot.right,k);
          if(node!=null)
          {
            return node;
          }
       }
       
       return null;
    }

}
