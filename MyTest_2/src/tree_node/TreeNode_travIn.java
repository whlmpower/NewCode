package tree_node;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 二叉树遍历中序 迭代版
 */
public class TreeNode_travIn {

    ArrayDeque<TreeNode> deque = new ArrayDeque<>();

    void goAlongLeftBranch(TreeNode node){
        while(node != null){
            deque.push(node);
            node = node.left;
        }
    }

    ArrayList<Integer> trav_In(TreeNode pRoot){
        ArrayList<Integer> list = new ArrayList<>();
        while (true){
            goAlongLeftBranch(pRoot);//左分支入栈
            if (deque.isEmpty()) break;
            TreeNode node = deque.pop();
            list.add(node.val);
            pRoot = node.right;//转向右子树 ，将右子树压入栈
        }
        return  list;
    }


    ArrayList<Integer> trav_In2(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            if (node != null){
                deque.push(node);
                node = node.left;
            }else if (!deque.isEmpty()){
                node = deque.pop();
                list.add(node.val);
                node = node.right;
            }
            else {
                break;
            }
        }
        return list;
    }

}
