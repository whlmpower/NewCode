package linked_list;

import tree_node.TreeNode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/10 0010.
 * 给定整数val  如何在节点有序的环形链表中插入一个节点为val的值
 * 保证整个链表仍然有序
 */
public class InsertValue {
    public ListNode insert(int[] A, int [] nxt, int val){
        int len = A.length;

        ListNode node = new ListNode(val);
        if (A == null || len == 0 || nxt == null || nxt.length == 0){
            node.next = node;
            return node;
        }

        ListNode head = new ListNode(A[0]);
        ListNode tnode = head;
        for (int i = 0; i < len; i++) {
            tnode.next = new ListNode(A[nxt[i]]);
            tnode = tnode.next;
        }
        ListNode cur  = head;
        ListNode cur_next = cur.next;
        while(len -- > 0){
            if (cur.val <= val && cur_next.val >= val){
                cur.next = node;
                node.next = cur_next;
                return head;
            }else{
                cur = cur_next;
                cur_next = cur_next.next;
            }
        }

        if (len == 0){
            if (cur.val <= val){
                cur.next = node;
                node.next = null;
            }
            if (cur_next.val >= val){
                node.next = cur_next;
                cur.next = null;
                head = node;
            }

        }
        return head;
    }
}
