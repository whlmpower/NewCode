package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 */
public class RadixSort {
    public int[] radixSort(int [] a, int n ){
        int maxLength = maxLength(a);
        return sortCore(a, 0, maxLength);
    }


    private int[] sortCore(int[] array, int digit, int maxLength){
        if(digit >= maxLength){ // 递归基 处理位数超过最大位数
            return  array;
        }

        final int radix = 10;// 基数，也就是0 - 9
        int arrayLength = array.length;
        int[] count = new int[radix]; //  每一位上面对应0 - 9 个数字的个数
        int[] bucket = new int[arrayLength]; // 存放数组的桶

        for(int i = 0; i < arrayLength; i++){
            count[getDigit(array[i], digit)]++; // 得到每一位上  对应数字的个数
        }

        for (int i = 1; i < radix; i++) {
            count[i] = count[i] + count[i -1]; // 将桶中数字个数转化为 数字下标的索引
        }

        for (int i = arrayLength -1; i >= 0; i--) {// 在第一遍的时候已经保证了 当十位数字相同时， 位于后面的个数数字大，倒序方式递减，保证28 先放，而且放在27后面
            int number = array[i];
            int d = getDigit(number, digit); // 当前位的数字
            bucket[count[d] - 1] = number; //按照对应下标索引放置到bucket中
            count[d] --;
        }

        return sortCore(bucket, digit + 1, maxLength);// 递归 将bucket数组 回传

    }


    private int maxLength(int [] array){
        int maxLength = 0;
        int arrayLength = array.length;

        for (int i = 0; i <arrayLength ; i++) {
            int currentLength = length(array[i]);
            if(currentLength > maxLength){
                maxLength = currentLength;
            }
        }
        return  maxLength;
    }

    private int length(int number){
        return  String.valueOf(number).length();
    }

    /**
     * 获取x 这个数上面d 位数上的shuz
     * 比如 123 的 个位（第0位）上面的数字为3
     * @param x
     * @param d
     * @return
     */
    private int  getDigit(int x, int d){
        int a[] = {1, 10, 100, 1000, 10000 };
        return ((x/ a[d]) % 10);
    }
}
