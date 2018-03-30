package sort_application;

/**
 * Created by Administrator on 2018/03/06 0006.
 */
public class TwoDFinder {

    public boolean findX(int [][] mat, int n, int m, int x){
        int i = 0;
        int j = m -1;
        while(i < n && j >=0){
            if(x > mat[i][j]){
                i++;
            }else if(x < mat[i][j]) {
                j--;
            }else
                return true;
        }
        return false;

    }
}
