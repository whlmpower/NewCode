package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 * 空间复杂度为logn ~ n 主要是递归造成的栈空间的使用，最好的情况是递归树的深度为long2n 其空间复杂度就是logn 最坏情况下，需要进行n-1次递归调用，其空间复杂度为n
 * 最差情况为每一次取到的元素都是数组中最小或者是最大的，退化为冒泡排序
 *
 */
public class QucikSort {
    public int[] quickSort(int[] A, int n){
        int lo = 0;
        int hi = n -1;
        quick_Sort(A, lo, hi);
        return A;
    }


    public void quick_Sort(int[] A, int lo, int hi){
        if(hi - lo < 1){
            return;
        }
        int mi = partition(A, lo, hi );
        quick_Sort(A, lo, mi);
        quick_Sort(A, mi+ 1, hi );
    }

    public int partition(int[] A, int lo, int hi){
        int pivot = A[lo];
        while(lo <hi){
            while(lo < hi && pivot <= A[hi]){
                hi--;
            }
            A[lo] = A[hi];

            while(lo < hi && A[lo] <= pivot){
                lo++;
            }
            A[hi] = A[lo];
        }
        A[hi] = pivot;
        return hi;
    }

}
