package sort_application;

/**
 * Created by Administrator on 2018/03/07 0007.
 * 旋转数组最小值
 * 二分法进行查找
 * a[mi] > a[hi] 类似 3 4 5 6 1 2 最小数字在右半部分 lo = mi + 1
 * a[mi] = a[hi] 类似 1 1 1 0 1 hi -- 试探
 * a[mi] < a[hi] 类似 5 1 2 3 4 hi = mi
 */
public class MinNumberInRoateArray {
    public int minNumberInRoateArray(int[] array){
        int lo =0;
        int hi = array.length -1;
        if(array.length == 0){
            return 0;
        }
        int mi;
        while(lo < hi){
            mi = (lo + hi)/2;
            if (array[mi] > array[hi]){
                lo = mi + 1;
            }else if(array[mi] == array[hi]){// 1 0 1 1 1  中间数字和 最大的数字相等 hi --  试探性减小
                hi --;
            }else {
                hi = mi;
            }
        }
        return array[lo];
    }
}
