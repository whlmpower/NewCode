package sort_application;

/**
 * Created by Administrator on 2018/03/06 0006.
 *
 * 三色旗问题
 * 000111222
 */
public class ThreeColor {
    public int[] sortThreeColor(int []A, int n){
        int index_0 = -1;
        int index_2 = n ;

        for (int i = 0; i < n; i++) {
            if(i >= index_2){
                break;
            }
            if(A[i] < 1){
                swap(A, index_0 + 1, i);
                index_0++;
            }
            if(A[i] > 1){
                swap(A, index_2 -1, i);
                index_2 --;
                i--;
            }

        }
        return A;
    }



    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
