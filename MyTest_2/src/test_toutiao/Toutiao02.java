package test_toutiao;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/03/24 0024.
 */
public class Toutiao02 {
    // 使用回溯法进行求解
    private static int minCount = Integer.MAX_VALUE;		// 静态成员变量 记录最小的操作次数
    // 核心回溯方法 n为输入的n sm[0]为s的长度，sm[1]为m的长度
    private static void count(int n, int[] sm, int count) {
        if (sm[0] == n) {
            minCount = count < minCount ? count : minCount;
            return;
        }
        if (sm[0] > n) return;

        int prevS = sm[0];			// 第一种操作
        int prevM = sm[1];
        if (prevS < n) {
            sm[1] = sm[0];
            sm[0] = 2 * sm[0];
            count(n, sm, count + 1);
            sm[1] = prevM;
            sm[0] = prevS;

            sm[0] = sm[0] + sm[1];		// 第二种操作
            count(n, sm, count + 1);
            sm[0] = prevS;
        }
    }
    public static void main(String[] args) {
        int[] sm = {1,1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count(n, sm, 0);
        System.out.println(minCount);
    }
}
