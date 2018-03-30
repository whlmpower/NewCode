package tree_node;

/**
 * Created by Administrator on 2018/03/21 0021.
 * 将二叉搜索树转换为双向链表
 * 链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5
 来源：牛客网

 public class Solution {
     TreeNode head = null;
     TreeNode realHead = null;
     public TreeNode Convert(TreeNode pRootOfTree) {
         ConvertSub(pRootOfTree);
         return realHead;
     }
      
     private void ConvertSub(TreeNode pRootOfTree) {
         if(pRootOfTree==null) return;
         ConvertSub(pRootOfTree.left);
         if (head == null) {
             head = pRootOfTree;
             realHead = pRootOfTree;
         } else {
             head.right = pRootOfTree;
             pRootOfTree.left = head;
             head = pRootOfTree;
         }
         ConvertSub(pRootOfTree.right);
     }
 }
 */
public class ConvertBinTreeToList {
    public TreeNode convert(TreeNode pRootOfTree){
        if (pRootOfTree == null){
            return null;
        }
        TreeNode node = pRootOfTree;
        TreeNode pLastNodeInList = null;
        trav_in(node, pLastNodeInList); // 在进行递归的时候，使用辅助节点
        TreeNode pHeadList = pLastNodeInList;
        while(pHeadList != null && pHeadList.left != null){
            pHeadList = pLastNodeInList.left;
        }
        return pHeadList;

    }

    private void trav_in(TreeNode node, TreeNode pLastNodeInList){
        if (node == null){
            return ;
        }
        TreeNode current = node;
        if (current.left != null){
            trav_in(current.left, pLastNodeInList);
        }
        current.left = pLastNodeInList; // 辅助节点是链表中最后的一个节点（值最大的节点）比如第一次指向4
                                        // current 为 6
        if (pLastNodeInList != null){
            pLastNodeInList.right = current; // 4 的right 指向current
        }
        pLastNodeInList = current; // 更新指向 上一级节点 将4 改为6
        if (current.right != null){
            trav_in(current.right, pLastNodeInList);
        }

    }

    /**
     * 解法二 直接让realHead 做 头部指针的指引
     */
    TreeNode readlHead = null;
    TreeNode pLastNodeInLT = null;
    public TreeNode convert2(TreeNode pRootOfTree){
        if (pRootOfTree == null)
            return null;
        convertSub(pRootOfTree);
        return readlHead;
    }

    private void convertSub(TreeNode pRootOfTree){
        if (pRootOfTree == null){
            return;
        }
        convertSub(pRootOfTree.left);

        if (pLastNodeInLT == null){
            pLastNodeInLT = pRootOfTree;
            readlHead = pRootOfTree;
        }else{
            pLastNodeInLT.right = pRootOfTree;
            pRootOfTree.left = pLastNodeInLT;
            pRootOfTree = pLastNodeInLT;
        }
        convertSub(pRootOfTree.right);
    }
}
