package tree_node;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 按照层打印二叉树，并打印二叉树的行号
 *
 * 两种方法 一种是 通过last  和  nlast 指针
 * nlast指针指向当前新入队列的指针
 * 当last == current(当前节点的时候) 将last 指针更新为nlast 指针
 *
 */
public class TreeNodePrintAndLine {
    public void print_line(TreeNode pRoot){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        if (pRoot == null){
            return;
        }

        deque.offer(pRoot);
        TreeNode last = pRoot;
        TreeNode nlast = null;
        int line = 1;
        while (!deque.isEmpty()){
            TreeNode current = deque.poll();
            if(current.left != null){
                deque.offer(current.left);
                nlast = current.left;
            }
            if (current.right != null){
                deque.offer(current.right);
                nlast = current.right;
            }
            list.add(current.val);
            if (current.equals(last)){
                last = nlast;
                for (Integer i: list
                     ) {
                    System.out.println(i);
                }
                System.out.println("当前为第" + line + "行, 打印完毕");
                line ++;
            }

        }

    }


    int[][] printTree(TreeNode root){
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        if (root == null){
            return new int[0][];
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        TreeNode last = root;
        TreeNode nlast = null;
        deque.offer(root);
        while(!deque.isEmpty()){
            TreeNode current = deque.poll();
            if (current.left != null){
                deque.offer(current.left);
                nlast = current.left;
            }
            if (current.right != null){
                deque.offer(current.right);
                nlast = current.right;
            }
            list.add(current.val);

            if (last == current){
                last = nlast;
                paths.add(list);
                list = new ArrayList<>();
            }

        }

        int[][] res = new int[paths.size()][];
        for (int i = 0; i < paths.size(); i++) {
            ArrayList<Integer> temp  =  paths.get(i);
            res[i] = new int[temp.size()];
            for (int j = 0; j < temp.size(); j++) {
                res[i][j] = temp.get(j);
            }
        }
        return res;
    }
}
