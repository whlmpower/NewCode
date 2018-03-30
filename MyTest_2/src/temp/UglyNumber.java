package temp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/22 0022.
 *
 * 丑数
 * 只包含因子 2 3 5 的数称为丑数
 * 使用数组来存储上一个丑数的值
 * 存储的丑数 用 t2 t3 t5 三个指针来指示三个序列
 * 2*a1 2*a2
 * 3*a1 3*a2
 * 5*a1 5*a2
 *
 */
public class UglyNumber {
    public int getuglyNumber(int index){
        if (index < 7){
            return index;
        }
        int[] res = new int[index];
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] *2, Math.min(res[t3] * 3, res[t5] * 5)); // 数组有序， 下一个值定为这三个序列中较小的一个
            if (res[i] == res[t2] * 2){ // t2 t3 t5 为指向三个序列的指针
                t2++;
            }
            if (res[i] == res[t3] * 3){
                t3++;
            }
            if (res[i] == res[t5] * 5){
                t5++;
            }
        }
        return res[index -1];
    }
}
