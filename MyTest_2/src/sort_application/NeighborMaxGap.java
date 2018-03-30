package sort_application;

/**
 * Created by Administrator on 2018/03/06 0006.
 * 排序后相邻数组的最大差值
 */
public class NeighborMaxGap {
    public int maxGap(int[] A, int n){
        int min = A[0];
        int max = A[0];

        for (int i = 0; i <n ; i++) {
            if(min > A[i]){
                min = A[i];
            }
            if (max < A[i]){
                max = A[i];
            }
        }

        boolean[] hasnum = new boolean[n + 1];
        int[] maxs = new int [n + 1];// 最大值需要单独放在一个桶里面 n +1
        int[] mins = new int [n + 1];
        for (int i = 0; i < n; i++) {
            int bid = locateBucketIndex(A[i], n, min, max);
            maxs[bid] = hasnum[bid] ? Math.max(maxs[bid], A[i]): A[i];
            mins[bid] = hasnum[bid] ? Math.min(mins[bid], A[i]): A[i];
            hasnum[bid] = true;
        }
        int first_max = 0;
        int i =0;
        int result = 0;
        for (; i <= n; i++) {
            if(hasnum[i]){
                first_max = maxs[i];
                break;
            }
        }

        for (i = i + 1; i <= n ; i++) {
            if (hasnum[i]){
                result = Math.max(mins[i] - first_max, result);
                first_max = maxs[i];
            }
        }
        return result;
    }

    private int locateBucketIndex(long num, long length, long min, long max){
        return  (int)((num -min ) * length /(max -min));//如何分配桶号码
        // max - min  除以  length =  一个桶的容量
        // 当前数 num - min 除以 一个桶容量  得到对应的桶id
    }
}
