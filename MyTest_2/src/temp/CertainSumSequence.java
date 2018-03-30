package temp;

/**
 * Created by Administrator on 2018/03/27 0027.
 * 找到一个数组中，两个数字的和为某一个数值
 * 如果有多个和为某一数值的对，任选一个
 */
public class CertainSumSequence {
    public int[] find(int[] array, int sum){
        int [] res = new int[2];
        int ahead = 0;
        int atail = array.length -1 ;

        while(ahead < atail){
            if (array[ahead] + array[atail] < sum){
                ahead++;
            }else if (array[ahead] + array[atail] > sum){
                atail --;
            }else {
                res[0] = array[ahead];
                res[1] = array[atail];
                break;
            }
        }
        return res;
    }
}
