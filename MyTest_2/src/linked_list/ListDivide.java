package linked_list;

/**
 * Created by Administrator on 2018/03/12 0012.
 * 链表划分问题
 * 给定一个链表，使用特定的阈值进行划分，使得小于这个值得节点移到前面，大于这个值的节点在后面，保证两类节点的内部结构不变
 *
 * 思路1  使用快排，利用格外的数组存储链表的值 重新连接链表
 * 思路2  比阈值小的点连接成链表， 比阈值大的点连接成链表   比阈值小的点连接成链表
 *
 */
public class ListDivide {
    public ListNode listDivide(ListNode head, int val){
        if(head == null){
            return null;
        }
        ListNode smallHead = new ListNode(-1);// 引入哨兵节点
        ListNode equalHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);

        ListNode smalltemp = smallHead;
        ListNode equaltemp = equalHead;
        ListNode bigtemp = bigHead;
        ListNode temp = null;
        while(head != null){
            temp = head;
            head = head.next;// 将遍历到当前的 每个节点 切开
            temp.next = null;
            if (temp.val < val){
                smalltemp.next = temp;
                smalltemp = smallHead.next;
            }else if(temp.val == val){
                equaltemp.next = temp;
                equaltemp = equaltemp.next;
            }else {
                bigtemp.next = temp;
                bigtemp = bigtemp.next;
            }

        }

        if (smallHead.next == null){ // 连接的时候 只需要考虑中间的节点是否存在
            equaltemp.next = bigHead.next;
        }else {
            equaltemp.next = smallHead.next;
            smalltemp.next = bigHead.next;
        }
        return  equalHead.next;

    }
}
