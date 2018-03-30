package tree_node;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/27 0027.
 */
public class SumCertainPath2 {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return paths;
        }
        ArrayList<Integer> path = new ArrayList<>();
        sub_FindPath(paths, path, root, target);
        return paths;
    }

    private void sub_FindPath(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root, int target){
        if(root == null) return ;
        path.add(root.val);
        if(root.val == target && root.left == null && root.right == null){
            paths.add(path);
            return;
        }
        target = target - root.val;
        ArrayList<Integer> path2 = new ArrayList<>(); // 每一次new 出来的path2 都是新的，所以间接地完成了现场的恢复工作  ，每一个现场的path2的值都是不一样的
        path2.addAll(path);
        sub_FindPath(paths, path, root.left, target);
        sub_FindPath(paths, path2, root.right, target);

    }
}
