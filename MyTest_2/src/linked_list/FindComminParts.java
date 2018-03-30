package linked_list;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/12 0012.
 * 打印两个链表的公共节点
 */
public class FindComminParts {
    public int[] findCommonParts(ListNode headA, ListNode headB){
        ArrayList<Integer> list = new ArrayList<>();
        if (headA == null || headB == null){
            return new int[0];
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null && curB != null){
            if (curA.val < curB.val){
                curA = curA.next;
            }
            else if(curA.val == curB.val) {
                list.add(curA.val);
                curA = curA.next;
                curB = curB.next;
            }else {
                curB = curB.next;
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            a[i] = list.get(i);
        }
        return a;
    }
}
