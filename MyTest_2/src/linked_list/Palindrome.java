package linked_list;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/18 0018.
 *
 * 链表回文结构
 *
 */
public class Palindrome {
    public boolean isPalindorme(ListNode pHead){

        if (pHead == null){
            return false;
        }
        if (pHead.next == null){
            return true;
        }
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast.next != null && fast.next.next != null){
            deque.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null){
            slow = slow.next;
        }
        while(slow != null && !deque.isEmpty()){
            ListNode temp = deque.peek();
            if (slow.val == temp.val){
                slow = slow.next;
                deque.pop();
            }else
                return false;
        }
        return true;
    }

    public boolean isPalindorme2(ListNode pHead){
        if (pHead == null){
            return false;
        }

        if (pHead.next == null){
            return true;
        }
        if (pHead.next.next == null){
            return pHead.val == pHead.next.val;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode nHead = resign(slow); // slow 指向了中间 进行逆序


        while(nHead != null){
            if (pHead.val == nHead.val){
                pHead = pHead.next;
                nHead = nHead.next;
            }else
                return false;
        }
        return true;
    }

    private ListNode resign(ListNode start){
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
