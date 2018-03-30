package sort_application;

/**
 * Created by Administrator on 2018/03/19 0019.
 * 将员工的年龄进行排序
 * 要求时间复杂度为n
 * 空间复杂度为n
 */
public class AgeSort {
    public int[]  sortAge(int[] age, int length){
        int oldestAge = 99;
        int[] timeOfAge = new int[oldestAge];

        for (int i = 0; i < length; i++) {
            timeOfAge[age[i]]++;
        }

        int index = 0;

        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timeOfAge[i]; j++) {
                age[index] = i;
                index ++;
            }
        }
        return age;
    }
}
