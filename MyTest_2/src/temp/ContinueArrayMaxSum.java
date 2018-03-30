package temp;

/**
 * Created by Administrator on 2018/03/22 0022.
 * 连续数组的最大值
 */
public class ContinueArrayMaxSum {
    public int findGreatestSumOfSubArray(int[] array){
        if (array.length <= 0 || array== null){
            return 0;
        }

        int cur_sum = 0;
        int max_sum = Integer.MIN_VALUE;// 将最开始的最大值设置为 min_value
        for (int i = 0; i < array.length; i++) {
            if (cur_sum <= 0){
                cur_sum = array[i];// 当前求和总数为负  令当前求和指向新的数
            }else {
                cur_sum += array[i]; // 否则加上新的数
            }
            if (cur_sum > max_sum){
                max_sum = cur_sum; // 判断当前求和总数  和   之前最大值  决定是否更新
            }
        }
        return max_sum;
    }
}
