package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 *
 * 空间复杂度为n
 */
public class MergeSort {

    public int[] mergeSort(int[] A, int n) {
        // write code here
        int hi = n - 1;
        int lo = 0;
        A = merge_Sort(A, lo, hi);
        return A;
    }

    public int[] merge_Sort(int[] A, int lo, int hi){
        int mid = (lo + hi) / 2;
        if(hi > lo){
            merge_Sort(A, lo, mid);
            merge_Sort(A, mid + 1, hi);
            merge(A, lo, hi, mid);
        }
        return A;
    }

    public void merge(int[] A, int lo, int hi, int mi){
        int i =lo;
        int j = mi + 1;
        int k = 0;
        int [] temp = new int[hi - lo +1];
        while(i <=mi && j <=hi){
            if(A[i] < A[j]){
                temp[k++] = A[i++];
            }else{
                temp[k++] = A[j++];

            }

        }
        while(i <= mi){
            temp[k++] = A[i++];
        }
        while(j <= hi){
            temp[k++] = A[j++];
        }
        for(int m = 0; m < temp.length; m++){
            A[lo + m] = temp[m];
        }
    }
}
