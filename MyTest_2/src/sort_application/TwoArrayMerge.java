package sort_application;

/**
 * Created by Administrator on 2018/03/06 0006.
 */
public class TwoArrayMerge {
    public int[] mergeAB(int[] A, int[] B, int n, int m){
        int len = n + m -1;
        int i = n-1;
        int j = m -1;
        while(i >=0 && j >=0){
            if(A[i] > B[j]){
                A[len--] = A[i];
                i--;
            }
            else{
                A[len--] = B[i];
                j--;
            }
        }
        while(j >=0){
            A[len--] = B[j--];
        }

        return A;
    }
}
