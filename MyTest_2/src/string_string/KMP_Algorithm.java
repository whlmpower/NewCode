package string_string;

/**
 * Created by Administrator on 2018/03/04 0004.
 * KMP 算法
 */
public class KMP_Algorithm {


    int[] bulid_next(char[] chars){

        String a = null;
        int m = chars.length;
        int[] next = new int[m];
        int t = next[0] = -1;
        int j = 0;
        while(t < m - 1){
            if(t < 0 || chars[t] == chars[j]){
                t++;
                j ++;
                next[j] = (chars[j] != chars[t]) ? t: next[t];
                //next[j] = t;
                //因为不应该出现chars[j] = chars[next[j] = t],
                // 所以当出现这种情况下，需要进行递归，
                //next[j] = next[next[j]]
            }else {
                t = next[t];
            }
        }
        return next;
    }


    boolean match_KMP(char[] a, char[] b){
        int[] next = bulid_next(b);
        int m = a.length;
        int n = b.length;
        int j = 0;
        int i = 0;
        while((i < m) && (j < n)){
            if(a[i] == b[j] || j < 0){
                i ++;
                j ++;
            }else  {
                j = next[j];
            }
        }
        return (i-j>=0 )? true : false;
    }

}
