package test_wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/03/27 0027.
 */
public class WY02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(find(a, b));
    }

//    public static int  find(int n, int k){
//        int count = 0;
//        for (int i = n; i > 0; i--) {
//            for (int j = 1; j <= i; j++) {
//                if ((i % j) >= k || (j % i) >=k ){
//                    System.out.println("(" + i+ ","  + j + ")");
//                    count++;
//                }
//            }
//        }
//        return count + 1;
//
//    }

    public static int find(int n , int k){
        int count =0;
        for (int i = 1; i < n / k; i++) {
            for (int j = 1; j < n / i; j++) {
                if(i * j + k < n){
                    count ++;
                }

            }
        }
        return count;
    }


}
