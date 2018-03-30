package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/08 0008.
 * 不借助别的栈  将栈里面的元素进行逆序操作
 * 3
 * 2
 * 1
 */
public class StackReverse {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    public int[] reverseStack(int[] A, int n ){
        for (int i = n -1; i >= 0 ; i++) {
            deque.push(A[i]);
        }

        reverse(deque);

        for (int i = 0; i < n; i++) {
            A[i] = deque.pop();
        }
        return  A;
    }

    /**
     * s将栈底元素清除并返回
     * @param deque
     * @return
     */
    private int get(ArrayDeque<Integer> deque){
        int result = deque.pop();
        if(deque.isEmpty()){
            return result;
        }else{
            int last = get(deque); // 得到递归调用的最后一层元素
            deque.push(result); //将当前栈层元素，压入栈中
            return last; // 永远返回最后一层元素
        }

    }

    /**
     * 递归逆序操作
     * @param deque
     */
    private void reverse(ArrayDeque<Integer> deque){
        if (deque.isEmpty()){
            return;
        }
        int last = get(deque);
        reverse(deque);
        deque.push(last);

    }

    private void reverse_array(int[] A, int index, int n){
        if (index == n-1){
            return;
        }
        int temp = getLast(A, index, n);
        index++;
        reverse_array(A, index, n);
        index--;
        A[index] = temp;

    }

    private int getLast(int[] A, int index, int n){
        int temp = A[index];
        if(index == n -1){
            return temp;
        }else{
            index ++;
            int last = getLast(A, index, n);
            A[index] = temp;
            return last;
        }

    }
}
