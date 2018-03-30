package temp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/19 0019.
 * 输入一个数的位数n
 * 打印从1 开始到 n 位数最大值的所有数
 * 数字的全排列
 * 回溯法 或者  成为DFS
 *
 */
public class Print1ToMaxOfNDigits_1 {

    public ArrayList<String> print(int n){
        int[] number = new int[n]; // number  存储的是n 位数字上每一位的数字
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            number[0] = i;
            permutationHelper(number, n, 0, list);
        }
        return list;
    }

    // 递归进行全排列
    private void permutationHelper(int [] number, int length, int index, ArrayList<String> list){
        if (index == length -1 ){
            printNumber(number, list);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = i;
            permutationHelper(number, length, index + 1, list);
        }
    }

    /**
     * 去除掉0开头的位  将number 数组组成一个整个数字
     * 添加到list 中
     * @param number
     * @param list
     */
    private void printNumber(int[] number, ArrayList<String> list){
        boolean isBegainning = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length; i++) {
            if (isBegainning && number[i] != 0){
                isBegainning = true;
            }
            if (isBegainning){
                System.out.print(number[i]);
                sb.append(number[i]);
            }
        }

        list.add(sb.toString());
    }
}
