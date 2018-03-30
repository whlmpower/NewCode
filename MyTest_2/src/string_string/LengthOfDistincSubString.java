package string_string;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/03/07 0007.
 * 字符串中无重复字符子串长度
 * 0 1 2 3 4 5(坐标)
 * 1 2 3 4 3 2
 * 当前是i = 4
 * pre_index 指的是前一个字符4  前一次出现的位置（若前一次未出现，则设置为-1）
 * cur_index 指的是当前字符     前一次出现的位置 例子中是2
 *
 */
public class LengthOfDistincSubString {

    public int LongestSubstring(String A, int n){
        char[] a = A.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        int pre_index = -1; // 当前字符前一个字符   前一次出现的位置
        int cur_index;      // 当前字符前一次出现的位置
        int temp = 0;
        int result = 0;
        for (int i = 0; i < n ; i ++) {
            if(map.containsKey(a[i])){  // 在这之前 当前字符出现过
               cur_index = map.get(a[i]);
            }else {
                cur_index = -1;        // 没出现过 设置为-1
            }

            if (pre_index > cur_index){ //前一个字符  前一次出现的位置 >  当前字符 前一次出现的位置
                temp = i - pre_index;   // 例子中 i= 5  pre_index = 2  cur_index = 1  此时最长距离为 i- pre_index
            }else {                     // 否则
                temp = i - cur_index;  // i - cur_index
                pre_index = cur_index; // 更新pre_index
            }
            map.put(a[i], i);         // 更新map中存放
            result = Math.max(result, temp); // 选取最大值
        }
        return result;
    }
}
