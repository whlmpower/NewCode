package temp;

import linked_list.ListNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/03/28 0028.
 * 圆圈中最后剩下的数
 * 数学推导 尼玛水会啊
 */
public class LastRemaining {
    public int lastRemaining(int n, int m){
        if (n < 1 || m < 1){
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}


