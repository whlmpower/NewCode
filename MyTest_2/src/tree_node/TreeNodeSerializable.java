package tree_node;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 二叉树先序遍历序列化
 */
public class TreeNodeSerializable {
    StringBuilder sb = new StringBuilder();
    void treeNode_serialize(TreeNode node){

        if (node == null){
            sb.append("#!").toString();
        }

        sb.append(node.val).append("!");

        treeNode_serialize(node.left);
        treeNode_serialize(node.right);
    }
}
