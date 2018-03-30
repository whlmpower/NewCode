package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 * 选择排序
 * 待排序序列分为有序和无序两个部分
 * 从无序序列中选出最大值（最小值）连接到有序序列上
 * 不稳定
 * 5 8 5 2
 * 第一次选择5 和 2交换  相等的5 顺序改变了
 * 时间复杂度 n方
 * 空间复杂度O1
 *
 */
public class SelectionSort {
    public void swap(int[] A, int i, int j  ){
        int temp = 0;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int[] selectionSort(int[] A, int n){
        for (int i = 0; i < n; i++) {
            int max_index = selectMax(A, 0, n -i);
            swap(A, max_index, n-i -1);
        }
        return  A;
    }

    public int selectMax(int[] A, int start, int end){
        int max = A[start];
        int max_index = start;
        while(++start < end){
            if (max < A[start]){
                max = A[start];
                max_index = start;
            }
        }
        return max_index;
    }
}
