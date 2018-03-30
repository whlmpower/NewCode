package temp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/27 0027.
 * 一个数组中除了两个数以外，其他数字都出现两次，请找出出现一次的那两个数
 * 异或操作  1^1 = 0 ^0 =0 0 ^1 = 1 使指定位进行反转
 * 思路  1.将整个数组的元素进行异或操作 （相同为0 相异为1）
 * 比如抑或结果为0100
 * 依据最后一个1 为标准  进行将数组分为两个数组
 * 数组中对应为1的话 为一个数组
 * 数组中对应位为0 为一个数组
 * 将两个数组单独进行异或操作
 *
 */
public class OneTimeAndTwoTimesInArrays {
    public void findTwoData(int [] data, int[] num1, int[] num2){
        if(data == null || data.length <2){
            return;
        }

        int len = data.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ data[i];
        }
        int index = getLast1(res);

        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < len; i++) {
            if (isBit(index, data[i])){
                num1[0] ^= data[i];
            }else
                num2[0] ^= data[i];
        }

    }

    private boolean isBit(int index, int data){
        return  (data >> index & 1) == 0;
    }

    private int getLast1 (int res){
        int index = 0;
        while ((res & 1 )== 0 && index < 32 ){
            res = res >> 1;
            index ++;
        }
        return  index;
    }
}
