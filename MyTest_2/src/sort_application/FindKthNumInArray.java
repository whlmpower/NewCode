package sort_application;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/03/09 0009.
 * 在一个数组中寻找前K大的数
 *
 */
public class FindKthNumInArray {

    public int[] kthArray(int[] a, int k){
        int locate = KthofArray(a, k, 0, a.length -1);
        int[] b = Arrays.copyOfRange(a, locate , a.length );
//        int[] b = new int[k];

        return b;

    }

    private int partition(int[] a, int lo, int hi){
        int pivot = a[lo];
        while(lo < hi){
            while(lo < hi && a[hi] >= pivot){
                hi--;
            }
            a[lo] = a[hi];

            while(lo < hi && a[lo] <= pivot ){
                lo ++;
            }
            a[hi] = a[lo];
        }

        a[lo] = pivot;
        return lo;
    }

    public int KthofArray(int[] a, int k, int lo, int hi){
        int mi = partition(a, lo, hi);
        if(hi - mi + 1 == k ){
            return  mi;
        }else if (hi - mi + 1 > k){
            return KthofArray(a, k, mi + 1, hi);
        }else {
            return KthofArray(a, k - (hi - mi + 1), lo, mi -1 );
        }
    }

}
