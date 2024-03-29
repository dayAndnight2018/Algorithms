/**
 * 4.输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
 *
 * 思路： 1.pre负责确定树的root; 2.in负责确定树的root.left,root.right,即左右子树; 3.递归1,2
 */
public class ReConstructBT {

	/*
	 * 解题思路： 先根遍历的第一个节点就是树的根节点，到中根遍历中查找根的位置，根前面的是左子树，后面的是右子树
	 * 递归调用，直至null
	 */
	public TreeNode construct(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}

		TreeNode root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);

		return root;
	}

	public TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		// 创建根节点
		TreeNode root = new TreeNode(pre[preStart]);

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == pre[preStart]) {
				root.left = construct(pre, preStart + 1, preStart + (i - inStart), in, inStart, i - 1);
				root.right = construct(pre, preStart + 1 + (i - inStart), preEnd, in, i + 1, inEnd);
				break;
			}
		}
		return root;

	}
}
