package sort_application;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/03/09 0009.
 *
 * 升序建立大根堆
 * 降序建立小根堆
 */
public class FindKthNumInArray2 {
    public int[] kthNumArray(int[] a, int k){
        int[] temp = Arrays.copyOf(a, k); //复制从0 到 k-1的数值
        initHeap(temp, k);
        for (int i = k; i < a.length; i++) {
            if(temp[0] < a[i]){
                temp[0] = a[i];
                adjustHeap(temp, 0, k);
            }else
                continue;

        }
        return temp;

    }

    private void adjustHeap(int[] a, int i, int k ){
        for(int j = i * 2 + 1 ; i < k ; j = j * 2 + 1){
            if (j + 1 < k && a[j + 1] < a[j] ){
                j++;
            }
            if(j < k && a[i] > a[j]){
                swap(a, i, j);
                i = j;
            }else
                break;

        }
    }

    private void swap(int[] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void initHeap(int[] a, int k){
        for(int i = k /2 -1 ; i >=0; i--){
            adjustHeap(a, i, k);
        }
    }
}
