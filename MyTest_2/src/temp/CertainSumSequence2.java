package temp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/27 0027.
 *  输入一个正数s，打印所有和为s的连续正序列
 *  15 = 7+8 = 4+5 +6 = 1+2+3+4+5
 *  受上一题的启发，定义两个指针，一个指向small 一个指向big
 *  如果当前和小于s big++
 *  当前和大于s    samll++
 */
public class CertainSumSequence2 {
    public ArrayList<ArrayList<Integer>> find(int n){
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (n < 3){
            return paths;
        }
        int small = 1;
        int big = 2;
        int sum = 3;
        while(small < (n + 1) / 2 ){
            if(sum < n){
                big++;
                sum += big;
            }else if (sum == n){
                for (int i = small; i <= big ; i++) {
                    list.add(i);
                }
                paths.add(list);
            }else {
                sum -= small;
                small++;
            }
        }
        return paths;
    }
}
