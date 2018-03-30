package string_string;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 给定一个字符串str  和一个整数i, i代表在str 中的位置
 * 将str[0...i] 移到右侧去， 将str[i+1, ... N-1]移到左侧去
 *
 * ABCDE
 * 先旋转AB
 * 再旋转CDE
 * 最后旋转 整个数组
 */
public class MoveIndexSplitStr {
    public String stringTranslation(String A, int n, int len) {
        // write code here
        char[] a = A.toCharArray();
        reverse(a, 0, n -1);
        reverse(a, n , len -1);
        reverse(a, 0, len -1);
        return new String(a);
    }

    private void reverse(char[] a, int i, int j){
        while(i < j){
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i ++;
            j --;
        }
    }
}
