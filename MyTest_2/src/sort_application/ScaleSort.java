package sort_application;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/03/06 0006.
 *
 * 一个几乎有序的数组，如果把数组排好序的话，数组的移动距离不超过k 并且k 对于数组来说很小
 * 选择方法进行排序
 * O(n^2) 冒泡 选择排序
 * O(n * k ) 插入排序
 * O(n*logn) 快排 归并
 * O(n*logk) 对排序
 *
 * 空间复杂度
 * O(1) 冒泡。选择。插入 希尔、堆(递归实现的空间复杂度为logn)
 * O(logn)~n 快速排序
 * 归并排序 O(n)
 * 基数排序和计数排序O(M)
 *
 */
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k){
        int[] temp = Arrays.copyOf(A, k);
        initKHeap(temp, k);

        for (int i = k; i < n; i++) {
            A[i - k] = temp[0];
            temp[0] = A[i];
            adjustHeap(temp, 0, k);
        }

        for(int i = n-k; i< n ; i ++){
            A[i] = temp[0];
            swap(temp, 0, k-1);
            adjustHeap(temp, 0, --k);
        }

        return A;
    }

    private void initKHeap(int [] a, int k){ // 初始化0-k/2部分
        for (int i = k/2 - 1; i >= 0 ; i--) {
            adjustHeap(a, i, k);
        }
    }

    private void adjustHeap(int[] a, int i, int k){
        for(int j = 2*i + 1 ; j < k ;  j=2*j + 1){
            if(j + 1 < k && a[j + 1] < a[j] ){
                j++;
            }
            if(a[j] < a[i]){
                swap(a, i, j);
                i = j;
            }else
                break;

        }

    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
