package tree_node;

import tree_node.TreeNode;

/**
 * Created by Administrator on 2018/03/07 0007.
 * 两科相互独立的二叉树A和B
 * 检查A中是否存在一颗子树与B的拓扑结构完全相同
 * 二叉树序列化 加KMP
 */
public class IdenticalTree {

    public boolean chkIdentical(TreeNode A, TreeNode B){
        StringBuilder sbA  = new StringBuilder();
        treeSerialize(A, sbA);
        StringBuilder sbB = new StringBuilder();
        treeSerialize(B, sbB);
        String str_A = sbA.toString();
        String str_B = sbB.toString();
        char[] a = str_A.toCharArray();
        char[] b = str_B.toCharArray();
        int result = kmp_match(a, b);
        return ( result != -1);

    }

    private void treeSerialize(TreeNode node , StringBuilder sb){
        if (node == null){
            sb.append("#!");
        }else {
            sb.append(node.val).append("!");
            treeSerialize(node.left, sb);
            treeSerialize(node.right, sb);
        }

    }

    private int kmp_match(char[] a, char[] b){
        int[] next = build_next(b);
        int i = 0; int j = 0;
        int lena =  a.length;
        int lenb = b.length;
        while( i <  lena && j < lenb){
            if(j < 0 || a[i] == b[j]){
                i ++;
                j ++;
            }else {
                j = next[j];
            }
        }
        return (j == lenb) ? i -j : -1;
    }


//    private int[] build_next(char[] a){
//        int len = a.length;
//        int[] next = new int[len];
//        int t = next[0] = -1; // t 是目前待匹配串比较数下标
//        int i = 0;
//        while (i < len -1){
//            if(t < 0 || a[i] == a[t]){ // 当前匹配串待比较数下标等于 当前 模式串数下标
//                i ++;
//                t ++;
////                next[i] = (a[i] != a[t])? t : next[t];
//                next[i] = t;
//            }else {
//                t = next[t];
//            }
//        }
//        return next;
//
//    }



    public int[] build_next(char[] chars){
        int lenb = chars.length;
        int[] next = new int[lenb];
        int t = next[0] = -1;
        int j = 0;
        while(j < lenb -1){
            if(t < 0 || chars[j] == chars[t]){
                t++;
                j ++;
                next[j] = (chars[j] != chars[t]) ? t : next[t];
            }else{
                t = next[t];
            }
        }
        return next;
    }
}
