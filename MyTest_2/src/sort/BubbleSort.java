package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 */
public class BubbleSort {
    public int[] bubbleSort(int[] A , int n ){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (A[i] > A[j]){
                    swap(A, i, j);
                }
            }
        }
        return A;
    }


    public void swap(int[] A, int i, int j  ){
        int temp = 0;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
