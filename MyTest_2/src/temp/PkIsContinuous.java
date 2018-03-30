package temp;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/03/28 0028.
 * 扑克牌 用0 表示 大小王 大小王 总共4 张 判断是否是顺子
 *
 */
public class PkIsContinuous {
    public boolean isContinuous(int[] numbers){
        int empty = 0;
        int count_zero = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0){
                count_zero++;
            }
            else {
                empty += numbers[i + 1] - numbers[i] - 1;
            }
        }

        if (empty == count_zero){
            return true;
        }else
            return false;
    }
}
