package temp;

/**
 * Created by Administrator on 2018/03/19 0019.
 *  计算二进制中 1 的个数
 *  1100 - 1 = 1011
 *  1100 & 1011 = 1000
 *  每次循环就消除一个右边的1
 *  有几个1 就做几次循环
 *
 *
 *  引申题目：
 *  1.判断一个数是不是2的整数次方 这个整数减一后 与原数& 看看结果是不是0
 *  2.输入两个整数m 和 n  计算改变m 中 多少位才能得到n   先把两个数进行异或操作 再统计 操作完成后1 的 个数
 *
 */
public class TheNum1InArray {
    public int numberOf1(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return  count;
    }

    /**
     * 引申题目2
     * @param n
     * @param m
     * @return
     */
    public int stepToAdapt(int n , int m ){
        int k = n ^ m ;
        int count = numberOf1(k);
        return  count;
    }
}
