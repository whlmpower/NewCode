package test_toutiao;

/**
 * Created by Administrator on 2018/03/26 0026.
 */
public class Toutiao02_1 {
    static int minStep=Integer.MAX_VALUE;//记录需要变换的最小次数
    /*
    这里由于第一次变换比第二次变换使得字符串增长的更快，所以先走第一次变换，
    如果无法达到，则回退
    如果达到，就和最小的步数比较

    这里应该可以用dp做的
     */
    public  void dfs(String s,String m,int step,int n){
        if(s.length()>=n){
            if(s.length()==n)minStep=step<minStep?step:minStep;
        }
        else {
            dfs(s+s,s,step+1,n);
            dfs(s+m,m,step+1,n);
        }
    }

    public  int getMinStep(int n) {
        dfs("mm", "m", 1, n);
        return minStep;
    }
}
