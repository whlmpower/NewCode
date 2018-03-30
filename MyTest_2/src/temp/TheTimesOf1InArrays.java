package temp;

/**
 * Created by Administrator on 2018/03/22 0022.
 * 从1 到 n 整数中1 出现的次数
 *
 * 主要思路： 设定整数（1， 10， 100）作为位置点 i （作为n 的个位、十位、 百位等）
 * 分别对每个数位上有多少包含1的点进行分析
 * 根据设定的整数位置，对n 进行分割， 分为两部分， 高位为n/i， 低位为n % i
 * 例子：
 * 当i 表示百位时， 且百位对应的数 >= 2， 如 31456 i = 100， 则a= 314, b = 56
 * 此时百位为1 的次数 为  a/10 + 1 = 32，每一次都包含100 个连续的点， 即共有（a / 10 + 1）*100 个点的百位为1
 *
 * 当i 表示百位时， 且百位对应的数字为1  如 311456， i=100， 则a = 311, b = 56
 * 此时百位对应的就是1, 总共有a/100 = 31, 每一次都是包含连续的点，然后有 对应局部00 ~ 56，共 b + 1次，
 * 加起来总共（a / 10）* 100 + b + 1 个点对应的百位数字为1
 *
 *
 * 当i 表示百位，且百位对应的数字为0， 如 n = 31056, i = 100, 则a = 310, b= 56,此时百位为1 的总数为 a/10 *100 个
 *
 * 综合上述情况， 当百位对应的数字为 0  和  >=2 时， 总共有（a + 8）/10 次包含1
 *
 * 当 百位数字对应为1， 即 a %10 == 1时， 需要增加局部点 b + 1 个
 *
 */
public class TheTimesOf1InArrays {
    public int numof1Between1AndN_Solution(int n){
        int count = 0;

        for (int i = 0; i <= n; i *= 10) {
            int a = n / 10 ;
            int b = n % i ;
            count = count + (a + 8) / 10 * i;
            if (a % 10 == 1){
                count = count + b + 1;
            }
        }
        return count;
    }
}
