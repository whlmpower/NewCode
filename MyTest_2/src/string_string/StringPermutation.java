package string_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Administrator on 2018/03/07 0007.
 * 字符串全排序后按照字典顺序输出
 */
public class StringPermutation {

    public ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0){
            return  list;
        }
        char[] a = str.toCharArray();
        permutationHelper(a, 0, list);
        Collections.sort(list);
        return list;
    }

    private void permutationHelper(char[] a, int i, ArrayList<String> list){
        if(i == a.length -1){
            String val = new String(a);
            if (!list.contains(val)){
                list.add(new String(a));
            }
            return;
        }

        for (int j = i; j < a.length; j++) {
            swap(a, i, j); //以abc为例， swap(0, 0) 将a 固定， 直至j = 2 定位到c  添加到list中
            permutationHelper(a, i + 1, list);  // c 递归回调  b 递归开始，交换 b c
            swap(a, i, j); //交换完元素 重置到起始位置
        }
    }

    private void swap(char[] a, int i , int j){
        char temp = a[i];
        a[i]  = a[j];
        a[j] = temp;
    }

//    public ArrayList<String> Permutation2(String str){
//        ArrayList<String> list = new ArrayList<String>();
//        if(str==null || str.length()==0){
//            return list;
//        }
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        list.add(String.valueOf(chars));
//        int len = chars.length;
//        while(true){
//            int lIndex = len-1;
//            int rIndex;
//            while(lIndex>=1 && chars[lIndex-1]>=chars[lIndex]){
//                lIndex--;
//            }
//            if(lIndex == 0)
//                break;
//            rIndex = lIndex;
//            while(rIndex<len && chars[rIndex]>chars[lIndex-1]){
//                rIndex++;
//            }
//            swap(chars,lIndex-1,rIndex-1);
//            reverse2(chars,lIndex);
//            list.add(String.valueOf(chars));
//        }
//        return list;
//    }

    public ArrayList<String> Permutation2(String str){
        ArrayList<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        int len = chars.length;
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        while(true){

            int lIndex = len -1; // 指向从右向左第一个变小的数的前一位 如：123469875 指向 9
            int rIndex = 0;// 指向从左向右最后一个比6 大的数的后一位  指向 5
            while (lIndex >= 1 && chars[lIndex -1] > chars[lIndex]){
                lIndex --;
            }
            if (lIndex == 0){
                break;
            }
            rIndex = lIndex;
            while (rIndex <len && chars[rIndex] > chars[lIndex -1]){ // 循环终止于 数字 5
                rIndex++;
            }
            swap(chars, lIndex -1, rIndex -1); // 将 6 到 7之间数字进行交换
            reverse2(chars, lIndex);
            list.add(String.valueOf(chars));
        }
        return list;
    }


    private void reverse2(char[] chars, int k){
        int len = chars.length;
        if(k >= len){
            return;
        }
        int start = k;
        int end = len -1;
        while(start < end){
            swap(chars, start, end);
            start ++;
            end --;
        }
    }

}
