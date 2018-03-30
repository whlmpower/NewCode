package tree_node;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/04 0004.
 *  从上向下打印二叉树，同一层节点从左到右输出，每一层输出一行
 *  两种方法 一种是 通过last  和  nlast 指针
 *  nlast指针指向当前新入队列的指针
 *  当last == current(当前节点的时候) 将last 指针更新为nlast 指针
 *  使用start  和  end 两个变量， 每次出栈 start++ start ==end  更新start
 */
public class TreeNodePrint {


    public ArrayList<ArrayList<Integer>> printandline(TreeNode pRoot){
        if (pRoot == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        deque.offer(pRoot);
        TreeNode last = pRoot;
        TreeNode nlast = null;
        while(!deque.isEmpty()){
            TreeNode temp = deque.poll();
            list.add(temp.val);
            if (temp.left != null){
                deque.offer(temp.left);
                nlast = temp.left;
            }
            if (temp.right != null){
                deque.offer(temp.right);
                nlast = temp.right;
            }

            if (temp.equals(last)){
                last = nlast;
                paths.add(list);
                list = new ArrayList<>();
            }

        }
        return paths;

    }


    ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (pRoot == null){
            return paths;
        }
        deque.offer(pRoot);
        int start = 0;
        int end = 1;
        while (!deque.isEmpty()){
            TreeNode current = deque.poll();
            list.add(current.val);
            start ++;
            if (current.left != null){
                deque.offer(current.left);
            }
            if (current.right != null){
                deque.offer(current.right);
            }
            if (start == end){
                start = 0;
                paths.add(list);
                end = deque.size();
                list = new ArrayList<>();
            }

        }
        return paths;

    }
}
