package stack_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/08 0008.
 * 按照升序对栈进行排序，只能使用一个额外的栈存放临时数据，不得将元素复制到别的数据结构中
 *  数组第一个元素为栈顶
 */
public class TwoStackSort {
    public ArrayList<Integer> twoStacksSort(int[] numbers){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            if(deque.isEmpty() || deque.peek() <= numbers[i]){
                deque.push(numbers[i]);
            }else{
                int temp_array = numbers[i];// 当前数组元素
                int j = i ;
                int temp_stack = deque.peek();//  当前栈顶元素
                while(j >= 0 && temp_stack > temp_array){ // 当前数组元素 小于栈顶元素时
                    numbers[j] = temp_stack; // 栈顶元素记录到当前数组中
                    j--;
                    if(!deque.isEmpty()){
                        deque.pop();     // 出栈操作前检测栈是否为空
                        if (!deque.isEmpty()){ // 更新栈顶元素前判断栈是否为空
                            temp_stack = deque.peek();
                        }else
                            break;
                    }
                }
                deque.push(temp_array);// 无论出现栈为空还是当前 当前数组元素大于栈顶元素  都将当前数组元素入栈
                i = j ; // 更新当前i 的值
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!deque.isEmpty()){
            list.add(deque.pop());
        }
        return list;
    }

    public ArrayList<Integer> twoStackSort2(int[] numbers){
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        for (int i = numbers.length -1; i >=0; i--) {
            deque1.push(numbers[i]);
        }
        deque2.push(deque1.pop());
        while(!deque1.isEmpty()){
            int cur_deal = deque1.poll();
            if(!deque2.isEmpty()){
                int cur_help = deque2.peek();
                if (cur_deal < cur_help){
                    deque1.push(deque2.pop());
                }else {
                    deque2.push(deque1.pop());
                }
            }else{
                deque2.push(deque1.pop());
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!deque2.isEmpty()){
            list.add(deque2.pop());
        }

        return list;
    }
}
