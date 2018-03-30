package linked_list;

/**
 * Created by Administrator on 2018/03/10 0010.
 * 删除单个节点 次节点前面节点均不可见
 */
public class RemoveSingleNode {
    public ListNode removeNode(ListNode pNode, int delVal){
        ListNode temp = pNode;
        ListNode node = pNode;
        if (pNode.val == delVal){
            pNode = pNode.next;
        }

        while(node != null){
            //复制后一个节点删除前一个节点
            if (node.val == delVal && node.next != null){
                node.val = node.next.val;
                node.next = node.next.next;
                break;
                //到尾节点删除的时候需要前一个节点，前一个节点的next 需要指向null
                // 如果直接删除的节点是尾节点的话   没办法解决，因为没办法让尾节点的前一个节点指向null
            }else if(node.val == delVal && node.next != null){
                temp.next = null;
                break;
            }
            temp = node;
            node = node.next;
        }
        return pNode;
    }

    /**
     * 给了链表的头结点 以及要删除的节点
     * 进行链表指定节点的删除
     * 时间复杂度为 （O(1) * (n -1) + O(n)） / n  = O(1)
     * @param pNode
     * @param pHead
     * @return
     */
    public ListNode remove(ListNode pNode, ListNode pHead){
        //删除节点不位于尾节点
        if(pNode.next != null){
            ListNode pTmp = pNode.next;
            pNode.val = pTmp.val;
            pNode.next = pTmp.next;
        }else if (pHead == pNode){ // 隐含的前提条件是PHead.next = null 并且删除的节点就是头结点 就一个节点
            pHead = null;
            pNode = null;
            return null;
        }else{
            // 删除节点位于尾节点  找到删除节点的前一个节点
            //将前一个节点的next 指针指向null
            ListNode node = pHead;
            while(node.next != pNode){
                node = node.next;
            }
            node.next = null;
            pNode = null;
        }
        return pHead;
    }

}
