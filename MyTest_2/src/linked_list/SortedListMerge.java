package linked_list;

/**
 * Created by Administrator on 2018/03/15 0015.
 *
 * 将两个有序的链表合成一个有序链表
 *
 * 方法一  使用递归进行
 * 方法二  不使用递归
 */
public class SortedListMerge {
    public ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null){
            return  list2;
        }
        if (list2 == null){
            return  list1;
        }
        if(list1.val <= list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }else{
            list2.next = merge(list1, list2.next);
            return list2;
        }

    }


    public ListNode merge2(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return  list1;
        }

        ListNode mergeHead = null;
        ListNode current = null;

        while(list1 != null && list2 != null ){
            if (list1.val <= list2.val){
                if (mergeHead == null){
                    mergeHead = list1;
                    current = list1;
                }else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }
            else{
                if (mergeHead == null){
                    mergeHead = list2;
                    current = list2;
                }
                else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

       if (list1 == null){
            current.next = list2;
       }else {
           current.next = list1;
       }
        return mergeHead;
    }
}
