package string_string;

/**
 * Created by Administrator on 2018/03/07 0007.
 *
 * 括号匹配
 */
public class MatchParenthesis {
    public boolean chkParenthesis(String A, int n){
        int num = 0;
        char[] a = A.toCharArray();
        for(int i = 0; i < n; i++){
            if (a[i] == '('){
                num ++;
            }
            if(a[i] == ')'){
                num --;
            }
            if (num < 0){
                return  false;
            }
        }
        if (num == 0){
            return true;
        }else {
            return false;
        }
    }

}
