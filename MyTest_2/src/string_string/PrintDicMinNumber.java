package string_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 数组排成字典数值最小数
 */
public class PrintDicMinNumber {
    public String joint(int[] num){
        int length = num.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(num[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                String c1 = o1 + "" + o2;
                String c2 = o2 + "" + o1;
                return c1.compareTo(c2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
