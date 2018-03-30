package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/09 0009.
 *
 * 滑动窗口最大值
 *
 * 时间复杂度O(n)
 *
 * 建立双端队列，双端队列中保存下标值
 * 入队列规则：
 * 1.空队列直接入队列
 * 2.当前数大于 队列尾元素对应数字大小 队列最后一个元素出队列（循环依次）
 * 3.当前数小于 队列尾元素对应数字大小 当前元素下标入队列
 *
 * 队首出队列规则：
 * i - w （窗口大小） == 队首元素  说明队首元素已经过期  队首元素出队列
 *
 * 当i >= 2  将队首元素的数组数值进行记录 返回就是所求数组
 */
public class SlideWindow {
    public int[] slide(int[] arr, int n, int w){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] win_max = new int[n - w + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (deque.isEmpty()){
                deque.offer(i);
            }else if(arr[deque.getLast()] >= arr[i] ){
                deque.offer(i);
            }
            else {
                while(!deque.isEmpty()){
                    if (arr[deque.getLast()] < arr[i]){
                        deque.pollLast();
                    }else{
                        deque.offer(i);
                        break;
                    }
                }if (deque.isEmpty()){
                    deque.offer(i);
                }
            }
            if(i >= w -1){
                if(deque.peek() == i - w){
                    deque.poll();
                }
                win_max[index] = arr[deque.peek()];
                index ++;
            }

        }
        return win_max;
    }


}
