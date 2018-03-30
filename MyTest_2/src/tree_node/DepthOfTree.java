package tree_node;

import static java.lang.Math.*;

/**
 * Created by Administrator on 2018/03/27 0027.
 * 题目1  二叉树深度
 * 题目2  判断二叉树是否为平衡二叉树 平衡二叉树 左右子树高度差不大于1
 */
public class DepthOfTree {
    public int getdepth(TreeNode node){
        if (node == null){ // 这里写了null 的判定
            return 0;
        }
        int left_depth = getdepth(node.left) + 1;// 下面无需做 左右子树为空的判定
        int right_depth = getdepth(node.right) + 1;

        return left_depth > right_depth ? left_depth : right_depth ;
    }

    public boolean isBalanced(TreeNode root){
        int[] depth = new int[]{0};
        return isB(root, depth);
    }

    /**
     * 后序遍历的时候， 需要将值从深层次的递归出来， 所以depth 不能用int类型（值传递）
     * 应该用数组或是对象来保存
     * @param node
     * @param depth
     * @return
     */
    private boolean isB(TreeNode node, int[] depth){
        if (node == null){
            return true;
        }
        int[] left_depth = new int[1];
        int[] right_depth = new int[1];
        if (isB(node.left, left_depth) && isB(node.right, right_depth)){
            int diff = left_depth[0] - right_depth[0];
            if (diff >1 || diff < -1){
                return false;
            }
            depth[0] = 1 + (left_depth[0] > right_depth[0] ? left_depth[0] : right_depth[0]);
            return true;
        }
        return false;
    }

    /**
     * int 类型的depth 不能从深层次的递归出来
     * 另外一种方式是使用返回值为int 类型的方法，
     * 每一次都接受来自子树的返回值
     */
    boolean isBalanced = true;
    private int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int left_h =  getHeight(node.left);
        int right_h = getHeight(node.right);
        int result = Math.abs(right_h - left_h);
        if (result >1){
            isBalanced = false;
        }
        return left_h < right_h ? right_h + 1: left_h + 1;

    }

}
