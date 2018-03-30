package tree_node;

/**
 * Created by Administrator on 2018/03/19 0019.
 *
 * 二叉树重构
 * 根据前序遍历序列和中序遍历序列
 * 有点不明白 preStart + local - inStart  和 preStart + local - inStart + 1
 *  为什么不能直接用local
 *
 */
public class ConstructTree {
    public TreeNode construct(int[] pre, int[] in){
        if (pre.length == 0 || in.length == 0|| pre == null || in== null){
            return  null;
        }
        int len = pre.length;
        int prestart = 0;
        int preend = len -1;
        int instart = 0;
        int inend = len -1;
        return constructCore(prestart, preend, instart, inend, pre, in);

    }

    private TreeNode constructCore(int preStart, int preEnd, int inStart, int inEnd, int[] pre, int[] in){
        if (preStart < preEnd || inStart < inEnd){
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        int local = -1;
        for (int i = inStart; i < inEnd ; i++) {
            if (pre[preStart] == in[i]){
                local = i;
                break;
            }
        }
        if (local == -1){
            throw new RuntimeException("数组错误");
        }
        node.left = constructCore(preStart + 1, preStart + local -inStart, inStart, local -1, pre, in);
        node.right = constructCore(preStart + local + 1 - inStart, preEnd, local + 1, inEnd, pre, in);
        return node;
    }
}
