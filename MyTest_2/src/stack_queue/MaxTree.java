package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/09 0009.
 * 2 1 3
 * 2 的下标 0 先进栈 res[0] = -1
 * 1 < 2    res[1] = 当前栈顶值0  将1 入栈
 * 3 > 1    1 出栈
 * 3 > 2    0 出栈
 * 栈空     2 入栈   res[2] = -1
 * 找到大于当前数 的 右边边第一个数
 *
 */
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayDeque<Integer> toRight = new ArrayDeque<>();
        int[] res = new int[A.length];
        for (int i = 0; i < n; i++) {
            while(!deque.isEmpty() && A[deque.peek()] < A[i]){ // 当前值 大于 栈顶指示值  进行出栈操作
                deque.pop();
            }
            if (deque.isEmpty()){ // 栈为空，说明左边找不到比当前数组大的值
                res[i] = -1;      // 先将数组标识设为 -1
            }else {
                res[i] = deque.peek(); // 栈不为空 说明栈顶值 大于当前值 将res 数组标识为栈顶值 即左边第一个大于当前值的下标
            }
            deque.push(i);
        }


        deque.clear();

        for (int i = A.length -1; i >=0 ; i--) {
            while (!deque.isEmpty() && A[deque.peek()] < A[i]){
                deque.pop();
            }
            //当前找不到右边第一个大于的值的时候， 栈为空， 直接采用左边找到比它大的值的下标
            //栈非空， 并且res[i] = -1 表示左边没有较大值
            //或者右边找到较小值，更新数组
            if(!deque.isEmpty() && (res[i] == -1 || A[deque.peek()] < A[res[i]])){
                res[i] = deque.peek();
            }

            deque.push(i);
        }
        return res;
    }
    public int[] buildMaxTree2(int [] A, int n ){
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = getIndex(i, A, n);
        }
        return  res;
    }

    private int getIndex(int target, int[] A, int n){
        int left = -1;
        int right = n;

        for (int i = target + 1; i < n; i++) {
            if (A[i] > A[target]){
                right = i;
                break;
            }
        }

        for (int i = target -1; i >= 0 ; i--) {
            if (A[i] > A[target]){
                left = i;
                break;
            }
        }
        if (left == -1 && right == n){
            return  -1;
        }else if (left != -1 && right != n){
            return A[left] > A[right] ? right :left;
        }else if (left != -1 && right == n){
            return left;
        }else if (left == -1 && right != n){
            return right;
        }
        return 0;
    }


}
