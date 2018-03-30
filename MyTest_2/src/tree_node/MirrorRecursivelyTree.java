package tree_node;

/**
 * Created by Administrator on 2018/03/19 0019.
 *  输入一个二叉树，输出二叉树的镜像
 *  将左右子树互换 进行递归
 */
public class MirrorRecursivelyTree {
    public void mirror(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root. right;
        root.right = temp;
        if (root.left != null){
            mirror(root.left);
        }
        if (root.right != null){
            mirror(root.right);
        }
    }
}
