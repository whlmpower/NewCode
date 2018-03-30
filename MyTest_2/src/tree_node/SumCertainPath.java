package tree_node;


import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/26 0026.
 * 输入一个二叉树和一个整数，打印二叉树中节点值和为输入整数的所有路径
 */
public class SumCertainPath {
   public ArrayList<ArrayList<TreeNode>> findPaths(TreeNode node, int n){
       ArrayList<TreeNode> list = new ArrayList<>();
       ArrayList<ArrayList<TreeNode>> paths = new ArrayList<>();
       sub_find(node, n, list, paths);
       return paths;
   }
   private void sub_find(TreeNode node, int n , ArrayList<TreeNode> list, ArrayList<ArrayList<TreeNode>> paths){
       if (node == null){
           return;
       }
       list.add(node);
       n -= node.val;
       if (n == 0 && isLeafNode(node)){
           paths.add(new ArrayList<>(list));
       }
       sub_find(node.left, n, list, paths);
       sub_find(node.right, n, list, paths);
       list.remove(list.size() - 1); // 递归回退前需要删除最后添加元素

   }
   private boolean isLeafNode(TreeNode node){
       return node.left == null && node.right == null;
   }
}
