package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/15 0015.
 */
public class StackReverse2 {
    public int[] reverseStack(int[] A, int n){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.push(A[i]);
        }
        reverse(deque);
        int[] a =  new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = deque.pop();
        }
        return a;
    }

    private void reverse(ArrayDeque<Integer> deque){
        if (deque.isEmpty()){
            return;
        }

        int last = get(deque);
        reverse(deque);
        deque.push(last);

    }


    private int get(ArrayDeque<Integer> deque){
        int result = deque.pop();
        if (deque.isEmpty()){
            return result;
        }else {
            int last = get(deque);
            deque.push(last);
            return last;
        }

    }
}
