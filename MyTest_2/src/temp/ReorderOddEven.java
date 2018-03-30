package temp;

/**
 * Created by Administrator on 2018/03/19 0019.
 *  调整一个数组
 *  使数组的奇数都放在左边 偶数都放在右边
 */
public class ReorderOddEven {
    public int [] reorder(int[] number){
        if (number == null){
            return null;
        }
        int len = number.length  ;
        int left= 0;
        int right = len -1;

        while(left < right){
            if (left < right && (number[left] & 1) != 0){
//            if (left < right && isEven(number[left]){ // 实现判断方式上的解耦
                left ++;
            }
            if (left < right && (number[right] & 1) == 0){
                right --;
            }
            swap(left, right, number);
        }
        return number;

    }

    private void swap(int i, int j , int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    // 解决一类问题 而不是单个问题  定义判断函数  解耦问题

    private boolean isEven(int i){
        return (i & 1) == 0;
    }
}
