package stack_queue;

import java.util.ArrayDeque;

/**
 * Created by Administrator on 2018/03/20 0020.
 * 输入两个向量
 * popA pushA
 * 判断pushA是否为popA的压栈队列
 */
public class StackPushPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA){

        if (popA == null || pushA == null || popA.length ==0 || pushA.length == 0 || popA.length != pushA.length ){
            return false;
        }
        // j 是在遍历过程指向popA 的指针
        // i 是在遍历过程指向pushA 的指针

        //例子： 1 2 3 4 5
        //      4 5 3 2 1
        // 找到4  将 1 2 3入栈  4与 4 匹配 j++ ,
        // 新的数字为5，
        // 5先和栈顶元素比较，相等，令其出栈，j++
        //                  不相等 让位于5之前的所有数字入栈
        int len = popA.length;
        int j = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (pushA[i] != popA[j]){
                deque.push(pushA[i]);
            }else {
                j++;// 如果相等将j指针向下移动
                    //并且下一步比较j指针指向的值和当前栈顶元素是否相等 如果相等出栈 并且j++

                while(!deque.isEmpty() && deque.peek() == popA[j]){
                    j++;
                    deque.pop();
                }
            }
        }
        if(deque.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
