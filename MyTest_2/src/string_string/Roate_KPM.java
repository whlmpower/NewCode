package string_string;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 旋转字符的匹配
 */
public class Roate_KPM {

    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena != lenb){
            return false;
        }
        if(A== null || B ==null || lena <0 || lenb < 0){
            return false;
        }
        A = A + A;
        char[] m = A.toCharArray();
        char[] n = B.toCharArray();

        return match(m,  n,  2*lena, lenb) == -1 ? false : true;

    }
    public int[] build_next(char[] chars, int lenb){
        int[] next = new int[lenb];
        int t = next[0] = -1;
        int j = 0;
        while(j < lenb -1){
            if(t < 0 || chars[j] == chars[t]){
                t++;
                j ++;
                next[j] = (chars[j] != chars[t]) ? t : next[t];
            }else{
                t = next[t];
            }
        }
        return next;
    }

    public int match(char [] a, char[] b, int lena, int lenb){
        int[] next = build_next(b, lenb);
        int j = 0;
        int i = 0;
        while((i < lena) && (j < lenb)){
            if(j< 0 || a[i] == b[j]){
                i ++;
                j ++;
            }else{
                j = next[j];
            }
        }
        return (j ==lenb) ? i-j : -1;
    }
}
