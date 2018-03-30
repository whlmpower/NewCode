package sort_application;

/**
 * Created by Administrator on 2018/03/06 0006.
 * 需要排序的最短子数组的长度
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * 定义两个指针，一个指针从左向右，找到凹槽位置
 * 另一个指针从右向左 找到顶峰位置
 */
public class ShortNeedSortSubsequence {
    public int shortestSubsequence(int [] A, int n){
        int left = 0;
        int right = n -1;
        int max = A[0];
        for(int i = 0; i < n; i++){
            if(A[i] > max){
                max = A[i];
            }
            if(A[i] < max){
                left = i;
            }
        }
        int min = A[n-1];
        for (int i = n -1; i >=0 ; i--) {
            if(A[i] < min){
                min = A[i];
            }
            if(A[i] > min){
                right = i;
            }
        }
        return right < left ? 0 : right -left +1;

    }

}
