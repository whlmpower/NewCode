package linked_list;

/**
 * Created by Administrator on 2018/03/15 0015.
 *
 *
 */
public class RandomListNodeClone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode temp = new RandomListNode(node.label);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node = pHead;
        while (node != null){
            if (node.random != null){
                node.next.random = node.random.next;
                node = node.next.next;
            }
        }

        RandomListNode currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}
