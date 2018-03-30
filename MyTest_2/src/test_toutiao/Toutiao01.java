package test_toutiao;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/03/24 0024.
 */
public class Toutiao01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scan = new int[n];
        for (int i = 0; i < n; i++) {
            scan[i] = sc.nextInt();
        }

        quick_Sort(scan, 0, n -1);

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = scan[i] + k;
        }
        int local = 0;
        int count= 0;
        for (int i = 0; i < n; i++) {
            if (temp[0] == scan[i]){
                local = i;
                count++;
                break;
            }
        }
        int i = 1;
        int j = local + 1;
        if(k == 0){
            while(j < n && i < n -1 ){
                if (scan[j] == temp[i]){
                    i++;
                    j++;
                    count ++;
                    if (temp[i] == temp[i - 1]){
                        count --;
                    }
                }
            }
        }else{
            while(j < n && i< n){
                if (scan[j] == temp[i]){
                    j++;
                    i++;
                    count++;
                }else {
                    j++;
                }
            }
        }



        System.out.println(count);


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
