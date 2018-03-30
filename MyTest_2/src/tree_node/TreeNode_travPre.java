package tree_node;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 二叉树先序遍历迭代版
 * */
public class TreeNode_travPre {

    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    void visitAlongLeftBranch(TreeNode node, ArrayList<Integer> list){
        while(node != null){
            list.add(node.val);//访问左分支，暂存右孩子
            if(node.right != null){
                deque.push(node.right);
            }
            node = node.left;
        }
    }

    ArrayList<Integer> trav_Pre(TreeNode pRoot ){
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            visitAlongLeftBranch(pRoot, list);
            if (deque.isEmpty()) break;
            pRoot = deque.pop();
        }
        return list;
    }


}
