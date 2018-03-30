package tree_node;

/**
 * Created by Administrator on 2018/03/27 0027.
 * 判断一棵树是否为平衡二叉树
 *
 */
public class BalancedTree {

    boolean isBalanced = true;
    public boolean isbalanced(TreeNode node){
        getheight(node);
        return isBalanced;

    }

    private int getheight(TreeNode node ){
        if (node == null){
            return 0;
        }

        int left_h = getheight(node.left);
        int right_h = getheight(node.right);
        if (Math.abs(left_h - right_h) <=1){
            isBalanced = false;
        }
        return 1+ (left_h > right_h ? left_h : right_h);

    }


    private boolean isBalancedHelper(TreeNode node, int[] depth){
        if (node == null){
            depth[0] = 0;
            return true;
        }
        int[] l_depth = new int[1];
        int[] r_depth = new int[1];
        if (isBalancedHelper(node.left, l_depth) && isBalancedHelper(node.right, r_depth)){ //在下一个递归调用中 l_depth为实参 depth 为形参
            if (Math.abs(l_depth[0]- r_depth[0]) <=1){
                depth[0] = (l_depth[0] > r_depth[0] ? l_depth[0] : r_depth[0]) + 1;
                return true;
            }
        }
        return false;

    }

}
