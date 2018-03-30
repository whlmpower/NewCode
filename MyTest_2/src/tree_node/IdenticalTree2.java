package tree_node;

/**
 * Created by Administrator on 2018/03/19 0019.
 *
 * 与identicalTree1 有区别
 * 具体区别在于
 * https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88
 * 链接：https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88
 来源：牛客网

 ps：
 看到有人提出了KMP的想法，即先序遍历然后比较B的先序序列是否是A的先序序列的子序列
 时间复杂度O(n + m)，想法挺好的，但是要考虑下面这种情况是否满足题意。如果下列满足
 题意，那么使用这种方法是不对的
 *
 *
 * 此题使用递归
 */
public class IdenticalTree2 {
    public boolean hasSubTree(TreeNode pRoot1, TreeNode pRoot2) {
        boolean result = false;
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }
        if (pRoot1.val == pRoot2.val){
            result = hasSubTreeHelper(pRoot1, pRoot2);
        }
        if (result){
            result = hasSubTreeHelper(pRoot1.left, pRoot2);
        }
        if (result){
            result = hasSubTreeHelper(pRoot1.right, pRoot2);
        }
        return result;
    }

    private boolean hasSubTreeHelper(TreeNode pRoot1, TreeNode pRoot2){
        if (pRoot2 == null){
            return  true;
        }
        if (pRoot1 == null){
            return false;
        }

        if (pRoot1.val != pRoot2.val){
            return false;
        }

        return hasSubTreeHelper(pRoot1.left, pRoot2.left) && hasSubTreeHelper(pRoot1.right, pRoot2.right);
    }
}
