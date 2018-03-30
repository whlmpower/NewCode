package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/08 0008.
 * 定义一个栈，并且实现一个可以在栈中取得最小值的min 函数
 * 定义两个栈，一个栈用来存放入栈的数值， 另一个栈用来存放当前存放数值栈中的最小值
 * 1 2 1 3 4
 * 栈1   栈2
 *
 * 1      1
 * 2     不入栈
 * 1     1
 * 3     3
 * 4     4
 *
 * 或者  当前入栈值小于 另一个栈中栈顶值时，便入栈
 *               大于 另一个栈中栈顶值    重复令栈顶值入栈
 * 1     1
 * 2     1
 * 1     1
 * 3     3
 * 4     4
 */
public class StackOutputMin {

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    ArrayDeque<Integer> min_Stack = new ArrayDeque<>();
    public void push(int node){
        deque.push(node);
        if (min_Stack.isEmpty() || node <= min_Stack.peek()){
            min_Stack.push(node);
        }
    }

    public void pop(){
        int temp = deque.pop();
        if (!min_Stack.isEmpty() && temp == min_Stack.peek()){
            min_Stack.pop();
        }
    }

    public int top(){
        return deque.peek();
    }

    public int min(){
        return min_Stack.peek();
    }
}
