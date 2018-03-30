package test_toutiao;

/**
 * Created by Administrator on 2018/03/24 0024.
 */
public class Toutiao03 {
    public static void main(String[] args) {

        long[] number1 = new long[]{1, 2, 5};
        long[] number2 = new long[]{2, 3, 4, 5, 6};

        long avg1 = getavage(number1);
        long avg2 = getavage(number2);


    }

//    private long put(long avg1, long avg2){
//
//    }

    private static long getavage(long[] a){
        int len = a.length;
        long avage = (long) 0.0;
        long sum = 0;
        for (int i = 0; i < len ; i++) {
            sum += a[i];
        }
        return sum/len;
    }


}
