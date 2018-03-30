package tree_node;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/04 0004.
 *
 * 后序遍历的迭代版本
 */
public class TreeNode_travPost {
    ArrayDeque<TreeNode> deque = new ArrayDeque<>();

    ArrayList<Integer> travPost(TreeNode node){
        if (node != null){
            deque.push(node);
        }
        TreeNode temp = null;
        while(!deque.isEmpty()){
            temp = deque.pop();
            if (temp != node.parent){//弹出的栈顶节点不是当前节点的父节点，则定为当前节点的右兄弟节点

                gotoHLVFL(temp);//深入右兄弟节点
            }
            node = temp;
        }

        return null;
    }

    void gotoHLVFL(TreeNode node){ //以栈顶节点为根子树中，找到最高左侧可见叶节点
        while(node != null){
            if (node.left != null){
                if (node.right != null){
                    deque.push(node.right);
                }
                deque.push(node.left);
            }else {
                deque.push(node.right);
            }
        }
    }
}
