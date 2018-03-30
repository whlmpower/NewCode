package stack_queue;

import tree_node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/08 0008.
 * 二叉树的DFS就是深度优先遍历
 * DFS的实现可以使用递归 或者使用栈结构
 */
public class DFS {

    public void itedfs_pre(TreeNode node){
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (true){
            while (node != null){
                list.add(node.val);
                if (node.right != null){
                    arrayDeque.push(node.right);
                }
                node = node.left;
            }
            if (arrayDeque.isEmpty()){
                break;
            }
            node = arrayDeque.pop();
        }
    }

    public void dfs_in(TreeNode node){
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (true){
            if (node != null){
                arrayDeque.push(node);
                node = node.left;
            }else if(!arrayDeque.isEmpty()){
                node = arrayDeque.pop();
                list.add(node.val);
                node = node.right;
            }else
                break;
        }
    }

}


