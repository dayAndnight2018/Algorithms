//逐行打印，不分ArrayList进行存储了
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TraverseTreeByLayer {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.add(root);

        while (!queue.isEmpty()) {
            //根节点出队，获取左子树和右子树根节点，入队
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        return result;
    }
}
