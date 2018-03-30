package temp;

/**
 * Created by Administrator on 2018/03/22 0022.
 * 字符串中第一次出现一次的字符
 * 使用hash 表
 * key 为 当前字符值
 * value 为 当前字符出现的次数
 *
 */
public class FirstNotRepeatingChar {
    public int find(String str){
        if (str.length() == 0 || str == null ){
            return 0;
        }
        int[] table = new int[256];
        char[]  a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            table[a[i]]++;
        }
        int locate = -1;
        for (int i = 0; i < a.length; i++) {
            if(table[a[i]] == 1){
                locate = i;
                break;
            }
        }
        if (locate != -1){
            return  locate;
        }else
            return 0;

    }
}
