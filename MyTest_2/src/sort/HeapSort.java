package sort;

/**
 * Created by Administrator on 2018/03/05 0005.
 * 不稳定
 * 时间复杂度 n logn
 * 空间复杂度 O1
 */
public class HeapSort {
//    public void adjustHeap(int[] a, int i , int len){
//        int temp, j;//j 是孩子指针 //i 是父亲指针
//        for(j = 2* i; j < len ; j *=2){
//            if(j < len && a[j] < a[j +1]){ //左孩子小于右孩子的值
//                j++;//将右孩子作为交换候选
//            }
//
//            if(a[j] > a[i]){ //孩子大于父亲，交换
//                swap(a, i, j);
//                i = j;//将父亲指针替换为孩子指针的值，进行进一步的递归
//            }else
//                break;
//        }
//    }
//
//    public int[] heapSort(int[] a){
//        int i;
//        //生成一个最大顶堆
//        for(i = a.length /2 -1; i >=0; i-- ){
//            adjustHeap(a, i, a.length-1);
//        }
//
//        for (i = a.length -1; i > 0; i--){
//            int temp = a[0];
//            a[0] = a[i];
//            a[i] = temp;
//            //交换与调整
//            adjustHeap(a, 0, i -1);
//        }
//        return  a;
//    }
//
//    public void swap(int[] a, int i, int j ){
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

    public int[] heapSort(int[] A, int n){
        for(int i = n /2 -1; i >= 0 ; i --){
            adjustHeap(A, i, n );
        }
        for(int i = n -1 ; i >=0; i-- ){
            swap(A, 0, i);
            adjustHeap(A, 0, i);
        }
        return A;
    }

    public void adjustHeap(int[] a, int i, int len){
        for(int j = 2 * i +1 ; j < len; j = 2* j + 1 ){// 修改为2*j+1
            if(j + 1 < len && a[j + 1] > a[j]){ //由j < len 更改为 j+1< len
                j++;
            }
            if(a[j] > a[i]){
                swap(a, i, j);
                i = j;
            }else
                break;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
