package temp;

/**
 * Created by Administrator on 2018/03/28 0028.
 * 求1+ 2 + 3 +4 + .... + n
 * 利用短路 与 找到递归基
 */
public class Sum_Solution {
    public int sum_solution(int n){
        int sum = n;
        boolean ans = (n > 0) && ((sum += sum_solution(n -1)) != 0);
        return sum;
    }
}
