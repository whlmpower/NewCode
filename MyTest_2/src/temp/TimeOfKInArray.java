package temp;

/**
 * Created by Administrator on 2018/03/27 0027.
 * 统计排序数组中 数字k 出现的次数
 */
public class TimeOfKInArray {
    public int countK(int[] array, int k){
        int len = array.length;
        int first = getFirst(0, len -1, k, array) ;
        int last = getLast(0, len -1, k, array);
        int number = 0;
        if(first != -1 && last!= -1){
            number = last - first + 1;
        }
        return number;
    }


    private int getFirst(int lo, int hi, int k, int[] array){
        if (hi < lo){
            return -1;
        }

        int mi = ( hi + lo) >> 1;
        if (array[mi] == k) {
            if (mi > 0 && array[mi - 1] != k || mi == 0) {
                return mi;
            } else {
                hi = mi - 1;
            }
        }else  if(array[mi] > k){
            hi = mi -1;
        }else
            lo = mi + 1;
        return getFirst(lo, hi, k, array);

    }

    private int getLast(int lo, int hi, int k, int[] array){
        if (hi < lo){
            return -1;
        }
        int mi = (lo + hi) >>1;
        if (array[mi] == k){
            if(array[mi + 1] != k && mi < array.length -1 || mi == array.length - 1){
                return mi;
            }else
                lo = mi + 1;
        }else if(array[mi] < k){
            lo = mi + 1;
        }else
            hi = mi - 1;
        return getLast(lo, hi, k, array);

    }

    public int  binarySearch(int lo, int hi, int k , int[] array){
        while(hi - lo > 1){
            int mi = (lo + hi) >>1;
            if (array[mi] > hi){
                lo = mi;
            }else {
                hi = mi;
            }
        }
        return array[lo] == k ? lo : -1;
    }

    public int  getFirst1(int lo, int hi, int k , int[] array){
        while(hi >= lo){
            int mi = (lo + hi) >>1;

            if(array[mi] == k){
                if(mi >0 && array[mi -1] != k || mi == 0){
                    return mi;
                }else {
                    hi = mi - 1;
                }
            }
            else if (array[mi] > hi){
                lo = mi + 1;
            }else {
                hi = mi - 1;
            }
        }
        return -1;

    }
}
