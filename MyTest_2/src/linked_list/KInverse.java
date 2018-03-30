package linked_list;

/**
 * Created by Administrator on 2018/03/12 0012.
 * 链表内 没间隔k 个节点进行逆序
 *
 */
public class KInverse {
    public ListNode inverse(ListNode head, int k){
        if (k < 2 ){
            return  head;
        }
        if (head == null || head.next == null){
            return  head;
        }

        ListNode pre = null;//保存着要反转的节点的上一个节点，初始的时候值为null
        ListNode cur = head; // 正在进行遍历的节点
        ListNode next = null; // 正在进行遍历的节点的下一个节点
        ListNode start = null;//将要反转的开始节点
        int count = 1;
        while(cur != null){
            next = cur.next;
            if (count == k){
                start = (pre == null) ? head : pre.next; // 通过pre 判断是否是第一次践行遍历
                // 第一次进行遍历 start 指向了head  以后每一次的遍历 start 都是pre 的下一个节点
                //因为pre 总是维护要反转子链表的前一个节点

                //pre == null 说明第一次遍历 此时把head 指向了cur
                //因为经过反转后 当前的节点就是 整个反转链表的头指针

                // 以后都不会再改变
                head = (pre == null) ? cur : head;
                resign(pre, start, cur, next );
                pre = start;// 反转重新调整后 start 成为调整后的最后的一个节点 让pre 指向他
                count = 0;
            }
            count ++;
            cur = next;
        }
        return head;
    }

    /**
     *
     * @param left  左边或者说是前一个节点
     * @param start 开始节点
     * @param end   结束节点
     * @param right 右边节点 结束节点的下一个节点
     */
    private void resign(ListNode left, ListNode start, ListNode end, ListNode right ){
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next = null;
        while(cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // C->B-> A-> D <- E <- F  G(目前处于孤立)
        //       left 目前left 指向了A
        // 需要更正left的next 指针  让他指向F 即end
        //
        if (left != null){
            left.next = end;
        }
//        C->B-> A-> F -> E -> D -> G
        //连接孤立的G  让start 指向 right
        start.next = right;

    }

    /**
     * 复习链表反转
     * @param head
     * @return
     */
    private ListNode inverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return  pre;
    }
}
