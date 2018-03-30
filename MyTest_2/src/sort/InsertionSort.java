package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 *2 5 7 3
 * 2 _ 5 7
 * 2 3 5 7
 * 前缀的序列有序，吼一个元素插入到前缀的位置
 * 不稳定的排序
 * 选择排序 希尔排序 快速排序  堆排序
 * 时间复杂度 n 方
 * 空间复杂度 O1
 *
 */
public class InsertionSort {
    public int[] insertSort(int[] A, int n){
        for (int j = 1; j < n; j++) {
            int ele = A[j];
            int i = j -1;
            while(i >=0 && A[i] >ele){
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = ele;
        }
        return  A;
    }




}
