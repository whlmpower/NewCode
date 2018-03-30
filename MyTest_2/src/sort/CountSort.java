package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 */
public class CountSort {
    public int[] countSort(int[] a, int n){
        int k  = findMax(a, n);
        int[] c = new int[k + 1];
        int[] b = new int[n];
        for(int i = 0; i < k + 1; i ++){
            c[i] = 0;
        }
        for(int i = 0; i < n; i++){
            c[a[i]] ++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i -1];
        }

        for (int i = 0; i < a.length; i++) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] --;
        }
        return b;
    }

    public int findMax(int[] a, int n ){
        int max = a[0];
        for (int i = 0; i < n ; i++) {
            if(a[i]  > max ){
                max = a[i];
            }
        }
        return  max;
    }
}
