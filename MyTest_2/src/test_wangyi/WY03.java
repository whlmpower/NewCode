package test_wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/03/27 0027.
 */
public class WY03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] task = new int[a][2];
        for (int i = 0; i < a; i++) {
            task[i][0] = in.nextInt();
            task[i][1] = in.nextInt();
        }
        int [] neng = new int[b];
        for (int i = 0; i < b; i++) {
            neng[i] = in.nextInt();
        }
    }
    public static void find_task(int[] neng){

    }


    public static  void quick_Sort(int[] A, int lo, int hi){
        if(hi - lo < 1){
            return;
        }
        int mi = partition(A, lo, hi );
        quick_Sort(A, lo, mi);
        quick_Sort(A, mi+ 1, hi );
    }

    public static  int partition(int[] A, int lo, int hi){
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
