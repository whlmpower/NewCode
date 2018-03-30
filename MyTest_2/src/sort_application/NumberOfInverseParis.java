package sort_application;

/**
 * Created by Administrator on 2018/03/22 0022.
 * 统计一个数组的逆序对的个数
 *
 */
public class NumberOfInverseParis {
    int count = 0;
    public int inversePairs(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        int len = array.length;
        mergeDeal(array, 0, len -1);
        return count;
    }

    private void mergeDeal(int[] array, int lo, int hi){

        if (lo < hi){
            int mi = (lo + hi) / 2;
            mergeDeal(array, lo, mi);
            mergeDeal(array, mi + 1, hi);
            merge(array, mi , lo, hi);
        }
    }

    private void merge(int[] array, int mi, int lo, int hi){
        int[] temp = new int[hi - lo + 1];
        int k = hi - lo ;
        int p1 = mi;
        int p2 = hi;
        while (p1 >= lo && p2 >= mi + 1){
            if (array[p1] > array[p2]){
                count = count + p2 - mi;
                temp[k--] = array[p1--];
                if (count > 1000000007){
                    count  %= 1000000007;
                }
            }else {
                temp[k--] = array[p2--];
            }
        }
        while(p1 >= lo){
            temp[k--] = array[p1--];
        }

        while(p2 >= mi + 1){
            temp[k--] = array[p2--];
        }


        for (int i = 0; i < temp.length; i++) {
            array[i + lo] = temp[i];
        }

    }

}
