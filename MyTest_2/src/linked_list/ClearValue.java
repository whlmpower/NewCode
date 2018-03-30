package linked_list;

/**
 * Created by Administrator on 2018/03/18 0018.
 * 删除链表中指定值的节点
 */
public class ClearValue {
    public ListNode clear(ListNode head, int val){
        if (head == null){
            return  head;
        }
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        while(cur != null){
            if(cur.val == val ){
                if (cur == head){
                    head = head.next;
                    cur = cur.next;
                }else {
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }
            else {
                pre = cur;
                cur = cur.next;
            }

        }
        return  head;
    }
}
