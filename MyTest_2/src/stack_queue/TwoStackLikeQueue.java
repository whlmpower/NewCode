package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/08 0008.
 */
public class TwoStackLikeQueue {
    ArrayDeque<Integer> deque1 = new ArrayDeque<>();
    ArrayDeque<Integer> deque2 = new ArrayDeque<>();
    int count0 = 0;
    public int[] twoStack(int[] poe, int n){

        for (int i = 0; i < n; i++) {
            if (poe[i] > 0){
                deque1.push(poe[i]);
            }else {
                count0++;
            }
        }

        while(!deque1.isEmpty()){
            deque2.push(deque1.poll());
        }

        int[] result = new int[count0];
        int index = 0;
        while (index < count0){
            result[index] = deque2.poll();
            index ++;
        }
        return result;
    }

}
