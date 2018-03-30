package linked_list;

/**
 * Created by Administrator on 2018/03/15 0015.
 */
public class FindFirstCommanListNode {
    public ListNode find(ListNode pHead1, ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        /**
         * p1 p2 同时走
         * 假设list1 链表短 长度为a+n 到第n节点便是公共端点  p1 先到头 走了 a+n 长度
         *                 长度为b+n                     p2 走了a + n 长度， 还差b -  a 到头
         * 令 p1 指向pHead2 继续走 b-a p2 到头
         * 令 p2 指向pHead1
         * 让p1 p2 继续一起走
         * p1 走 a 长度 到达n 计算公式为（b + n - (b - a) - a ）= n 位置
         * p2 走 a 长度 到达n 计算公式为 a + n - a = n
         */

        while(p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }
}
