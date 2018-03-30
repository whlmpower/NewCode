package linked_list;

/**
 * Created by Administrator on 2018/03/19 0019.
 * 查找链表倒数第k 个节点
 * 代码的鲁棒性
 * 输出参数的校验
 * k 的值  小于0 等于0  大于链表的长度怎么办
 * head 的 值 为空怎么办
 */
public class FindKthToTail {
    public ListNode find(ListNode head, int k){
        if (head == null){
            return  null;
        }
        if (k <= 0){
            return  null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        while (--k >0 ){ // --k >0 保证其移动了 k -1 步
            p1 = p1.next;
            if (p1 == null){
//                throw new RuntimeException("输入k 的值 大于链表长度");
                return  null;
            }
        }

        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }
}
