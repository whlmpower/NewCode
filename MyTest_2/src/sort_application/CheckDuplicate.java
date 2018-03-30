package sort_application;

/**
 * Created by Administrator on 2018/03/06 0006.
 * 核对有无重复数字
 * 要求空间复杂度为O(1)
 * 使用无递归的堆排序
 */
public class CheckDuplicate {
    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        a = sort(a, n);
        for(int i = 0; i < n; i++){
            if(i + 1 < n && a[i] == a[i +1]){
                return true;
            }
        }
        return false;
    }
    public int[] sort(int[] a, int n){
        for(int i= n / 2; i >= 0; i--){
            adjustHeap(a, i, n);
        }
        for(int i = n -1; i >= 0; i--){
            swap(a, 0, i);
            adjustHeap(a, 0, i );
        }
        return  a;
    }

    private void adjustHeap(int[] a, int i, int len){
        for(int j = 2* i +1 ; j < len; j= 2* j +1){
            if(j + 1 < len && a[j+ 1] < a[j]){
                j++;
            }
            if(a[j] < a[i]){
                swap(a, i, j);
                i = j;
            }else
                break;
        }
    }


//    public void adjustHeap(int[] a, int i, int len){
//        for(int j = 2 * i +1 ; j < len; j = 2* j + 1 ){// 修改为2*j+1
//            if(j + 1 < len && a[j + 1] > a[j]){ //由j < len 更改为 j+1< len
//                j++;
//            }
//            if(a[j] > a[i]){
//                swap(a, i, j);
//                i = j;
//            }else
//                break;
//        }
//    }

    private void swap(int[] a, int i ,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
